package codeforcesRound;

/**
 * @author Kunal
 * "One should never loose the assets they have in trying to
 * achieve what they don't have"
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class C371 {
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
			int t=in.nextInt(), odd=0, even=0;
			TrieST<Integer> trie=new TrieST<Integer>();
			while(t-->0){
				char c=in.next().charAt(0);
				String s=in.next();
				if(c=='+'){
					if((s.charAt(s.length()-1)-'0')%2==0) even++;
					else odd++;
					
					if(trie.get(s)==null) trie.put(s, 1);
					else trie.put(s, 0);
				}
				else if(c=='-'){
					if((s.charAt(s.length()-1)-'0')%2==0) even--;
					else odd--;
					
					trie.put(s, trie.get(s)-1);
				}
				else if(c=='?'){
					if(s.length()==1){
						if(s.charAt(0)=='1'){
							out.println(odd);
						}
						else out.println(even);
					}
					else{
						
					}
				}
			}
		}
	}

	static class TrieST<Value> {
		static final int R=256;
		Node root=new Node();
		
		static class Node{
			Object value;
			Node[] next=new Node[R];
		}
		
		public void put(String key, Value val){
			root=put(key, val, root, 0);
		}
		
		@SuppressWarnings("unchecked")
		public Value get(String key){
			Node x=get(root, key, 0);
			if(x==null) return null;
			return (Value)x.value;
		}
		
		private Node put(String key, Value val, Node x, int index){
			if(x==null) x=new Node();
			if(index==key.length()) x.value=val;
			else{
				char c=key.charAt(index);
				x.next[c]=put(key, val, x.next[c], index+1);
			}
			return x;
		}
		
		private Node get(Node x, String key, int index){
			if(index==key.length()) return x;
			char c=key.charAt(index);
			if(x.next[c]==null) return null;
			return get(x.next[c], key, index+1);
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
