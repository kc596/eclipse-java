package library;

public class BinomialCoefficient {
	static long C(int n, int k){
		if(k>n) return 0;
		else if(n==k) return 1;
		double ans=n;
		k=Math.min(k, n-k);
		for(int i=1; i<k; i++){
			ans*=(n-i);
			ans/=i+1;
		}
		return (long)ans;
	}
}
