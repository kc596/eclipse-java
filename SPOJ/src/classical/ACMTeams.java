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

public class ACMTeams {
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
			int teams=0;
			while(t-- >0){
				int a=in.nextInt();
				int b=in.nextInt();
				teams=0;
				if(a>=(2*b)){
					out.println(b);
				}
				else if(b>=(2*a)){
					out.println(a);
				}
				else{
					while(true){
						if(a>=b){
							a-=2;
							b--;
							if(a>=0 && b>=0) teams++;
						}else{
							a--;
							b-=2;
							if(a>=0 && b>=0) teams++;							
						}
						if(a==0 || b==0 || (a==1 && b==1)) break;
					}
					out.println(teams);
				}
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
