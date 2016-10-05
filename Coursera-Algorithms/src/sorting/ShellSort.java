package sorting;
@SuppressWarnings("all")
public class ShellSort{
	public static void sort(Comparable[] a){
		int N=a.length, h=1;

		while(h<N/3){
			h=3*h+1;	//1,4,13,40,121,364,..
		}

		while(h>=1){
			//h-sort (insertion sort) the array
			for(int i=h; i<N; i++){
				for(int j=i; j>=h; j-=h){
					if(less(a[j],a[j-h])) swap(a,j,j-h);
					else break;
				}
				h=h/3;
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