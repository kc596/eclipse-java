package segment_and_binaryindexed_trees;

/**
 * @author kunal05
 * unsolved
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ComradesIII {
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
		@SuppressWarnings("unused")
		public void solve(InputReader in, PrintWriter out){
			int n=in.nextInt();
			int[] a=new int[n+1];
			SegmentTreeLazy s=new SegmentTreeLazy(a);
			for(int i=1; i<=n; i++){
				
			}
		}
		
		static class SegmentTreeLazy{
			static int[] segTree;
			static int[] lazyTree;
			public SegmentTreeLazy(int[] input){
				int n=input.length;
				int size=(int)Math.ceil(Math.log(n)/Math.log(2));
				size=pow(2,size+1)-1;
				segTree=new int[size];
				lazyTree=new int[size];
				buildSegmentTree(input, 0, n-1, 0);
			}

			void buildSegmentTree(int[] input, int lo, int hi, int pos){
				if(lo==hi){
					segTree[pos]=input[lo];
					return;
				}
				int mid=lo+(hi-lo)/2;
				buildSegmentTree(input, lo, mid, 2*pos+1);
				buildSegmentTree(input, mid+1, hi, 2*pos+2);
				segTree[pos]=segTree[2*pos+1]+segTree[2*pos+2];
			}

			void updateRange(int lo, int hi, int qlo, int qhi, int value, int pos){
				if(lazyTree[pos]!=0){
					segTree[pos]+=(hi-lo+1)*lazyTree[pos];
					if(lo!=hi){
						lazyTree[2*pos+1] += lazyTree[pos];
						lazyTree[2*pos+2] += lazyTree[pos];
					}
					lazyTree[pos]=0;
				}
				
				if(lo>hi || qlo>hi || qhi<lo) return;			//no overlap
				else if(qlo<=lo && qhi>=hi){					//complete overlap
					segTree[pos] += (hi-lo+1)*value;
					if(lo!=hi){
						lazyTree[2*pos+1] += value;
						lazyTree[2*pos+2] += value;
					}
					return;
				}
				int mid=lo+(hi-lo)/2;
				updateRange(lo, mid, qlo, qhi, value, 2*pos+1);
				updateRange(mid+1, hi, qlo, qhi, value, 2*pos+2);
				segTree[pos]=segTree[2*pos+1]+segTree[2*pos+2];
			}
			
			void updateSegmentTree(int lo, int hi, int index, int value, int pos){
				if(lo==hi){
					segTree[pos]=value;
					return;
				}
				int mid=lo+(hi-lo)/2;
				if(index<=mid) updateSegmentTree(lo, mid, index, value, 2*pos+1);
				else updateSegmentTree(mid+1, hi, index, value, 2*pos+2);
				segTree[pos]=segTree[2*pos+1]+segTree[2*pos+2];
			}
			
			int query(int lo, int hi, int qlo, int qhi, int pos){
				if(lazyTree[pos]!=0){
					segTree[pos]+=(hi-lo+1)*lazyTree[pos];
					if(lo!=hi){
						lazyTree[2*pos+1]+=lazyTree[pos];
						lazyTree[2*pos+2]+=lazyTree[pos];
					}
					lazyTree[pos]=0;
				}
				
				if(lo>hi || qlo>hi || qhi<lo) return 0;
				else if(qlo<=lo && qhi>=hi) return segTree[pos];
				
				int mid=lo+(hi-lo)/2;
				return query(lo, mid, qlo, qhi, 2*pos+1)+query(mid+1, hi, qlo, qhi, 2*pos+2);
				
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