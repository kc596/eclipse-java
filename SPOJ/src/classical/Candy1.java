package classical;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Candy1 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			int sum, avg;
			while(n!=-1){
				int[] arr=new int[n];
				sum=0;
				for(int i=0; i<n; i++){
					arr[i]=in.nextInt();
					sum+=arr[i];
				}
				avg=sum/n;
				if(avg*n!=sum){
					out.println("-1");
				}
				else{
					sum=0;
					for(int i=0;i<n; i++){
						if(arr[i]>avg) sum+=(arr[i]-avg);
					}
					out.println(sum);
				}
				n=in.nextInt();
			}
		}
	}//--end of task--

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
