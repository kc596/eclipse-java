package substring_search;
/**
 * Knuth-Morris-Pratt substring search
 * @author Kunal
 *
 */
public class KMP {
	private static final int R = 256;		//radix
	private int M;
	private String pat;
	private int[][] dfa;
	
	public KMP(String pattern){
		this.pat = pattern;
		M = pat.length();
		dfa = new int[R][M];				//row = char, col = state
		dfa[pat.charAt(0)][0] = 1;
		for(int X=0, j=1; j<M; j++){
			for(int c=0; c<R; c++)
				dfa[c][j] = dfa[c][X];		//copy mismatch cases
			dfa[pat.charAt(j)][j] = j+1;	//set match case
			X = dfa[pat.charAt(j)][X];		//update restart state
		}
	}
	
	public int search(String txt){
		//pattern has already been preprocessed
		int i,j, N = txt.length();
		for(i=0, j=0; i<N && j<M; i++)
			j = dfa[txt.charAt(i)][j];
			
		if(j==M) return i-M;				//index of match start
		else return N;						//not found
	}
	
	/*demo*/
	public static void main(String[] args){
		KMP k = new KMP("ABABAC");
		System.out.println(k.search("ABABABABABABABABABACABA"));
	}
}
