package hackerearth;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class RoyAndRopes {
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
				int temp,n=in.nextInt();
				int[] a=new int[n-1];
				for(int j=0; j<n-1; j++) a[j]=in.nextInt();
				long time=n;
				
				for(int j=0; j<n-1; j++){
					temp=in.nextInt();
					if(temp>a[j]) a[j]=temp;
					if(a[j]+1+j>time) time=a[j]+1+j;
				}
				
				out.println(time);
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
	}
}
