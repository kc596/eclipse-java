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

public class TheCoinChangeProblem {
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
			int n=in.nextInt(), m=in.nextInt();
			Integer[] c=new Integer[m];
			long[][] dp=new long[m+1][n+1];
			
			for(int i=0; i<m+1; i++) dp[i][0]=1;	//0 amount	-> 1 WAY
			
			for(int i=0; i<m; i++) c[i]=in.nextInt();
			Arrays.sort(c);
			
			for(int i=1; i<m+1; i++){		//coins
				int coin_value=c[i-1];
				for(int j=1; j<n+1; j++){	//amount
					if(j<coin_value) dp[i][j]=dp[i-1][j];
					else dp[i][j]=dp[i][j-coin_value]+dp[i-1][j];
				}
			}
			out.println(dp[m][n]);
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
