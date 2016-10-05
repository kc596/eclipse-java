package hackerrank;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.math.BigInteger;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WorldCodeSprint6 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		new Task6().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt(), k=in.nextInt();
			Integer p,sum=0;
			for(int i=0; i<n; i++){
				p=in.nextInt();
				if(i!=k) sum+=p;
			}
			Integer actual=in.nextInt();
			if(2*actual==sum) out.println("Bon Appetit");
			else out.println(actual-(sum/2));
		}
	}
	
	static class Task2 {
		public void solve(InputReader in, PrintWriter out) {
			int[] a=new int[5];
			int d, ans=0;
			
			for(int i=0; i<5; i++) a[i]=in.nextInt();
			for(int i=0; i<5; i++){
				d=in.nextInt();
				if(d<a[i]) ans+=Math.min(Math.abs(d-a[i]), Math.abs(10+d-a[i]));
				else ans+=Math.min(Math.abs(d-a[i]), Math.abs(10+a[i]-d));
			}
			out.println(ans);
		}
	}
	
	static class Task4 {
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				String a=in.next();
				String b=in.next();
				HashMap<Character, Integer> prev=new HashMap<Character, Integer>();
				
				Integer k=0, temp;
				boolean flag=true, status=true;
				for(int i=0; i<a.length(); i++){
					Character c=a.charAt(i);
					if(status && c==b.charAt(k)){
						k++;
					}
					else if(status && Character.toUpperCase(c)==b.charAt(k)){
						temp=prev.get(c);
						if(temp==null) temp=0;
						prev.put(c, temp+1);
						k++;
					}
					else if(Character.isUpperCase(c)){
						temp=prev.get(Character.toLowerCase(c));
						if(temp==null || temp==0){
							flag=false;
							break;
						}
						else prev.put(Character.toLowerCase(c), temp-1);
					}
					if(k==b.length()) status=false;
				}
				if(!flag){
					out.println("NO");
					continue;
				}
				if(k==b.length()) out.println("YES");
				else out.println("NO");
			}
		}
	}
	
	static class Task3 {
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				int n=in.nextInt();
				int tn=2*n;
				long sum=0;
				Integer[][] a=new Integer[tn][tn];
				
				for(int i=0; i<tn; i++)
					for(int j=0; j<tn; j++)
						a[i][j]=in.nextInt();
				
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
						sum+=Math.max(Math.max(a[i][j], a[tn-i-1][j]), Math.max(a[i][tn-j-1], a[tn-i-1][tn-j-1]));
				
				out.println(sum);
			}
		}
	}
	
	static class Task5 {
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			BigInteger two=new BigInteger("2");
			while(t-->0){
				BigInteger n=new BigInteger(in.next());
				BigInteger k=new BigInteger(in.next());
				BigInteger b=new BigInteger(in.next());
				BigInteger count=b;
				BigInteger max= ((k.multiply(two).subtract(b).add(BigInteger.ONE)).multiply(b)).divide(two);
				BigInteger min= ((BigInteger.ONE.add(b)).multiply(b)).divide(two);
				
				if(n.compareTo(min)<0 || n.compareTo(max)>0){ out.println(-1); continue;}
				BigInteger stock=n.subtract(min), sum=min, i=b, j=k;
				
				//1 to b
				while(sum.compareTo(n)!=0){
					//sum=sum.add(k.subtract(b));
					if(stock.compareTo(j.subtract(i))>0){
						sum=sum.add(j.subtract(i));
						stock=stock.subtract(j.subtract(i));
						out.print(j+" ");
						j=j.subtract(BigInteger.ONE);
						i=i.subtract(BigInteger.ONE);
					}
					else{
						sum=sum.add(stock);
						out.print(i.add(stock));
						if(count.compareTo(BigInteger.ONE)>0) out.print(" ");
						i=i.subtract(BigInteger.ONE);
						stock=BigInteger.ZERO;
					}
					count=count.subtract(BigInteger.ONE);
				}
				while(i.compareTo(BigInteger.ZERO)>0){
					out.print(i);
					if(count.compareTo(BigInteger.ONE)>0) out.print(" ");
					i=i.subtract(BigInteger.ONE);
					count=count.subtract(BigInteger.ONE);
				}
				out.println();
			}
		}
	}
	
	static class Task6{
		static final int MOD=1000000007, aa=100001;
		long[] f;
		public void solve(InputReader in, PrintWriter out){
			int n=in.nextInt(), q=in.nextInt();
			ArrayList<String> subs=new ArrayList<String>();
			String s=in.next(), temp;
			for(int i=0; i<n; i++){
				for(int j=i+1; j<=n; j++){
					temp=s.substring(i, j);
					if(isPalindrome(temp)){
						subs.add(temp);
					}
				}
			}
			Collections.sort(subs);
			int qq;
			f=new long[subs.size()];
			for(int i=0; i<subs.size(); i++){
				f[i]=ff(subs.get(i));
			}
			
			for(int i=0; i<q; i++){
				qq=in.nextInt();
				if(qq>subs.size()) out.println(-1);
				else out.println( f[(qq-1)] );
			}
		}
		static long ff(String s){
			long a=1, ans=0;
			for(int i=0; i<s.length(); i++){
				ans=(ans+((s.charAt(i)*a)%MOD))%MOD;
				a=a*aa%MOD;
			}
			return ans;
		}
		static boolean isPalindrome(String s){
			//System.out.println(s);
			int n=s.length();
			if(n==1) return true;
			else{
				for(int i=0; i<n/2; i++){
					if(s.charAt(i)!=s.charAt(n-i-1)) return false;
				}
				return true;
			}
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

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
