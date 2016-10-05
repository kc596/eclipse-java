package segment_trees;

/**
 * @author Kunal
 *
 */
public class SegmentTreeRangeMin{
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

	/*demo*/
	public static void main(String[] args){
		java.util.Scanner in=new java.util.Scanner(System.in);
		int n=in.nextInt();
		Integer[] a=new Integer[n];
		Integer[] segTree=createSegmentTree(n);

		for(int i=0; i<n; i++) a[i]=in.nextInt();	//taking input

		buildSegmentTree(a, segTree, 0, n-1, 0);	//building segment tree

		int q=in.nextInt();							//number of queries
		while(q-->0){
			int query=in.nextInt(), f=in.nextInt(), s=in.nextInt();
			if(query==0) System.out.println(rangeMinQuery(segTree, 0, n-1, f, s, 0));
			else updateSegmentTree(segTree, 0, n-1, f, s, 0);
		}
		
		in.close();
	}
}