package graph.demo;

import java.util.Stack;
import graph.*;
/**
 * @author Kunal
 */
public class DepthFirstPathsDemo {
	/*demo*/
	public static void main(String[] args){
		Graph g=new Graph(10);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		//g.addEdge(4, 9);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(7, 1);
		g.addEdge(8, 0);
		
		DepthFirstPaths p=new DepthFirstPaths(g,9);
		System.out.println(p.hasPathTo(9));
		
		if(p.hasPathTo(4)){
			Stack<Integer> s=(Stack<Integer>)p.pathTo(4);
			while(!s.empty()){
				System.out.println(s.pop());
			}
		}
	}
}
