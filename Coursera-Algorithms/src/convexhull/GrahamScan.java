package convexhull;
import java.util.Arrays;
import convexhull.Stack;
/*Steps:
 * 1. Input the points in an array
 * 2. Find the point with lowest y-coordinate (say P)
 * 3. In case more more than 1 points have lowest y, choose the leftmost
 * 4. Sort the array in increasing angle wrt P
 * 5. If more points have same polar angle, choose the one at largest distance from P
 * 5. Traverse through the array and check orientation
 * 		a) if anti-clockwise, push the point to stack
 * 		b) if not so, pop top until the orientation is anti-clockwise
 */
public class GrahamScan{
	static Point smallestPoint;
	private static Stack<Point> s=new Stack<Point>();
	
	@SuppressWarnings("all")
	public class Point implements Comparable{
		private final double x;
		private final double y;
		public Point(double x, double y){
			this.x=x;
			this.y=y;
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
				else return 0;
			}
		}		
	}
	
	public static void convexHull(Point[] arr, int n){//n=no. of points
		int min=smallestY(arr, n);
		swapPoints(arr,0,min);
		smallestPoint=arr[0];
		Arrays.sort(arr,1,n);
		
		int m = 1;
		for (int i=1; i<n; i++){
			// Keep removing i until angle of i and i+1 is same
			while (i < n-1 && orientation(smallestPoint, arr[i], arr[i+1]) == 0){
				i++;
			}
			arr[m] = arr[i];
			m++;
		}
		/*m is the new size*/

		if(m<3) return;
		s.push(arr[0]);
		s.push(arr[1]);
		s.push(arr[2]);

		findConvexHull(arr,m); //returns number of points on convex hull
		while(!s.isEmpty()){
			Point pr=s.pop();
			System.out.println(pr.x+" "+pr.y);
		}
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