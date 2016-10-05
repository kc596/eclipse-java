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

public class B370 {
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
			String s=in.next();
			int u=0, d=0, l=0, r=0;
			int h=0, v=0;
			
			for(int i=0; i<s.length(); i++){
				if(s.charAt(i)=='L') l++;
				else if(s.charAt(i)=='R') r++;
				else if(s.charAt(i)=='U') u++;
				else if(s.charAt(i)=='D') d++;
			}
			if(l==r && u==d){
				out.println(0);
				return;
			}
			else {
				if((l+r+u+d)%2==0){
					h=Math.abs(r-l);
					v=Math.abs(u-d);
				}
				else{
					out.println(-1);
					return;
				}
			}
			out.println((h+v)/2);
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
