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

public class B377 {
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
			int n=in.nextInt(), k=in.nextInt(), left=0;
			int[] a=new int[n+2];
			a[n]=a[0]=k;
			
			for(int i=1; i<=n; i++){
				a[i]=in.nextInt();
			}
			
			if(n<=1){
				out.println(0);
				for(int i=1; i<=n; i++) out.print(a[i]+" ");
				out.println();
				return;
			}
			
			int prev=1, curr=2, temp;
			while(curr<=(n)){
				if(a[prev]+a[curr]<k){
					temp=k-(a[prev]+a[curr]);
					a[curr]+=temp;
					left+=temp;
				}
				prev++; curr++;
			}
			
			out.println(left);
			for(int i=1; i<=n; i++) out.print(a[i]+" ");
			out.println();
			
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
