package geeksforgeeks;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _15_LongestBitonicSubsequence {
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
			Integer[] a=new Integer[n];
			Integer[] rev=new Integer[n];
			Integer[] dp=new Integer[n];
			Integer[] dpr=new Integer[n];			
			Integer[] ans=new Integer[n];
			
			for(int i=0; i<n; i++){
				a[i]=in.nextInt();
				rev[n-i-1]=a[i];
			}
			
			for(int i=0; i<n; i++){
				dp[i]=1; dpr[i]=1;
			}
			
			for(int i=1; i<n; i++){
				for(int j=i-1; j>=0; j--){
					if(a[i]>a[j]) dp[i]=Math.max(dp[j]+1, dp[i]);
					if(rev[i]>rev[j]) dpr[i]=Math.max(dpr[j]+1, dpr[i]);
				}
			}
			
			int max=1;
			for(int i=0; i<n; i++){
				ans[i]=dp[i]+dpr[n-i-1]-1;
				max=Math.max(ans[i], max);
			}
			
			out.println(max);
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
