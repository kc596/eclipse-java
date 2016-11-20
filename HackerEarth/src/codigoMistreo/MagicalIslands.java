package codigoMistreo;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class MagicalIslands {
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
		static boolean marked[];
		static int id[];
		static int count;
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt(), m=in.nextInt();
			count = 0;
			marked = new boolean[n+1];
			id = new int[n+1];
			for(int i=1; i<n+1; i++){
				id[i]=i;
			}
			
			Digraph G = new Digraph(n+1);
			for(int i=0; i<m; i++){
				int from = in.nextInt(), to = in.nextInt();
				G.addEdge(from, to);
			}
			
			for(int i=1; i<=n; i++){
				if(!marked[i]){
					dfs(G, i);
					count++;
				}
			}
			
			//out.println(count);
			int[] hash = new int[count+1];
			
			for(int i=0; i<=n; i++){
				out.println(id[i]);
				hash[id[i]]++;
			}
			
			int max = 0;
			for(int i=0; i<count+1; i++){
				//max = Math.max(max, hash[i]);
				out.print(hash[i]+" ");
			}
			
			out.println(max);
		}
		static void dfs(Digraph G, int v){
			marked[v]=true;
			id[v] = count;
			for(int w: G.adj(v)){
				if(!marked[w]){
					dfs(G,w);
				}
			}
		}
	}
	
	static class Digraph {
		private int V;
		private LinkedList<Integer>[] adj;
		
		@SuppressWarnings("unchecked")
		public Digraph(int V){
			this.V=V;
			this.adj=(LinkedList<Integer>[])new LinkedList[V];
			for(int i=0; i<V; i++){
				adj[i]=new LinkedList<Integer>();
			}
		}
		
		public void addEdge(int v, int w){
			adj[v].add(w);
		}
		
		public Iterable<Integer> adj(int v){
			return adj[v];
		}
		
		public int V(){
			return this.V;
		}
		
		public Digraph reverse(){
			Digraph R = new Digraph(V);
			for(int v=0; v<V; v++){
				for(int w: adj(v)){
					R.addEdge(w, v);
				}
			}
			return R;
		}
	}

	static class DepthFirstOrder {
		private boolean[] marked;
		private Stack<Integer> reversePost;	//contains vertices in reverse topological order
		
		public DepthFirstOrder(Digraph G){
			//if(isCyclic(G)) throw new Exception("Cyclic graph so topological sort is not possible");
			reversePost=new Stack<Integer>();
			this.marked=new boolean[G.V()];
			for(int v=0; v<G.V(); v++){
				if(!marked[v]){
					dfs(G,v);
				}
			}
		}
		
		private void dfs(Digraph G, int v){
			marked[v]=true;
			for(int w: G.adj(v)){
				if(!marked[w]) dfs(G,w);
			}
			reversePost.push(v);
		}
		
		public Stack<Integer> reversePost(){
			return (reversePost);
		}
	}
	static class KosarajuSharirSCC {
		private boolean[] marked;
		private int[] id;
		private int count;	//for indexing of id
		
		public KosarajuSharirSCC(Digraph G) {
			this.marked=new boolean[G.V()];
			this.id=new int[G.V()];
			count=0;
			
			DepthFirstOrder dfo=new DepthFirstOrder(G.reverse());
			Stack<Integer> s = dfo.reversePost();
			while(!s.empty()){
				int v = s.pop();
				if(!marked[v]){
					dfs(G,v);
					count++;
				}
			}
			/**
			 * Other Possible Implementation:-
				# DepthFirstOrder dfo=new DepthFirstOrder(G);
				# for(int v: dfo.reversePost()){
				#	if(!marked[v]){
				#		dfs(G,v);	//we could use other traversal here too
				#		count++;
				#	}
				# }
				
				Note that for-each loop is used to access the stack.
			 */
		}

		private void dfs(Digraph G, int v){
			marked[v]=true;
			id[v]=count;
			for(int w: G.adj(v)){
				if(!marked[w]) dfs(G,w);
			}
		}
		
		public int count(){	//returns total number of strong components
			return count;
		}
		
		public boolean stronglyConnected(int v, int w){
			return id[v]==id[w];
		}
		
		public int id(int v){
			return id[v];
		}
		
		/*private Iterable<Integer> reverseStack(Stack<Integer> reversePost){
			Stack<Integer> s= new Stack<Integer>();
			while(!reversePost.empty()){
				s.push(reversePost.pop());
			}
			return s;
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
