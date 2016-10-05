package sorting;
@SuppressWarnings("all")
public class SelectionSort{
	public static void sort(Comparable[] a){
		int min;
		int N=a.length;
		for(int i=0; i<N; i++){
			min=i;
			for(int j=i+1; j<N; j++){
				if(less(a[j],a[min])) min=j;
			}
			swap(a,min,i);
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