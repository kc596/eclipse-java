package algorithms;

/**
 * @author kunal05
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

import java.util.StringTokenizer;
import java.util.TreeSet;


public class TicketToRide {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		Task1 solver=new Task1();		
		solver.solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		out.close();
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

		public String toString(){
			return (this.V+"-"+this.W+" "+this.weight);
		}
	}

	static class EdgeWeightedGraph {
		private final int V;
		private final LinkedList<Edge>[] adj;
		private final TreeSet<Edge> edges;	//set used to resolve redundancy
		
		@SuppressWarnings("unchecked")
		public EdgeWeightedGraph(int V){
			this.V=V;
			this.adj=(LinkedList<Edge>[])new LinkedList[V];
			this.edges = new TreeSet<Edge>();
			
			for(int i=0; i<V; i++){
				adj[i]=new LinkedList<Edge>();
			}
		}
		
		public void addEdge(Edge e){
			edges.add(e);
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
		
		public Iterable<Edge> edges(){
			return edges;
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

	static class BellmanFordSP {
	private double[] distTo;				//distance of shortest path from s to v
	private DirectedEdge[] edgeTo;			//edgeTo[w] = edge used to reach w
	
	public BellmanFordSP(EdgeWeightedDigraph G, int s){
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		for(int i=0; i<G.V(); i++)
			distTo[i]=Double.POSITIVE_INFINITY;
		
		distTo[s]=0;
		
		for(int i=0; i<G.V(); i++)
			for(int v=0; v<G.V(); v++)
				for(DirectedEdge e: G.adj(v))
					relax(e);
	}
	
	private void relax(DirectedEdge e){
		int v=e.from(), w=e.to();
		if(distTo[w] > distTo[v]+e.weight()){
			distTo[w] = distTo[v]+e.weight();
			edgeTo[w] = e;
		}
	}
	}
	
	static class Task1{
		public void solve(InputReader in, PrintWriter out){
			int n=in.nextInt();
			EdgeWeightedDigraph g=new EdgeWeightedDigraph(n);
			for(int i=0; i<n-1; i++){
				int a=in.nextInt();
				int b=in.nextInt();
				int wt=in.nextInt();
				g.addEdge(new DirectedEdge((a-1), (b-1), wt));
				g.addEdge(new DirectedEdge((b-1), (a-1), wt));
			}
			BellmanFordSP sp= new BellmanFordSP(g,3);
			for(double i: sp.distTo) out.println(i);
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