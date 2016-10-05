package random;

/**
 * @author Kunal
 * Problem link: http://codeforces.com/contest/650/problem/A 
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Watchmen {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}
	
	static class Point{
		final int x;
		final int y;
		public static final Comparator<Point> X_ORDER=new Xorder();
		public static final Comparator<Point> Y_ORDER=new Yorder();
		public Point(int x, int y){
			this.x=x;
			this.y=y;
		}
		private static class Xorder implements Comparator<Point>{
			@Override
			public int compare(Point a, Point b) {
				if(a.x<b.x) return -1;
				else if(a.x>b.x) return 1;
				else{
					if(a.y<b.y) return -1;
					else if(a.y>b.y) return 1;
					else return 0;
				}
			}
		}
		private static class Yorder implements Comparator<Point>{
			@Override
			public int compare(Point a, Point b) {
				if(a.y<b.y) return -1;
				else if(a.y>b.y) return 1;
				else{
					if(a.x<b.x) return -1;
					else if(a.x>b.x) return 1;
					else return 0;
				}
			}
		}
	}
	
	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			Point[] arr=new Point[n];
			int[] countrep=new int[n];
			for(int i=0; i<n; i++){
				countrep[i]=1;
			}
			long count=0,counttemp,countr=0;
			int k;
			for(int i=0; i<n; i++){
				int x=in.nextInt();
				int y=in.nextInt();
				arr[i]=new Point(x,y);
			}
			Arrays.sort(arr,Point.X_ORDER);
			for(int i=0; i<n-1; ){
				k=i+1;counttemp=1;
				while(arr[i].x==arr[k].x){
					counttemp++;
					k++;
					if(k==n) break;
				}
				i=k;
				count+=calculator(counttemp);
				//out.println("x "+counttemp+" "+calculator(counttemp));
			}
			//out.println();
			Arrays.sort(arr,Point.Y_ORDER);
			int repindex=0;
			for(int i=0; i<n-1;){
				int temp=i;
				while(arr[temp].x==arr[temp+1].x && arr[temp].y==arr[temp+1].y){
					temp++;
					countrep[repindex]++;
					if(temp==n-1) break;
				}
				repindex++;
				i=temp+1;
			}
			for(int i=0; i<n-1; ){
				k=i+1;counttemp=1;
				while(arr[i].y==arr[k].y){
					counttemp++;
					k++;
					if(k==n) break;
				}
				count+=calculator(counttemp);
				i=k;
				//out.println("y "+counttemp+" "+calculator(counttemp));
			}
			for(int i=0; i<n; i++){
				if(countrep[i]!=1) countr+=calculator(countrep[i]);
				//out.print(arr[i].x+" "+arr[i].y+" ");
				//out.println(countrep[i]);
			}
			out.println(count-countr);
		}
		static int calculator(int n){
			return n*(n-1)/2;
		}
		static long calculator(long n){
			return n*(n-1)/2;
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
	}
}
