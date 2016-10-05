package hackerrank;

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

public class Knapsack {
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
		static int k;
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				int n=in.nextInt(), k=in.nextInt();
				Integer[] c=new Integer[n];
				for(int i=0; i<n; i++) c[i]=in.nextInt();
				Arrays.sort(c);
				
				int[] dp=new int[k+1];		//[coin][weight]
				for(int i=1; i<k+1; i++){
					if(i>=c[0]) dp[i]=Math.max(dp[i-1], dp[i-c[0]]+c[0]);
					else dp[i]=dp[i-1];
					//out.print(dp[i]+" ");
				}
				
				for(int i=1; i<n; i++){
					int coin=c[i];
					for(int j=1; j<k+1; j++){
						if(j>=coin) dp[j]=Math.max(dp[j], dp[j-coin]+coin);
						else dp[j]=Math.max(dp[j-1], dp[j]);
						if(dp[j]>k) dp[j]-=coin;
					}
				}
				int ans=0;
				for(int i=0; i<k+1; i++){
					ans=Math.max(ans, dp[i]);
				}
				out.println(ans);
			}
		}
		
		static int knapsack(Integer[] a, int n, int k){
			if(n==0) return 0;
			return knapsack(a, n, k-a[n])+knapsack(a, n-1, k);
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
