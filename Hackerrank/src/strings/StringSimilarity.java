package strings;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class StringSimilarity {
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
				String s=in.next();
				int n=s.length();
				String[] suffixes=new String[n];
				
				for(int i=0; i<n; i++)
					suffixes[i]=s.substring(i);
				
				long sum=0;
				for(int i=0; i<n; i++){
					sum+=cp(s, suffixes[i]);
				}
				
				out.println(sum);
			}
		}
		static int cp(String a, String b){
			int lg=a.length()>b.length()?a.length():b.length();
			int sm=a.length()+b.length()-lg;
			for(int i=0; i<sm; i++)
				if(a.charAt(i)!=b.charAt(i)) return i;
			
			return sm;
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
