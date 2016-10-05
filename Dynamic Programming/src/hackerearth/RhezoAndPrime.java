package hackerearth;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class RhezoAndPrime {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		Task1 solver = new Task1();
		solver.solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		boolean[] isPrime;
		long sum[];
		void preCompute(int ROOT){
			isPrime=new boolean[ROOT];
			
			for(int i=2; i<ROOT; i++) isPrime[i]=true;
			
			for(int i=2; i<ROOT; i++){
				if(isPrime[i]){
					for(int j=i+i; j<ROOT; j+=i)
						isPrime[j]=false;
				}
			}
		}
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			preCompute(n+1);
			int a[]=new int[n];
			sum=new long[n+1];
			for(int i=0; i<n; i++){
				a[i]=in.nextInt();
				sum[i+1]=sum[i]+a[i];
			}
			if(n==1){
				out.println(0);
				return;
			}
			int len=previousPrime(n);
			long max=0;
			for(int i=0; i<=n-len; i++){
				max=Math.max(max, sum(i, len, n));
			}
			
			out.println(max);
		}
		
		int previousPrime(int n){
			if(n<=1) return 0;
			while(!isPrime[n]) n--;
			return n;
		}
		
		long sum(int start, int len, int n){
			/**
			 * start = starting index
			 * n = ending
			 * len = length of subarray (prime)
			 */
			if(len<=1) return 0;
			if(start+len>n) return 0; 
			long curr= sum[start+len]-sum[start];
			int temp=len;
			while(temp>=n-len) temp=previousPrime(temp-1);
			return curr + sum(start+len+1, temp, n);
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
