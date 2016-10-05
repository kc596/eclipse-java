package hackerearth;

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
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class CakeWalk {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		final static BigInteger MOD=new BigInteger("1000000007");
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			BigInteger two=new BigInteger("2");
			while(t-->0){
				BigInteger l=new BigInteger(in.next());
				BigInteger r=new BigInteger(in.next());
				BigInteger sum=BigInteger.ZERO, n;
				
				BigInteger a= l.multiply(two).add(BigInteger.ONE), last;
				
				if(l.mod(two).equals(r.mod(two))){
					sum=sum.add(r.multiply(r));
					last = r.multiply(two).subtract(new BigInteger("3"));
				}
				else last=r.multiply(two).subtract(BigInteger.ONE);
				
				n=((last.subtract(a)).divide(new BigInteger("4"))).add(BigInteger.ONE);
				
				//out.println(n+" "+a+" "+last+" "+sum);
				out.println( (( (n.multiply(a.add(last))).divide(two) ).add(sum)).mod(MOD) );
			}
		}
	}
	
	static class Task2 {
		ArrayList<Integer> set=new ArrayList<Integer>();		
		public void solve(InputReader in, PrintWriter out) {
			String txt=in.next();
			int t=in.nextInt();
			while(t-->0){
				String pat=in.next();
				KMP k=new KMP(pat);
				int index=0, offset=0;
				while(true){
					index=k.search(txt.substring(offset));
					if(index==-2) break;
					offset+=index+1;
					set.add(offset-1);
				}
				//System.out.println("I am free");
			}
			Collections.sort(set);
			for(int i: set){
				out.print(i+" ");
			}
			if(set.isEmpty()) out.println(-1);
		}
		static class KMP{
			int R=256;
			private int[][] dfa;
			private int M, N;

			public KMP(String pat){
				this.M=pat.length();
				this.dfa=new int[R][M];
				dfa[pat.charAt(0)][0]=1;

				int x=0;
				for(int i=1; i<M; i++){
					for(int j=0; j<R; j++)
						dfa[j][i]=dfa[j][x];	//mismatch case
					dfa[pat.charAt(i)][i]=i+1;	//match case
					x=dfa[pat.charAt(i)][x];	//update restart state
				}
			}
			public int search(String txt){
				this.N=txt.length();
				int i, j;
				for(i=0, j=0; i<N && j<M; i++){
					j=dfa[txt.charAt(i)][j];
				}
				if(j==M) return i-M;
				else return (-2);
			}
		}
	}
	
	static class Task3 {
		public void solve(InputReader in, PrintWriter out) {
			String s=in.next();
			String m=in.next();
			
			char[] c=s.toCharArray();
			Arrays.sort(c);
			
			int i;
			for(i=0; i<c.length; i++){
				if(c[i]!='0')break;
			}
			//out.print(i);
			if(i==c.length-1 && s.equals(m)){ out.println("OK"); return; }
			c[0]=c[i];
			for(int j=1; j<=i; j++) c[i]='0';
			s=new String(c);
			if(s.equals(m)) out.println("OK");
			else out.println("WRONG_ANSWER");
		}
	}
	static class Task4{
		public void solve(InputReader in, PrintWriter out){
			int m=in.nextInt(), n=in.nextInt();
			Integer[][] ar=new Integer[m][n];
			
			for(int i=0; i<m; i++)
				for(int j=0; j<m; j++)
					ar[i][j]=in.nextInt();
			
			int q=in.nextInt();
			while(q-->0){
				boolean[][] marked=new boolean[m][n];
				int a=in.nextInt();
				int b=in.nextInt();
				int c=in.nextInt();
				int d=in.nextInt();
				int e=in.nextInt();
				int f=in.nextInt();
				int g=in.nextInt();
				int h=in.nextInt();
				for(int i=a; i<=c; i++)
					for(int j=b; j<=d; j++)
						marked[i][j]=true;
				
				for(int i=e; i<=g; i++)
					for(int j=f; j<=h; j++)
						marked[i][j]=false;
				
				for(int i=a; i<=c; i++)
					for(int j=b; j<=d; j++){
						if(!marked[i][j]) marked[i][j]=true;
						else marked[i][j]=false;
					}
				
				int max=1, min=1000000000;
				
				for(int i=a; i<=c; i++){
					for(int j=b; j<=d; j++){
						if(!marked[i][j]){
							max=Math.max(ar[i][j], max);
							min=Math.min(ar[i][j], min);
						}
					}
				}
				BigInteger g1=new BigInteger(max+"").gcd(new BigInteger(min+""));
				max=1; min=1000000000;
				for(int i=e; i<=g; i++){
					for(int j=f; j<=h; j++){
						if(!marked[i][j]){
							max=Math.max(ar[i][j], max);
							min=Math.min(ar[i][j], min);
						}
					}
				}
				BigInteger g2=new BigInteger(max+"").gcd(new BigInteger(min+""));
				if(g1.compareTo(g2)>0) out.println("LONG WINS");
				else if(g1.compareTo(g2)<0) out.println("CIRCUIT WINS");
				else out.println("BOTH WINS");
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
