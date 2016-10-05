package geeksforgeeks;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _07R_CoinChange {
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
		static long[][] dp;
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt(), m=in.nextInt();
			Integer[] c=new Integer[m];
			dp=new long[m+1][n+1];
			for(int i=0; i<m+1; i++)
				for(int j=0; j<n+1; j++)
					dp[i][j]=-1;
			
			for(int i=0; i<m; i++) c[i]=in.nextInt();
			
			out.println(count(c, m, n));
		}
		static long count(Integer[] c, int m, int n){
			if(n==0) return 1;
			else if(n<0) return 0;
			if(m<=0 && n>=1) return 0;
			else if(dp[m][n]!=-1) return dp[m][n];
			else return dp[m][n]=(count(c, m-1, n) + count(c, m, n-c[m-1]));
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
