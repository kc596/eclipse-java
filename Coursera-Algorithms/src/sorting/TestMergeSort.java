package sorting;
import java.util.Random;

public class TestMergeSort {
	public static void main(String[] args){
		Random r=new Random();
		Integer[] arr=new Integer[10000000];
		
		for(int i=0; i<10000000; i++){
			arr[i]=r.nextInt();
		}
	
		final long startTime = System.nanoTime();
		MergeSort.sort(arr);
		final long duration = System.nanoTime() - startTime;

		System.out.println("Runtime(Merge Sort): "+duration);
	}
}

