package graph;

/**
 * Finding shortest path from a source vertex to every vertex
 * of an EdgeWeightedDigraph using Bellman-Ford algorithm.
 * @author Kunal
 */

public class BellmanFordSP {
	private double[] distTo;				//distance of shortest path from s to v
	private DirectedEdge[] edgeTo;			//edgeTo[w] = edge used to reach w
	
	public BellmanFordSP(EdgeWeightedDigraph G, int s){
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		for(int i=0; i<G.V(); i++)
			distTo[i]=Double.POSITIVE_INFINITY;
		
		distTo[s]=0;
		
		for(int i=0; i<G.V(); i++)
			for(int v=0; v<G.V(); v++)
				for(DirectedEdge e: G.adj(v))
					relax(e);
	}
	
	private void relax(DirectedEdge e){
		int v=e.from(), w=e.to();
		if(distTo[w] > distTo[v]+e.weight()){
			distTo[w] = distTo[v]+e.weight();
			edgeTo[w] = e;
		}
	}
	
	/*demo*/
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

		BellmanFordSP bfsp=new BellmanFordSP(G,0);
		for(double i:bfsp.distTo){
			System.out.println(i);
		}
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