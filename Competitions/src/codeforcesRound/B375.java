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

public class B375 {
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
			int n=in.nextInt();
			int num_words=0, longest=0;
			String s=in.next();
			
			int curr=0;
			int flag=0;
			for(int i=0; i<n; i++){
				char c=s.charAt(i);
				if(flag>0){
					//under parenthesis
					if(c=='('){
						curr=0;
						flag++;
					}
					else if(c==')'){
						flag--;
						if(curr>0) num_words++;
						curr=0;
					}
					else if(c=='_'){
						if(curr>0) num_words++;
						curr=0;
					}
					else{
						curr++;
					}
				}
				else{
					if(c=='('){
						flag++;
						longest=Math.max(longest, curr);
						curr=0;
					}
					else if(c=='_'){
						longest=Math.max(longest, curr);
						curr=0;
					}
					else{
						curr++;
					}
				}
			}
			longest=Math.max(longest, curr);
			
			out.println(longest+" "+num_words);
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
