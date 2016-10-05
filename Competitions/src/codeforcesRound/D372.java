package codeforcesRound;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D372 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		Task1 solver = new Task1();
		solver.solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt(), m=in.nextInt();
			double L=in.nextDouble();
			int s=in.nextInt(), t=in.nextInt();
			EdgeWeightedDigraph G=new EdgeWeightedDigraph(n);
			Integer[] fr=new Integer[m];
			Integer[] to=new Integer[m];
			Integer[] wtt=new Integer[m];
			for(int i=0; i<m; i++){
				int v=in.nextInt(), w=in.nextInt(), wt=in.nextInt();
				fr[i]=v; to[i]=w; wtt[i]=wt;
				G.addEdge(new DirectedEdge(v,w,wt));
			}
			
			DijkstraSP sp=new DijkstraSP(G, s);
			double shortest=sp.distTo[t];
			if(shortest>L){
				out.println("NO");
				return;
			}
			int num_zero=0, v=t;
			double rem_weight=L-shortest;
			
			while(sp.edgeTo[v].from()!=s){
				if(sp.edgeTo[v].weight()==0) num_zero++;
				v=sp.edgeTo[v].from();
			}
			if(sp.edgeTo[v].from()==s){
				if(sp.edgeTo[v].weight()==0) num_zero++;
				v=sp.edgeTo[v].from();
			}
			
			//out.println(num_zero);
			
			if(num_zero>rem_weight){
				out.println("NO");
				return;
			}
			
			out.println("YES");
			
			for(int i=0; i<m; i++){
				out.print(fr[i]+" "+to[i]+" ");
				if(wtt[i]==0 && num_zero==1) out.println((int)rem_weight);
				else if(wtt[i]==0 && num_zero>1){
					num_zero--;
					rem_weight--;
					out.println(1);
				}
				else out.println(wtt[i]);
			}
		}
	}

	static class DirectedEdge {
		private int v, w;
		private double weight;
		
		public DirectedEdge(int v, int w, double weight){
			this.v=v;
			this.w=w;
			this.weight=weight;
		}
		
		public int from(){
			return v;
		}
		
		public int to(){
			return w;
		}
		
		public double weight(){
			return weight;
		}
	}

	static class EdgeWeightedDigraph {
		private final int V;
		private LinkedList<DirectedEdge>[] adj;
		
		@SuppressWarnings("unchecked")
		public EdgeWeightedDigraph(int V){
			this.V=V;
			adj=(LinkedList<DirectedEdge>[])new LinkedList[V];
			for(int i=0; i<V; i++){
				adj[i]=new LinkedList<DirectedEdge>();
			}
		}
		
		public void addEdge(DirectedEdge e){
			adj[e.from()].add(e);
		}
		
		public Iterable<DirectedEdge> adj(int v){
			return adj[v];
		}
		
		public int V(){
			return V;	//number of vertices
		}
	}

	static class DijkstraSP {
		double[] distTo;
		DirectedEdge[] edgeTo;
		private IndexMinPQ<Double> pq;
		
		public DijkstraSP(EdgeWeightedDigraph G, int s){
			distTo= new double[G.V()];
			edgeTo= new DirectedEdge[G.V()];
			pq= new IndexMinPQ<Double>(G.V());			//maxN = G.V()
			
			for(int i=0; i<G.V(); i++){
				distTo[i]=Double.POSITIVE_INFINITY;
			}
			distTo[s]=0.0;
			
			pq.insert(s, 0.0);
			while(!pq.isEmpty()){
				int v = pq.delMin();
				for(DirectedEdge e: G.adj(v)){
					relax(e);
				}
			}
		}
		
		private void relax(DirectedEdge e){
			int v=e.from(), w=e.to();
			if(distTo[w] > distTo[v]+e.weight()){
				distTo[w]= distTo[v]+e.weight();
				edgeTo[w]= e;
				
				if(pq.contains(w)){
					if(pq.keyOf(w)>distTo[w]) pq.changeKey(w, distTo[w]);
				}
				else pq.insert(w, distTo[w]);
			}
		}
	}
	
	static class IndexMinPQ<Key extends Comparable<Key>>{
		private int[] a, b;
		private Key[] keys;
		private int N, maxN;
		
		@SuppressWarnings("unchecked")
		public IndexMinPQ(int capacity){
			this.maxN=capacity-1; this.N=0;
			this.a=new int[maxN+1];	this.b=new int[maxN+1];
			this.keys=(Key[])new Comparable[maxN+1];
			for(int i=0; i<maxN+1; i++) a[i]=-1;	
		}
		
		public boolean isEmpty(){ return N==0; }

		public int size(){ return N; }

		public boolean contains(int index){ return a[index] != -1; }

		public void insert(int index, Key key){
			N++;
			a[index]=N-1; b[N-1]=index;
			keys[index]=key;
			swim(N-1);
		}

		public int minIndex(){ return b[0]; }

		public Key minKey(){ return keys[b[0]]; }

		public Key keyOf(int index){ return keys[index]; }

		public int delMin(){
			int min=b[0];
			exch(0,--N);
			sink(0);
			a[min]= -1;
			b[N]= -1;
			return min;
		}

		public void changeKey(int index, Key newKey){
			if(contains(index)){
				keys[index]=newKey;
				swim(a[index]);
				sink(a[index]);
			}
			else throw new IllegalArgumentException("There is no key associated with this index.");
		}

		/* General Helper Functions */
		private boolean greater(int i, int j){
			return keys[b[i]].compareTo( keys[b[j]] ) > 0;
		}

		private void exch(int i, int j){
			int swap=b[i];
			b[i]=b[j];	b[j]=swap;
			a[b[i]]=i;	a[b[j]]=j;
		}

		/* Heap Helper Functions */
		private void swim(int child){
			int root=(child-1)/2;
			while(greater(root, child)){
				exch(root, child);
				child=root;
				root=(child-1)/2;
			}
		}

		private void sink(int root){
			int child=2*root +1;
			while(child<N){
				if(child<N-1)
					if(greater(child, child+1)) child++;
				if(greater(root, child))
					exch(root, child);
				else break;

				root=child;
				child=2*root+1;
			}
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
