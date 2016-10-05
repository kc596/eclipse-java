package random;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.math.BigInteger;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class C {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		@SuppressWarnings("unused")
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int n=in.nextInt();
				int j=in.nextInt();
				
				String s="1000000000000001";
				final BigInteger two=new BigInteger("10",2);
				BigInteger num2=new BigInteger(s,2);
				BigInteger num=new BigInteger(s,10);
				final BigInteger pr=new BigInteger("14923738830");
				System.out.println("Case #1:");
				for(int k=1; k<=50; k++){
					int[] ans=new int[11];
					for(int bb=2; bb<=10; bb++){
						num=new BigInteger(s,bb);
						
						if((num.gcd(pr)).equals(BigInteger.ONE)){
							num2=num2.add(two);
							s=new String(num2.toString(2));
							bb=1;
							continue;
						}
						
						for(int iti=2;  ;iti++){
							int MM=num.mod(new BigInteger(""+iti)).intValue();
							if(MM==0){
								ans[bb]=iti;
								break;
							}
						}
					}
					//answer print
					System.out.print(num2.toString(2)+" ");
					for(int ii=2; ii<=10; ii++){
						System.out.print(ans[ii]+" ");
					}
					System.out.println();
					num2=num2.add(two);
					s=new String(num2.toString(2));
				}
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
	}
}
