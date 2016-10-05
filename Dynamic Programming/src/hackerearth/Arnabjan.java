package hackerearth;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Arnabjan {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int n=in.nextInt();
				long k=in.nextLong();
				Long[] a=new Long[n+1];
				a[0]=0L;
				int[] ans=new int[n+1];
				
				for(int j=1; j<=n; j++){
					a[j]=in.nextLong();
					a[j]+=a[j-1];
				}
				
				for(int j=1; j<=n; j++){
					int len=Arrays.binarySearch(a, j, n+1, a[j-1]+k);
					if(len<0) len=-len-1-j;
					else len=len+1-j;
					ans[len]+=1;
				}
				
				for(int j=n-1; j>=1; j--) ans[j]+=ans[j+1];
				
				for(int j=1; j<=n; j++) out.print(ans[j]+" ");
				
				out.println();
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
	}
}
