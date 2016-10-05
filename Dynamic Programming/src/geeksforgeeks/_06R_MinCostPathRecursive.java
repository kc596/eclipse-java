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

public class _06R_MinCostPathRecursive {
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
			int m=in.nextInt(), n=in.nextInt();
			Integer[][] cost=new Integer[m][n];
			
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					cost[i][j]=in.nextInt();
				}
			}
			
			out.println(minCost(cost, 2, 1));
		}
		
		static int minCost(Integer[][] cost, int m, int n){
			if(m==0 && n==0) return cost[m][n];
			else if(m==0) return cost[m][n]+minCost(cost, m, n-1);
			else if(n==0) return cost[m][n]+minCost(cost, m-1, n);
			else return cost[m][n]+min(minCost(cost, m-1, n-1), minCost(cost, m-1, n), minCost(cost, m, n-1));
		}
		
		static int min(int a, int b, int c){
			return Math.min(Math.min(a, b), c);
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
