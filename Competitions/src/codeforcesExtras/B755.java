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

public class B755 {
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
			int n=in.nextInt(), m=in.nextInt();
			TreeSet<String> Poland =  new TreeSet<String>();
			TreeSet<String> Enemy = new TreeSet<String>();
			TreeSet<String> enemyInPoland = new TreeSet<String>();
			TreeSet<String> both = new TreeSet<String>();
			
			for(int i=0; i<n; i++){
				String temp = (in.next());
				Poland.add(temp);
			}
			
			for(int i=0; i<m; i++){
				String temp = in.next();
				Enemy.add(temp);
				if(Poland.contains(temp)){
					enemyInPoland.add(temp);
				}
			}
			
			/*for(String s: enemyInPoland){
				out.println(s);
			}*/
			
			boolean chance = true;		//chance of poland
			while(true){
				if(chance){
					if(Poland.isEmpty()){
						out.println("NO");
						return;
					}
					String temp = null;
					if(!enemyInPoland.isEmpty()){
						temp = enemyInPoland.pollFirst();
						Poland.remove(temp);
					}
					
					while(temp!=null && both.contains(temp) && !enemyInPoland.isEmpty()){
						temp = enemyInPoland.pollFirst();
						if(Poland.isEmpty()){
							out.println("NO");
							return;
						}						
						Poland.remove(temp);
					}
					
					if(temp == null){
						temp = Poland.pollFirst();
						while(temp!=null && both.contains(temp)){
							if(Poland.isEmpty()){
								out.println("NO");
								return;
							}
							temp = Poland.pollFirst();
						}
					}
					
					//out.println(chance+" "+temp+" ");
					
					both.add(temp);
					chance = false;
				} else {
					if(Enemy.isEmpty()){
						out.println("YES");
						return;
					}
					String temp = null;
					if(!enemyInPoland.isEmpty()){
						temp = enemyInPoland.pollFirst();
						Enemy.remove(temp);
					}
					
					while(temp!=null && both.contains(temp) && !enemyInPoland.isEmpty()){
						temp = enemyInPoland.pollFirst();
						if(Enemy.isEmpty()){
							out.println("YES");
							return;
						}						
						Enemy.remove(temp);
					}
					
					if(temp == null){
						temp = Enemy.pollFirst();
						while(temp!=null && both.contains(temp)){
							if(Enemy.isEmpty()){
								out.println("YES");
								return;
							}
							temp = Enemy.pollFirst();
						}
					}
					
					//out.println(chance+" "+temp+" ");
					
					both.add(temp);
					chance = true;
				}
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
