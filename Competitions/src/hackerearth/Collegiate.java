package hackerearth;
/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Collegiate {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		new Task2().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task2{
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

		static class Topological{
			/**
			 * Topological order for an EdgeWeightedDigraph(with no directed cycles).
			 * Topological order of any graph is its reverse post-order.
			 */
				private Stack<Integer> reversePost;
				private boolean[] marked;
				
				public Topological(EdgeWeightedDigraph G){
					reversePost = new Stack<Integer>();
					marked = new boolean[G.V()];
					for(int i=0; i<G.V(); i++){
						if(!marked[i]){
							dfs(G,i);
						}
					}
				}
				private void dfs(EdgeWeightedDigraph G, int v){
					marked[v]=true;
					for(DirectedEdge e: G.adj(v)){
						if(!marked[e.to()]) dfs(G, e.to());
					}
					reversePost.push(v);
				}
				public Iterable<Integer> order(){
					return reversePost;
				}
		}
		
		static EdgeWeightedDigraph G;
		static Topological tt=new Topological(G);
		
		static class AcyclicSP {
			private DirectedEdge[] edgeTo;			//edge used to reach to a vertex v
			private double[] distTo;				//distTo[v]=shortest distance from s to v
			
			public AcyclicSP(EdgeWeightedDigraph G, int s){
				edgeTo = new DirectedEdge[G.V()];
				distTo = new double[G.V()];
				
				for(int i=0; i<G.V(); i++) distTo[i]=Double.POSITIVE_INFINITY;
				distTo[s]=0;
				
				Topological t = tt;
				Stack<Integer> st = (Stack<Integer>)t.order();
				while(!st.isEmpty()){
					int v = st.pop();
					for(DirectedEdge e: G.adj(v)) relax(e);
				}
			}
			private void relax(DirectedEdge e){
				int v = e.from(), w = e.to();
				if(distTo[w] > distTo[v]+e.weight()){
					distTo[w] = distTo[v]+e.weight();
					edgeTo[w] = e;
				}
			}
		}
		
		public void solve(InputReader in, PrintWriter out){
			int N=in.nextInt();
			G=new EdgeWeightedDigraph(N+1);
			for(int i=0; i<N-1; i++){
				int a=in.nextInt(), b=in.nextInt(), c=in.nextInt();
				G.addEdge(new DirectedEdge(a,b,c));
				G.addEdge(new DirectedEdge(b,a,c));
			}
			
		}
	}
	
	static class Task1 {
		static final long MOD=1000000007L;
		public void solve(InputReader in, PrintWriter out) {
			long n=in.nextLong();
			long num=expo(2,n, MOD-1);
			long pow=expo(2,num, MOD);
			long ans=(pow-1);
			out.println(ans);
		}
		static long expo(long a, long b, long MOD){
			long result = 1;
			while (b>0){
				if (b%2==1) result=(result*a)%MOD;
				b>>=1;
				a=(a*a)%MOD;
			}
			return result%MOD;
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
