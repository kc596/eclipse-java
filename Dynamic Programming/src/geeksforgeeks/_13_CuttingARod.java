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

public class _13_CuttingARod {
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
			int n=in.nextInt();				//length of rod
			Integer[] p=new Integer[n+1];	//price of pieces
			p[0]=0;
			
			for(int i=1; i<=n; i++) p[i]=in.nextInt();
			
			/* #### ITERATIVE #### */
			int[][] dp=new int[n+1][n+1];
			
			for(int i=1; i<=n; i++){
				int price=p[i];
				for(int j=1; j<=n; j++){
					if(j<i) dp[i][j]=dp[i-1][j];
					else dp[i][j]=Math.max(dp[i][j-i]+price, dp[i-1][j]);
				}
			}
			out.println(dp[n][n]);
			
			/* #### RECURSIVE #### */
			out.println(cut(p,n,n));
		}
		
		static int cut(Integer[] p, int len, int n){
			if(n<=0) return 0;
			else if(len==0) return 0;
			else if(len<0) return -99999;
			return Math.max(cut(p, len-n, n)+p[n], cut(p, len, n-1));
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
