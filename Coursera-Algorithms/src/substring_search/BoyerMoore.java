package substring_search;

public class BoyerMoore {
	private static final int R =256;	//radix
	private final String pat;			//pattern
	private final int M;				//length of pattern
	private int[] right;				//rightmost index of pattern characters
	
	public BoyerMoore(String pat){
		this.pat = pat;
		this.M = pat.length();
		this.right = new int[R];
		
		/*precompute rightmost index of chars of pattern*/
		for(int i=0; i<R; i++)
			right[i]=-1;
		for(int i=0; i<M; i++)
			right[pat.charAt(i)] = i;
	}
	
	public int search(String txt){
		int N = txt.length();
		for(int i=0; i<N-M; i++){
			int skip=0;
			for(int j=M-1; j>=0; j--){
				if(pat.charAt(j) != txt.charAt(i+j)){
					skip = Math.max(1, j-right[txt.charAt(i+j)]);
					//To avoid backup in text, Math.max() is used
					break;
				}			
			}
			if(skip==0) return i;		//match
		}
		return N;						//no match found
	}
	
	/*demo*/
	public static void main(String[] args){
		BoyerMoore bm = new BoyerMoore("NEEDLE");
		System.out.println(bm.search(
				"FINDINAHAYSTACKNEEDLEINAHAYSTACK"
		));
	}
}
