package graph;

/**
 * This is an all-path shortest path algorithm for a given weighted Digraph.
 * @author Kunal
 *
 */
public class FloydWarshall {
	final static Integer INF=1000000009;
	final int V;
	private int[][] dist;
	public FloydWarshall(int[][] graph){
		this.V=graph.length;
		this.dist=new int[V][V];
		
		for(int i=0; i<V; i++)
			for(int j=0; j<V; j++)
				dist[i][j]=graph[i][j];
		
		for(int k=0; k<V; k++)
			for(int i=0; i<V; i++)		//pick all vertices as source one by one
				for(int j=0; j<V; j++)	//pick all vertices as destination for the above source
					dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					//if k is on the shortest path from i to j then update dist[i][j]
	}
	
	/*demo*/
	public static void main(String[] args){
		int[][] graph={
				{0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
		};
		
		FloydWarshall ff=new FloydWarshall(graph);
		for(int[] i: ff.dist){
			for(int j: i)
				System.out.print(j+" ");
			System.out.println();
		}
	}
}
