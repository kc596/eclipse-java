package classical;
/**
 * @author Kunal Chaudhary
 */

import java.io.PrintWriter;
import java.math.BigInteger;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SmallFactorials {
	static BigInteger[] bArr=new BigInteger[101];
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
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int n=in.nextInt();
				out.println(bArr[n]);				
			}
		}
	}
	private static void preCompute(){
		BigInteger ans=BigInteger.ONE;
		BigInteger temp=BigInteger.ONE;
		for(int i=1; i<101; i++){
			bArr[i]=ans;
			temp=temp.add(BigInteger.ONE);
			ans=ans.multiply(temp);
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
	}
}
