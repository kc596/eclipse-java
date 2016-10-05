package graph;

import java.util.Stack;

/**
 * @author Kunal
 *
 */
public class DepthFirstOrder {
	private boolean[] marked;
	private Stack<Integer> reversePost;	//contains vertices in reverse topological order
	
	public DepthFirstOrder(Digraph G){
		//if(isCyclic(G)) throw new Exception("Cyclic graph so topological sort is not possible");
		reversePost=new Stack<Integer>();
		this.marked=new boolean[G.V()];
		for(int v=0; v<G.V(); v++){
			if(!marked[v]){
				dfs(G,v);
			}
		}
	}
	
	private void dfs(Digraph G, int v){
		marked[v]=true;
		for(int w: G.adj(v)){
			if(!marked[w]) dfs(G,w);
		}
		reversePost.push(v);
	}
	
	public Stack<Integer> reversePost(){
		return (reversePost);
	}
	
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		Digraph G = new Digraph(7);
		int a=7,b=8;
		while(a!=0 || b!=0){
			a=sc.nextInt();
			b=sc.nextInt();
			if(a!=0 || b!=0){
				G.addEdge(a, b);
			}
		}
		DepthFirstOrder dfo = new DepthFirstOrder(G);
		Stack<Integer> s = dfo.reversePost();
		System.out.print("Postorder: ");
		for(int i: s){
			System.out.print(i+" ");
		}
		System.out.print("\nTopological Order: ");
		while(!s.isEmpty()){
			System.out.print(s.pop()+" ");
		}
		sc.close();
	}
}
/*Input:-
0 1
0 2
0 5
1 4
3 2
3 4
3 5
3 6
5 2
6 0
0 0
 */
