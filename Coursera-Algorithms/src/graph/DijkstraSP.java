package graph;

import java.util.Scanner;
import priorityqueue.IndexMinPQ;

public class DijkstraSP {
	/**
	 * This algorithm is used to calculate shortest path in a edge-weighted directed
	 * graph with non-negative weights.
	 * Idea:
	 	i. Consider vertices in increasing order of distance from source vertex s
	 		(non-tree vertex with the lowest distTo[] value)
	 	ii. Add vertex to tree and relax all edges pointing from that vertex.
	 */
	private double[] distTo;
	private DirectedEdge[] edgeTo;
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(EdgeWeightedDigraph G, int s){
		distTo= new double[G.V()];
		edgeTo= new DirectedEdge[G.V()];
		pq= new IndexMinPQ<Double>(G.V());			//maxN = G.V()
		
		for(int i=0; i<G.V(); i++){
			distTo[i]=Double.POSITIVE_INFINITY;
		}
		distTo[s]=0.0;
		
		pq.insert(s, 0.0);
		while(!pq.isEmpty()){
			int v = pq.delMin();
			for(DirectedEdge e: G.adj(v)){
				relax(e);
			}
		}
	}
	
	private void relax(DirectedEdge e){
		int v=e.from(), w=e.to();
		if(distTo[w] > distTo[v]+e.weight()){
			distTo[w]= distTo[v]+e.weight();
			edgeTo[w]= e;
			
			if(pq.contains(w)){
				if(pq.keyOf(w)>distTo[w]) pq.changeKey(w, distTo[w]);
			}
			else pq.insert(w, distTo[w]);
		}
	}
	
	/*demo*/
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		EdgeWeightedDigraph G=new EdgeWeightedDigraph(8);
		for(int i=0; i<16; i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			double w=sc.nextDouble();
			G.addEdge(new DirectedEdge(a,b,w));
		}
		DijkstraSP sp= new DijkstraSP(G,0);
		for(double i:sp.distTo){
			System.out.println(i);
		}
		sc.close();
	}
}
/*
Input:
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
	
Output:
	0.0
	5.0
	14.0
	17.0
	9.0
	13.0
	25.0
	8.0
*/
