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

public class XsquareAndChocolates {
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
				String s=in.next();
				int k,j=2,max=0,curr=0,n=s.length();
				if(n<3){
					out.println(n);
					continue;
				}

				while(j<=n-1){
					k=j;
					while(k>=2){
						/*considering k as an endpoint, find the length of the
						continuous chocolate substring*/
						if(s.charAt(k-2)==s.charAt(k-1) && s.charAt(k-1)==s.charAt(k))
							break;
						k=k-3;
						curr++;
					}
					j++;
					max=Math.max(curr, max);
					curr=0;
				}
				
				//out.println(Math.max(max,curr));
				out.println(n-3*Math.max(max,curr));
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
