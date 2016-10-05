package classical.unsolved;
/**
 * @author Kunal Chaudhary
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PythagorasTriplets {
	private static final int ROOT=1000001;
	static long[] pyArray=new long[ROOT];
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver=new Task();
		preCompute();
		solver.solve(in, out);
		out.close();
	}
	static class Task{
		public void solve(InputReader in, PrintWriter out){
			long N=Long.parseLong(in.next());
			int count=0;
			for(int i=0; pyArray[i]<=N; i++){
				if(pyArray[i]>0){
					count++;
					//System.out.println(pyArray[i]);
				}
			}
			out.println(count);
		}
	}
	static void preCompute(){
		long b,c;
		int k=0;
		Arrays.fill(pyArray, 1);
		pyArray[k++]=5;
		for(long i=5; i<10000; i++){
			if(i%2!=0){
				b=((i*i)-1)/2;
				c=b+1;
				pyArray[k++]=c;
				k+=10000/c;
			}
			if(i%2==0){
				b=(i/2)*(i/2)-1;
				c=b+2;
				pyArray[k++]=c;
				pyArray[k++]=10000/c;
			}
		}
		Arrays.sort(pyArray);
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
}
