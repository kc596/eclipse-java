package nitsMashup;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
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
		public void solve(InputReader in, PrintWriter out) {
			Long p=in.nextLong();
			Long q=in.nextLong();
			
			int n=in.nextInt();	//height
			Long[] a=new Long[n];
			
			for(int i=0; i<n; i++){
				a[i]=in.nextLong();
			}
			
			double temp,num=1.0, den=(double)a[n-1], gcd;
			for(int i=n-2; i>=0; i--){
				num=((den*a[i])+num);
				gcd=GCD(num, den);
				num/=gcd;
				den=den/gcd;
				
				temp=num;
				num=den;
				den=temp;
			}
			//out.println(den+" "+num);
			if(num==0){
				if(q==0) out.println("YES");
				else out.println("NO");
			}
			else if(den==0){
				if(p==0) out.println("YES");
				else out.println("NO");
			}
			else if(den==(double)p && num==(double)q) out.println("YES");
			else out.println("NO");
			
			out.println(den+" "+num);
		}
		
		double GCD(double a, double b ) {
		    double r;
		     
		    while (b>0) {
		        r = a % b;
		        a = b;
		        b = r;
		    }
		    return a;
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
		
		public Long nextLong() {
			return Long.parseLong(next());
		}
	}
}
