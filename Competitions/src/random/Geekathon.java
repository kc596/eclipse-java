package random;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Geekathon {
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
		static class Point implements Comparable<Point>{
			int x, y;
			Double dist;
			public Point(int x, int y){
				this.x=x;
				this.y=y;
				dist=Math.sqrt((x*x)+(y*y));
			}
			public int compareTo(Point x){
				return dist.compareTo(x.dist);
			}
		}
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			while(t-->0){
				int r=in.nextInt(), n=in.nextInt();
				Integer[] R=new Integer[r];
				Point[] P=new Point[n];
				for(int i=0; i<r; i++) R[i]=in.nextInt();
				Arrays.sort(R);
				
				for(int i=0; i<n; i++){
					int x=in.nextInt(), y=in.nextInt();
					P[i]=new Point(x,y);
					//out.println(x+" "+y+" "+P[i].dist);
				}
				Arrays.sort(P);
				long ans=0;
				for(int i=0; i<n; i++){
					int pos=Arrays.binarySearch(R, P[i].dist.intValue());
					//out.println(P[i].dist.intValue()+" "+pos);
					if(pos<0){
						//out.println(-(pos+1));
						ans+=r+(pos+1);
					}
					else{
						ans+=r-(pos+1);
					}
				}
				out.println(ans);
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
