package codeforcesRound;

/**
 * @author kunal05
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B376 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);	
		new Task1().solve(in, out);
		out.close();
	}
	
	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt(), prev, curr, rem=0;
			boolean status=true;
			prev=in.nextInt();
			if(n==1){
				if(prev%2==0) out.println("YES");
				else out.println("NO");
				return;
			}
			rem=prev%2;
			for(int i=1; i<n; i++){
				curr=in.nextInt();
				if(rem==1) curr--;
				if(curr<0) status=false;
				rem=curr%2;
			}
			if(rem==1) status=false;
			if(status) out.println("YES");
			else out.println("NO");
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
		public long nextLong(){
			return Long.parseLong(next());
		}
		public double nextDouble(){
			return Double.parseDouble(next());
		}
		public String nextLine() throws IOException{
            return reader.readLine();
        }
	}
}