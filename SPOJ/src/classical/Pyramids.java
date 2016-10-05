package classical;
/**
 * @author Kunal Chaudhary
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Pyramids {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver=new Task();
		solver.solve(in, out);
		out.close();
	}
	static class Task{
		public void solve(InputReader in, PrintWriter out){
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				double U=Double.parseDouble(in.next());
				double V=Double.parseDouble(in.next());
				double w=Double.parseDouble(in.next());
				double W=Double.parseDouble(in.next());
				double v=Double.parseDouble(in.next());
				double u=Double.parseDouble(in.next());
				
				double X=(w-U+v)*(U+v+w);
				double x=(U-v+w)*(v-w+U);
				double Y=(u-V+w)*(V+w+u);
				double y=(V-w+u)*(w-u+V);
				double Z=(v-W+u)*(W+u+v);
				double z=(W-u+v)*(u-v+W);
				double a=Math.sqrt(x*Y*Z);
				double b=Math.sqrt(y*Z*X);
				double c=Math.sqrt(z*X*Y);
				double d=Math.sqrt(x*y*z);

				double Volume=Math.sqrt((b-a+c+d)*(a-b+c+d)*(a+b-c+d)*(a+b+c-d));
				out.println(Math.round((Volume/(192*u*v*w)) * 10000.0) / 10000.0);
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
