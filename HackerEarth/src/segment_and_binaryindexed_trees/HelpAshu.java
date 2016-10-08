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
			int n=in.nextInt();
			Integer[] a=new Integer[n];
			for(int i=0; i<n; i++) a[i]=in.nextInt();
			Integer[] oddSegTree=SegmentTree.createSegmentTree(n);
			Integer[] evenSegTree=SegmentTree.createSegmentTree(n);
			SegmentTree.buildEvenSegmentTree(a, evenSegTree, 0, n-1, 0);
			SegmentTree.buildOddSegmentTree(a, oddSegTree, 0, n-1, 0);

			/**
			 * Other way: no. of odd number bw x and y = (y-x+1)-(no. of even numbers)
			 */
			int q=in.nextInt();
			for(int i=0; i<q; i++){
				int type=in.nextInt();
				int x=in.nextInt()-1;
				int y=in.nextInt()-1;
				
				if(type==0){
					//modify the number at index x to y
					SegmentTree.updateSegmentTree(oddSegTree, evenSegTree, 0, n-1, x, y+1, 0);
				}
				else if(type==1){
					//count even numbers b/w x to y (inclusive)
					out.println(SegmentTree.query(evenSegTree, 0, n-1, x, y, 0));
				}
				else if(type==2){
					//count odd number b/w x to y (inclusive)
					out.println(SegmentTree.query(oddSegTree, 0, n-1, x, y, 0));					
				}
			}
		}
	}
	static class SegmentTree{
		static Integer[] createSegmentTree(int n){
			int size=(int)Math.ceil(Math.log(n)/Math.log(2));
			return new Integer[pow(2,size+1)-1];
		}

		static void buildEvenSegmentTree(Integer[] input, Integer[] segTree, int lo, int hi, int pos){
			if(lo==hi){
				if(input[lo]%2==0) segTree[pos]=1;
				else segTree[pos]=0;
				return;
			}
			int mid=lo+(hi-lo)/2;
			buildEvenSegmentTree(input, segTree, lo, mid, 2*pos+1);
			buildEvenSegmentTree(input, segTree, mid+1, hi, 2*pos+2);
			segTree[pos]=segTree[2*pos+1]+segTree[2*pos+2];
		}
		
		static void buildOddSegmentTree(Integer[] input, Integer[] segTree, int lo, int hi, int pos){
			if(lo==hi){
				if(input[lo]%2==1) segTree[pos]=1;
				else segTree[pos]=0;
				return;
			}
			int mid=lo+(hi-lo)/2;
			buildOddSegmentTree(input, segTree, lo, mid, 2*pos+1);
			buildOddSegmentTree(input, segTree, mid+1, hi, 2*pos+2);
			segTree[pos]=segTree[2*pos+1]+segTree[2*pos+2];
		}

		static int query(Integer[] segTree, int lo, int hi, int qlo, int qhi, int pos){
			if(qlo>hi || qhi<lo) return 0;
			else if(qlo<=lo && qhi>=hi) return segTree[pos];
			int mid=lo+(hi-lo)/2;
			return query(segTree, lo, mid, qlo, qhi, 2*pos+1) + query(segTree, mid+1, hi, qlo, qhi, 2*pos+2);
		}

		static void updateSegmentTree(Integer[] oddSegTree, Integer[] evenSegTree, int lo, int hi, int index, int value, int pos){
			if(lo==hi){
				if(value%2==0){
					oddSegTree[pos]=0;
					evenSegTree[pos]=1;
				}
				else{
					oddSegTree[pos]=1;
					evenSegTree[pos]=0;
				}
				return;
			}
			int mid=lo+(hi-lo)/2;
			if(index<=mid) updateSegmentTree(oddSegTree, evenSegTree, lo, mid, index, value, 2*pos+1);
			else updateSegmentTree(oddSegTree, evenSegTree, mid+1, hi, index, value, 2*pos+2);
			oddSegTree[pos]=oddSegTree[2*pos+1]+oddSegTree[2*pos+2];
			evenSegTree[pos]=evenSegTree[2*pos+1]+evenSegTree[2*pos+2];
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