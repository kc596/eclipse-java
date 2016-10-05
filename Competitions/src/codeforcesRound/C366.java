package codeforcesRound;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C366 {
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
			int cstart=0,n=in.nextInt(),  q=in.nextInt();
			int[] notification=new int[n];
			ArrayList<Integer> cache=new ArrayList<Integer>();
			long sum=0;
			for(int i=0; i<q; i++){
				int type=in.nextInt(), x=in.nextInt();
				if(type==1){
					notification[x-1]+=1;
					sum+=1;
					cache.add(x-1);
				}
				else if(type==2){
					sum-=notification[x-1];
					notification[x-1]=0;
				}
				else if(type==3){
					sum-=x;
					for(int jj=cstart; jj<cstart+x; jj++){
						notification[cache.get(jj)]-=1;
					}
					cstart+=x;
				}
				
				out.println(sum);
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
