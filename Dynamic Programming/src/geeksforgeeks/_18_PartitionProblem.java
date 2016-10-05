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

public class _18_PartitionProblem {
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
				int n=in.nextInt(), sum=0;
				Integer[] a=new Integer[n];
				for(int i=0; i<n; i++){ a[i]=in.nextInt(); sum+=a[i]; }
				
				if(sum%2==1){
					out.println("NO");
					continue;
				}
				
				/**
				 * Problem changed to coin-change problem. We have to form sum/2 from given numbers.
				 */
				sum/=2;
				boolean[][] dp=new boolean[n+1][sum+1];
				
				for(int i=0; i<=n; i++) dp[i][0]=true;		//form 0 -> true
				for(int i=1; i<=sum; i++) dp[0][i]=false;	//0 coin -> nothing can be formed
				
				for(int i=1; i<=n; i++){
					int coin=a[i-1];
					for(int j=1; j<=sum; j++){
						if(j<coin) dp[i][j]=dp[i-1][j];
						else dp[i][j]=dp[i-1][j-coin]?true:dp[i-1][j];
					}
				}
				if(dp[n][sum]) out.println("YES");
				else out.println("NO");
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
