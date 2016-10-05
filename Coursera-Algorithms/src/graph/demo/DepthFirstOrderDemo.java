package graph.demo;
import graph.*;
import java.util.Scanner;

/**
 * @author Kunal
 *
 */
public class DepthFirstOrderDemo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int V=sc.nextInt();
		Digraph G=new Digraph(V);
		int a=sc.nextInt();
		int b=sc.nextInt();
		while(a!=b){
			G.addEdge(a, b);
			a=sc.nextInt();
			b=sc.nextInt();
		}
		
		DepthFirstOrder df=new DepthFirstOrder(G);
		for(int w: df.reversePost()){
			System.out.print(w+" ");
		}
		System.out.println();
		sc.close();
	}

}
/*Input:-
7
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
6 4
0 0
 */
/*
Output:-	4 1 2 5 0 6 3	//postorder
			3 6 0 5 2 1 4	//topological order
We may get different order by changing order of adding edge.
*/