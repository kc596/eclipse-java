package graph.demo;

import java.util.Scanner;
import graph.*;

/**
 * @author Kunal
 *
 */
public class KosarajuSharirSCCDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		int V=sc.nextInt();
		Digraph G=new Digraph(V);
		
		System.out.println("Enter directed edges and connect same edge twice to exit");
		int a=sc.nextInt();
		int b=sc.nextInt();
		while(a!=b){
			G.addEdge(a, b);
			a=sc.nextInt();
			b=sc.nextInt();
		}

		KosarajuSharirSCC scc=new KosarajuSharirSCC(G);
		System.out.println(scc.count());
		for(int i=0; i<V; i++){
			System.out.print(scc.id(i)+" ");
		}
		System.out.println();
		
		sc.close();
	}
}
/*Input:-
13
0 1
0 5
2 0
2 3
3 2
3 5
4 3
5 4
6 4
6 0
6 9
6 8
7 9
7 6
8 6
9 11
9 10
10 12
11 12
11 4
12 9
0 0
*/

/*Output:-
5
1 0 1 1 1 1 3 4 3 2 2 2 2
*/