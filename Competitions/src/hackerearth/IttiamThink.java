package hackerearth;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class IttiamThink {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		new Task2().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		final static int RANGE=224738;
		static ArrayList<Integer> series;
		static boolean[] isPrime;
		public void solve(InputReader in, PrintWriter out) {
			series=new ArrayList<Integer>();
			isPrime=new boolean[RANGE];
			for(int i=2; i<RANGE; i++)
				isPrime[i]=true;
			
			for(int i=2; i<RANGE; i++)
				if(isPrime[i]){
					series.add(i);
					for(int j=i+i; j<RANGE; j+=i)
						isPrime[j]=false;
				}
			
			int n=in.nextInt();
			ArrayList<Long> pro=new ArrayList<Long>();
			
			int f=0, s=1, t=2;
			while(true){
				if(t==n+1){
					s++;
					t=s+1;
				}
				if(s==n){
					f++;
					s=f+1;
					t=s+1;
				}
				pro.add((long) (series.get(f)*series.get(s)*series.get(t)));
				t++;
				if(f==n-2) break;
			}
			Collections.sort(pro);
			
			for(int i=0; i<n; i++){
				//out.println(pro.get(in.nextInt()-1));
			}
		}
	}
	static class Task2{
		@SuppressWarnings("unused")
		public void solve(InputReader in, PrintWriter out) {
			int t=1;
			while(t-->0){
				int n=in.nextInt();
				int k=in.nextInt();
				int[] a=new int[n];			//input
				int[] T=new int[n];
				long[] sum=new long[n+1];
				sum[0]=0;
				int ans=0;
				/**
				 * Maximum length of the Increasing subsequence can be n. 
				 * T[i] = *index* of last element which is LIS till length (i+1).
				 */
				int len=0;					//length of the LIS = len+1
				a[0]=in.nextInt();
				T[0]=0;
				
				for(int i=1; i<n; i++){
					a[i]=in.nextInt();
					if(a[i]>a[T[len]]){
						T[++len]=i;
						sum[len]=a[i]+sum[len-1];
					}
					else{
						int j=ceiling(T, a, 0, len, a[i]);
						T[j]=i;
					}
				}
				out.println(ans);
			}
		}
		static int ceiling(int[] T, int a[], int lo, int hi, int key){
			/**
			 * returns the index s.t., a[T[index]] is just greater than key and 0=<index<=len
			 */
			while(hi>=lo){
				int mid=lo+(hi-lo)/2;
				if(a[T[mid]]==key) return mid;
				else if(a[T[mid]]>key) hi=mid-1;
				else if(a[T[mid]]<key) lo=mid+1;
			}
			return lo;
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
