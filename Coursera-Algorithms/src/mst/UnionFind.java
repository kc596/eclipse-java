package mst;

public class UnionFind {
	private int[] id, size;
	
	public UnionFind(int n){
		id = new int[n];
		size = new int[n];
		for(int i=0; i<n; i++){
			id[i]=i;
			size[i]=1;
		}
	}
	
	private int root(int a){
		while(id[a]!=a){
			a=id[a];
		}
		return a;
	}
	
	public void union(int a, int b){
		int p = root(a);
		int q = root(b);
		if(p==q) return;
		
		if(size[p]>=size[q]){
			id[q]=p;
			size[p]+=size[q];
		}
		else{
			id[p]=q;
			size[q]+=size[p];
		}
	}
	
	public boolean connected(int a, int b){
		return root(a)==root(b);
	}
	
	/*main function for testing*/
	public static void main(String[] args){
		UnionFind uf=new UnionFind(6);
		uf.union(1, 2);
		uf.union(0, 1);
		uf.union(0, 2);
		uf.union(2, 4);
		uf.union(2, 3);
		
		System.out.println(uf.connected(2,5));
	}
}
