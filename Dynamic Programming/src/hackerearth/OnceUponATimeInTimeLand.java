package hackerearth;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class OnceUponATimeInTimeLand {
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
			for(int i=0; i<t; i++){
				int n=in.nextInt(), k=in.nextInt();
				int[] a=new int[n];
				long[] dp=new long[n];
				for(int j=0; j<n; j++)
					a[j]=in.nextInt();

				if(a[0]>0) dp[0]=a[0];
				else dp[0]=0;
				
				for(int j=1; j<=k; j++)
					dp[j]=Math.max(a[j], dp[j-1]);
				
				for(int j=k+1; j<n; j++){
					dp[j]=Math.max(dp[j-k-1]+a[j], dp[j-1]);
				}
				
				out.println(dp[n-1]);
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
