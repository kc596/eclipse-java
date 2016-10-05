/**
 * 
 */
package library;

import java.math.BigInteger;

/**
 * @author Kunal
 *
 */
public class FibonacciCalculator {
	private BigInteger[] cache;
	public FibonacciCalculator(int n){
		cache=new BigInteger[n+1];
		cache[0]=BigInteger.ZERO;
		cache[1]=BigInteger.ZERO;
		cache[2]=BigInteger.ONE;
		
		for(int i=3; i<=n; i++) cache[i]=cache[i-1].add(cache[i-2]);
	}
	
	public BigInteger get(int index){
		return cache[index];
	}
	
	public static void main(String[] args){
		FibonacciCalculator c=new FibonacciCalculator(100000);
		System.out.println(c.get(100000));
	}
}
