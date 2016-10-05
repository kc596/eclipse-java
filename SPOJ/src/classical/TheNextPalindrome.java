package classical;
/**
 * @author Kunal Chaudhary
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheNextPalindrome {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver=new Task();
		solver.solve(in, out);
		out.close();
	}
	static class Task{
		public void solve(InputReader in, PrintWriter out){
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				String s=in.next();
				char[] arr=s.toCharArray();
				int len=s.length();
				out.println(new String(NextPalindrome(arr,len,len/2,len%2==0)));
			}
		}
		private static char[] NextPalindrome(char[] a, int len, int mid, boolean even){
			if(isPalindrome(a,len)){
				if(allDigitsAreEqual(a,len)){
					if(allDigitsAreNine(a,len)){
						char[] ans=new char[len+1];
						Arrays.fill(ans, '0');
						ans[0]='1';
						ans[len]='1';
						return ans;
					}
					else{
						if(even){
							a[mid]++;
							a[mid-1]++;
							return a;
						}
						if(!even){
							a[mid]++;
							return a;
						}
					}
				}
				else{
					if(even){
						if(a[mid-1]=='9'){
							propogateCarry(a,len,mid-1,true);
							return a;
						}
						else{
							a[mid]++;
							a[mid-1]++;
						}
						return a;
					}
					else{//odd
						if(a[mid]=='9'){
							propogateCarry(a,len,mid,false);
							return a;
						}
						else{
							a[mid]++;
							return a;
						}
					}
				}
			}
			else{
				int l=0,r=0;
				if(even){
					for(l=0; l<mid; l++){
						if(a[mid+l]!=a[mid-l-1]) break;
					}
					r=mid+l;
					l=mid-l-1;
				}
				else{//odd
					for(l=1; l<mid; l++){
						if(a[mid+l]!=a[mid-l]) break;
					}
					r=mid+l;
					l=mid-l;
				}
				
				//mirror step - 2 possible cases
				if(a[l]>a[r]){
					for(int i=l,j=r; i>=0; i--,j++){
						a[j]=a[i];
					}
					return a;
				}
				if(a[l]<a[r]){
					if(even){
						if(a[mid-1]=='9'){
							propogateCarry(a,len,mid-1,true);
							return a;
						}
						else{
							a[mid]++;
							a[mid-1]++;
							for(int i=l,j=r; i>=0; i--,j++){
								a[j]=a[i];
							}
						}
						return a;
					}
					else{//odd
						if(a[mid]=='9'){
							propogateCarry(a,len,mid,false);
							return a;
						}
						else{
							a[mid]++;
							for(int i=l,j=r; i>=0; i--,j++){
								a[j]=a[i];
							}
							return a;
						}
					}
				}
			}
			return a;
		}
		private static void propogateCarry(char[] a,int len, int place, boolean even){
			int i=place;
			while(a[i]=='9'){
				a[i]='0';
				i--;
			}
			a[i]++;
			if(even){
				for(int j=place,k=place+1; j>=0; j--,k++){
					a[k]=a[j];
				}
			}
			if(!even){
				for(int j=place-1,k=place+1; j>=0; j--,k++){
					a[k]=a[j];
				}
			}
		}
		private static boolean isPalindrome(char[] a,int len){
			for(int i=0; i<len; i++){
				if(a[i]!=a[len-i-1]) return false;
			}
			return true;
		}
		private static boolean allDigitsAreEqual(char[] a,int len){
			for(int i=0; i<len-1; i++){
				if(a[i]!=a[i+1]) return false;
			}
			return true;
		}
		private static boolean allDigitsAreNine(char[] a,int len){
			for(int i=0; i<len; i++){
				if(a[i]!='9') return false;
			}
			return true;
		}
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		
		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}
		
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}