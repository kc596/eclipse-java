package graph;

/**
 * @author Kunal
 *
 */
public class ConnectedComponents {
	private boolean[] marked;				//visited or not
	private int[] id;						//id[v] = id of component containing v
	private int count;						//number of connected components
	
	public ConnectedComponents(Graph G){
		this.marked=new boolean[G.V()];
		this.id=new int[G.V()];
		this.count=0;
		
		for(int v=0; v<G.V(); v++){
			if(!marked[v]){
				dfs(G,v);
				count++;
			}
		}
	}
	
	private void dfs(Graph G, int v){
		marked[v]=true;
		id[v]=count;
		for(int w:G.adj(v)){
			if(!marked[w])
				dfs(G,w);
		}
	}
	
	public int count(){
		return count;
	}
	
	public int id(int v){
		return id[v];
	}
}
