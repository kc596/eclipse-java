package classical.unsolved;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimeIntervals {
	private static final int ROOT=46342;
	public static boolean[] isPrime=new boolean[ROOT];
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		preCompute();
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}
	private static void preCompute(){
		Arrays.fill(isPrime,true);
		isPrime[0]=isPrime[1]=false;
		for(int i=2; i<ROOT; i++){
			if(isPrime[i]){
				for(int j=i+i; j<ROOT; j=j+i){
					isPrime[j]=false;
				}
			}
		}
	}
	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int l=in.nextInt();
				int u=in.nextInt();
				int D=u-l;
				if(u<ROOT){
					for(int j=l; j<=u; j++){
						if(isPrime[j]) out.println(j);
					}
				}
				else{
					boolean[] isBigPrime=new boolean[D+1];//0=l, 1=l+1, .... , D=u
					Arrays.fill(isBigPrime, true);
					for(int j=2; j<ROOT; j++){
						if(isPrime[j]){
							int mod=(l%j);
							if(mod==0) mod=j;
							for(int k=l-mod+j; k<=u; k=k+j){
								isBigPrime[k-l]=false;
							}
						}
					}
					for(int j=l; j<=u; j++){
						if(isBigPrime[j-l]) out.println(j);
					}
				}
			}
		}
		@SuppressWarnings("unused")
		private static boolean computePrime(int p, int root){
			for(int i=2; i<=root; i++){
				if(isPrime[i]){
					if(p%i==0) return false;
				}
			}
			return true;
		}
	}//--end of task--

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
