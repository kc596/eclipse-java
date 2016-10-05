package regular_expressions;

import java.util.ArrayDeque;
import java.util.Stack;
import graph.Digraph;
import graph.DirectedDFS;

/**
 * @author Kunal
 *
 */
public class NFA {
	private char[] re;		//match transitions
	private Digraph G;		//epsilon transition digraph
	private int M;			//number of states
	
	public NFA(String regexp){
		this.M=regexp.length();
		re=regexp.toCharArray();
		G=buildEpsilonTransitionGraph();
	}
	
	public boolean recognizes(String txt){
		ArrayDeque<Integer> pc=new ArrayDeque<Integer>();
		DirectedDFS dfs=new DirectedDFS(G, 0);				//states reachable from 0(using null transition)
		for(int i=0; i<G.V(); i++)
			if(dfs.marked[i]) pc.add(i);
		
		for(int i=0; i<txt.length(); i++){
			ArrayDeque<Integer> match=new ArrayDeque<Integer>();
			for(int v: pc){									//transition(change state and scan to next text char)
				if(v==M) continue;
				if(re[v]==txt.charAt(i) || re[v]=='.') match.add(v+1);
			}
			
			dfs= new DirectedDFS(G, match);
			pc=new ArrayDeque<Integer>();
			for(int j=0; j<G.V(); j++)						//states reachable from state i 
				if(dfs.marked[j]) pc.add(j);
		}
		
		for(int v: pc)
			if(v==M) return true;
		return false;
	}
	
	private Digraph buildEpsilonTransitionGraph(){
		Digraph G=new Digraph(M+1);
		Stack<Integer> ops=new Stack<Integer>();
		for(int i=0; i<M; i++){
			int lp=i;
			
			if(re[i]=='(' || re[i]=='|') ops.push(i); 		//left parenthesis and |
			else if(re[i]==')'){							//2 way OR
				int or=ops.pop();
				if(re[or]=='|'){
					lp=ops.pop();
					G.addEdge(lp, or+1);
					G.addEdge(or, i);
				}
				else lp=or;
			}
			
			if(i<M-1 && re[i+1]=='*'){						//closure
				G.addEdge(lp, i+1);
				G.addEdge(i+1, lp);
			}
			
			if(re[i]=='(' || re[i]=='*' || re[i]==')')		//metasymbols
				G.addEdge(i, i+1);
		}
		return G;
	}
	
	/*demo*/
	public static void main(String[] args){
		NFA n=new NFA( "(a|aa)*b" );
		System.out.println(n.recognizes("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaac"));
	}
}
