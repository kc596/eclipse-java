package codeforcesExtras;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class C727 {
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
			int ans[] = new int[n];
			long temp[] = new long[n];
			for(int i=2; i<=n; i++){
				System.out.println("? 1 "+i);
				System.out.flush();
				temp[i-2]=in.nextLong();
			}
			System.out.println("? 2 3");
			System.out.flush();
			temp[n-1]=in.nextLong();
			
			int offset=(int)(temp[0]+temp[1]-temp[n-1]);
			ans[0]=offset/2;
			for(int i=1; i<n; i++){
				ans[i]=(int)(temp[i-1]-ans[0]);
			}
			
			System.out.print("!");
			for(int i: ans) System.out.print(" "+i);
			System.out.println();
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
