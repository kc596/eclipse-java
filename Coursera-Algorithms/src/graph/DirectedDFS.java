package graph;

/**
 * @author Kunal
 * No change in program from DepthFirstPaths except that we need to pass Digraph.
 */
public class DirectedDFS {
	public boolean[] marked;
	
	public DirectedDFS(Digraph G, int s){
		this.marked=new boolean[G.V()];
		dfs(G,s);
	}
	
	public DirectedDFS(Digraph G, Iterable<Integer> a) {
		this.marked=new boolean[G.V()];
		for(int v:a){
			if(!marked[v]) dfs(G,v);
		}
	}

	private void dfs(Digraph G, int v){
		marked[v]=true;
		for(int w: G.adj(v)){
			if(!marked[w]) dfs(G,w);
		}
	}
}
