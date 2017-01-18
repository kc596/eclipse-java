package codeforcesRound;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B383 {
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
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt(), x=in.nextInt();
			Integer[] a = new Integer[n];
			for(int i=0; i<n; i++){
				a[i] = in.nextInt();
			}
			Arrays.parallelSort(a);
			long ans=0;
			for(int i=0; i<n; i++){
				int xor = a[i]^x;
				int u= upper_bound(a, i+1, n-1, xor);
				int l= lower_bound(a, i+1, n-1, xor);
				
				ans += u-l;
			}
			out.println(ans);
		}
		
		private int upper_bound(Integer[] a, int lo, int hi, int key){
			while(lo<=hi){
				int mid = lo+(hi-lo)/2;
				if(key>=a[mid]){
					lo = mid+1;
				} else {
					hi = mid-1;
				}
			}
			return lo;
		}
		
		private int lower_bound(Integer[] a, int lo, int hi, int key){
			while(lo<=hi){
				int mid = lo+(hi-lo)/2;
				if(a[mid]<key){
					lo = mid+1;
				} else if(a[mid]>=key) {
					hi = mid-1;
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