package convexhull;
import java.util.Scanner;
/**
 * @author Kunal Chaudhary
 *
 */

public class GrahamScanDemo {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		GrahamScan.Point[] arr=new GrahamScan.Point[8];
		for(int i=0; i<8; i++){
			double x=sc.nextDouble();
			double y=sc.nextDouble();
			arr[i]=new GrahamScan().new Point(x, y);
		}
		sc.close();
		GrahamScan.convexHull(arr, 8);
	}
}
/*
Input:
0 3
1 1
2 2
4 4
0 0
1 2
3 1
3 3
Output:
0.0 3.0
4.0 4.0
3.0 1.0
0.0 0.0
*/