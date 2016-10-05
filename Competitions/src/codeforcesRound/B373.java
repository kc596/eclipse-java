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

public class B373 {
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
			int dev1=0, dev2=0, ans=0;
			int d1_r=0, d1_b=0, d2_r=0, d2_b=0;
			
			String s=in.next();
			for(int i=0; i<n; i++){
				if(i%2==0){
					if(s.charAt(i)=='r'){ dev2++; d2_b++; }
					else if(s.charAt(i)=='b'){ dev1++; d1_r++; }
				}
				else{
					if(s.charAt(i)=='r'){ dev1++; d1_b++; }
					else if(s.charAt(i)=='b'){ dev2++; d2_r++;}
				}
			}
			if(dev1<=dev2){
				ans=Math.max(d1_r, d1_b);
			}
			else ans=Math.max(d2_r, d2_b);
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
