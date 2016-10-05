package sorting;

/**
 * @author Kunal
 *
 */

@SuppressWarnings("rawtypes")
public class HeapSort {
	public void sort(Comparable[] a){
		int N=a.length;
		for(int i=N/2; i>=1; i--){
			exch(a,1,N--);
			sink(a,1,N);
		}
	}
	
	private static void sink(Comparable[] a, int k, int N){
		while(2*k<=N){
			int j=2*k;
			if(j<N && less(a,j,j+1)) j++; 	//largest of 2 children
			if(less(a,j,k)) break;			//if(child<parent) break since all is normal now;
			exch(a,j,k);
			k=j;
		}
	}
	@SuppressWarnings("unchecked")
	private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }
	private static void exch(Comparable[] pq, int a, int b){
		Comparable swap=pq[a];
		pq[a]=pq[b];
		pq[b]=swap;
	}
}
