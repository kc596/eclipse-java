package radixsorts;

public class MSD {
	int radix=256;
	
	public void sort(String[] a){
		String[] aux=new String[a.length];
		sort(a, aux, 0, a.length-1, 0);
	}
	
	private void sort(String[] a, String[] aux, int lo, int hi, int d){
		if(hi<=lo) return;
		
		int[] count=new int[radix+2];
		/**
		 * Since charAt() function returns -1 for last char of string so we need 2 offset to handle that.
		 */
		for(int i=lo; i<=hi; i++)
			count[charAt(a[i], d)+2]++;
		
		for(int i=0; i<radix+1; i++)
			count[i+1]+=count[i];
		
		for(int i=lo; i<=hi; i++)
			aux[count[charAt(a[i],d)+1]++]=a[i];
		
		for(int i=lo; i<=hi; i++)
			a[i]=aux[i-lo];
		
		for(int i=0; i<radix; i++)
			sort(a, aux, lo+count[i], lo+count[i+1]-1, d+1);
		
	}
	
	private int charAt(String s, int i){
		if(s.length()<=i) return -1;
		else return s.charAt(i);
	}
	
	/*demo*/
	public static void main(String[] args){
		String a[]={"Hero", "ki", "kya", "baat", "hai", "gajab", "ganja", "ganjaa"};
		MSD msd=new MSD();
		msd.sort(a);
		for(String s: a) System.out.println(s);
	}
}
