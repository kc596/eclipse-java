package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Kunal
 *
 */
public class BFS {
	public static void main(String[] args){
		InputReader in=new InputReader();
		PrintWriter out=new PrintWriter(System.out);
		int t=in.nextInt();
		while(t-->0){
			int n=in.nextInt();		//no. of nodes of graph
			int m=in.nextInt();		//no. of edges of graph
			
			Graph G=new Graph(n+1);
			for(int i=0; i<m; i++){
				int x=in.nextInt();
				int y=in.nextInt();
				G.addEdge(x, y);
			}
			int hero=in.nextInt();
			BreadthFirstPaths bf=new BreadthFirstPaths(G,hero);
			for(int i=1; i<=n; i++){
				if(i==hero) continue;
				out.print(bf.distance(i)+" ");
			}
			out.println();
		}
		
		out.close();
	}
	static class Graph{
		private int V,E;
		private LinkedList<Integer>[] adj;
		
		@SuppressWarnings("unchecked")
		public Graph(int V){
			this.V=V;
			this.E=0;
			adj=new LinkedList[V];
			for(int i=0; i<V; i++){
				adj[i]=new LinkedList<Integer>();
			}
		}
		
		public void addEdge(int v, int w){
			adj[v].add(w);
			adj[w].add(v);
			E++;
		}
		
		public Iterable<Integer> adj(int v){
			return adj[v];
		}
		public int V(){ return this.V; }
		public int E(){ return this.E; }
	}
	static class BreadthFirstPaths{
		private boolean[] marked;
		private int[] edgeTo;
		private int[] distTo;
		
		public BreadthFirstPaths(Graph G, int s){
			this.marked=new boolean[G.V()];
			this.edgeTo=new int[G.V()];
			this.distTo=new int[G.V()];
			
			bfs(G,s);
		}
		
		private void bfs(Graph G, int s){
			for(int i=0; i<G.V(); i++){
				distTo[i]=Integer.MAX_VALUE;
			}
			Queue<Integer> q=new LinkedList<Integer>();
			q.offer(s);
			distTo[s]=0;
			marked[s]=true;
			
			while(!q.isEmpty()){
				int v=q.poll();
				for(int w:G.adj(v)){
					if(!marked[w]){
						marked[w]=true;
						distTo[w]=distTo[v]+1;
						edgeTo[w]=v;
						q.offer(w);
					}
				}
			}
		}
		
		public boolean hasPathTo(int v){
			return marked[v];
		}
		
		public Iterable<Integer> pathTo(int v){
			if(!hasPathTo(v)) return null;
			Stack<Integer> s=new Stack<Integer>();
			int i;
			for(i=v; distTo[i]!=0; i=edgeTo[i]){
				s.push(i);
			}
			s.push(i);
			return s;
		}
		
		public int distance(int v){
			if(distTo[v]==Integer.MAX_VALUE) return -1;
			return (6*distTo[v]);
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
}
