package codeforcesRound;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B368 {
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
			int n=in.nextInt(), m=in.nextInt(), k=in.nextInt();
			EdgeWeightedGraph G=new EdgeWeightedGraph(n+1);
			
			for(int i=0; i<m; i++){
				int a=in.nextInt();
				int b=in.nextInt();
				int wt=in.nextInt();
				G.addEdge(new Edge(a,b,wt));
			}
			
			if(k==0) out.println(-1);
			else{
				boolean isFlour[]=new boolean[n+1];
				int flour[]=new int[k];
				int min=2000000000;
				for(int i=0; i<k; i++){
					flour[i]=in.nextInt();
					isFlour[flour[i]]=true;
				}
				for(int i=0; i<k; i++){
					for(Edge e: G.adj(flour[i])){
						int v=flour[i], w=e.other(v), wt=(int)e.weight();
						if(!isFlour[w]) min=Math.min(wt, min);
					}
				}
				if(min==2000000000) out.println(-1);
				else out.println(min);
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		private int V,W;
		private double weight;
		
		public Edge(int V, int W, double weight){
			this.V=V;
			this.W=W;
			this.weight=weight;
		}
		
		public int either(){
			return V;
		}
		
		public int other(int v){
			if(V==v) return W;
			else return V;
		}

		public double weight(){
			return weight;
		}
		@Override
		public int compareTo(Edge a){
			if(this.weight < a.weight) return -1;
			else if(this.weight > a.weight) return 1;
			else return 0;
		}
	}
	
	static class EdgeWeightedGraph {
		private final int V;
		private final ArrayDeque<Edge>[] adj;
		
		@SuppressWarnings("unchecked")
		public EdgeWeightedGraph(int V){
			this.V=V;
			this.adj=(ArrayDeque<Edge>[])new ArrayDeque[V];
			
			for(int i=0; i<V; i++){
				adj[i]=new ArrayDeque<Edge>();
			}
		}
		
		public void addEdge(Edge e){
			int v=e.either();
			int w=e.other(v);
			adj[v].add(e);
			adj[w].add(e);
		}
		
		public Iterable<Edge> adj(int v){
			return adj[v];
		}
		
		public int V(){
			return V;
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
