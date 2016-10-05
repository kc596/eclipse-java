package classical.unsolved;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TheIndianConnection {
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
				int k=in.nextInt();
				out.println(isMale(n+k));
			}
		}
		private static boolean isMale(int n){
			/*
			 * odd + reaches 2 	=> female
			 * even + reaches 2	=> male
			 * odd + reaches 3	=> male
			 * even + reaches 3	=> female
			 */
			if(n==1 || n==2) return true;
			if(n==3) return false;
			int count=0;
			while(n>3){
				count+=n%2;
				n=n/2;
			}
			if(n==2){
				if(count%2==0) return true;
				else return false;
			}else
				{
					if(count%2==0) return false;
					else return true;
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
