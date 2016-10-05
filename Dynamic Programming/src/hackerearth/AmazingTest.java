package hackerearth;

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

public class AmazingTest {
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
				int n=in.nextInt(), k=in.nextInt();
				int a[]=new int[n];
				for(int i=0; i<n; i++){
					a[i]=in.nextInt();
				}
				
				Arrays.sort(a);
				
				long time=0, spare=0;
				for(int i=n-1; i>=0; i--){
					if(spare>0){
						if(spare>=a[i]){
							spare-=a[i];
						}
						else{
							spare=a[i]-spare;
							time+=spare;
						}
					}
					else{
						time+=a[i];
						spare=a[i];
					}
					//out.println(time+" "+spare);
				}
				
				out.println(time<=k?"YES":"NO");
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
