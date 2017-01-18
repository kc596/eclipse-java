package codeforcesExtras;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C755 {
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
			
			QuickUnion q = new QuickUnion(n);
			
			for(int i=0; i<n; i++){
				int temp = in.nextInt()-1;
				q.union(i, temp);
			}
			int[] id = new int[n];
			
			for(int i=0; i<n; i++){
				id[i] = q.root(i);
			}
			
			TreeSet<Integer> set = new TreeSet<Integer>();
			for(int i: id){
				set.add(i);
			}
			
			out.println(set.size());
		}
	}
	
	static class QuickUnion{
		private int[] id;
		private int[] size;
		
		public QuickUnion(int a){
			id=new int[a];
			size=new int[a];
			for(int i=0; i<a; i++){
				size[i]=1;
				id[i]=i;
			}
		}
		
		int root(int i){
			while(id[i]!=i){
				id[i]=id[id[i]];
				i=id[i];
			}
			return i;
		}
		
		public boolean isConnected(int p, int q){
			return root(p)==root(q);
		}
		
		public void union(int p, int q){
			int pid=root(p);
			int qid=root(q);
			if(pid==qid) return;
			
			if(size[p]>size[q]){
				id[qid]=pid;
				size[pid]+=size[qid];
			}
			else{
				id[pid]=qid;
				size[qid]+=size[pid];
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

		public String nextLine() {
			String s = null;
			try {
				s = reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return s;
		}

		public String nextParagraph() {
			String line = null;
			String ans = "";
			try {
				while ((line = reader.readLine()) != null) {
					ans += line;
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return ans;
		}

	}
}
