package codeforcesExtras;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D727 {
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
		static class Tee implements Comparable<Tee>{
			Integer size, index;
			public Tee(String s, int i){
				size=conv.get(s);
				index=i;
			}
			
			public int compareTo(Tee x){
				return size.compareTo(x.size);
			}
		}
		
		static class BYINDEX implements Comparator<Tee>{
			@Override
			public int compare(Tee o1, Tee o2) {
				return o1.index.compareTo(o2.index);
			}
			
		}
		
		static HashMap<String, Integer> conv=new HashMap<String, Integer>();
		static HashMap<Integer, String> map=new HashMap<Integer, String>();
		public void solve(InputReader in, PrintWriter out) {
			conv.put("S", 0); conv.put("M", 1); conv.put("L", 2);
			conv.put("XL", 3); conv.put("XXL", 4); conv.put("XXXL", 5);
			
			conv.put("S,M", 6); conv.put("M,L", 7); conv.put("L,XL", 8);
			conv.put("XL,XXL", 9); conv.put("XXL,XXXL", 10);			
			
			map.put(0, "S"); map.put(1, "M"); map.put(2, "L");
			map.put(3, "XL"); map.put(4, "XXL"); map.put(5, "XXXL");
			
			
			int size[]=new int[6];
			int backup[]=new int[6];
			for(int i=0; i<6; i++){
				size[i]=in.nextInt();
				backup[i]=size[i];
			}
			int n=in.nextInt();
			Tee[] t=new Tee[n];			
			
			for(int i=0; i<n; i++){
				String s=in.next();
				t[i]=new Tee(s, i);
			}
			Arrays.sort(t);
			
			for(int i=0; i<n; i++){
				int temp=t[i].size;
				if(temp<6){
					size[temp]--;
					if(size[temp]<0){
						out.println("NO");
						return;
					}
				}
			}
						
			for(int i=0; i<n; i++){
				int temp=t[i].size;
				if(temp<6){
					//do nothing - its work already done
				}
				else{
					int a=temp-6;
					int b=a+1;
					if(size[a]>0){
						size[a]--;
						t[i].size=a;
					}
					else if(size[b]>0){
						size[b]--;
						t[i].size=b;
					}
					else{
						out.println("NO");
						return;
					}
				}
			}
			
			out.println("YES");
			Arrays.sort(t, new BYINDEX());
			for(int i=0; i<n; i++){
				out.println(map.get(t[i].size));
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
