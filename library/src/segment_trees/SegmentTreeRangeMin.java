package segment_trees;

/**
 * @author Kunal
 *
 */

public class SegmentTreeRangeMin{
	static Integer[] segTree;
	public SegmentTreeRangeMin(Integer[] input){
		int n=input.length;
		int size=(int)Math.ceil(Math.log(n)/Math.log(2));
		segTree=new Integer[pow(2,size+1)-1];
		buildSegmentTree(input, 0, n-1, 0);
	}

	void buildSegmentTree(Integer[] input, int lo, int hi, int pos){
		if(lo==hi){
			segTree[pos]=input[lo];
			return;
		}
		int mid=lo+(hi-lo)/2;
		buildSegmentTree(input, lo, mid, 2*pos+1);
		buildSegmentTree(input, mid+1, hi, 2*pos+2);
		segTree[pos]=Math.min(segTree[2*pos+1], segTree[2*pos+2]);
	}

	public int query(int lo, int hi, int qlo, int qhi, int pos){
		if(qlo>hi || qhi<lo) return Integer.MAX_VALUE;
		else if(qlo<=lo && qhi>=hi) return segTree[pos];
		int mid=lo+(hi-lo)/2;
		return Math.min(
				query(lo, mid, qlo, qhi, 2*pos+1),
				query(mid+1, hi, qlo, qhi, 2*pos+2)
				);
	}

	public void updateSegmentTree(int lo, int hi, int index, int value, int pos){
		if(lo==hi){
			segTree[pos]=value;
			return;
		}
		int mid=lo+(hi-lo)/2;
		if(index<=mid) updateSegmentTree(lo, mid, index, value, 2*pos+1);
		else updateSegmentTree(mid+1, hi, index, value, 2*pos+2);
		segTree[pos]=Math.min(segTree[2*pos+1], segTree[2*pos+2]);
	}

	public void updateRange(int lo, int hi, int qlo, int qhi, int value, int pos){ //each node += value
		if(lo>hi || qlo>hi || qhi<lo) return;
		else if(lo==hi){
			segTree[pos]+=value;
			return;
		}
		int mid=lo+(hi-lo)/2;
		updateRange(lo, mid, qlo, qhi, value, 2*pos+1);
		updateRange(mid+1, hi, qlo, qhi, value, 2*pos+1);
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