package hackerrank;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Queue;
public class HackerRank101Hack40 {
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
		static TreeSet<Integer>[] adj;
		static Stack<Integer> reversePost;
		static boolean[] marked;
		static Integer[] p;
		public void solve(InputReader in, PrintWriter out) {
			/*Integer[] h=new Integer[26];
			for(int i=0; i<26; i++) h[i]=in.nextInt();
			String s=in.next();
			Integer hmax=0,area=s.length();
			for(int i=0; i<s.length(); i++)
				hmax=Math.max(hmax, h[s.charAt(i)-'a']);
			out.println(area*hmax);*/
			
			/*int n=in.nextInt();
			Integer[] h=new Integer[n+1];
			for(int i=1; i<=n; i++) h[i]=in.nextInt();
			int m=in.nextInt();
			TreeSet<Integer> set=new TreeSet<Integer>();
			for(int i=0; i<m; i++) set.add(in.nextInt());
			Long ans=0L; Integer temp;
			for(int i=1; i<=n; i++){
				temp=set.ceiling(i+1);
				if(temp==null){
					ans+=h[i];
				}
				else ans+=Math.min((temp-i),h[i]);
			}
			out.println(ans);*/
			
			/*int n=in.nextInt(), m=in.nextInt(), a,b;
			adj=(TreeSet<Integer>[])new TreeSet[n];
			for(int i=0; i<n; i++) adj[i]=new TreeSet<Integer>();
			
			p=new Integer[n];
			
			for(int i=0; i<m; i++){
				a=in.nextInt()-1; b=in.nextInt()-1;
				adj[b].add(a);							//creating reverse graph
			}
			
			for(int i=0; i<n; i++)
				p[i]=in.nextInt();
			
			for(int i=0; i<n/2; i++){		//reversing the P array
				a=p[i];
				p[i]=p[n-1-i];
				p[n-1-i]=a;
			}

			Topological(n);
			
			while(!reversePost.isEmpty()){
				out.print(reversePost.pop()+1 +" ");
			}*/
		}
		
		static void Topological(int V){
			marked = new boolean[V];
			
			for(int i:p){
				if(!marked[i-1]){
					bfs(i-1);
				}
			}
		}
		
		static void bfs(int v){
			Queue<Integer> q=new ArrayDeque<Integer>();
			marked[v]=true;
			q.offer(v);
			
			while(!q.isEmpty()){
				//int w=q.poll();
				
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
