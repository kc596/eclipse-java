package substring_search;

public class KMP{
	int R=256;
	private int[][] dfa;
	private int M, N;

	public KMP(String pat){
		this.M=pat.length();
		this.dfa=new int[R][M];
		dfa[pat.charAt(0)][0]=1;

		int x=0;
		for(int i=1; i<M; i++){
			for(int j=0; j<R; j++)
				dfa[j][i]=dfa[j][x];	//mismatch case
			dfa[pat.charAt(i)][i]=i+1;	//match case
			x=dfa[pat.charAt(i)][x];	//update restart state
		}
	}
	public int search(String txt){
		this.N=txt.length();
		int i, j;
		for(i=0, j=0; i<N && j<M; i++){
			j=dfa[txt.charAt(i)][j];
		}
		if(j==M) return i-M;
		else return N;
	}
}