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

public class C3 {
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
			int p[]=new int[n+1];
			int m[]=new int[n+1];
			int kk=(n)*(n-1)/2 -1;
			for(int i=0; i<kk; i++){
				int a=in.nextInt();
				int b=in.nextInt();
				p[a]++;
				p[b]--;
				m[a]++; m[b]++;
			}
			
			int t1=0, t2=0;
			int match=n-1;
			for(int i=1; i<n+1; i++){
				if(m[i]<match){
					if(t1>0) t2=i;
					else t1=i;
				}
			}
			
			out.println(p[t1]>p[t2]?(t1+" "+t2):(t2+" "+t1));
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
