package sorting;
import java.util.Random;
/**
 * @author Kunal
 *
 */
@SuppressWarnings("rawtypes")
public class QuickSort {
	/*private static int partition(Comparable[] a, int lo, int hi){
		int i=lo, j=hi+1;
		while(true){
			while(less(a[++i],a[lo]))
				if(i==hi) break;
			while(less(a[lo],a[--j]))
				if(j==lo) break;
			
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}*/
	public static void sort(Comparable[] a){
		shuffle(a);
		sort(a,0,a.length-1);
		assert isSorted(a,0,a.length-1);
	}
	/*private static void sort(Comparable[] a, int lo, int hi){
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}*/
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi<=lo) return;
		int lt=lo, gt=hi;
		Comparable v=a[lo];
		int i=lo;
		while(i<=gt){
			@SuppressWarnings("unchecked")
			int cmp=a[i].compareTo(v);
			if(cmp<0) exch(a,lt++,i++);
			else if(cmp>0) exch(a,i,gt--);
			else i++;
		}
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	
	@SuppressWarnings("unchecked")
	private static boolean less(Comparable a, Comparable b){
		return a.compareTo(b)<0;
	}
	private static void exch(Comparable[] a, int i, int j){
		Comparable swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	private static void shuffle(Comparable[] a){
		int N=a.length;
		Random r=new Random();
		for(int i=0; i<N; i++){
			int rn=r.nextInt(i+1);
			exch(a,i,rn);
		}
	}
	private static boolean isSorted(Comparable[] a, int lo, int hi){
		for(int i=lo; i<hi; i++){
			if(less(a[i],a[i-1])) return false;
		}
		return true;
	}
}
