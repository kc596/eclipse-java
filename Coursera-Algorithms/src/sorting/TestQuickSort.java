package sorting;
import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("unused")
public class TestQuickSort {
	private final static int N=10000000;
	public static void main(String[] args){
		Random r=new Random();
		Integer[] arr=new Integer[N];
		
		for(int i=0; i<N; i++){
			arr[i]=r.nextInt();
		}
	
		final long startTime = System.nanoTime();
		QuickSort.sort(arr);	//10578676213 7519088994(w/o shuffling)
		//Arrays.sort(arr);		//5501255807
		final long duration = System.nanoTime() - startTime;

		/*System.out.println();
		for(int i=0; i<N; i++){
			System.out.print(arr[i]+" ");
		}*/
		System.out.println("Runtime(Quick Sort): "+duration);
	}
}

