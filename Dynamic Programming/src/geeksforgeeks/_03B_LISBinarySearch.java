package geeksforgeeks;

/**
 * @author Kunal
 * Time Complexity: O(n*logn)
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _03B_LISBinarySearch {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		Task1 solver = new Task1();
		solver.solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				int n=in.nextInt();
				int[] a=new int[n];			//input
				int[] T=new int[n];
				
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
					}
					else{
						int j=ceiling(T, a, 0, len, a[i]);
						T[j]=i;
					}
				}
				out.println(len+1);
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
