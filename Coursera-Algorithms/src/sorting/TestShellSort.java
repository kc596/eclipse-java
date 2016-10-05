package sorting;
import java.util.Random;

public class TestShellSort {
	public static void main(String[] args){
		Random r=new Random();
		Integer[] arr=new Integer[10000000];
		
		for(int i=0; i<10000000; i++){
			arr[i]=r.nextInt();
		}
	
		final long startTime = System.nanoTime();
		ShellSort.sort(arr);
		final long duration = System.nanoTime() - startTime;

		System.out.println("Runtime(Shell Sort): "+duration);
	}
}

