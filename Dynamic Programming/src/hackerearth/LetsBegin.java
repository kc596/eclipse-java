package hackerearth;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LetsBegin {
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
		static final int INF=1000001;
		static int[] way;
		public void solve(InputReader in, PrintWriter out) {
			way=new int[INF];
			for(int i=0; i<INF; i++) way[i]=INF;
			way[2]=way[3]=way[5]=way[7]=1;
			way[4]=way[6]=2;
			
			for(int i=8; i<INF; i++) way[i]=min(way[i], way[i-7]+1, way[i-5]+1, way[i-3]+1, way[i-2]+1);
			
			int t=in.nextInt();
			while(t-->0){
				int n=in.nextInt();
				out.println(way[n]<INF?way[n]:-1);
			}
		}
		
		/*private static int ways(int n){
			if(n==0) return 0;
			if(n<0) return -INF;
			if(way[n]>0) return way[n];
			
			int w=ways(n-D)+1;
			if(w>0) way[n]=Math.min(way[n]>0?way[n]:INF, w);
					
			int x=ways(n-C)+1;
			if(x>0) way[n]=Math.min(way[n]>0?way[n]:INF, x);
			
			int y=ways(n-B)+1;
			if(y>0) way[n]=Math.min(way[n]>0?way[n]:INF, y);
			
			int z=ways(n-A)+1;
			if(z>0) way[n]=Math.min(way[n]>0?way[n]:INF, z);
			
			return way[n];
		}*/
		
		private static int min(int a, int b, int c, int d, int e){
			int mini=a;
			if(b<mini) mini=b;
			if(c<mini) mini=c;
			if(d<mini) mini=d;
			if(e<mini) mini=e;
			return mini;
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
