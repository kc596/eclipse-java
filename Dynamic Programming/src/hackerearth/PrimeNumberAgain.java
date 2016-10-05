package hackerearth;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PrimeNumberAgain {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		Task1 solver = new Task1();
		solver.solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		static final int MN=10001;
		public void solve(InputReader in, PrintWriter out) {
			java.util.ArrayList<Integer> primes=new java.util.ArrayList<Integer>();	
			boolean[] isPrime=new boolean[MN];
			int[] dp=new int[MN];
			for(int i=0; i<MN; i++) dp[i]=MN;
			for(int i=2; i<MN; i++) isPrime[i]=true;			
			
			for(int i=2; i<MN; i++){
				if(isPrime[i]){
					for(int j=i+i; j<MN; j+=i)
						isPrime[j]=false;
					
					dp[i]=1;
					primes.add(i);
				}
				if(i==4) primes.add(4);
				if(i==27) primes.add(27);
				if(i==3125) primes.add(3125);
			}
			dp[4]=dp[27]=dp[3125]=1;
			
			for(int i=2; i<MN; i++){
				if(dp[i]==1) continue;
				else{
					for(int j=0; j<primes.size(); j++){
						int p=primes.get(j);
						if(p>=i-1) break;
						dp[i]=Math.min(dp[i], dp[i-p]+1);
						if(dp[i]==2) break;
					}
				}
			}			
			
			int t=in.nextInt();
			while(t-->0){
				int n=in.nextInt();
				out.println(dp[n]);
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

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
