package codeforcesRound;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class C375 {
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
			int n=in.nextInt(), m=in.nextInt();
			Integer[] band=new Integer[n];
			
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] liked_band=(ArrayList<Integer>[])new ArrayList[m+1];
			for(int i=1; i<=m; i++) liked_band[i]=new ArrayList<Integer>();

			ArrayList<Integer> blank_pos=new ArrayList<Integer>();
			HashMap<Integer, Integer> how_much_deviation=new HashMap<Integer, Integer>();
			
			for(int i=0; i<n; i++){
				band[i]=in.nextInt();
				if(band[i]<=m) liked_band[band[i]].add(i);
				else blank_pos.add(i);									//non-favourite
			}
			
			int size_each=n/m;											//maximum possible value of bj
			Integer[] deviation=new Integer[m+1];
			
			for(int i=1; i<=m; i++){
				deviation[i]=liked_band[i].size()-size_each;
				if(deviation[i]<0) how_much_deviation.put(i, -deviation[i]);
				else if(deviation[i]>0){
					for(int j=0; j<size_each; j++)
						blank_pos.add(liked_band[i].get(j));			//favourite
				}
			}
			
			int iter=0;
			for(Integer b: how_much_deviation.keySet()){
				int dev_amount=how_much_deviation.get(b);
				while(dev_amount-->0){
					band[blank_pos.get(iter++)]=b;
				}
			}
			
			out.println(size_each+" "+iter);
			for(Integer i:band) out.print(i+" ");
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
