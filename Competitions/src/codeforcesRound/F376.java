package codeforcesRound;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F376 {
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
		static final int MAX=200000;
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			long sum=0;
			Integer[] a=new Integer[n];
			
			for(int i=0; i<n; i++){
				a[i]=in.nextInt();
				sum+=a[i];
			}
			Arrays.sort(a);
			if(a[0]==1){out.println(sum); return; }
			long sum2=sum;
			for(int i=0; i<n; i++){
				sum2=a[i];
				for(int j=i+1; j<n; j++){
					sum2+=a[j]-(a[j]%a[i]);
				}
				sum-=a[i];
				if(sum2>=sum) break;
			}
			out.println(sum2);
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
