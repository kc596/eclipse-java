package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kunal
 * Program is same as BreadthFirstPaths for Undirected Graphs.
 */
public class DirectedBFS {
	private boolean[] marked;
	private int[] distTo;
	
	public DirectedBFS(Digraph G, int s){
		this.marked=new boolean[G.V()];
		this.distTo=new int[G.V()];	
		bfs(G,s);
	}
	
	private void bfs(Digraph G, int s){
		for(int i=0; i<G.V(); i++) distTo[i]=Integer.MAX_VALUE;
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(s);
		marked[s]=true;
		distTo[s]=0;
		
		while(!q.isEmpty()){
			int v=q.poll();					//already marked true
			for(int w: G.adj(v)){
				if(!marked[w]){
					marked[w]=true;
					distTo[w]=distTo[v]+1;
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
}
