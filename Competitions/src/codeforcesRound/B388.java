package codeforcesRound;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B388 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Point implements Comparable<Point>{
		Integer x,y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		public int compareTo(Point p){
			if(x>p.x) return 1;
			else if(x<p.x) return -1;
			else return y.compareTo(p.y);
		}
	}
	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			int xa=in.nextInt(), ya=in.nextInt();
			int xb=in.nextInt(), yb=in.nextInt();
			int xc=in.nextInt(), yc=in.nextInt();
			
			TreeSet<Point> set=new TreeSet<Point>();
			int xd, yd;
			
			//AB || CD and DC
			yd = yb-ya+yc;
			xd = xb-xa+xc;
			set.add(new Point(xd, yd));
			
			yd = ya-yb+yc;
			xd = xa-xb+xc;
			set.add(new Point(xd, yd));
			
			//BC || AD and DA
			yd = yc-yb+ya;
			xd = xc-xb+xa;
			set.add(new Point(xd, yd));
			
			yd = yb-yc+ya;
			xd = xb-xc+xa;
			set.add(new Point(xd, yd));
			
			//AC || BD and DB
			yd = yc-ya+yb;
			xd = xc-xa+xb;
			set.add(new Point(xd, yd));
			
			yd = ya-yc+yb;
			xd = xa-xc+xb;
			set.add(new Point(xd, yd));
			
			out.println(set.size());
			for(Point p : set){
				out.println(p.x+" "+p.y);
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
