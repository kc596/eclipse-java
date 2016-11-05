package hackerearth;

/**
 * @author kunal05
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RoyAndCoinBoxes {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();		
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		out.close();
	}
	
	static class Task1{
		public void solve(InputReader in, PrintWriter out){
			int n=in.nextInt(), m=in.nextInt();
			int[] a=new int[n+2];
			int[] ans=new int[1000002];
			
			for(int i=0; i<m; i++){
				int l=in.nextInt(), r=in.nextInt();
				a[l]+=1; a[r+1]-=1;
			}
			
			int curr=0, max=0;
			for(int i=1; i<n+1; i++){
				curr+=a[i];
				max=Math.max(max, curr);
				ans[curr]++;
			}

			for(int i=max; i>=1; i--){
				ans[i]+=ans[i+1];
			}
			
			int q=in.nextInt();
			for(int i=0; i<q; i++){
				int query=in.nextInt();
				out.println(ans[query]);
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