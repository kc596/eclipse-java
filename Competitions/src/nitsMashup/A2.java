package nitsMashup;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class A2 {
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
		static int[] f;
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			f=new int[n+1];
			
			int a=in.nextInt(), b=in.nextInt(), c=in.nextInt();
			out.println(f(n,a,b,c));
		}
		static int f(int n, int a, int b, int c){
			if(n==0) return 0;
			else if(n<0) return -50000;
			else if(f[n]!=0) return f[n];
			
			int x=f(n-a, a,b,c)+1;
			f[n]=x;
			int y=f(n-b, a,b,c)+1;
			f[n]=Math.max(x, y);
			int z=f(n-c, a,b,c)+1;
			return f[n]=max(x,y,z);
		}
		
		static int max(int a, int b, int c){
			if(a>=b && a>=c) return a;
			else if(b>=a && b>=c) return b;
			else return c;
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
