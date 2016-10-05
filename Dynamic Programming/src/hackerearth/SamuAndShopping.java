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

public class SamuAndShopping {
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
		static final int INF=1000000001;
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				int n=in.nextInt();
				int[][] a=new int[n][3];
				int[][] dp=new int[n][3];
				for(int i=0; i<n; i++){
					for(int j=0; j<3; j++)
						dp[i][j]=INF;
				}
				
				for(int i=0; i<n; i++){
					for(int j=0; j<3; j++){
						a[i][j]=in.nextInt();
					}
				}
				
				dp[0][0]=a[0][0]; dp[0][1]=a[0][1]; dp[0][2]=a[0][2];
				
				for(int i=1; i<n; i++){
					for(int j=0; j<3; j++){
						dp[i][j]=Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3])+a[i][j];
					}
				}
				
				out.println(min(dp[n-1][0], dp[n-1][1], dp[n-1][2]));
			}			
		}
		
		private static int min(int a, int b, int c){
			if(a<=b && a<=c) return a;
			else if(b<=c && b<=a) return b;
			else return c;
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
