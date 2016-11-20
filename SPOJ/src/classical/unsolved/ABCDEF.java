package classical.unsolved;

/**
 * @author Kunal
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ABCDEF {
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
			int n = in.nextInt();
			int[] input = new int[n];
			ArrayList<Integer> ab_plus_c = new ArrayList<Integer>();
			ArrayList<Integer> d_e_plus_f = new ArrayList<Integer>();
			
			for(int i=0; i<n; i++){
				input[i] = in.nextInt();
			}
			
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					for(int k=0; k<n; k++){
						ab_plus_c.add((input[i]*input[j])+input[k]);
						if(input[i]!=0){
							d_e_plus_f.add(input[i]*(input[j]+input[k]));
						}
					}
				}
			}

			int answer = 0;
			Collections.sort(d_e_plus_f);
			for(int i: ab_plus_c){
				answer += upper_bound(d_e_plus_f, i) - lower_bound(d_e_plus_f, i);
			}
			
			out.println(answer);
		}
		
		static int lower_bound(ArrayList<Integer> list, int key){
			int lo=0, hi=list.size();
			while(hi>lo){
				int mid = lo+(hi-lo)/2;
				if(list.get(mid)>=key){
					hi=mid;
				} else {
					lo = mid+1;
				}
			}
			return lo;
		}
		
		static int upper_bound(ArrayList<Integer> list, int key){
			int lo = 0, hi = list.size();
			while(hi>lo){
				int mid = lo+(hi-lo)/2;
				if(list.get(mid)<=key){
					lo = mid+1;
				} else {
					hi = mid;
				}
			}
			return lo;
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
