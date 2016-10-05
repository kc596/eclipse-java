package radixsorts;

public class LSD {	
	public static void sort(String[] a, int W){
		/**
		 * Sorting an array of string where each string is of fixed length W.
		 */
		int R=256;			//radix R
		int N=a.length;
		String[] aux = new String[N];
		
		for(int d=W-1; d>=0; d--){
			int[] count = new int[R+1];
			
			for(int i=0; i<N; i++)
				count[a[i].charAt(d)+1]++;
			
			for(int r=0; r<R; r++)
				count[r+1] += count[r];
			
			for(int i=0; i<N; i++)
				aux[count[a[i].charAt(d)]++] = a[i];
			
			for(int i=0; i<N; i++)
				a[i]=aux[i];
			
		}
	}
	
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int W=sc.nextInt();			//width of strings
		int N=sc.nextInt();			//number of strings to sort
		sc.nextLine();
		String[] a = new String[N];
		
		for(int i=0; i<N; i++){
			a[i]=sc.nextLine();
			assert(a[i].length()==W);
		}

		LSD.sort(a, W);
		for(int i=0; i<N; i++)
			System.out.println(a[i]);
		
		sc.close();
	}
}
