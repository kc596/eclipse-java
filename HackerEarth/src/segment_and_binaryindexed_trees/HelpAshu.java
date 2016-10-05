package segment_and_binaryindexed_trees;

/**
 * @author kunal05
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HelpAshu {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		Task1 solver=new Task1();		
		solver.solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		out.close();
	}
	
	static class Task1{
		public void solve(InputReader in, PrintWriter out){
			//
		}
	}
	static class SegmentTree{
		static Integer[] createSegmentTree(int n){
			int size=(int)Math.ceil(Math.log(n)/Math.log(2));
			return new Integer[pow(2,size+1)-1];
		}

		static void buildSegmentTree(Integer[] input, Integer[] segTree, int lo, int hi, int pos){
			if(lo==hi){
				segTree[pos]=input[lo];
				return;
			}
			int mid=lo+(hi-lo)/2;
			buildSegmentTree(input, segTree, lo, mid, 2*pos+1);
			buildSegmentTree(input, segTree, mid+1, hi, 2*pos+2);
			segTree[pos]=Math.min(segTree[2*pos+1], segTree[2*pos+2]);
		}

		static int rangeMinQuery(Integer[] segTree, int lo, int hi, int qlo, int qhi, int pos){
			if(qlo>hi || qhi<lo) return Integer.MAX_VALUE;
			else if(qlo<=lo && qhi>=hi) return segTree[pos];
			int mid=lo+(hi-lo)/2;
			return Math.min(
					rangeMinQuery(segTree, lo, mid, qlo, qhi, 2*pos+1),
					rangeMinQuery(segTree, mid+1, hi, qlo, qhi, 2*pos+2)
					);
		}

		static void updateSegmentTree(Integer[] segTree, int lo, int hi, int index, int value, int pos){
			if(lo==hi){
				segTree[pos]=value;
				return;
			}
			int mid=lo+(hi-lo)/2;
			if(index<=mid) updateSegmentTree(segTree, lo, mid, index, value, 2*pos+1);
			else updateSegmentTree(segTree, mid+1, hi, index, value, 2*pos+2);
			segTree[pos]=Math.min(segTree[2*pos+1], segTree[2*pos+2]);
		}

		private static int pow(int a, int b){
			int result = 1, MOD=Integer.MAX_VALUE;
			while (b>0){
				if (b%2==1) result=(result*a)%MOD;
				b>>=1;
				a=(a*a)%MOD;
			}
			return result%MOD;
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
		public long nextLong(){
			return Long.parseLong(next());
		}
		public double nextDouble(){
			return Double.parseDouble(next());
		}
	}
}