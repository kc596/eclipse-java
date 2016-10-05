package random;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class CodechefAugLunch {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		
		new Task2().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			String s=in.next();
			boolean[] canRead=new boolean[256];
			for(int i=0; i<s.length(); i++) canRead[s.charAt(i)]=true;
			
			int n=in.nextInt();
			while(n-->0){
				String q=in.next();
				boolean flag=true;
				for(int i=0; i<q.length(); i++){
					if(!canRead[q.charAt(i)]){
						flag=false;
						break;
					}
				}
				if(flag) out.println("Yes");
				else out.println("No");
			}
		}
	}
	
	static class Task2 {
		@SuppressWarnings("unchecked")
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			Integer[] ar;
			while(t-->0){
				int n=in.nextInt(), total=0;
				Stack<Integer>[] stack=(Stack<Integer>[])new Stack[n];
				for(int i=0; i<n; i++){
					stack[i]=new Stack<Integer>();
					int a=in.nextInt();
					total+=a;
					for(int j=0; j<a; j++){
						int temp=in.nextInt();
						stack[i].push(temp);
					}
				}
				ar=new Integer[total];
				for(int i=0; i<total; i++){
					ar[i]=in.nextInt();
				}
				boolean flag=false;
				for(int i=0; i<total; i++){
					flag=false;
					//out.print(ar[i]+" ");
					for(int j=0; j<n; j++){
						//out.print(stack[j].peek()+" ");
						if(stack[j].peek()==ar[i]){
							flag=true;
							stack[j].pop();
							break;
						}
					}
					//out.println();
					if(!flag) break;
				}
				if(!flag) out.println("No");
				else out.println("Yes");
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
