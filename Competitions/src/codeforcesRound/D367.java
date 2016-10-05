package codeforcesRound;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class D367 {
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
			Integer q=in.nextInt(), n;
			Trie trie=new Trie();
			trie.put("00000000000000000000000000000000", 1);
			String bb, b;
			while(q-->0){
				char c=in.next().charAt(0);
				n=in.nextInt();
				bb=Integer.toBinaryString(n);
				b = new String(new char[32-bb.length()]).replace("\0", "0").concat(bb);

				if(c=='+') trie.put(b, 1);
				else if(c=='-'){
					trie.put2(b, 1);
					trie.put(b, 0);
				}
				else if(c=='?'){
					out.println(trie.xor(b));
//					out.println(new BigInteger(trie.xor(b), 2));
				}
			}
		}
	}
	
	static class Trie{
		/*Value will be Integer*/
		class Node{
			Integer value;
			Node[] next=new Node[2];
			Node(){
				value=0;
			}
		}
		
		Node root=new Node();
		
		public void put(String key, Integer val){
			root=put(root, key, val, 0);
		}
		
		public void put2(String key, Integer val){
			put2(root, key);
		}
		
		public String xor(String s){
			Node x=root;
			String ans="";
			for(int i=0; i<32; i++){
				char c=s.charAt(i);
				char inverse=c=='0'?'1':'0';
				System.out.print(" inv "+inverse+" "+x.value+" "+" ");
				if(x.next[inverse-48]!=null){
					if(x.next[inverse-48].value>0){
						x=x.next[inverse-48];
						ans+='1';
						System.out.print("here "+x.value+" ");
					}
					else{
						x=x.next[c-48];
						ans+='0';
					}
				}
				else{
					x=x.next[c-48];
					ans+='0';
				}
			}
			System.out.println();
			return ans;
		}
		
		/*public Integer get(String key){
			Node x=get(root, key, 0);
			if(x==null) return 0;
			else if(x.value==0) return 0;
			else return x.value;
		}*/
		
		private Node put(Node x, String key, Integer val, int index){
			if(x==null) x=new Node();
			if(index==key.length()){
				x.value+=val;
				return x;
			}
			char c=key.charAt(index);
			x.next[c-48]= put(x.next[c-48], key, val, index+1);
			x.value=(x.next[0]!=null ? x.next[0].value: 0)+(x.next[1]!=null ? x.next[1].value: 0)+1;
			return x;
		}
		
		private void put2(Node x, String key){
			Node last=root;
			int prev=root.value, index=0;
			for(int i=0; i<32; i++){
				x=x.next[key.charAt(i)-48];
				if(prev-x.value>1){
					last=x;
					index=i;
				}
			}
			
			for(int i=index; i<32; i++){
				last.value=last.value-1;
				last=last.next[key.charAt(i)-48];
			}
		}
		
		/*private Node get(Node x, String key, int index){
			if(x==null) return null;
			if(index==key.length()) return x;
			return get(x.next[key.charAt(index)-48], key, index+1);
		}*/
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
