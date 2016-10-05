package codeforcesRound;

/**
 * @author Kunal
 * Humans are made for choices. It is something that have kept us alive for so long and have endangered us many times.
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B372 {
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
			HashMap<Character, Integer> map=new HashMap<Character, Integer>();
			TreeSet<Character> set=new TreeSet<Character>();
			ArrayList<Character> missing=new ArrayList<Character>();
			
			String s=in.next();
			int num=0;
			if(s.length()<26){ out.println(-1); return; }
			for(int i=0; i<26; i++){
				if(s.charAt(i)=='?') num++;
				else{
					if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i))+1);
					else map.put(s.charAt(i), 1);
					set.add(s.charAt(i));
				}
			}

			for(int j=26; j<=s.length(); j++){
				
				//out.println(set.size()+" "+num);
				if(set.size()+num==26){
					//printing previous part
					for(int i=0; i<j-26; i++){
						if(s.charAt(i)=='?') out.print('A');
						else out.print(s.charAt(i));
					}
					
					//printing nice part
						for(int i=0; i<26; i++){
							if(!map.containsKey((char)('A'+i)) ){
								missing.add((char) ('A'+i));
							}
							else if(map.get((char)('A'+i)) == 0){
								missing.add((char) ('A'+i));
							}
						}
						int mp=0;
						for(int i=j-26; i<j; i++){
							if(s.charAt(i)=='?') out.print(missing.get(mp++));
							else out.print(s.charAt(i));
						}
					
					//printing last part
						for(int i=j; i<s.length(); i++){
							if(s.charAt(i)=='?') out.print('A');
							else out.print(s.charAt(i));
						}
					return;
				}
				else{
					if(j<s.length()){
						if(s.charAt(j-26)=='?') num--;
						if(s.charAt(j)=='?') num++;
						else{
							if(s.charAt(j-26)!='?'){
								map.put(s.charAt(j-26), (map.get(s.charAt(j-26))) -1);
								if(map.get(s.charAt(j-26))==0) set.remove(s.charAt(j-26));
							}
							if(map.containsKey(s.charAt(j))) map.put(s.charAt(j), map.get(s.charAt(j))+1);
							else map.put(s.charAt(j), 1);
							set.add(s.charAt(j));
						}
					}
				}
			}
			out.println(-1);
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
