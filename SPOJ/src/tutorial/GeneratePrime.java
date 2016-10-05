package tutorial;
/**
 * @author Kunal Chaudhary
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class GeneratePrime {
	private static final int ROOT=664580;
	static int[] primeArray=new int[ROOT];
	static boolean[] isPrimeArray=new boolean[10000000];
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		computePrime();
		Task solver=new Task();
		solver.solve(in,out);
		out.close();
	}
	private static void computePrime(){
		int k=0;
		for(int i=2; i<10000000; i++){
			isPrimeArray[i]=true;
		}
		for(int i=2; i<10000000; i++){
			if(isPrimeArray[i]){
				for(int j=i+i; j<10000000; j+=i){
					isPrimeArray[j]=false;
				}
				primeArray[k++]=i;				
			}
		}
		//System.out.println(count);
	}
	static class Task{
		public void solve(InputReader in, PrintWriter out){
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int n=in.nextInt();
				out.println(primeArray[n-1]);
			}
		}
	}
	//static nested class for taking input
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		
		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}
		
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}