package codeforcesExtras;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A724 {
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
			HashMap<String, Integer> map=new HashMap<String, Integer>();
			String mon="monday", tue="tuesday", wed="wednesday", thur="thursday", fri="friday", sat="saturday", sun="sunday";
			map.put(mon, 0);
			map.put(tue, 1);
			map.put(wed, 2);
			map.put(thur, 3);
			map.put(fri, 4);
			map.put(sat, 5);
			map.put(sun, 6);
			
			String a=in.next(), b=in.next();
			int num=(map.get(b)-map.get(a));
			if(num<0) num=(7-map.get(a))+map.get(b);
			out.println(num);
			if(num<=3 && num!=1) out.println("YES");
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

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
