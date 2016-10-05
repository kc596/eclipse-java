package mst;

import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

import graph.*;

public class KruskalMST {
	private Queue<Edge> mst = new LinkedList<Edge>();
	
	/*
	//comparator for creating maxPQ
	static class MAXPQ implements Comparator<Edge>{
		@Override
		public int compare(Edge e1, Edge e2) {
			if(e2.weight()-e1.weight()>0) return 1;
			else return -1;
		}
	}
	*/
	
	public KruskalMST(EdgeWeightedGraph G){
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();	//by default minPQ
		/**
		 * For MaxPQ, use comparators.
		 	MAXPQ comparator_maxpq=new MAXPQ();
			PriorityQueue<Edge> pq=new PriorityQueue<Edge>(comparator_maxpq);
		 */
		for(Edge e:G.edges()){
			pq.add(e);
		}
		
		UnionFind uf = new UnionFind(G.V());
		/*
		 * Idea is that, mst should not have cycles.
		 * So, if two point on graph are connected already, then new edge should
		   not join those connected points.
		 */
		while(!pq.isEmpty() && mst.size()<G.V()-1){
			Edge e=pq.poll();
			int v=e.either(), w=e.other(v);
			
			if(!uf.connected(v,w)){
				mst.add(e);
				uf.union(v, w);
			}
		}
	}
		
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public double weight(){
		//returns total weight of mst
		double wt=0;
		for(Edge e:mst){
			wt+=e.weight();
		}
		return wt;
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
		
		KruskalMST k = new KruskalMST(G);
		for(Edge e: k.edges()){
			int v=e.either();
			int w=e.other(v);
			double wt=e.weight();
			System.out.println(v+"--"+w+" "+wt);
		}
		System.out.println(k.weight());
	}
}
