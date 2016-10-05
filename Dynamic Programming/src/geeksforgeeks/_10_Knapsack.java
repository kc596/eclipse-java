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

public class _10_Knapsack {
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
				int n=in.nextInt(), w=in.nextInt();		//w = sum of all the weights that we can pick
				Integer[] value=new Integer[n];
				Integer[] wt=new Integer[n];
				
				for(int i=0; i<n; i++) value[i]=in.nextInt();
				for(int i=0; i<n; i++) wt[i]=in.nextInt();
				
				Integer[][] dp=new Integer[n][w+1];
				for(int i=0; i<n; i++) dp[i][0]=0;		//if w==0, we can't pick any value
				for(int i=1; i<w+1; i++){
					if(wt[0]<=i) dp[0][i]=value[0];		//picking the first item(if possible with i weight)
					else dp[0][i]=0;
				}
				
				for(int i=1; i<n; i++){
					int weight=wt[i];
					for(int j=1; j<=w; j++){
						if(j<weight) dp[i][j]=dp[i-1][j];
						else dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-weight]+value[i]);	//either pick or don't pick
					}
				}
				
				out.println(dp[n-1][w]);
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
