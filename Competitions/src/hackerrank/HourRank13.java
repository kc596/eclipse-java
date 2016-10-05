package hackerrank;


/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.math.BigInteger;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class HourRank13 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		new Task2().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		//out.println(duration);
		out.close();
	}

	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			BigInteger n=new BigInteger(in.next());
			String s=n.toString(2);
			long ans=1;
			if(n.equals(BigInteger.ONE)){out.println(1); return; }
			for(int i=0; i<s.length(); i++){
				if(s.charAt(i)=='0') ans*=2;
			}
			out.println(ans);
		}
	}
	
	static class Task2 {
		static final int MAX=46342;
		public void solve(InputReader in, PrintWriter out) {
			TreeSet<Long> answer=new TreeSet<Long>();
			for(int i=2; i<MAX; i++){
				for(int j=i+1; j<MAX; j++){
					if((i*j)>MAX) break;
					if(j%i!=0) answer.add((long) (i*j));
				}
			}
			Long[] ans=answer.toArray(new Long[answer.size()]);
			long n=in.nextInt();
			out.println(ans[0]+" "+ans[1]+" "+ans[2]+" "+ans[answer.size()-1]);
			int pos=Arrays.binarySearch(ans, n);
			if(pos>=0) out.println(pos+1);
			else if(pos<0) out.println(-(pos+1));
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
