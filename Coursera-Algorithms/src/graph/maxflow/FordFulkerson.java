package graph.maxflow;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
	/**
	 * This algorithm calculates maxflow in a given FlowNetwork.
	 */
	private boolean[] marked;	//true is s->v path in residual network
	private FlowEdge[] edgeTo;	//last edge on s->v path
	private double value;		//value of the flow
	
	public FordFulkerson(FlowNetwork G, int s, int t){
		/**
		 * s = source
		 * t = destination
		 */
		value = 0.0;
		while(hasAugmentingPath(G,s,t)){
			double bottle = Double.POSITIVE_INFINITY;
			for(int v=t; v!=s; v=edgeTo[v].other(v))	//compute bottleneck capacity
				bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
			
			for(int v=t; v!=s; v=edgeTo[v].other(v))	//augment flow
				edgeTo[v].addResidualFlowTo(v, bottle);
			
			value+=bottle;
		}
	}
	
	private boolean hasAugmentingPath(FlowNetwork G, int s , int t){
		/*bfs is used*/
		edgeTo = new FlowEdge[G.V()];
		marked = new boolean[G.V()];
		
		Queue<Integer> queue= new LinkedList<Integer>();
		queue.offer(s);
		marked[s] = true;
		
		while(!queue.isEmpty()){
			int v=queue.poll();
			for(FlowEdge e: G.adj(v)){
				int w=e.other(v);
				if(e.residualCapacityTo(w)>0 && !marked[w]){
					edgeTo[w]=e;	//save last edge on path to w
					marked[w]=true;	//mark w
					queue.offer(w);	//add w to queue
				}
			}
		}
		
		return marked[t];			//is t reachable from s in residual network?
	}
	
	public double value(){
		return value;
	}
	
	public boolean inCut(int v){	//is v reachable from s in residual network?
		return marked[v];
	}
}
