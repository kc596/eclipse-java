package classical;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BuildTheFence {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				GrahamScan.india=1;
				int n=in.nextInt();
				GrahamScan.Point[] arr=new GrahamScan.Point[n];
				for(int j=0; j<n; j++){
					int a=in.nextInt();
					int b=in.nextInt();
					arr[j]=new GrahamScan().new Point(a,b);
				}
				GrahamScan.convexHull(arr, n);
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
	}
	static class Stack<T>{
		private class Node{
			T data;
			Node next;
		}	
		private Node head=null;

		public void push(T data){
			Node temp=new Node();
			temp.data=data;
			temp.next=head;
			head=temp;
		}
		public T pop(){
			if(isEmpty()) return null; //empty stack
			T temp=head.data;
			head=head.next;
			return temp;
		}
		public T top(){
			if(head==null) return null;
			return head.data;
		}
		public T nextToTop(){
			if(head.next==null) return null;
			return head.next.data;
		}
		public boolean isEmpty(){
			return head==null;
		}
	}
	static class GrahamScan{
		static int india=1;
		static DecimalFormat f = new DecimalFormat("##.00");
		@SuppressWarnings("all")
		public class Point implements Comparable{
			private final double x;
			private final double y;
			int index;
			public Point(double x, double y){
				this.x=x;
				this.y=y;
				index=india++;
			}
			@Override
			public int compareTo(Object arg0) {
				Point temp=(Point)arg0;
				Point p=GrahamScan.smallestPoint;
				if(GrahamScan.angleTo(p,this)>GrahamScan.angleTo(p,temp)) return 1;
				if(GrahamScan.angleTo(p,this)<GrahamScan.angleTo(p,temp)) return -1;
				else{
					if(distanceOf(p,this)>distanceOf(p,temp)) return 1;
					if(distanceOf(p,this)<distanceOf(p,temp)) return -1;
					else{
						if(this.index<temp.index) return 1;
						else return -1;
					}
				}
			}		
		}
		
		static Point smallestPoint;
		private static Stack<Point> s=new Stack<Point>();
		public static void convexHull(Point[] arr, int n){//n=no. of points
			int min=smallestY(arr, n);
			swapPoints(arr,0,min);
			smallestPoint=arr[0];
			Arrays.sort(arr,1,n);
			
			int m = 1;
			for (int i=1; i<n; i++){
				// Keep removing i while angle of i and i+1 is same
				while (i < n-1 && orientation(smallestPoint, arr[i], arr[i+1]) == 0){
					i++;
				}
				arr[m] = arr[i];
				m++;
			}
			/*m is the new size*/
			if(m==1){
				System.out.println("0.00");
				System.out.println(1+"\n");
				return;
			}
			if(m==2){
				GrahamScan.Point xx=new GrahamScan().new Point(arr[0].x,arr[0].y);
				xx.index=arr[0].index+1;
				s.push(arr[0]);
				s.push(arr[1]);
				s.push(xx);	
			}
			else{
				s.push(arr[0]);
				s.push(arr[1]);
				s.push(arr[2]);
			}
			double distance=0;
			findConvexHull(arr,m); //returns number of points on convex hull
			if(m==2) s.pop();
			//s=reverseStack(s);
			distance=calculateDistance(s);
			System.out.println(f.format(distance));
			while(!s.isEmpty()){
				Point pr=s.pop();
				System.out.print(pr.index+" ");
			}
			System.out.println("\n");
		}
		private static double calculateDistance(Stack<Point> s1){
			Stack<Point> t=new Stack<Point>();
			double distance=0;
			Point prev, curr=s1.pop();
			Point first=curr;
			t.push(curr);
			while(!s1.isEmpty()){
				prev=curr;
				curr=s1.pop();
				t.push(curr);
				distance+=Math.sqrt(((curr.x-prev.x)*(curr.x-prev.x))+((curr.y-prev.y)*(curr.y-prev.y)));
			}
			Point last=curr;
			distance+=Math.sqrt(((first.x-last.x)*(first.x-last.x))+((first.y-last.y)*(first.y-last.y)));
			s=t;
			return distance;
		}

		private static void findConvexHull(Point[] arr, int n){
			for(int i=3; i<n; i++){
				while(orientation(arr[i], s.top(), s.nextToTop())!=1) s.pop();
				s.push(arr[i]);
			}
		}
		
		private static int orientation(Point a, Point b, Point c){
			double area=(c.x-b.x)*(b.y-a.y)-(c.y-b.y)*(b.x-a.x);
			if(area>0.0) return 1;	//anti-clockwise
			if(area<0.0) return -1;	//clockwise
			return 0;				//collinear
		}
		
		private static void swapPoints(Point[] arr, int a, int b){
			Point temp=arr[a];
			arr[a]=arr[b];
			arr[b]=temp;
		}
		
		private static double angleTo(Point P, Point A) {
	    	double dx = A.x-P.x;
	    	double dy = A.y-P.y;
	    	return Math.atan2(dy, dx);
	    }
		
		private static double distanceOf(Point P, Point A){
			double dx = P.x-A.x;
	    	double dy = P.y-A.y;
	    	return (dx*dx+dy*dy);
		}
		
		private static int smallestY(Point[] arr, int n){
			int min=0;
			for(int i=1; i<n; i++){
				if(arr[i].y<arr[min].y || (arr[min].y==arr[i].y && arr[i].x<arr[min].x)){
					min=i;
				}
			}
			return min;
		}
	}
}
