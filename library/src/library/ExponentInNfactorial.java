package library;

/**
 * @author Kunal
 * This is for finding exponent of a number p in n!
 * e.g., Exponent of 10 in 100! = 24
 * 	Or., No. of zeros in 100!	= 24
 */
public class ExponentInNfactorial {
	static long exponentofprimep(int p, long n){
		//To find:- exponent of a prime number p in n!
		long ans=0;
		n = n/p;
		while(n != 0){
			ans+= n;
			n= n/p;
		} 
		return ans;
	}
	
	static private boolean[] seive;
	static long exponentofcompositep(int p, long n){
		/*
		 * For finding exponent of a composite number:
		 * 	1. Prime factorize the composite number
		 * 	2. Find the exponent of each prime number and take minimum of the set
		 */
		final int ROOT=(p/2)+1;		//define the maximum range of prime factors
									//this method is used to prevent costly sqrt()
		seive = new boolean[ROOT];
		for(int i=1; i<ROOT; i++) seive[i]=true;
		seive[0]=seive[1]=false;
		
		for(int i=4; i<ROOT; i+=2) seive[i]=false;
		
		for(int i=3; i<ROOT; i+=2){
			if(seive[i]){
				for(int j=i+i; j<ROOT; j=j+i){
					seive[j]=false;
				}
			}
		}
		/* seive completed */
		
		long ans=0,temp;
		//solving for each prime
		for(int i=1; i<ROOT; i++){
			if(seive[i]){
				int pow=powerofprime(i, p);
				if(pow==0) continue;
				long exp=exponentofprimep(i, n);
				temp=exp/pow;
				ans=(ans>0 && ans<temp)?ans:temp;	//minimum of exponent
			}
		}
		return ans;
	}
	
	private static int powerofprime(int prime, long num){
		long mod = num%prime;
		int ans=0;
		while(mod==0 && num>1){
			num/=prime;
			mod=num%prime;
			ans+=1;
		}
		return ans;
	}
	
	public static void main(String[] args){
		System.out.println(exponentofcompositep(12,1000));
	}
}
