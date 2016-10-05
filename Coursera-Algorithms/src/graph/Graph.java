package graph;

import java.util.LinkedList;

/**
 * @author Kunal
 *
 */

public class Graph {
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
