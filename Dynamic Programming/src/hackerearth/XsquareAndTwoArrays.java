package hackerearth;

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class XsquareAndTwoArrays {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt(), q=in.nextInt();
			int[] a=new int[n];
			int[] b=new int[n];
			
			for(int i=0; i<n; i++)
				a[i]=in.nextInt();
			for(int i=0; i<n; i++)
				b[i]=in.nextInt();
			
			long[][] type=new long[2][n+1];

			//computing sum
			for(int i=0; i<n; i++){
				if(i%2==0){
					type[0][i+1]=type[0][i]+a[i];
					type[1][i+1]=type[1][i]+b[i];
				}
				else{
					type[0][i+1]=type[0][i]+b[i];
					type[1][i+1]=type[1][i]+a[i];
				}
			}
			
			for(int i=0; i<q; i++){
				int _type=in.nextInt(), l=in.nextInt(), r=in.nextInt();
				if(_type==1){
					if(l%2==1){
						out.println(type[0][r]-type[0][l-1]);
					}
					else out.println(type[1][r]-type[1][l-1]);
				}
				else{
					if(l%2==0){
						out.println(type[0][r]-type[0][l-1]);
					}
					else out.println(type[1][r]-type[1][l-1]);
				}
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