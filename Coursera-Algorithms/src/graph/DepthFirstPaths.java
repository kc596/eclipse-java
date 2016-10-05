package graph;

import java.util.Stack;
/**
 * @author Kunal
 *
 */
public class DepthFirstPaths {
	private boolean[] marked;	//marked[v]==true if v is connected to s.
	private int[] edgeTo;		//edgeTo[w]=v if edge v--w used to visit w for first time
	private final int s;		//source vertex
	
	public DepthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s=s;
		
		dfs(G,s);				//automatically traverse through graph from s
	}
	
	private void dfs(Graph G, int v){
		marked[v]=true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G,w);
				edgeTo[w]=v;
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer>  pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path=new Stack<Integer>();
		for(int x=v; x!=s; x=edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}
}
