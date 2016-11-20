package codigoMistreo;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Kunal {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		static long a, b, c, k;
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				a=in.nextLong(); b=in.nextLong(); c=in.nextLong(); k=in.nextLong();
				
				long small = Math.min(a, Math.min(b, c));
				long large = Math.max(a, Math.max(b, c));
				long mid = (a+b+c)-(small+large);
				
				a=small; b=mid; c=large;
				
				long guess = a*k;
				//long guess1 = guess;
				
				while(true){
					//long offset
					break;
				}
				
				out.println(guess);
			}
		}
		
		static long prevMultiple(long num, long factor, long amount){
			return num-(factor)*(amount);
		}
		
		static long nextMultiple(long num, long factor, long amount){
			return num+(factor)*(amount);
		}
		
		static boolean condition(long num){
			long a_f = num/a;
			long b_f = num/b;
			long c_f = num/c;
			long ab_f = num/(a*b);
			long bc_f = num/(b*c);
			long ac_f = num/(a*c);
			long abc_f = num/(a*b*c);
			return (a_f+b_f+c_f-ab_f-bc_f-ac_f+abc_f)==k;
		}
		
		static long offset(long num){
			long b_f = num/b;
			long c_f = num/c;
			long ab_f = num/(a*b);
			long bc_f = num/(b*c);
			long ac_f = num/(a*c);
			long abc_f = num/(a*b*c);
			return num-a*(b_f+c_f-ab_f-bc_f-ac_f+abc_f);
		}
		
		static boolean isDivided(long guess){
			return ((guess%a==0)||(guess%b==0)||(guess%c==0));
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

		public String nextLine() {
			String s = null;
			try {
				s = reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return s;
		}

		public String nextParagraph() {
			String line = null;
			String ans = "";
			try {
				while ((line = reader.readLine()) != null) {
					ans += line;
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return ans;
		}

	}
}
