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

public class _12R_LongestPalindromicSubsequenceRecursive {
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
		static StringBuilder aa;
		public void solve(InputReader in, PrintWriter out) {
			String s=in.next();
			int n=s.length();
			dp=new Integer[n][n];
			out.println(lps(s,0,n-1));
		}
		static int lps(String a,int lo, int hi){
			if(lo>hi) return 0;
			else if(dp[lo][hi]!=null)
				return dp[lo][hi];
			else if(lo==hi)
				return dp[lo][hi]=1;
			else if(a.charAt(lo)==a.charAt(hi))
				return dp[lo][hi]=lps(a, lo+1, hi-1)+2;
			else
				return dp[lo][hi]=Math.max(lps(a, lo+1, hi), lps(a,lo, hi-1));
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
