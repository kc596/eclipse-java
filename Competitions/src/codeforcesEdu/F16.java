package codeforcesEdu;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class F16 {
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
			TrieST<Integer> trie=new TrieST<Integer>();
			int t=in.nextInt();
			while(t-->0){
				int ans=0,len,n=in.nextInt();
				String s=in.next();
				
				if(n==1){
					if(trie.contains(s)) trie.put(s, trie.get(s)+1);
					else trie.put(s, 1);
				}
				else if(n==2){
					trie.put(s, trie.get(s)-1);
				}
				else if(n==3){
					ans=0;
					len=s.length();
					for(int i=0; i<len; i++){
						ans+=trie.getans(s.substring(i));
					}
					//ans+=trie.getans(s);
					System.out.println(ans);
				}
				
				
			}
		}
	}

	static class TrieST<Value> {
		private static final int R = 256;
		private Node root = new Node();
		static int ans;
		private static class Node{
			private Object value;
			private Node[] next = new Node[R];
		}
		
		public Integer getans(String key){
			ans=0;
			getans(root, key, 0);
			//if(x!=null) ans+=(Integer)x.value;
			return ans;
		}
		private Node getans(Node x, String key, int index){
			if (x == null) return null;
			if (index == key.length()) return x;
			char c = key.charAt(index);
			try{
				//System.out.println(c+" "+x.next[c].value+" "+index);
				ans+=(int)x.next[c].value;
			}
			catch(Exception e){
				//System.out.println("exception");
			}
			return getans(x.next[c], key, index+1);
		}
		
		public void put(String key, Value value){
			root = put(root, key, value, 0);
		}
		private Node put(Node x, String key, Value value, int index){
			if(x==null) x=new Node();
			if(index == key.length()) x.value=value;
			else{
				char c = key.charAt(index);
				x.next[c]=put(x.next[c], key, value, index+1);
			}
			return x;
		}
		
		public boolean contains(String key){
			return get(key)!=null;
		}
		
		@SuppressWarnings("unchecked")
		public Value get(String key){		//recursive version
			Node x = get(root, key, 0);
			if (x == null) return null;
			return (Value)x.value;
		}
		
		private Node get(Node x, String key, int index){
			if (x == null) return null;
			if (index == key.length()) return x;
			char c = key.charAt(index);
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
