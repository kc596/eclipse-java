package codeforcesRound;

/**
 * @author kunal05
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class D378 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();		
		new Task1().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		out.close();
	}
	
	static class Task1{
		static class Cube{
			Integer a,b,c;
			int index;
			public Cube(int a, int b, int c, int index){
				this.a=a; this.b=b; this.c=c;
				this.index = index;
			}
		}
		
		static class COMP implements Comparator<Cube>{
			public int compare(Cube x, Cube y){
				if(x.a > y.a) return 1;
				else if(x.a < y.a) return -1;
				else{
					if(x.b > y.b) return 1;
					else if(x.b < y.b) return -1;
					else return x.c.compareTo(y.c);
				}
			}
		}
		
		public void solve(InputReader in, PrintWriter out){
			int n=in.nextInt();
			Cube[] a = new Cube[3*n];
			int max_solo = 0, index_solo = 0;
			
			for(int i=0; i<n; i++){
				int x = in.nextInt();
				int y = in.nextInt();
				int z = in.nextInt();
				int min = Math.min(Math.min(x, y), z);
				
				if(max_solo < min){
					index_solo = i+1;
					max_solo = min;
				}
				
				a[i] = new Cube(Math.min(x,y), Math.max(x,y), z, i+1);
				a[n+i] = new Cube(Math.min(x,z), Math.max(x,z), y, i+1);
				a[2*n+i] = new Cube(Math.min(y,z), Math.max(y,z), x, i+1);
			}
			
			Arrays.sort(a, new COMP());
			
			int max_d=0, max_index1=0, max_index2=0;
			for(int i=1; i<3*n; i++){
				if(a[i-1].a.equals(a[i].a) && a[i-1].b.equals(a[i].b)){
					int temp = Math.min(a[i].a, a[i].c+a[i-1].c);
					if(temp > max_d){
						max_d = temp;
						max_index1=a[i-1].index;
						max_index2=a[i].index;
					}
				}
			}
			if(max_index1 == max_index2 || max_solo>=max_d){
				out.println("1");
				out.println(index_solo);
			} else{
				out.println("2");
				out.println(max_index1+" "+max_index2);
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
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public String nextLine() {
			String s=null;
			try{
				s = reader.readLine();
			} catch(IOException e){
				throw new RuntimeException(e);
			}
			return s;
        }
		
		public String nextParagraph() {
			String line=null;
			String ans = "";
			try{
				while ((line = reader.readLine()) != null) {
				ans += line;
				}
			} catch(IOException e){
				throw new RuntimeException(e);
			}
			return ans;
		}
		
	}
}