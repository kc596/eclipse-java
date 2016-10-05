package graph;

import java.util.Stack;

//import java.util.Stack;

/**
 * @author Kunal
 *
 */
public class KosarajuSharirSCC {
	private boolean[] marked;
	private int[] id;
	private int count;	//for indexing of id
	
	public KosarajuSharirSCC(Digraph G) {
		this.marked=new boolean[G.V()];
		this.id=new int[G.V()];
		count=0;
		
		DepthFirstOrder dfo=new DepthFirstOrder(G.reverse());
		Stack<Integer> s = dfo.reversePost();
		while(!s.empty()){
			int v = s.pop();
			if(!marked[v]){
				dfs(G,v);
				count++;
			}
		}
		/**
		 * Other Possible Implementation:-
			# DepthFirstOrder dfo=new DepthFirstOrder(G);
			# for(int v: dfo.reversePost()){
			#	if(!marked[v]){
			#		dfs(G,v);	//we could use other traversal here too
			#		count++;
			#	}
			# }
			
			Note that for-each loop is used to access the stack.
		 */
	}

	private void dfs(Digraph G, int v){
		marked[v]=true;
		id[v]=count;
		for(int w: G.adj(v)){
			if(!marked[w]) dfs(G,w);
		}
	}
	
	public int count(){	//returns total number of strong components
		return count;
	}
	
	public boolean stronglyConnected(int v, int w){
		return id[v]==id[w];
	}
	
	public int id(int v){
		return id[v];
	}
	
	/*private Iterable<Integer> reverseStack(Stack<Integer> reversePost){
		Stack<Integer> s= new Stack<Integer>();
		while(!reversePost.empty()){
			s.push(reversePost.pop());
		}
		return s;
	}*/
}
