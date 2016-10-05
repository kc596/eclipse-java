package hackerearth;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PrateekAndTheories {
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
			int a,b,t=in.nextInt();
			for(int i=0; i<t; i++){
				TreeMap<Integer, Integer> hm=new TreeMap<Integer, Integer>();
				int n=in.nextInt();
				for(int j=0; j<n; j++){
					a=in.nextInt();
					b=in.nextInt();
					if(hm.containsKey(a)) hm.put(a,hm.get(a)+1);
					else hm.put(a, 1);
					
					if(hm.containsKey(b)) hm.put(b,hm.get(b)-1);
					else hm.put(b, -1);
				}
				
				int max=0, curr=0;
				for(Entry<Integer, Integer> it: hm.entrySet()){
					curr+=it.getValue();
					max=Math.max(max, curr);
				}
				out.println(max);
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
