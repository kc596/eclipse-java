package sorting;
@SuppressWarnings("all")
public class MergeSort {
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
		assert isSorted(a,lo,mid);
		assert isSorted(a, mid+1, hi);
		
		for(int i=lo; i<=hi; i++) aux[i]=a[i];
		
		int j=lo, k=mid+1;
		for(int i=lo; i<=hi; i++){
			if(j>mid)		a[i]=aux[k++];
			else if(k>hi)	a[i]=aux[j++];
			else if(less(aux[j],aux[k])) a[i]=aux[j++];
			else a[i]=aux[k++];
		}
		
		assert isSorted(a, lo, hi);
	}
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
		if(hi<=lo) return;
		int mid=lo+(hi-lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		

		//if(less(a[mid],a[mid+1]))

		merge(a, aux, lo, mid, hi);
	}
	public static void sort(Comparable[] a){
		Comparable[] aux=new Comparable[a.length];
		sort(a, aux, 0, (a.length)-1);
	}

	@SuppressWarnings("unchecked")


	private static boolean less(Comparable a, Comparable b){
		return a.compareTo(b)<0;
	}
	private static boolean isSorted(Comparable[] a, int lo, int hi){
		for(int i=lo; i<hi; i++){
			if(less(a[i],a[i-1])) return false;
		}
		return true;
	}
}

