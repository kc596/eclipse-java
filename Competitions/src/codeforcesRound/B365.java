package codeforcesRound;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B365 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int temp,n=in.nextInt(), k=in.nextInt();
			int c[]= new int[n];
			boolean isCapital[]=new boolean[n];
			
			long sum=0, ans=0, marked=0;
			for(int i=0; i<n; i++){
				c[i]=in.nextInt();
				sum+=c[i];
			}
			
			for(int i=0; i<k; i++){
				temp=in.nextInt();
				isCapital[temp-1]=true;
			}
			
			if(isCapital[0]){
				ans+=(sum-c[0])*c[0]-(c[0]*c[1]);
				if(isCapital[n-1]) ans+=c[n-1]*c[0];
				marked+=c[0];
			}
			else ans+=c[n-1]*c[0];
			
			for(int i=1; i<n; i++){
				if(isCapital[i]){
					ans+=(sum-c[i])*c[i]-(c[(i+1)%n]*c[i])-marked*c[i];
					if(isCapital[i-1]) ans+=c[i-1]*c[i];
					marked+=c[i];
				}
				else ans+=c[i-1]*c[i];
			}
			
			
			out.println(ans);
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
