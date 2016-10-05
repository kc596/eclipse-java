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

public class _19_WordWrapProblem {
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
		static int INF=1000000;
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();					//no. of words
			int w=in.nextInt();					//length of each line
			String[] words=new String[n];		//words
			Integer[] len=new Integer[n];		//length of words
			Integer[][] cost=new Integer[n][n];
			/**
			 * cost[i][j] = min cost if word_i to word_j is in same line
			 */
			
			for(int i=0; i<n; i++){
				words[i]=in.next();
				len[i]=words[i].length();
			}
			
			for(int i=0; i<n; i++){
				int curr_len=0;
				for(int j=i; j<n; j++){
					curr_len+=len[j];
					if(curr_len>w) cost[i][j]=INF; 
					else cost[i][j]=cost(w, curr_len);
					curr_len++;					//space after a word
				}
			}
			
			Integer[] index=new Integer[n];
			Integer[] dp=new Integer[n];
			
			index[n-1]=n;
			dp[n-1]=cost[n-1][n-1];
			
			for(int i=n-2; i>=0; i--){
				int j=n-1;
				
				//can i to j exist in one line?
				if(cost[i][j]<INF){
					dp[i]=cost[i][j];
					index[i]=j+1;
				}
				else{
					//if they cannot exist in one line then find out at what point should we split it
					int min=INF;
					for(j=n-1; j>i; j--){
						if(min>dp[j]+cost[i][j-1]){
							min=dp[j]+cost[i][j-1];
							index[i]=j;
						}
					}
					dp[i]=min;
				}
			}
			
			/*for(int ii=0; ii<n; ii++){
				for(int jj=0; jj<n; jj++)
					out.print(cost[ii][jj]+"\t");
				out.println();
			}
			
			for(int i: dp) out.print(i+" ");
			out.println();
			for(int i: index) out.print(i+" ");*/
			
			/* Printing the paragraph */
			int start=0, end=index[0];
			while(start!=n){
				for(int i=start; i<end; i++)
					out.print(words[i]+" ");
				out.println();
				start=end;
				if(start<n)end=index[start];
			}
		}
		
		static int cost(int w, int len){
			return (w-len)*(w-len);
		}
		
		static int word_wrap(Integer[] len, Integer[] w, int n){
			/* returns the minimum number of lines required */
			return 0;
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
