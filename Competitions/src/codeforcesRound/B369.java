package codeforcesRound;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B369 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		Task1 solver = new Task1();
		solver.solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}

	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			int row=-1, col=-1,n=in.nextInt();
			Long[][] a=new Long[n][n];
			TreeSet<Long> set=new TreeSet<Long>();
			long rsum, low_sum=0, d1=0, d2=0;
			boolean status=false;
			for(int i=0; i<n; i++){
				rsum=0;
				for(int j=0; j<n; j++){
					a[i][j]=in.nextLong();
					rsum+=a[i][j];
					if(a[i][j]==0){row=i; col=j; status=true;}
					if(i==j) d1+=a[i][j];
					if(i+j==n-1) d2+=a[i][j];
				}
				set.add(rsum);
				if(status){
					low_sum=rsum;
					status=false;
				}
			}
			if(n==1 && a[0][0]==0){
				out.println(1);
			}
			else if(set.size()!=2){
				out.println(-1);
			}
			else{
				long one=set.first();
				long two=set.last();
				if((row==-1 && col==-1) || (low_sum==two)){ out.println(-1); return; }
				a[row][col]=two-one;
				if(row==col) d1+=a[row][col];
				if(row+col==n-1) d2+=a[row][col];
				
				//verifying col sum
				for(int i=0; i<n; i++){
					rsum=0;
					for(int j=0; j<n; j++){
						rsum+=a[j][i];
						//out.print(a[j][i]+" ");
					}
					//out.println();
					if(rsum!=two){
						out.println(-1);
						return;
					}
				}
				
				//out.println(d1+" "+d2);
				if(d1==d2 && d1==two) out.println(a[row][col]);
				else out.println(-1);
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
	}
}
