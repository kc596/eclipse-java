package sorting;
import java.util.Random;

public class TestMergeSort {
	static final int MAX = 20;
	public static void main(String[] args){
		Random r=new Random();
		Integer[] arr=new Integer[MAX];
		
		for(int i=0; i<MAX; i++){
			arr[i]=r.nextInt()%40;
		}
	
		final long startTime = System.nanoTime();
		MergeSort.sort(arr);
		for(int i: arr){
			System.out.print(i+" ");
		}
		final long duration = System.nanoTime() - startTime;

		System.out.println("Runtime(Merge Sort): "+duration);
	}
}

