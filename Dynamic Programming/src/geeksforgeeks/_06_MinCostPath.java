package geeksforgeeks;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _06_MinCostPath {
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
		static final int INFINITY=Integer.MAX_VALUE;
		public void solve(InputReader in, PrintWriter out) {
			int m=in.nextInt(), n=in.nextInt();
			Integer[][] a=new Integer[m][n];
			Integer[][] cost=new Integer[m][n];
			
			for(int i=0; i<m; i++)
				for(int j=0; j<n; j++){
					a[i][j]=in.nextInt();
					cost[i][j]=INFINITY;
				}
			
			cost[0][0]=a[0][0];
			cost[0][1]=a[0][1]+a[0][0];
			cost[1][0]=a[1][0]+a[0][0];
			
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					if(i>=1 && j>=1)
						cost[i][j]=min(cost[i-1][j-1], cost[i-1][j], cost[i][j-1])+a[i][j];
					else if(i>=1 && j==0)
						cost[i][j]=cost[i-1][j]+a[i][j];
					else if(j>=1 && i==0)
						cost[i][j]=cost[i][j-1]+a[i][j];
				}
			}
			
			out.println(cost[m-1][n-1]);
		}
		static int min(int a, int b, int c){
			return Math.min(Math.min(a, b),c);
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
