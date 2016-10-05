package codeforcesExtras;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class A722 {
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
			int format=in.nextInt();
			String s=in.next();
			int h1=Integer.parseInt(s.substring(0,1));
			int h2=Integer.parseInt(s.substring(1,2));
			int m1=Integer.parseInt(s.substring(3,4));
			int m2=Integer.parseInt(s.substring(4,5));
			if(format==12){
				if(h1==0){
					if(h2==0){ h2=1; }
				}
				else if(h1==1){
					if(h2>2){ h2=0; }
				}
				else if(h2==0){
					h1=1;
				}
				else h1=0;
			}
			else if(format==24){
				if(h1==0 || h1==1){
					//
				}
				else if(h1==2){
					if(h2>=4){ h2=0; }
				}
				else{ h1=0; }
			}
			
			//handling minutes
			if(m1>=6) m1=0;
			
			out.println(h1+""+h2+":"+m1+""+m2);
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
