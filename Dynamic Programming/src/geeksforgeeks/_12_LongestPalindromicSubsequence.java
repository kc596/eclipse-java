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

public class _12_LongestPalindromicSubsequence {
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
			String s=in.next();
			int n=s.length();
			int[][] dp=new int[n][n];
			/**
			 * dp[i][j] = length of longest palindromic subsequence bw s[i] and s[j] (inclusive)
			 */
			
			for(int i=0; i<n; i++)								//lps possible with substring of length 1
				dp[i][i]=1;
			
			for(int j=0; j<n-1; j++)							//lps possible with substring of length 2
				if(s.charAt(j)==s.charAt(j+1)) dp[j][j+1]=2;
				else dp[j][j+1]=1;
			
			for(int len=3; len<=n; len++){						//length of substring under consideration
				for(int i=0; i<=n-len; i++){					//starting index of our substring
					int j=i+len-1;
					if(s.charAt(i)==s.charAt(j)) dp[i][j]=(dp[i+1][j-1]+2);
					else dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}

			/*backtracing to get the string*/
			int i=0, j=n-1;
			StringBuilder ans1=new StringBuilder(""), ans2=new StringBuilder("");
			do{
				if(dp[i][j]==dp[i+1][j]) i++;
				else if(dp[i][j]==dp[i][j-1]) j--;
				else if(dp[i][j]==dp[i+1][j-1]+2){
					ans1.append(s.charAt(i));
					ans2.append(s.charAt(j));
					i=i+1; j=j-1;
				}
			}while(dp[i][j]!=0);
			
			if(dp[0][n-1]%2==1) ans1.append(s.charAt(i));
			
			out.println(ans1.toString()+ans2.reverse()+" "+dp[0][n-1]);
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
