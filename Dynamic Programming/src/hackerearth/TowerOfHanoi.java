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

public class TowerOfHanoi {
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
		static class Disc implements Comparable<Disc>{
			int h, r;
			public Disc(int radius, int height){
				r=radius;
				h=height;
			}
			public int compareTo(Disc that){
				if(this.r>that.r) return 1;
				else if(this.r<that.r) return -1;
				else{
					if(this.h>that.h) return 1;
					else if(this.h<that.h) return -1;
					else return 0;
				}
			}
			public boolean greater(Disc that){
				return (r>that.r && h>that.h);
			}
		}
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int n=in.nextInt();
				Disc disc[]=new Disc[n];
				
				for(int j=0; j<n; j++){
					int r=in.nextInt(), h=in.nextInt();
					disc[j]=new Disc(r,h);
				}
				
				Arrays.sort(disc);
				
				long dp[]=new long[n];
				dp[0]=disc[0].h;
				long ans=dp[0];
				
				for(int j=1; j<n; j++){
					dp[j]=disc[j].h;
					for(int jj=0; jj<j; jj++){
						if(disc[j].greater(disc[jj])) dp[j]=Math.max(dp[j], dp[jj]+disc[j].h);
					}
					ans=Math.max(ans, dp[j]);
				}
				
				out.println(ans);
				
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
