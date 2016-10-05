package hackerearth;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SeptEasy {
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
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			Integer[] a=new Integer[n];
			TreeSet<Integer> set=new TreeSet<Integer>();
			HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
			for(int i=0; i<n; i++){
				a[i]=in.nextInt();
				set.add(a[i]);
			}
			
			int j=0,distinct=set.size();
			set.clear();
			while(set.size()!=distinct){
				set.add(a[j]);
				if(!map.containsKey(a[j])) map.put(a[j], 1);
				else map.put(a[j], map.get(a[j])+1);
				j++;
			}
			long ans=0;
			for(int i=0; i<n; i++){
				ans+=(n-j+1);
				map.put(a[i], map.get(a[i])-1);
				if(map.get(a[i])<=0) set.remove(a[i]);
				while(set.size()!=distinct && j<n){
					set.add(a[j]);
					if(!map.containsKey(a[j])) map.put(a[j], 1);
					else map.put(a[j], map.get(a[j])+1);
					j++;
				}
				if(set.size()==distinct && j>=n) ans+=1;
				if(j>=n) break;
			}
			out.println(ans);
		}
	}
	
	static class Task3 {
		public void solve(InputReader in, PrintWriter out) {
			int prev=0,n=in.nextInt();
			Integer[] a=new Integer[n];
			TreeSet<Integer> set=new TreeSet<Integer>();
			HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> count=new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> distinct=new HashMap<Integer, Integer>();
			long ans=(n*(n-1))/2;
			System.out.println(ans);
			for(int i=0; i<n; i++){
				a[i]=in.nextInt();
				set.add(a[i]);
				if(set.size()==prev){
					if(map.get(a[i]) >0)ans-=(distinct.get(map.get(a[i])-1)+(n-i-1));
					else ans-=(n-1-i);
					//if(count.get(a[i])>=2) ans-=(1);
				}
				map.put(a[i], i);
				if(count.containsKey(a[i])) count.put(a[i], count.get(a[i])+1);
				else count.put(a[i], 1);
				prev=set.size();
				distinct.put(i, prev);
				//out.print(ans+" ");
			}
			out.println(ans);
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
