package codeforcesEdu;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B15 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			//precompute
			final int ROOT=1000000001;
			int value=0;
			int[] two=new int[31];
			HashMap<Integer, Integer> h=new HashMap<Integer, Integer>();
			for(int i=2; i<ROOT; i*=2) two[value++]=i;
			two[value]=2*two[value-1];
			value++;
			
			int n=in.nextInt(), current, diff;
			long sum=0;
			int[] a=new int[n];
			for(int i=0; i<n; i++){
				a[i]=in.nextInt();
				if(h.containsKey(a[i])) h.put(a[i], h.get(a[i])+1);
				else h.put(a[i], 1);
			}
			//Arrays.sort(a);
			
			for(int i=0; i<n; i++){
				current=a[i];
				for(int j=0; j<value; j++){
					diff=two[j]-current;
					if(diff>0){
						if(h.containsKey(diff)){
							sum+=h.get(diff);
							if(current==diff) sum--;
						}
					}
				}
			}
			
			out.println(sum/2);
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


