package mst;

import graph.Edge;
import graph.EdgeWeightedGraph;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class LazyPrimMST {
	private boolean[] marked;					//vertices in mst
	private Queue<Edge> mst;
	private PriorityQueue<Edge> pq;
	
	public LazyPrimMST(EdgeWeightedGraph G){
		marked= new boolean[G.V()];
		mst = new LinkedList<Edge>();
		pq = new PriorityQueue<Edge>();			//min priority queue
		visit(G,0);
		
		while(!pq.isEmpty()){
			Edge e=pq.remove();
			int v=e.either(), w=e.other(v);
			if(marked[v] && marked[w]) continue;
			
			mst.add(e);
			if(!marked[v]) visit(G,v);
			if(!marked[w]) visit(G,w);
		}
	}
	
	private void visit(EdgeWeightedGraph G, int v){
		marked[v]=true;
		for(Edge e: G.adj(v)){
			if(!marked[e.other(v)]) pq.add(e);
		}
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	/*main*/
	public static void main(String[] args){
		EdgeWeightedGraph G= new EdgeWeightedGraph(8);
		G.addEdge(new Edge(4,5,0.35));
		G.addEdge(new Edge(4,7,0.37));
		G.addEdge(new Edge(5,7,0.28));
		G.addEdge(new Edge(0,7,0.16));
		G.addEdge(new Edge(1,5,0.32));
		G.addEdge(new Edge(0,4,0.38));
		G.addEdge(new Edge(2,3,0.17));
		G.addEdge(new Edge(1,7,0.19));
		G.addEdge(new Edge(0,2,0.26));
		G.addEdge(new Edge(1,2,0.36));
		G.addEdge(new Edge(1,3,0.29));
		G.addEdge(new Edge(2,7,0.34));
		G.addEdge(new Edge(6,2,0.40));
		G.addEdge(new Edge(3,6,0.52));
		G.addEdge(new Edge(6,0,0.58));
		G.addEdge(new Edge(6,4,0.93));
		
		LazyPrimMST p = new LazyPrimMST(G);
		for(Edge e: p.edges()){
			int v=e.either();
			int w=e.other(v);
			double wt=e.weight();
			System.out.println(v+"--"+w+" "+wt);
		}
	}
}

/*Output:
	0--7 0.16
	1--7 0.19
	0--2 0.26
	2--3 0.17
	5--7 0.28
	4--5 0.35
	6--2 0.4
*/