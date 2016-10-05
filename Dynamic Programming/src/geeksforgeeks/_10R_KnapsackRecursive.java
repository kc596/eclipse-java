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

public class _10R_KnapsackRecursive {
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
		static Integer[][] dp;
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				int n=in.nextInt(), w=in.nextInt();
				Integer[] value=new Integer[n];
				Integer[] wt=new Integer[n];
				dp=new Integer[n+1][w+1];
				
				for(int i=0; i<n; i++) value[i]=in.nextInt();
				for(int i=0; i<n; i++) wt[i]=in.nextInt();
				
				out.println(knapSack(value, wt, n, w));
			}
		}
		static int knapSack(Integer[] value, Integer[] wt, int n, int w){
			if(w==0 || n==0) return 0;
			else if(dp[n][w]!=null) return dp[n][w];
			else if(w<wt[n-1]) return dp[n][w]=knapSack(value, wt, n-1, w);
			return dp[n][w]=Math.max(knapSack(value, wt, n-1, w), value[n-1]+knapSack(value, wt, n-1, w-wt[n-1]));
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
