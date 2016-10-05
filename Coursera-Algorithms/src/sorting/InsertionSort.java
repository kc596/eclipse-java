package sorting;
@SuppressWarnings("all")
public class InsertionSort {
	public static void sort(Comparable[] a){
		int N=a.length;
		for(int i=0; i<N; i++){
			for(int j=i; j>0 && less(a[j],a[j-1]); j--){
				swap(a,j,j-1);
			}
		}
	}

	private static boolean less(Comparable a, Comparable b){
		return a.compareTo(b)<0;
	}

	public static void swap(Comparable[] a, int i, int j){	//copies reference to array
		Comparable swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
}

