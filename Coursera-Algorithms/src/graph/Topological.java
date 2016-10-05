package graph;

import java.util.Stack;

public class Topological{
/**
 * Topological order for an EdgeWeightedDigraph(with no directed cycles).
 * Topological order of any graph is its reverse post-order.
 */
	private Stack<Integer> reversePost;
	private boolean[] marked;
	
	public Topological(EdgeWeightedDigraph G){
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		for(int i=0; i<G.V(); i++){
			if(!marked[i]){
				dfs(G,i);
			}
		}
	}
	private void dfs(EdgeWeightedDigraph G, int v){
		marked[v]=true;
		for(DirectedEdge e: G.adj(v)){
			if(!marked[e.to()]) dfs(G, e.to());
		}
		reversePost.push(v);
	}
	public Iterable<Integer> order(){
		return reversePost;
	}
	
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(8);
		for(int i=0; i<16; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			double wt = sc.nextDouble();
			G.addEdge(new DirectedEdge(a,b,wt));
		}
		sc.close();
		
		Topological t = new Topological(G);
		Stack<Integer> st = (Stack<Integer>)t.order();
		while(!st.isEmpty()){
			System.out.print(st.pop()+" ");
		}
	}
}

/*
Input:-
	0 1 5.0
	0 4 9.0
	0 7 8.0
	1 2 12.0
	1 3 15.0
	1 7 4.0
	2 3 3.0
	2 6 11.0
	3 6 9.0
	4 5 4.0
	4 6 20.0
	4 7 5.0
	5 2 1.0
	5 6 13.0
	7 5 6.0
	7 2 7.0
Output:-
	0 4 1 7 5 2 3 6 
*/