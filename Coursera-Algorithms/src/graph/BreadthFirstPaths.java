package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Kunal
 *
 */
public class BreadthFirstPaths {
	private static final int INFINITY=Integer.MAX_VALUE;
	private boolean[] marked;	//marked[v] == true, if there is a path from s to v
	private int[] edgeTo;		//edgeTo[v] = w, then w--v path was used to reach w
	private int[] distTo;		//distTo[v] = number of edges in shortest path from s to v
	
	public BreadthFirstPaths(Graph G, int s){
		this.marked=new boolean[G.V()];
		this.edgeTo=new int[G.V()];
		this.distTo=new int[G.V()];
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s){
		Queue<Integer> q=new LinkedList<Integer>();
		for(int v=0; v<G.V(); v++){
			distTo[v]=INFINITY;
		}
		distTo[s]=0;
		marked[s]=true;
		
		q.offer(s);
		
		while(!q.isEmpty()){
			int v=q.poll();
			for(int w: G.adj(v)){
				if(!marked[w]){
					edgeTo[w]=v;
					distTo[w]=distTo[v]+1;
					marked[w]=true;
					q.offer(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public int distTo(int v){
		/**
		 * returns INTEGER.MAX_VALUE for unreachable paths.
		 * Handle this in main program.
		 */
		return distTo[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> s = new Stack<Integer>();
		int x;
		for(x=v; distTo[x]!=0; x=edgeTo[x]){	//since first point's distance is zero
			s.push(x);
		}
		s.push(x);
		return s;
	}
}
