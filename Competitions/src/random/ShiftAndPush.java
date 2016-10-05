package random;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ShiftAndPush {
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
		static final int MAX=100001;
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			int[] a=new int[n];
			int[] freq=new int[MAX];
			for(int i=0; i<n; i++){
				a[i]=in.nextInt();
				freq[a[i]]++;
			}
			
			//computing for each freq
			int min=2000000;
			for(int i=0; i<n; i++){
				int temp=2*(n)-freq[a[i]]+i;
				//out.println(temp);
				min=Math.min(temp, min);
			}
			
			out.println(min);
			/**
			 * Wrong Answer
			 */
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
