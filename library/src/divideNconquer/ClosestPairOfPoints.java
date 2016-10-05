package divideNconquer;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPairOfPoints {
	static class Point{
		int x,y;
		public Point(int x, int y){
			this.x=x; this.y=y;
		}
		public void printPoint(){
			System.out.println(x+" "+y);
		}
	}
	
	private double min;
	public ClosestPairOfPoints(Point[] P){
		Arrays.sort(P, new SortByX());
		min= closestPoints(P, 0, P.length-1);
	}
	
	public double minDistance(){
		return min;
	}
	
	private double closestPoints(Point[] P, int lo, int hi){
		int n=hi-lo+1;		//size of subarray
		if(n<=3) return bruteForce(P, lo, hi);
		
		int mid=lo+(hi-lo)/2;
		Point midPoint=P[mid];
		double dL=closestPoints(P, lo, mid);
		double dR=closestPoints(P, mid+1, hi);
		double d=Math.min(dL, dR);
		
		/*Build an array strip[] that contains points close to the line passing throught the middle point*/
		Point[] strip=new Point[n];
		int j=0;
		for(int i=lo; i<=hi; i++)
			if(Math.abs(P[i].x - midPoint.x) < d){
				strip[j++]=P[i];
			}
		return Math.min(d, stripClosest(strip, j, d));
	}
	
	private double stripClosest(Point[] strip, int len, double d){
		double min=d;
		Arrays.sort(strip, 0, len, new SortByY());
		for(int i=0; i<len; i++){
			for(int j=i+1; j<len && (strip[j].y - strip[i].x < min); j++){
				min=Math.min(min, distance(strip[i], strip[j]));
			}
		}
		return min;
	}
	
	private double bruteForce(Point[] P, int lo, int hi){
		double min=Double.POSITIVE_INFINITY;
		for(int i=lo; i<=hi; i++){
			for(int j=i+1; j<=hi; j++){
				min=Math.min(min, distance(P[i], P[j]));
			}
		}
		return min;
	}
	
	private double distance(Point a, Point b){
		return Math.sqrt(((a.x-b.x)*(a.x-b.x)) + ((a.y-b.y)*(a.y-b.y)));
	}
	
	/*comparators*/
	private static class SortByX implements Comparator<Point>{
		@Override
		public int compare(Point a, Point b) {
			if(a.x > b.x) return 1; 
			else if(a.x < b.x) return -1;
			else{
				if(a.y > b.y) return 1;
				else if(a.y < b.y) return -1;
				else return 0;
			}
		}
	}
	private static class SortByY implements Comparator<Point>{
		@Override
		public int compare(Point a, Point b) {
			if(a.y > b.y) return 1; 
			else if(a.y < b.y) return -1;
			else{
				if(a.x > b.x) return 1;
				else if(a.x < b.x) return -1;
				else return 0;
			}
		}
	}
	
	/*demo*/
	public static void main(String[] args){
		java.util.Scanner sc=new java.util.Scanner(System.in);
		int n=sc.nextInt();
		Point[] P=new Point[n];
		
		for(int i=0; i<n; i++){
			int x=sc.nextInt();
			int y=sc.nextInt();
			P[i]=new Point(x,y);
		}
		
		ClosestPairOfPoints cpp=new ClosestPairOfPoints(P);
		System.out.println(cpp.minDistance());
		sc.close();
	}
}
