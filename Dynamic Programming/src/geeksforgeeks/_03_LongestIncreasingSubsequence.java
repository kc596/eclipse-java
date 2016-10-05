package geeksforgeeks;

/**
 * @author Kunal
 * Time Complexity: O(n^2)
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _03_LongestIncreasingSubsequence {
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
			int t=in.nextInt();
			while(t-->0){
			    int max=1,n=in.nextInt();
			    int[] a=new int[n];
			    int[] dp=new int[n];
			    a[0]=in.nextInt();
			    dp[0]=1;
			    for(int i=1; i<n; i++){
			        dp[i]=1;
			        a[i]=in.nextInt();
			        for(int j=i-1; j>=0; j--){
			            if(a[i]>a[j]) dp[i]=Math.max(dp[j]+1, dp[i]);
			        }
			        max=Math.max(max, dp[i]);
			    }
			    out.println(max);
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
