package graph;

import java.util.LinkedList;

/**
 * @author Kunal
 * 
 */
public class Digraph {
	private int V;
	private LinkedList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public Digraph(int V){
		this.V=V;
		this.adj=(LinkedList<Integer>[])new LinkedList[V];
		for(int i=0; i<V; i++){
			adj[i]=new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public int V(){
		return this.V;
	}
	
	public Digraph reverse(){
		Digraph R = new Digraph(V);
		for(int v=0; v<V; v++){
			for(int w: adj(v)){
				R.addEdge(w, v);
			}
		}
		return R;
	}
	
}
