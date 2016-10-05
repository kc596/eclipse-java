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

public class Collegiate {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task2{
		public void solve(InputReader in, PrintWriter out){
			
		}
	}
	
	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			int q=in.nextInt();
			while(q-->0){
				int n=in.nextInt();
				Integer[] p=new Integer[n];
				for(int i=0; i<n; i++) p[i]=in.nextInt();
				long x1=in.nextLong(), a=in.nextLong(), b=in.nextLong(), t=in.nextLong();

				long[] stack=new long[n];
				long ans=0;
				for(int i=0; i<t; i++){
					stack[(int)x1]++;
					if(stack[(int)x1]>=p[(int)x1]){
						ans++;
						stack[(int)x1]=0;
					}
					x1=((a%n)*(x1%n)+(b%n))%n;
				}
				out.println(ans);
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
