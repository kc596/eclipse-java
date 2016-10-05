package graph.maxflow;
import java.util.LinkedList;

public class FlowNetwork {
	private final int V;				//total no. of vertices
	private LinkedList<FlowEdge>[] adj;	//adjacency list
	
	@SuppressWarnings("unchecked")
	public FlowNetwork(int V){
		this.V=V;
		adj = (LinkedList<FlowEdge>[]) new LinkedList[V];
		for(int i=0; i<V; i++){
			adj[i] = new LinkedList<FlowEdge>();
		}
	}
	
	public void addEdge(FlowEdge e){
		int v=e.from();
		int w=e.to();
		adj[v].add(e);				//add forward edge
		adj[w].add(e);				//add backward edge
	}
	
	public int V(){
		return this.V;
	}
	
	public Iterable<FlowEdge> adj(int v){
		return adj[v];
	}
}
