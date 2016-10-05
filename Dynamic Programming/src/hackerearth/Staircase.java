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

public class Staircase {
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
			int n=in.nextInt();
			if(n<0){
				out.println("ERROR");
				return;
			}
			if(n<=2){
				out.println("Jack-"+n);
				out.println("Jill-"+n);
				return;
			}
			int[] dp=new int[n+1];
			int[] dp2=new int[n+1];
			dp[1]=dp2[1]=1; dp[2]=dp2[2]=2; dp[3]=4; dp2[3]=3;
			for(int i=4; i<=n; i++){
				dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
				dp2[i]=dp2[i-1]+dp2[i-2];
			}
			out.println("Jack-"+dp[n]);
			out.println("Jill-"+dp2[n]);
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
