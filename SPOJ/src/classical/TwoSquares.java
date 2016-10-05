package classical;
/**
 * @author Kunal Chaudhary
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TwoSquares {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver=new Task();
		solver.solve(in, out);
		out.close();
	}
	static class Task{
		public void solve(InputReader in, PrintWriter out){
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				long n=new Long(in.next());
				long root=(long)Math.sqrt(n);
				boolean flag=false;
				long diff,r;
				for(long j=0; j<=root; j++){
					diff=n-(j*j);
					r=(long)Math.sqrt(diff);
					if(r*r==diff){
						flag=true;
						break;
					}
				}
				if(flag) out.println("Yes");
				else out.println("No");
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
