package classical;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class HappyNumbers1 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			int count=0,squaresum=0;
			while(squaresum!=4){
				squaresum=sqrSum(n);
				n=squaresum;
				//System.out.println(squaresum);
				count++;
				if(n==1){
					out.println(count);
					break;
				}
				else if(n==4 || n==25){
					out.println("-1");
					break;
				}
			}
		}
		private static int sqrSum(int n){
			int result=0;
			while(n!=0){
				int k=n%10;
				result+=k*k;
				n=n/10;
			}
			return result;
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
	}
}
