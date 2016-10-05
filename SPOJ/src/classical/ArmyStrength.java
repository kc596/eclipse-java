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

public class ArmyStrength {
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
			while(t-- >0){
				int ng=in.nextInt();
				int nm=in.nextInt();
				int maxng=0, maxnm=0;
				
				while(ng-- >0){
					int temp=in.nextInt();
					if(temp>maxng) maxng=temp;
				}
				
				while(nm-- >0){
					int temp=in.nextInt();
					if(temp>maxnm) maxnm=temp;
				}
				
				if(maxng>=maxnm){
					out.println("Godzilla");
				}
				else{
					out.println("MechaGodzilla");
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
