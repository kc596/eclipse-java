package medlifeIntern;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class One {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}
	static class Task {
		/**
		 * Idea is to find number of distinct characters in repeated substrings.
		 */
		public static long answer(String s){
			int k=0,N = s.length(), len=0;
			long R=N*(N+1)/2;
			int ROOT=(int)R;
			/*creating suffixes - linear time and space*/
			String[] suffixes = new String[ROOT];
			for(int length=N; length>=1; length--){
				for(int i=0; i<=N-length; i++){
					suffixes[k++]=s.substring(i, i+length);
				}
			}
			Arrays.sort(suffixes);
			
			long sum=0;
			for(int i=0; i<ROOT-1; i++){
				//System.out.print(suffixes[i]+" ");
				if(suffixes[i].equals(suffixes[i+1])){
					len = numDistinct(suffixes[i]);
					sum+=len;
					//System.out.print(sum);
				}
				//System.out.println();
			}
			
			return sum;
		}
		
		static int numDistinct(String a){
			int[] count=new int[26];
			int ans=0;
			for(int i=0; i<a.length(); i++){
				count[(int)a.charAt(i)-(int)'a']++;
			}
			
			for(int i=0; i<26; i++){
				if(count[i]>=1) ans++;
			}
			return ans;
		}
		
		public void solve(InputReader in, PrintWriter out) {
			String s=in.next();
			out.println(answer(s));
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
