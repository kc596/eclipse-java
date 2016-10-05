package classical;

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

public class FashionShows {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}
	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				int n=in.nextInt();
				long sum=0;
				int[] arrm=new int[n];
				int[] arrw=new int[n];
				for(int i=0; i<n; i++){
					arrm[i]=in.nextInt();
				}
				for(int i=0; i<n; i++){
					arrw[i]=in.nextInt();
				}
				Arrays.sort(arrm);
				Arrays.sort(arrw);
				for(int i=0; i<n; i++){
					sum+=arrm[i]*arrw[i];
				}
				out.println(sum);
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
	}
}
