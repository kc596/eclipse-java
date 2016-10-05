/**
 * 
 */
package algorithms;

/**
 * @author kunal05
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BeautifulBinaryString {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		Task1 solver=new Task1();		
		solver.solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		out.close();
	}
	
	static class Task1{
		public void solve(InputReader in, PrintWriter out){
			int n=in.nextInt();
			String s=in.next();
			int count=0;
			char zero1, one, zero2;
			if(n<=2) out.println("0");
			else{
				zero1=s.charAt(0);
				one=s.charAt(1);
				zero2=s.charAt(2);				
				if(zero1=='0' && one=='1' && zero2=='0'){
					zero2='1';
					count++;
				}
				for(int j=3; j<s.length(); j++){
					if(zero1=='0' && one=='1' && zero2=='0'){
						zero2='1';
						count++;
					}
					zero1=one;
					one=zero2;
					zero2=s.charAt(j);
				}
				if(zero1=='0' && one=='1' && zero2=='0'){
					zero2='1';
					count++;
				}
				
				out.println(count);
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