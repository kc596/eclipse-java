package algorithms;

/**
 * @author kunal05
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SherlockValidStrings {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		Task1 solver=new Task1();		
		solver.solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		out.close();
	}
	
	static class Task1{
		public void solve(InputReader in, PrintWriter out){
			int freq[]=new int[26];
			HashSet<Integer> set=new HashSet<Integer>();
			String s=in.next();
			for(int i=0; i<s.length(); i++) freq[(int)s.charAt(i)-97]++;
			
			for(int i=0; i<26; i++)
				if(freq[i]>0) set.add(freq[i]);
			
			int l,sm,siz=set.size();
			if(siz>2) out.println("NO");
			else if(siz<=1) out.println("YES");
			else{
				//siz==2
				Integer[] ar=set.toArray(new Integer[0]);
				if(ar[0]>ar[1]){
					l=ar[0];
					sm=ar[1];
				}
				else{
					l=ar[1];
					sm=ar[0];
				}
				if(l-sm>1) out.println("NO");
				else{
					//removal can always be done from larger one
					//so larger should have only one frequency count
					int count=0;
					for(int i=0; i<26; i++) if(freq[i]==l) count++;
					
					if(count==1) out.println("YES");
					else out.println("NO");
				}
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
	}
}