package classical.unsolved;

/**
 * @author Kunal
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LightSwitching {
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
		static long expo(long a, long b, long MOD){
			long result = 1;
			while (b>0){
				if (b%2==1) result=(result*a)%MOD;
				b>>=1;
				a=(a*a)%MOD;
			}
			return result%MOD;
		}
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt()+1, m=in.nextInt();
			Integer[] a=new Integer[n];
			for(int i=0; i<n; i++) a[i]=1;
			
			int size= (int)Math.ceil(Math.log(n)/Math.log(2));
			Integer[] segTree=new Integer[(int)(2*expo(2,size, 100000000))-1];
			
			constructSegmentTree(segTree, a, 0, n-1, 0);
			for(int i=0; i<m; i++){
				int q=in.nextInt(), qlo=in.nextInt(), qhi=in.nextInt();
				if(q==0) out.println(rangeSum(segTree, qlo, qhi, 0, n-1, 0));
			}
		}
		
		static void constructSegmentTree(Integer[] segTree, Integer[] input, int lo, int hi, int pos){
			if(lo==hi){
				segTree[pos]=input[lo];
				return;
			}
			int mid=lo+(hi-lo)/2;
			constructSegmentTree(segTree, input, lo, mid, 2*pos+1);
			constructSegmentTree(segTree, input, mid+1, hi, 2*pos+2);
			segTree[pos]=segTree[2*pos+1]+segTree[2*pos+2];
		}
		
		static int rangeSum(Integer[] segTree, int qlo, int qhi, int lo, int hi, int pos){
			if(qlo<=lo && qhi>=hi) return segTree[pos];		//completely overlap
			else if(qlo>hi || qhi<lo) return 0;				//no overlap
			int mid=lo+(hi-lo)/2;
			
			return rangeSum(segTree, qlo, qhi, lo, mid, 2*pos+1) + rangeSum(segTree, qlo, qhi, mid+1, hi, 2*pos+2);
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
