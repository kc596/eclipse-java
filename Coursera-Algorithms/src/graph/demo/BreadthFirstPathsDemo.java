package graph.demo;

import java.util.Scanner;
import java.util.Stack;
import graph.*;
/**
 * @author Kunal
 *
 */
public class BreadthFirstPathsDemo {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		Graph G=new Graph(size);
		int a=sc.nextInt();
		int b=sc.nextInt();
		G.addEdge(a,b);
		while(a!=b){
			a=sc.nextInt();
			b=sc.nextInt();
			G.addEdge(a, b);
		}
		
		System.out.println("Enter starting point of path");
		int from=sc.nextInt();
		BreadthFirstPaths bfp=new BreadthFirstPaths(G,from);
		//System.out.println(bfp.hasPathTo(13));
		
		System.out.println("Enter ending point of path");
		int to=sc.nextInt();
		
		if(bfp.hasPathTo(to)){
			Stack<Integer> s=(Stack<Integer>)bfp.pathTo(to);
			while(!s.empty()){
				System.out.println(s.pop());
			}
		}
		else{
			System.out.println("No path");
		}
		
		sc.close();
	}
}
