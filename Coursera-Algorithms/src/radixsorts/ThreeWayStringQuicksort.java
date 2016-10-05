package radixsorts;

public class ThreeWayStringQuicksort {
	public static void sort(String[] a){
		sort(a, 0, a.length-1, 0);
	}
	
	private static void sort(String[] a, int lo, int hi, int d){
		if(hi <= lo) return;
		int lt=lo, gt=hi;
		int i = lo+1;
		int v = charAt(a[lo], d);
		
		while(i<=gt){
			int t = charAt(a[i], d);
			if(t<v) 	 exch(a, i++, lt++);
			else if(t>v) exch(a, i, gt--);
			else 		 i++;
		}
		
		//sort 3 subarrays recursively
		sort(a, lo, lt-1, d);
		if(v>=0) sort(a, lt, gt, d+1);
		sort(a, gt+1, hi, d);
	}
	
	private static int charAt(String s, int d){
		if(d<s.length()) return s.charAt(d);
		else return -1;
	}
	
	private static void exch(String[] a, int m, int n){
		String temp=a[m];
		a[m]=a[n];
		a[n]=temp;
	}
	
	/*demo*/
	public static void main(String[] args){
		java.util.Scanner sc= new java.util.Scanner(System.in);
		int N=sc.nextInt();
		sc.nextLine();
		
		String[] a=new String[N];
		for(int i=0; i<N; i++)
			a[i]=sc.nextLine();
		
		sort(a);
		
		for(int i=0; i<N; i++)
			System.out.println(a[i]);
		
		sc.close();
	}
}
