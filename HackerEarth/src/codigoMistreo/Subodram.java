package codigoMistreo;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Subodram {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			long max1 = 1, max2 =1, max3 =1;
			boolean allzero = true;
			for(int i=0; i<n; i++){
				long temp = in.nextLong();
				if(temp!=0){
					allzero=false;
				}
				if(temp>=max1){
					max3 = max2;
					max2 = max1;
					max1 = temp;
				}
				else if(temp>=max2){
					max3 = max2;
					max2 = temp;
				}
				else if(temp>=max3){
					max3 = temp;
				}
			}
			if(allzero){
				out.println(0);
			}
			else out.println(max1*max2*max3);
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

		public String nextLine() {
			String s = null;
			try {
				s = reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return s;
		}

		public String nextParagraph() {
			String line = null;
			String ans = "";
			try {
				while ((line = reader.readLine()) != null) {
					ans += line;
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return ans;
		}

	}
}
