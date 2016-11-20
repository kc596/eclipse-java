package codigoMistreo;

/**
 * @author kunal05
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Random {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();		
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		//out.println(duration);
		out.close();
	}
	
	static class Task1{
		/*static final int MAX = 31624;
		static boolean[] isPrime;
		static int[] gd;*/
		static long[] F;
		
		public void solve(InputReader in, PrintWriter out){
			/*// precompute seive
			isPrime = new boolean[MAX];
			for(int i=2; i<MAX; i++){
				isPrime[i] = true;
			}
			for(int i=4; i<MAX; i+=2){
				isPrime[i]=false;
			}
			for(int i=3; i<MAX; i+=2){
				if(isPrime[i]){
					for(int j=i+i; j<MAX; j+=i){
						isPrime[j]=false;
					}
				}
			}
			// seive done
			
			// precompute g(d) using Euler toitent function
			gd = new int[MAX];
			gd[1]=1;
			for(int i=2; i<MAX; i++){
				if(isPrime[i]){
					gd[i]=i-1;
					continue;
				}
				
				int ans = i;
				if(i%2==0){
					ans = i/2;
				}
				for(int j=3; j<=i/2; j+=2){
					if(isPrime[j] && i%j==0){
						ans = ans*(j-1)/j;
					}
				}
				gd[i] = ans;
			}
			// g(d) done
*/			
			int n=in.nextInt(), q=in.nextInt();
			Integer[] ar = new Integer[n];
			F = new long[n+1];
			
			for(int i=0; i<n; i++){
				ar[i] = in.nextInt();
				F[i+1] = F[i]+ar[i];
			}
			
			for(int i=0; i<q; i++){
				int l=in.nextInt(), r=in.nextInt();
				out.println(F[r]-F[l-1]);
			}
			
		}
		
		/*static long fn(int a){
			if(a==1) return 1L;
			//first find divisors then add gd[divisor]
			long ans = gd[a]+1;
			int root = (int)Math.sqrt(a);
			
			for(int i=2; i<=root; i++){
				if(a%i==0){
					ans+=gd[i];
					if(i!=root){
						ans+= gd[a/i];
					}
				}
			}
			return ans;
		}*/
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
			String s=null;
			try{
				s = reader.readLine();
			} catch(IOException e){
				throw new RuntimeException(e);
			}
			return s;
        }
		
		public String nextParagraph() {
			String line=null;
			String ans = "";
			try{
				while ((line = reader.readLine()) != null) {
				ans += line;
				}
			} catch(IOException e){
				throw new RuntimeException(e);
			}
			return ans;
		}
		
	}
}