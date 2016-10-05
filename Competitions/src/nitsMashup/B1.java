package nitsMashup;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B1 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int a=in.nextInt(), b=in.nextInt(), c=in.nextInt(), d=in.nextInt();
			Double A=(double)a;
			Double B=(double)b;
			Double C=(double)c;
			Double D=(double)d;
			Double p1= A/B;
			Double p2= C/D;
			if(p1==1.0) out.println(1);
			else if(p2==1.0) out.println(0);
			else
				out.println(new BigDecimal(String.valueOf( A*D/(A*D+B*C-A*C) )).setScale(12, BigDecimal.ROUND_HALF_UP));
			//out.println(p1+" "+p2);
			//out.println( ( p1/(1-(p1*p2)) ) );
			
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
