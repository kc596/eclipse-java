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

public class Momowali {
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
		static final int MOD = 1000000007;
		static final int MAX = 100001;
		public void solve(InputReader in, PrintWriter out) {
			//precompute
			long[] D = new long[MAX];
			long[] fact = new long[MAX];
			
			D[0]=D[1]=0; D[2]=1;
			fact[0]=fact[1]=1; fact[2]=2;
			for(int i=3; i<MAX; i++){
				D[i] = ((i-1)*((D[i-1]+D[i-2])%MOD))%MOD;
				fact[i] = (i*fact[i-1])%MOD;
			}
			
			int t = in.nextInt();
			while(t-->0){
				int n = in.nextInt();
				
				out.println( ( ((fact[n]-D[n]+MOD)%MOD)*(expo(fact[n],MOD-2,MOD)) )%MOD );
			}
		}
		
		long expo(long a, long b, long MOD){
			long result = 1;
			while (b>0){
				if (b%2==1) result=(result*a)%MOD;
				b>>=1;
				a=(a*a)%MOD;
			}
			return result%MOD;
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
