package library;

public class Fibonacci {
	
	static final long MOD = 1000000007;
	static long fibonacci(long n){
		if(n==0) return 0;
		long a=0, b=1, c=1, d=1, e=n-2;
		long a1, b1, c1, d1, a2=0, b2=1, c2=1, d2=1;
		
		while(e>0){
			if(e%2==1){
				a1 = (a*a2+b*c2)%MOD;
				c1 = (c*a2+d*c2)%MOD;
				b1 = (a*b2+ b*d2)%MOD;
				d1 = (b2*c+ d*d2)%MOD;
				a=a1; b=b1; c=c1; d= d1;
			}
			a1 = (a2*a2+b2*c2)%MOD;
			c1 = (c2*a2+d2*c2)%MOD;
			b1 = (a2*b2+ b2*d2)%MOD;
			d1 = (b2*c2+ d2*d2)%MOD;
			a2=a1; b2=b1; c2=c1; d2= d1;
			e /= 2;
		}
		return d;
	}
	
	/*demo*/
	public static void main(String[] args) {
		for(int i=0; i<15; i++){
			System.out.print(fibonacci(i)+" ");
		}
	}

}
