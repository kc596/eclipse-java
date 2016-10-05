package graph;

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
			for(int i=0; i<V; i++)
				for(int j=0; j<V; j++)
					dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
	}
}