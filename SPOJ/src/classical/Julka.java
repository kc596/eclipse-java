package classical;
/**
 * @author Kunal Chaudhary
 */

import java.io.PrintWriter;
import java.math.BigInteger;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Julka {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver=new Task();
		solver.solve(in, out);
		out.close();
	}
	static class Task{
		private static final BigInteger TWO=new BigInteger("2");
		public void solve(InputReader in, PrintWriter out){
			for(int i=0; i<10; i++){
				BigInteger a=new BigInteger(in.next());
				BigInteger b=new BigInteger(in.next());
				out.println(a.add(b).divide(TWO));
				out.println(a.subtract(b).divide(TWO));
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
