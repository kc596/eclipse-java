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

public class AddingReversedNumbers {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		private static int[] tenPower={1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int a=in.nextInt();
				int b=in.nextInt();
				out.println(reverseSum(a,b));
			}
		}
		private static int reverseSum(int a, int b){
			String x=new String(a+"");
			int len1=x.length();
			x=new String(b+"");
			int len2=x.length();
			int num1=0,num2=0;
			for(int i=1; i<=len1; i++){
				num1+=(a%10)*tenPower[len1-i];
				a=a/10;
			}
			for(int i=1; i<=len2; i++){
				num2+=(b%10)*tenPower[len2-i];
				b=b/10;
			}
			a=num1+num2;
			b=0;
			x=(a)+"";
			len1=x.length();
			for(int i=1; i<=len1; i++){
				b+=(a%10)*tenPower[len1-i];
				a=a/10;
			}
			return b;
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
