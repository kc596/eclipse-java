package sorting;
import java.util.Random;

public class TestHeapSort {
	private final static int N=10000000;
	public static void main(String[] args){
		Random r=new Random();
		Integer[] arr=new Integer[N];
		
		for(int i=0; i<N; i++){
			arr[i]=r.nextInt();
		}
	
		final long startTime = System.nanoTime();
		QuickSort.sort(arr);//10578676213
		final long duration = System.nanoTime() - startTime;

		/*System.out.println();
		for(int i=0; i<N; i++){
			System.out.print(arr[i]+" ");
		}*/
		System.out.println("Runtime(Quick Sort): "+duration);
	}
}

