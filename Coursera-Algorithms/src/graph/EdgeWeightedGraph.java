package graph;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author Kunal
 *
 */
public class EdgeWeightedGraph {
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
	
	/*main*/
	public static void main(String[] args){
		EdgeWeightedGraph G= new EdgeWeightedGraph(8);
		G.addEdge(new Edge(4,5,0.35));
		G.addEdge(new Edge(4,7,0.37));
		G.addEdge(new Edge(5,7,0.28));
		G.addEdge(new Edge(0,7,0.16));

		for(Edge e: G.edges()){
			System.out.println(e);
		}
	}
}
