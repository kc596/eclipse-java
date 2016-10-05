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

public class _11_EggDroppingPuzzle {
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
				int n=in.nextInt(), k=in.nextInt();		//n->no of eggs, k->no of floors
				Integer[][] dp=new Integer[n+1][k+1];
				for(int i=1; i<=k; i++) dp[1][i]=i;		//only one egg
				for(int i=1; i<=n; i++){
					dp[i][0]=0;							//no egg required for zero floor
					dp[i][1]=1;							//one egg required for one floor
				}
				
				for(int i=2; i<=n; i++){				//egg
					for(int j=2; j<=k; j++){			//floor
						dp[i][j]=Integer.MAX_VALUE;
						for(int x=1; x<=j; x++){
							int res=1+Math.max(dp[i-1][x-1], dp[i][j-x]);
							dp[i][j]=Math.min(dp[i][j], res);
						}
					}
				}
				out.println(dp[n][k]);
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
