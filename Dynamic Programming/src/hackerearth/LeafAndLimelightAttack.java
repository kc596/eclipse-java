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

public class LeafAndLimelightAttack {
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
		static final int MOD=1000000009;
		public void solve(InputReader in, PrintWriter out) {
			//precompute
			
			
			int t=in.nextInt();
			while(t-->0){
				long ans,n=in.nextLong();
				if(n%2==0) ans= (( (n%MOD) * (( (4*(n%MOD)*(n%MOD))%MOD + (3*(n%MOD))%MOD + 8)%MOD) )%MOD)/6;
				else ans= (((n%MOD)*((4*n*n%MOD)+(3*n%MOD)+8)%MOD)-3)/6 -1;
				
				out.println((long)(double)ans);
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
