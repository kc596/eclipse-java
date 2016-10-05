package substring_search;

public class RabinKarp {
	private long patHash;		//pattern hash value
	private int M;				//pattern length
	private long Q;				//modulus
	private int R;				//radix
	private long RM;			//R^(M-1) % Q
	
	public RabinKarp(String pat){
		M = pat.length();
		R = 256;
		Q = longRandomPrime();	//a large prime
		
		/*precompute R^(M-1)%Q */
		RM = 1;
		for(int i=1; i <= M-1; i++)
			RM = (R * RM) % Q;
		patHash = hash(pat, M);
	}
	
	private long hash(String key, int M){
		long h=0;
		for(int j=0; j<M; j++)
			h = (R*h + key.charAt(j)) % Q;
		return h;
	}
	
	public int search(String txt){
		int N = txt.length();
		long txtHash = hash(txt, M);
		if(patHash == txtHash) return 0;
		
		for(int i=M; i<N; i++){
			txtHash = (txtHash+ Q - RM*txt.charAt(i-M)%Q) %Q;
			txtHash = (txtHash*R + txt.charAt(i)) %Q;
			if(patHash == txtHash) return i-M+1;		//MONTE-CARLO version
			
			/**
			 * MONTE-CARLO version
			 	- Return match if hash match.
			 	- Always runs in linear time.
			 	- Extremely likely to return correct answer.
			 
			 * LAS VEGAS version
			 	- Check for substring match if hash matches.
			 	- Continue search if false collision.
			 	- Always return correct answer.
			 	- Extremely likely to run in linear time.
			 */
		}
		return N;	//no match
	}
	
	private static long longRandomPrime(){
		return 1000000007L;
	}
	
	/*demo*/
	public static void main(String[] args){
		RabinKarp r = new RabinKarp("26535");
		System.out.println(r.search("55265352226521555544454451"));
		//System.out.println(r.hash("26535", 5));		
	}
}
