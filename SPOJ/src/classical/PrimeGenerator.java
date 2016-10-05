package classical;
/**
 * @author Kunal Chaudhary
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PrimeGenerator {
	private static final int ROOT=31623;
	static boolean[] isPrimeArray=new boolean[ROOT];
	static int[] primeArray;
	public static void main(String[] args){
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		computePrime();
		Task solver=new Task();
		solver.solve(in,out);
		out.close();
	}
	static class Task{
		public void solve(InputReader in, PrintWriter out){
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int a=in.nextInt();
				int b=in.nextInt();
				
				for(int j=a; j<=b; j++){
					if(j==1) continue;
					if(isPrime(j)) out.println(j);
				}
				out.println();
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
	private static void computePrime(){
		int count=1,k=0;
		for(int i=2; i<ROOT; i++){
			isPrimeArray[i]=true;
		}
		for(int i=2; i<ROOT; i++){
			if(isPrimeArray[i]){
				for(int j=i+i; j<ROOT; j+=i){
					isPrimeArray[j]=false;
				}
				count++;
			}
		}
		//System.out.println(count);
		primeArray=new int[count];
		for(int i=2; i<ROOT; i++){
			if(isPrimeArray[i]){
				primeArray[k++]=i;
			}
		}
	}
	private static boolean isPrime(int a){
		for(int i=0; i<=a && i<3401; i++){
				if(a%primeArray[i]==0 && a!=primeArray[i]){
					return false;
				}
		}
		return true;
	}
}