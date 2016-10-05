package priorityqueue;

/**
 * @author Kunal
 * This code is of no use.
 */

public class UnorderedMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int n;
	
	@SuppressWarnings("unchecked")
	public UnorderedMaxPQ(int maxcapacity){
		pq=(Key[])new Comparable[maxcapacity];
		n=0;
	}
	
	public boolean isEmpty(){
		return n==0;
	}
	
	public void insert(Key x){
		pq[n++]=x;
	}
	
	public Key delMax(){
		int max=0;
		for(int i=0; i<n; i++){
			if(less(max,i)) max=i;
		}
		exch(pq,max,n-1);
		return pq[--n];
	}
	
	private boolean less(int a, int b){
		return pq[a].compareTo(pq[b])<0;
	}
	
	private void exch(Key[] pq, int a, int b){
		Key x=pq[a];
		pq[a]=pq[b];
		pq[b]=x;
	}
}
