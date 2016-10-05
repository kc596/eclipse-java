/**
 * 
 */
package unionfind;

import java.util.Arrays;

/**
 * @author Kunal
 *
 */
public class QuickUnionDemo {
	public static void main(String[] args) {
		QuickUnion q=new QuickUnion(10);
		q.union(5,3);
		q.union(3,9);
		q.union(9,6);
		q.union(9,7);
		q.union(7,5);
		System.out.println(q.isConnected(7, 5)+" "+q.isConnected(5,5)+" "+q.isConnected(5, 1)+" "+q.isConnected(6, 7));
		
		//binary search analysis
		int a[]={10,20,30,40,50,60,70,80,90,99};
		System.out.println(a[Math.abs(Arrays.binarySearch(a, 0)+1)]);
	}
}
