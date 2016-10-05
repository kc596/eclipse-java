package classical.unsolved;

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

public class IsItATree {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();		//no. of vertices
			int m=in.nextInt();		//no. of edges
			
			Graph g=new Graph(n+1);
			for(int i=0; i<m; i++){
				int a=in.nextInt();
				int b=in.nextInt();
				g.addEdge(a, b);
			}
			
			//checking
			
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
	}
	
	static class Graph {
		private LinkedList<Integer>[] adj;							//adjacency list
		private int V,E;											//no. of Vertices and Edges
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Graph(int V){
			this.V=V;
			this.E=0;
			adj=new LinkedList[V];
			for(int i=0; i<V; i++){
				adj[i]=new LinkedList();
			}
		}
		
		public void addEdge(int v, int w){
			adj[v].add(w);
			adj[w].add(v);
			E++;
		}
		
		public void deleteEdge(int v, int w){
			adj[v].remove(w);
			adj[w].remove(v);
			E--;
		}
		
		public Iterable<Integer> adj(int v){
			return adj[v];
		}
		
		public int V(){
			return this.V;
		}
		
		public int E(){
			return this.E;
		}
	}

}
