package classical;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
1
10
1 2
5 8
3 65 
23 32
1 52 
31 54
45 50
2 10
5 6 
2 7



*/
public class BusyMan {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int n=in.nextInt(); //no. of activities
				Pair[] a=new Pair[n];
				for(int j=0; j<n; j++){
					int k1=in.nextInt(); //start time
					int k2=in.nextInt(); //end time
					a[j]=new Pair(k1,k2);
				}
				Arrays.sort(a);
				
				int prevEndTime=a[0].end;
				int count=1;
				for(int j=1; j<n; j++){
					if(a[j].start>=prevEndTime){
						count++;
						prevEndTime=a[j].end;
					}
				}
				out.println(count);
			}
		}
		
		@SuppressWarnings("rawtypes")
		static class Pair implements Comparable{
			int start;
			int end;
			public Pair(int start, int end){
				this.start=start;
				this.end=end;
			}
			@Override
			public int compareTo(Object arg0) {
				Pair arg=(Pair)arg0;
				if(end<arg.end) return -1;
				else if(end>arg.end) return 1;
				else{
					if(start<arg.start) return -1;
					else if(start>arg.start) return 1;
					else return 0;
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
