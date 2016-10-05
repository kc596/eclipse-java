package unionfind;

/**
 * @author Kunal
 * Weighted QuickUnion
 * Depth of any node is atmost log2(N)
 */
public class QuickUnion{
	private int[] id;
	private int[] size;
	
	public QuickUnion(int a){
		id=new int[a];
		size=new int[a];
		for(int i=0; i<a; i++){
			size[i]=1;
			id[i]=i;
		}
	}
	
	private int root(int i){
		while(id[i]!=i){
			id[i]=id[id[i]];
			i=id[i];
		}
		return i;
	}
	
	public boolean isConnected(int p, int q){
		return root(p)==root(q);
	}
	
	public void union(int p, int q){
		int pid=root(p);
		int qid=root(q);
		if(pid==qid) return;
		
		if(size[p]>size[q]){
			id[qid]=pid;
			size[pid]+=size[qid];
		}
		else{
			id[pid]=qid;
			size[qid]+=size[pid];
		}
	}
}
