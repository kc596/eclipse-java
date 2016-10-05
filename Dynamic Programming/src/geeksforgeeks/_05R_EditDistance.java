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

public class _05R_EditDistance {
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
		static int dp[][];
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				String a=in.next(), b=in.next();
				int na=a.length(), nb=b.length();
				dp=new int[na+1][nb+1];
				for(int i=0; i<=na; i++)
					for(int j=0; j<=nb; j++)
						dp[i][j]=-1;
				
				out.println(editDist(a,b, na,nb));
			}
		}
		
		static int editDist(String a, String b, int na, int nb){
			if(na==0) return nb;
			else if(nb==0) return na;
			else if(dp[na][nb]!=-1) return dp[na][nb];
			
			if(a.charAt(na-1)==b.charAt(nb-1)) return dp[na][nb]=editDist(a, b, na-1, nb-1);
			
			else return dp[na][nb]=1 + min( editDist(a,b,na-1, nb),		//remove
											editDist(a,b, na, nb-1),	//insert
											editDist(a,b, na-1, nb-1)	//replace
										);
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
