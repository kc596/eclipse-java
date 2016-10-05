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

public class D365 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			int[] a=new int[n];
			int[] x=new int[n+1];
			a[0]=in.nextInt();
			x[0]=0;
			x[1]=(x[0]^a[0]);
			
			for(int i=1; i<n; i++){
				a[i]=in.nextInt();
				x[i+1]=x[i]^a[i];
			}
			
			int q=in.nextInt();
			int xx=0;
			for(int i=0; i<q; i++){
				int l=in.nextInt()-1, r=in.nextInt();
				xx=x[r]^x[l];
				out.println(x[l]+" "+x[r]+" "+xx);
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
