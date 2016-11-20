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

public class B380 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}
	
	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt(), m = in.nextInt();
			int[][] stage = new int[n][m];
			
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					stage[i][j] = in.nextInt();
				}
			}
			
			long ans=0;
			
			for(int i=0; i<n; i++){
				int curr_zero_count_in_left = 0;
				boolean found_one_in_left = false;
				for(int j=0; j<m; j++){
					if(found_one_in_left){
						if(stage[i][j]==0){
							ans++;
							curr_zero_count_in_left++;
						} else if(stage[i][j]==1){
							ans += curr_zero_count_in_left;
							curr_zero_count_in_left = 0;
						}
					} else {
						if(stage[i][j]==0){
							curr_zero_count_in_left++;
						} else if(stage[i][j]==1){
							found_one_in_left = true;
							ans += curr_zero_count_in_left;
							curr_zero_count_in_left = 0;
						}
					}
				}
			}
			
			for(int i=0; i<m; i++){
				int curr_zero_count_in_left = 0;
				boolean found_one_in_left = false;
				for(int j=0; j<n; j++){
					if(found_one_in_left){
						if(stage[j][i]==0){
							ans++;
							curr_zero_count_in_left++;
						} else if(stage[j][i]==1){
							ans += curr_zero_count_in_left;
							curr_zero_count_in_left = 0;
						}
					} else {
						if(stage[j][i]==0){
							curr_zero_count_in_left++;
						} else if(stage[j][i]==1){
							found_one_in_left = true;
							ans += curr_zero_count_in_left;
							curr_zero_count_in_left = 0;
						}
					}
				}
			}
			
			out.println(ans);
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

		public String nextLine() {
			String s = null;
			try {
				s = reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return s;
		}

		public String nextParagraph() {
			String line = null;
			String ans = "";
			try {
				while ((line = reader.readLine()) != null) {
					ans += line;
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return ans;
		}

	}
}
