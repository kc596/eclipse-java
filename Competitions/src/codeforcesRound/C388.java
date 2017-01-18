package codeforcesRound;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C388 {
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
			String s=in.next();
			TreeSet<Integer> rpos = new TreeSet<Integer>();
			TreeSet<Integer> dpos = new TreeSet<Integer>();
			TreeSet<Integer> rpos_aux = new TreeSet<Integer>();
			TreeSet<Integer> dpos_aux = new TreeSet<Integer>();
			
			for(int i=0; i<n; i++){
				if(s.charAt(i)=='D'){
					dpos.add(i);
				} else if(s.charAt(i)=='R'){
					rpos.add(i);
				}
			}
			
			while(!rpos.isEmpty() && !dpos.isEmpty()){
				//System.out.println(rpos.size()+" "+dpos.size());
				Integer r=rpos.pollFirst(), d=dpos.pollFirst();
				
				while(true){
					//System.out.print(r+" "+d+"  ");
					if(d==null && r!=null){
						dpos_aux.pollFirst();
						rpos_aux.add(r);
						r=rpos.pollFirst();
					} else if(r==null && d!=null){
						rpos_aux.pollFirst();
						dpos_aux.add(d);
						d=dpos.pollFirst();
					} else if(d==null && r==null){
						break;
					} else if(r<d){
						d=dpos.pollFirst();
						rpos_aux.add(r);
						r=rpos.pollFirst();
					} else if(d<r) {
						r=rpos.pollFirst();
						dpos_aux.add(d);
						d=dpos.pollFirst();
					}
					//System.out.println(r+" "+d);
				}
				rpos.addAll(rpos_aux);
				dpos.addAll(dpos_aux);
				rpos_aux.clear();
				dpos_aux.clear();
			}
			
			if(rpos.size()>0){
				out.println('R');
			} else {
				out.println('D');
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
