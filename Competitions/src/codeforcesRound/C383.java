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

public class C383 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		int junjun;
		int[] id;
		boolean[] marked;

		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			boolean flag = true;
			id = new int[n+1];
			
			for(int i=0; i<n; i++){
				id[i+1] = in.nextInt();
				if(id[i+1]!=i+1) flag=false;
			}
			
			if(flag){
				out.println(1);
				return;
			}
			
			int ans=-1, temp_ans1, temp_ans2;
			for(int i=1; i<=n; i++){
				marked = new boolean[n+1];
				temp_ans1 = dfs(i);
				
				marked = new boolean[n+1];
				temp_ans2 = dfs(junjun);
				
				if((temp_ans1<0) || (temp_ans2<0)){
					out.println(-1);
					return;
				}
				
				if(marked[i]){
					ans = Math.max(ans, Math.max(temp_ans2, temp_ans1));
				} else {
					out.println(-1);
					return;
				}
			}
			
			out.println(ans);
		}
		
		private int dfs(int v){
			if(marked[v]){
				junjun = v;
				return 0;
			}
			marked[v] = true;
			if(id[id[v]]==v){
				junjun = v;
				return 1;
			}
			return 1+dfs(id[v]);
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

		public String nextLine() {
			String s = null;
			try {
				s = reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return s;
		}

		public String nextParagraph() {
			String line = null;
			String ans = "";
			try {
				while ((line = reader.readLine()) != null) {
					ans += line;
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return ans;
		}

	}
}
