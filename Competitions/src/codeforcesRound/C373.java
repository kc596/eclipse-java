package codeforcesRound;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class C373 {
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
		@SuppressWarnings("unused")
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt(), t=in.nextInt(), kg5=0, k4_5=0, ans_till_here=0, offset=0, pos=0;
			char[] temp=in.next().toCharArray();
			char[] a=new char[n];
			a[n-1]=' ';
			for(int i=0; i<n; i++){
				if(temp[i]=='.'){ offset=1; pos=i; continue; }
				a[i-offset]=temp[i];
			}
			
			boolean status=false, flag=false;
			for(int i=pos-1; i<n; i++){
				if(temp[i]=='.') flag=true;
				
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
