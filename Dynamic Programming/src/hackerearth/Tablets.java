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

public class Tablets {
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
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			int[] dp=new int[n];
			int[] a=new int[n];

			a[0]=in.nextInt();
			dp[0]=1;
			
			for(int i=1; i<n; i++) a[i]=in.nextInt();
			
			for(int i=1; i<n; i++){
				if(a[i]>a[i-1]) dp[i]=dp[i-1]+1;
				else dp[i]=1;
			}
			
			for(int i=n-2; i>=0; i--){
				if(a[i]>a[i+1]){
					if(dp[i]<=dp[i+1]) dp[i]=dp[i+1]+1;
				}
			}
			
			long sum=0;
			for(int i=0; i<n; i++) sum+=dp[i];
			
			out.println(sum);
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
