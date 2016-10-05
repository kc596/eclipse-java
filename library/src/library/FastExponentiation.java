package library;

public class FastExponentiation {
	long expo(long a, long b, long MOD){
		long result = 1;
		while (b>0){
			if (b%2==1) result=(result*a)%MOD;
			b>>=1;
			a=(a*a)%MOD;
		}
		return result%MOD;
	}
	
	public static void main(String[] args){
		System.out.println(new FastExponentiation().expo(2,30,100000000007L));
	}
}
