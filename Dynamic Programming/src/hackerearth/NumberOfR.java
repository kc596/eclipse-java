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
 
public class NumberOfR {
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
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				String s=in.next();
				int n=s.length();
				int b[]=new int[n];
				int num_r=0;					//num_r is the
				
				for(int i=0; i<n; i++){
					if(s.charAt(i)=='K'){
						b[i]=1;
					}
					else if(s.charAt(i)=='R'){
						b[i]=-1;
						num_r++;
					}
				}
				
				//calculating largest sum
				int max=0, curr=0;
				for(int i=0; i<n; i++){
					curr+=b[i];
					if(curr>=max){
						max=curr;
					}
					if(curr<0){
						curr=0;
					}
				}
				out.println(num_r+(max==0?-1:max));
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