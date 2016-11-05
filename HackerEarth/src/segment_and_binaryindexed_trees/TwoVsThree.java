package segment_and_binaryindexed_trees;

/**
 * @author kunal05
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TwoVsThree {
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
			int n=in.nextInt();
			String s=in.next();
			char[] ar=s.toCharArray();
			int[] a=new int[n];
			
			for(int i=0; i<n; i++) a[i]=Integer.parseInt(""+s.charAt(i));
			
			SegmentTree tree=new SegmentTree(a);
			
			
			
			int q=in.nextInt(), type, l, r;
			
			for(int i=0; i<q; i++){
				type=in.nextInt();
				l=in.nextInt();
				if(type==0){
					r=in.nextInt();
					out.println(tree.query(0, n-1, l, r, 0));
					continue;
				}
				else{
					if(ar[l]=='0') tree.updateSegmentTree(0, n-1, l, 1, 0);
					ar[l]='1';
				}
			}
		}
	}
	
	static class SegmentTree{
		int[] segTree;
		int[] pow;
		int n;
		
		public SegmentTree(int[] a){
			n=a.length;
			
			pow=new int[n+1];
			pow[0]=1;
			for(int i=1; i<=n; i++){
				pow[i]=(pow[i-1]*2)%3;
			}
			
			int size=(int) Math.ceil(Math.log(n)/Math.log(2));
			size = (int)Math.pow(2, size+1)-1;
			segTree=new int[size];
			buildSegmentTree(a, 0, n-1, 0);
		}
		
		void buildSegmentTree(int[] input, int lo, int hi, int pos){
			if(lo==hi){
				segTree[pos]=pow[n-lo-1]*input[lo];
				return;
			}
			int mid=lo+(hi-lo)/2;
			buildSegmentTree(input, lo, mid, 2*pos+1);
			buildSegmentTree(input, mid+1, hi, 2*pos+2);
			segTree[pos]=(segTree[2*pos+1]+segTree[2*pos+2])%3;
		}
		
		void updateSegmentTree(int lo, int hi, int index, int value, int pos){
			if(lo==hi){
				segTree[pos] = pow[n-lo-1]*1;
				return;
			}
			int mid=lo+(hi-lo)/2;
			if(index<=mid) updateSegmentTree(lo, mid, index, value, 2*pos+1);
			else updateSegmentTree(mid+1, hi, index, value, 2*pos+2);
			segTree[pos]=(segTree[2*pos+1]+segTree[2*pos+2])%3;
		}
		
		int query(int lo, int hi, int qlo, int qhi, int pos){
			if(qhi<lo || qlo>hi) return 0;
			else if(qlo<=lo && qhi>=hi) return pow[n-qhi-1]*segTree[pos];
			int mid=lo+(hi-lo)/2;
			return (query(lo, mid, qlo, qhi, 2*pos+1)+query(mid+1, hi, qlo, qhi, 2*pos+2))%3;
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