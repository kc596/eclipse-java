package codeforcesExtras;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class A727 {
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
			int a=in.nextInt(), b=in.nextInt();
			Stack<Integer> s=new Stack<Integer>();
			s.push(b);
			while(b>a){
				if(b%10==1){
					b=b/10;
					s.push(b);
				}
				else if(b%2==0){
					b=b/2;
					s.push(b);
				}
				else{
					break;
				}
			}
			if(b==a){
				out.println("YES");
				out.println(s.size());
				while(!s.isEmpty()){
					out.print(s.pop()+" ");
				}
				out.println();
			}
			else out.println("NO");
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
