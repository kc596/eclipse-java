package classical;

/**
 * @author Kunal
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AGGRCOW {
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
			int t = in.nextInt();
			while(t-->0){
				int n = in.nextInt(), c = in.nextInt();
				int[] stalls = new int[n];
				for(int i=0; i<n; i++){
					stalls[i] = in.nextInt();
				}
				Arrays.sort(stalls);
				
				int lo = stalls[0], hi = stalls[n-1], mid = 0;
				while(lo<=hi){
					mid = lo+(hi-lo)/2;
					//out.println(lo+" "+mid+" "+hi);
					int curr = 0, stock = c-1;
					
					for(int i=0; i<n && stock>0; i++){
						if(stalls[i]-stalls[curr] >= mid){
							curr = i;
							stock--;
						}
					}
					if(stock==0){
						lo = mid+1;
					} else {
						hi = mid-1;
					}
				}
				out.println(hi);
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
