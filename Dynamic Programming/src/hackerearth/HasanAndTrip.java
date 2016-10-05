package hackerearth;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class HasanAndTrip {
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
		class City{
			int x,y,f;
			public City(int X, int Y, int F){
				x=X;
				y=Y;
				f=F;
			}
		}
		static City[] c;
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			c= new City[n];
			
			Double[] dp=new Double[n];
			for(int i=0; i<n; i++) dp[i]=Double.NEGATIVE_INFINITY;
			for(int i=0; i<n; i++){
				int x=in.nextInt();
				int y=in.nextInt();
				int f=in.nextInt();
				
				c[i]=new City(x,y,f);
			}
			dp[0]=(double)c[0].f;
			
			for(int i=0; i<n; i++){
				for(int j=i-1; j>=0; j--){
					dp[i]=Math.max(dp[j]+c[i].f-distance(i,j), dp[i]);
				}
			}
			DecimalFormat df = new DecimalFormat("#.######");
			out.println(df.format(dp[n-1]));							// -> good method
			//System.out.printf("%.6f", dp[n-1]);						// -> good method
			//out.println(Math.round(dp[n-1]*1000000.00) / 1000000.00);	// -> worst method
		}
		
		static double distance(int i, int j){
			return Math.sqrt( Math.abs(Math.pow((c[i].x-c[j].x),2) + Math.pow((c[i].y-c[j].y), 2)) );
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
