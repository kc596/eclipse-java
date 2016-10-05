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

public class NumberSteps {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int x=in.nextInt();
				int y=in.nextInt();
				int k=x/2;
				int mod=x%2;
				int n=-1;
				if(mod==0){
					if(y==2*k) n=4*k;
					else if(y==2*(k-1)) n=4*k-2;
					else{
						out.println("No Number");
						continue;
					}
				}
				else if(mod==1){
					if(y==2*k+1) n=4*k+1;
					else if(y==2*(k-1)+1) n=4*k-1;
					else{
						out.println("No Number");
						continue;
					}
				}
				out.println(n);
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
	}
}
