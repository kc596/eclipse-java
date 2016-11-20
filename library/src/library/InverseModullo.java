package library;

public class InverseModullo {
	long expo(long a, long b, long MOD){ //fast exponentiation
		long result = 1;
		while (b>0){
			if (b%2==1) result=(result*a)%MOD;
			b>>=1;
			a=(a*a)%MOD;
		}
		return result%MOD;
	}
	
	long inverseModullo(long numerator, long denominator, long MOD){
		return ((numerator%MOD)*(expo(denominator, MOD-2, MOD)))%MOD;
	}
}
