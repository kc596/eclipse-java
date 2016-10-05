package codeforcesRound;

/**
 * @author Kunal
 * You always don't get what your deserve. Sometimes,
 * Life does not reward you on the basis of how much
 * good and deserving you are but instead it punishes
 * you to bring out the best of you. You just have to
 * keep it going.
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class A371 {
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
			long l1=in.nextLong(), r1=in.nextLong(), l2=in.nextLong(), r2=in.nextLong(), k=in.nextLong();
			
			long ans=0, a=0,b=0;
			if(r1<l2 || r2<l1) ans=0;
			else{
				a=Math.max(l1, l2);
				b=Math.min(r1, r2);
				ans=(b-a)+1;
				if(k>=a && k<=b) ans--; 
			}
			out.println(ans);
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
