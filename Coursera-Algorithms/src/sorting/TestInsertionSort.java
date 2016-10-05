package sorting;
import java.util.Random;

public class TestInsertionSort {
	public static void main(String[] args){
		Random r=new Random();
		Integer[] arr=new Integer[100000];
		
		for(int i=0; i<100000; i++){
			arr[i]=r.nextInt();
		}
	
		final long startTime = System.currentTimeMillis();
		InsertionSort.sort(arr);
		final long duration = System.currentTimeMillis() - startTime;

		System.out.println("Runtime(Insertion Sort): "+duration);
	}
}

