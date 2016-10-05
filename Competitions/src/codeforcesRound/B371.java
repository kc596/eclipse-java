package codeforcesRound;

/**
 * @author Kunal
 * The most interesting part of life is uncertainty ...
 * Life is very cruel and will try its best to tear you
 * apart but it will be in your hand to give or fight back.
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B371 {
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
			int n=in.nextInt(), temp;
			TreeSet<Integer> set=new TreeSet<Integer>();
			for(int i=0; i<n; i++){
				temp=in.nextInt();
				set.add(temp);
			}
			if(set.size()>3) out.println("NO");
			else if(set.size()<=2) out.println("YES");
			else{
				int i=0,a=0,b=0,c=0;
				/*Integer[] ar=set.toArray(new Integer[3]);
				for(int iii:ar){
					out.print(iii+" ");
				out.println();
				}*/
				for(int j:set){
					if(i==0) a=j;
					else if(i==1) b=j;
					else if(i==2) c=j;
					i++;
				}
				if((c-b) == (b-a)) out.println("YES");
				else out.println("NO");
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
