package radixsorts;

public class LSD {
	int radix=256;
	
	void sort(String[] a, int w){ //w=length of each string
		String aux[]=new String[a.length];
		
		for(int d=w-1; d>=0; d--){
			int[] count=new int[radix+1];
			
			for(int j=0; j<a.length; j++)
				count[a[j].charAt(d)+1]++;
			
			for(int j=0; j<radix; j++)
				count[j+1] += count[j];
			
			for(int j=0; j<a.length; j++)
				aux[count[a[j].charAt(d)]++]=a[j];
			
			for(int j=0; j<a.length; j++)
				a[j]=aux[j];
		}
	}
	
	/*demo*/
	public static void main(String[] args){
		String[] s={"kunal", "heroe", "insan", "table", "javam", "javaa"};
		LSD l=new LSD();
		l.sort(s, 5);
		
		for(String k: s) System.out.println(k);
	}
}
