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

public class _04R_LongestCommonSubsequence {
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
		static int[][] dp;
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				int n1=in.nextInt(), n2=in.nextInt();
				dp=new int[n1][n2];
				for(int i=0; i<n1; i++)
					for(int j=0; j<n2; j++)
						dp[i][j]=-1;
				
				String A=in.next(), B=in.next();
				
				out.println(LCS(A,B, n1,n2));
			}
		}
		
		static int LCS(String A, String B, int n1, int n2){
			if(n1==0 || n2==0) return 0;
			if(dp[n1-1][n2-1]!=-1) return dp[n1-1][n2-1];
			
			if(A.charAt(n1-1)==B.charAt(n2-1)){
				return dp[n1-1][n2-1]=1+LCS(A, B, n1-1, n2-1);
			}
			else return dp[n1-1][n2-1]=Math.max(LCS(A, B, n1-1, n2), LCS(A,B, n1, n2-1));
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
