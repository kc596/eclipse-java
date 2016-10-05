package nitsMashup;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A1 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			Scanner sc=new Scanner(System.in);
			int t=sc.nextInt();
			sc.nextLine();
			String la="lala.";
			String me="miao.";
			String omg="OMG>.< I don't know!";
			String freda="Freda's";
			String rain="Rainbow's";
			
			for(int i=0; i<t; i++){
				String s=sc.nextLine();
				
				int n=s.length();
				if(n>=5){
					if(s.substring(n-5).equals(la)){
						if(s.substring(0, 5).equals(me)){
							out.println(omg);
						}
						else{
							out.println(freda);
						}
					}
					else{
						if(s.substring(0,5).equals(me)){
							out.println(rain);
						}
						else{
							out.println(omg);
						}
					}
				}
				else out.println(omg);
			}
			sc.close();
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
