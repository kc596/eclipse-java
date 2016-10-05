package graph;

import java.util.LinkedList;

public class EdgeWeightedDigraph {
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
