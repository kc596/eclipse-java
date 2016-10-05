package radixsorts;

import java.util.Arrays;

public class LongestRepeatedSubstring {
	/**
	 * Calculate longest repeated substring in a string
	 */
	
	public static String lrs(String s){
		int N = s.length();
		
		/*creating suffixes - linear time and space*/
		String[] suffixes = new String[N];
		for(int i=0; i<N; i++)
			suffixes[i] = s.substring(i);	//constant time operation
		
		Arrays.sort(suffixes);				//sort suffixes
		
		/*find LCP b/w adjacent suffixes in sorted order*/
		String lrs="";
		for(int i=0; i<N-1; i++){
			int len = lcp(suffixes[i], suffixes[i+1]);
			if(len>lrs.length()) lrs=suffixes[i].substring(0, len);
		}
		
		return lrs;
	}
	
	private static int lcp(String a, String b){
		int n = Math.min(a.length(), b.length());
		for(int i=0; i<n; i++){
			if(a.charAt(i) != b.charAt(i))
				return i;			
		}
		return n;
	}
	
	/*demo*/
	public static void main(String[] args){
		String a="hellohowareyoujalkjnvaheueiogfjdfhellohowareyoulajfnvajfjoiuriu";
		System.out.println(lrs(a));
	}
}
