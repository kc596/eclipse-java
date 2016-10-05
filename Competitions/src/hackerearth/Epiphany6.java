package hackerearth;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Epiphany6 {
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
		ArrayList<Long> sum=new ArrayList<Long>();
		public void solve(InputReader in, PrintWriter out) {
			long n=in.nextLong(), k=in.nextLong(), m=in.nextLong(), temp=0;
			
			for(int i=1; i<=Math.min(m, n); i++){
				long a=(( ((n-i+1)%m)*(expo(i,k,m)%m) )%m);
				temp=(temp+a)%m;
				sum.add(temp);
			}
			long ans=((n/m)*temp)%m;
			if((n%m)>0){
				ans+=sum.get((int)((n%m)-1))%m;
				ans=ans%m;
			}
			out.println(ans);
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
	
	static class Task2 {
		public void solve(InputReader in, PrintWriter out) {
			//
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
	}
}
