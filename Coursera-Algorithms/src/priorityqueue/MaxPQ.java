package priorityqueue;

/**
 * @author Kunal
 * Binary Heap MaxPQ
 * Note: Indexing starts from 1
 */

public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int n;
	
	@SuppressWarnings("unchecked")
	public MaxPQ(int capacity){
		pq=(Key[])new Comparable[capacity+1];
	}
	
	public boolean isEmpty(){
		return n==0;
	}
	
	public void insert(Key k){
		pq[++n]=k;
		swim(n);
	}
	public Key delMax(){
		Key max=pq[1];
		exch(1,n--);	//swapping first and last and deleting max(last) element
		sink(1);
		pq[n+1]=null;
		return max;
	}
	public void printQueue(){
		for(int i=1; i<=n; i++){
			System.out.print(pq[i]+" ");
		}
		System.out.println();
	}
	/*helper functions*/
	private void swim(int k){
		while(k>1 && less(k/2,k)){
			exch(k,k/2);
			k=k/2;
		}
	}
	private void sink(int k){
		while(2*k<=n){
			int j=2*k;
			if(j<n && less(j,j+1)) j++;	//choosing the largest child
			if(less(j,k)) break;		//sink till k does not becomes greater than children
			exch(k,j);
			k=j;
		}
	}
	
	private boolean less(int a, int b){
		return pq[a].compareTo(pq[b])<0;
	}
	private void exch(int a, int b){
		Key swap=pq[a];
		pq[a]=pq[b];
		pq[b]=swap;
	}
}
