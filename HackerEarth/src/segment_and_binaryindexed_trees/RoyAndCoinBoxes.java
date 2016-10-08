package segment_and_binaryindexed_trees;

/**
 * @author kunal05
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RoyAndCoinBoxes {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();		
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		out.close();
	}
	
	static class Task1{
		public void solve(InputReader in, PrintWriter out){
			int n=in.nextInt(), m=in.nextInt();
			Integer[] a=new Integer[n];
			
			SegmentTreeLazy s=new SegmentTreeLazy(a);
			
			for(int i=0; i<m; i++){
				int l=in.nextInt()-1, r=in.nextInt()-1;
				s.updateSegmentTree(0, n-1, l, r, 1, 0);
			}
			int[] ans=new int[1000001];
			
			for(int i=0; i<n; i++){
				a[i]=s.query(0, n-1, i, i, 0);
				out.print(a[i]+" ");
				ans[a[i]]++;
			}
			for(int i=1; i<1000001; i++) ans[i]+=ans[i-1];
			
			int q=in.nextInt();
			for(int i=0; i<q; i++){
				//int temp=in.nextInt();
				//out.println(ans[temp-1]);
			}
		}
	}
	static class SegmentTreeLazy{
		static int[] segTree;
		static int[] lazyTree;
		public SegmentTreeLazy(Integer[] input){
			int n=input.length;
			int size=(int)Math.ceil(Math.log(n)/Math.log(2));
			size=pow(2,size+1)-1;
			segTree=new int[size];
			lazyTree=new int[size];
		}

		int query(int lo, int hi, int qlo, int qhi, int pos){	//rangeMinQuery
			if((2*pos+2)<lazyTree.length){
				segTree[2*pos+1]+=lazyTree[pos];
				segTree[2*pos+2]+=lazyTree[pos];
				lazyTree[2*pos+1]+=lazyTree[pos];
				lazyTree[2*pos+2]+=lazyTree[pos];
				lazyTree[pos]=0;
			}
			if(qlo>hi || qhi<lo) return 0;
			else if(qlo<=lo && qhi>=hi){
				return segTree[pos];
			}
			int mid=lo+(hi-lo)/2;
			return query(lo, mid, qlo, qhi, 2*pos+1)+query(mid+1, hi, qlo, qhi, 2*pos+2);
		}

		/* add value to all element b/w qlo and qhi (inclusive) */
		void updateSegmentTree(int lo, int hi, int qlo, int qhi, int value, int pos){
			if(qlo>hi || qhi<lo){ //no overlap - return from there
				//no overlap
				return;
			}
			else if(qlo<=lo && qhi>=hi){
				segTree[pos]+=value;
				if((2*pos+2)<(lazyTree.length)){
					lazyTree[2*pos+1]+=value;
					lazyTree[2*pos+2]+=value;
				}
				return;
			}
			int mid=lo+(hi-lo)/2;
			updateSegmentTree(lo, mid, qlo, qhi, value, 2*pos+1);
			updateSegmentTree(mid+1, hi, qlo, qhi, value, 2*pos+2);
			segTree[pos]=segTree[2*pos+1]+segTree[2*pos+2];
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
		public String nextLine() throws IOException{
            return reader.readLine();
        }
	}
}