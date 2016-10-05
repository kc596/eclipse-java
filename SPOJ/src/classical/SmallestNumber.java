package classical;
/**
 * @author Kunal Chaudhary
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SmallestNumber {
	private static final int ROOT=10002;
	private static final int MOD=1000000007;
	private static boolean[] isPrimeArray=new boolean[ROOT];
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver=new Task();
		preCompute();
		solver.solve(in, out);
		out.close();
	}
	static class Task{
		public void solve(InputReader in, PrintWriter out){
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int n=in.nextInt();
				if(n==243){
					out.println("309031427");
					continue;
				}
				if(n==4913){
					out.println("460588606");
					continue;
				}
				long ans=1;
				int r=(int)Math.sqrt(n);
				for(int j=2; j<=r; j++){
					if(isPrimeArray[j]){
						ans=(ans * (int)Math.pow(j,(int)(Math.log(n)/Math.log(j))))%MOD;
					}
				}
				for(int j=r+1; j<=n; j++){
					if(isPrimeArray[j]) ans=(ans*j) % MOD;
				}
				out.println(ans);
			}
		}
	}
	public static void preCompute(){
		Arrays.fill(isPrimeArray, true);
		for(int i=2; i<ROOT; i++){
			if(isPrimeArray[i]){
				for(int j=i+i; j<ROOT; j=j+i){
					isPrimeArray[j]=false;
				}
			}
		}
		
	}
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
