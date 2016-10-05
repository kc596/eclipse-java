package radixsorts;

public class MSD {
	private static final int R=256;
	
	public static void sort(String[] a){
		String[] aux=new String[a.length];
		sort(a, aux, 0,a.length-1, 0);
	}
	private static void sort(String[] a, String[] aux, int lo, int hi, int d){
		if(hi<=lo) return;
		
		/*key-indexed counting*/
		int[] count = new int[R+2];		//1 extra for end of string
		/*
		 * Since end-of-string character is smaller than all of the char,
		 * Therefore we use count[..+2] for indexing.
		 */
		
		for(int i=lo; i<=hi; i++)
			count[a[i].charAt(d)+2]++;
		
		for(int r=0; r<R+1; r++)
			count[r+1] += count[r];
		
		for(int i=lo; i<=hi; i++)
			aux[count[a[i].charAt(d)+1]++] = a[i];
		
		for(int i=lo; i<=hi; i++)
			a[i]=aux[i-lo];
		
		for(int r=0; r<R; r++)			//vertically sort the string array
			sort(a, aux, lo+count[r], lo+count[r+1]-1, d+1);
	}
	
	//for variable-length strings
	@SuppressWarnings("unused")
	private static int charAt(String s, int d){
		if(d<s.length()) return s.charAt(d);
		else return -1;
	}
	
	public static void main(String[] args){
		java.util.Scanner sc=new java.util.Scanner(System.in);
		int N=sc.nextInt();
		sc.nextLine();
		String[] a=new String[N];
		
		for(int i=0; i<N; i++)
			a[i]=sc.nextLine();
		
		MSD.sort(a);
		
		for(int i=0; i<N; i++)
			System.out.println(a[i]);
		
		sc.close();
	}
}
