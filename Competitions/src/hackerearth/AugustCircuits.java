package hackerearth;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class AugustCircuits {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		//Task1 solver = new Task1();
		Task2 solver = new Task2();
		solver.solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}
	static class Task2{
		public void solve(InputReader in, PrintWriter out){
			int t=in.nextInt();
			while(t-->0){
				int n=in.nextInt(), m=in.nextInt();
				int num=9*m;
				int den=(m+8*n);
				int gcd=(int)gcd(num,den);
				out.println(num/gcd+"/"+den/gcd);
			}
		}
		private static long gcd(long a, long b)
		{
		    while (b > 0)
		    {
		        long temp = b;
		        b = a % b; // % is remainder
		        a = temp;
		    }
		    return a;
		}
	}

	static class Task1 {
		static boolean[] isPrime; static final int MAX=1001;
		public void solve(InputReader in, PrintWriter out) {
			isPrime=new boolean[MAX];
			for(int i=2; i<MAX; i++) isPrime[i]=true;
			for(int i=2; i<MAX; i++){
				if(isPrime[i]){
					for(int j=i+i; j<MAX; j+=i)
						isPrime[j]=false;
				}
			}
			
			int t=in.nextInt();
			while(t-->0){
				int n=in.nextInt(), max=-1;
				for(int i=0; i<n; i++){
					int temp=in.nextInt();
					if(isPrime[temp]){
						max=Math.max(max, temp*temp);
					}
				}
				out.println(max);
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

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
