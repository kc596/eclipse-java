package graph;

/**
 * @author Kunal
 *
 */
public class Edge implements Comparable<Edge> {
	private int V,W;
	private double weight;
	
	public Edge(int V, int W, double weight){
		this.V=V;
		this.W=W;
		this.weight=weight;
	}
	
	public int either(){
		return V;
	}
	
	public int other(int v){
		if(V==v) return W;
		else return V;
	}

	public double weight(){
		return weight;
	}
	@Override
	public int compareTo(Edge a){
		if(this.weight < a.weight) return -1;
		else if(this.weight > a.weight) return 1;
		else return 0;
	}

	public String toString(){
		return (this.V+"-"+this.W+" "+this.weight);
	}
}
