/**
 * @author Kunal Chaudhary
 */
package classical;

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
InputReader in = new InputReader();
PrintWriter out = new PrintWriter(System.out);
*/

public class LifeUniverse {
	public static void main(String[] args) {
		InputReader in=new InputReader();
		PrintWriter out=new PrintWriter(System.out);
		Task solver=new Task();
		solver.solve(in,out);
		out.flush();
		out.close();
	}
	
	static class Task{
		public void solve(InputReader in, PrintWriter out){
			int b;
			while(true){
				b=in.nextInt();
				if(b==42) return;
				out.println(b);
			}
		}
	}
	
	//static nested class for taking input
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
