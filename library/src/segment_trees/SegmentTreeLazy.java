package segment_trees;

/**
 * @author Kunal
 *
 */
public class SegmentTreeLazy{
	static Integer[] segTree;
	static int[] lazyTree;
	public SegmentTreeLazy(Integer[] input){
		int n=input.length;
		int size=(int)Math.ceil(Math.log(n)/Math.log(2));
		size=pow(2,size+1)-1;
		segTree=new Integer[size];
		lazyTree=new int[size];
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

	int query(int lo, int hi, int qlo, int qhi, int pos){	//rangeMinQuery
		if(2*pos<lazyTree.length-2){
			segTree[2*pos+1]+=lazyTree[pos];
			segTree[2*pos+2]+=lazyTree[pos];
			lazyTree[pos]=0;
		}
		if(qlo>hi || qhi<lo) return Integer.MAX_VALUE;
		else if(qlo<=lo && qhi>=hi){
			return segTree[pos];
		}
		int mid=lo+(hi-lo)/2;
		return Math.min(
				query(lo, mid, qlo, qhi, 2*pos+1),
				query(mid+1, hi, qlo, qhi, 2*pos+2)
				);
	}

	/* add value to all element b/w qlo and qhi (inclusive) */
	void updateSegmentTree(int lo, int hi, int qlo, int qhi, int value, int pos){
		if(qlo>hi || qhi<lo){ //no overlap - return from there
			//no overlap
			return;
		}
		else if(qlo<=lo && qhi>=hi){
			segTree[pos]+=value;
			if((2*pos)<(lazyTree.length-2)){
				lazyTree[2*pos+1]+=value;
				lazyTree[2*pos+2]+=value;
			}
			return;
		}
		int mid=lo+(hi-lo)/2;
		updateSegmentTree(lo, mid, qlo, qhi, value, 2*pos+1);
		updateSegmentTree(mid+1, hi, qlo, qhi, value, 2*pos+2);
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