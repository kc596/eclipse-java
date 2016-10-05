package graph.demo;

import java.util.LinkedList;
import graph.*;
/**
 * @author Kunal
 */

public class GraphDemo {

	public static void main(String[] args) {
		Graph g=new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 6);
		
		LinkedList<Integer> l=(LinkedList<Integer>)g.adj(4);
		System.out.println(l);
	}

}
