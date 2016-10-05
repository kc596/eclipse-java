package codechef;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SepLunchtime {
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
			int t=in.nextInt();
			while(t-->0){
				long a=in.nextLong(), b=in.nextLong(), c=in.nextLong(), d=in.nextLong(), l, r, ans=0;
				if(a>b || c>d || ((a<=b)&&(c<=d)&&(a>=d)) ){
					out.println(0); return;
				}
				else{
					if(a<=b && c<=d){
						if(b<c){
							ans=(b-a+1)*(d-c+1);
							out.println(ans);
							return;
						}
						if(a<=c){
							l=(d-c);
							ans+=(c-a)*(l+1);
							//out.println(ans);
						}
						else l=(d-a);
						
						if(b>=d) r=1;
						else r=(d-b);
						
						//out.println(l+" "+r);
						ans+=ans(l,r);
						out.println(ans);
					}
				}
			}
		}
		static long ans(long l, long r){
			long n=Math.max((l-r), (r-l))+1;
			return (n*(l+r))/2;
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
