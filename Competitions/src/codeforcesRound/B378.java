package codeforcesRound;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B378 {
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

	static class Task1{
		public void solve(InputReader in, PrintWriter out){
			int n=in.nextInt(), neg_count=0, pos_count=0, p_sum = 0, n_sum = 0, p_max_index=0, n_max_index=0, p_max=Integer.MIN_VALUE, n_max=Integer.MAX_VALUE;
			int[] LmR=new int[n];
			int[] L = new int[n];
			int[] R = new int[n];
			
			for(int i=0; i<n; i++){
				L[i]=in.nextInt(); R[i]=in.nextInt();
				LmR[i] = (L[i]-R[i]);
				
				if(LmR[i]>0) {
					pos_count++;
					p_sum += LmR[i];
				} else if(LmR[i]<0) {
					neg_count++;
					n_sum -= LmR[i];
				}
				
				if(LmR[i]>p_max && LmR[i]>0){
					p_max = LmR[i];
					p_max_index = i;
				}
				if(LmR[i]<0 && LmR[i]<n_max){
					n_max = LmR[i];
					n_max_index = i;
				}
			}
			
			if(neg_count == 0 || pos_count == 0){
				out.println("0");
				return;
			}
			
			if(neg_count == 1){
				for(int i=0; i<n; i++){
					if(LmR[i]<0){
						out.println(i+1);
						return;
					}
				}
			}
			
			if(pos_count == 1){
				for(int i=0; i<n; i++){
					if(LmR[i]>0){
						out.println(i+1);
						return;
					}
				}
			}
			
			if(p_sum > n_sum){
				out.println(n_max_index + 1);
			}
			else if(n_sum > p_sum){
				out.println(p_max_index + 1);
			}
			else {
				n_max = -1*n_max;
				if(p_max >= n_max){
					out.println(p_max_index+1);
				}
				else out.println(n_max_index+1);
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
