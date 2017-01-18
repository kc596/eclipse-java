package codeforcesRound;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D386 {
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
			@SuppressWarnings("unused")
			int n=in.nextInt(), k=in.nextInt(), a=in.nextInt(), b=in.nextInt();
			boolean flag=true;	//more green tea than black -> more a than b
			if(a<b) flag=false;
			
			ArrayList<Character> list;
			
			if(flag){ //a>b G>B
				if((b+1)*k<a){
					out.println("NO");
					return;
				}
				list = new ArrayList<Character>();
				for(int i=0; i<a; i++) list.add('G');
				if(k>=a){					
					for(int i=0; i<b; i++) list.add('B');
				} else { 
					int pos = k;
					for(int i=0; i<b; i++){
						list.add(pos, 'B');
						pos += k+1;
						if(pos>list.size()){
							pos = 0;
						}
					}					
				}
			} else {
				if((a+1)*k<b){
					out.println("NO");
					return;
				}
				list = new ArrayList<Character>();
				for(int i=0; i<b; i++) list.add('B');
				if(k>=b){					
					for(int i=0; i<a; i++) list.add('G');
				} else { 
					int pos = k;
					for(int i=0; i<a; i++){
						list.add(pos, 'G');
						pos += k+1;
						if(pos>list.size()){
							pos = 0;
						}
					}					
				}
			}
			
			for(char c: list){
				out.print(c);
			}
			out.println();
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
