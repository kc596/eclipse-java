package codeforcesRound;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C378 {
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
			int n=in.nextInt();
			ArrayList<Integer> a = new ArrayList<Integer>(n);
			for(int i=0; i<n; i++){
				a.add(in.nextInt());
			}
			
			int k=in.nextInt();
			Integer[] b = new Integer[k];
			for(int i=0; i<k; i++){
				b[i] = in.nextInt();
			}
			
			ArrayList<Integer> box = new ArrayList<Integer>();
			box.add(0);
			
			int sum = 0, start = 0;
			for(int i=0; i<k; i++){
				sum = b[i];
				while(true){
					if(start>=n){
						out.println("NO");
						return;
					}
					sum -= a.get(start++);
					if(sum==0){
						box.add(start);
						break;
					} else if(sum<0){
						out.println("NO");
						return;
					} else if(start>=n){
						out.println("NO");
						return;
					}
				}
			}
			if(start<n){
				out.println("NO");
				return;
			}
			if(box.size()==1){
				out.println("YES");
				return;
			}
			
			start = 0;
			int lo= box.get(start), hi=box.get(start+1);
			
			ArrayList<Integer> index = new ArrayList<Integer>();
			ArrayList<Character> direction = new ArrayList<Character>();
			
			while(lo!=n){
				//out.println(start+" "+lo+" "+(hi-lo));
				if(!isPossibleToEat(a, start, hi-lo+start, index, direction)){
					out.println("NO");
					return;
				}
				start++;
				lo = box.get(start);
				try{
					hi = box.get(start+1);
				} catch(Exception e){
					hi=n;
				}
				
				/*for(Integer II: a){
					out.print(II+" ");
				}
				out.println();*/
			}
			
			out.println("YES");
			for(int i=0; i<index.size(); i++){
				out.println(index.get(i)+" "+direction.get(i));
			}
			
		}
		
		static boolean isPossibleToEat(ArrayList<Integer> a, int lo, int n, ArrayList<Integer> index, ArrayList<Character> direction){
			int max = lo;
			for(int i=lo+1; i<n; i++){
				if( (a.get(max)<=a.get(i)) && ( ((i<n-1)&&(a.get(i)>a.get(i+1))) || ((i>0)&&(a.get(i)>a.get(i-1))) ) ){
					max = i;
				}
			}
			
			int left = max-1, right = max+1;
			
			while(true){
				boolean flag = false;
				while(left>=lo){
					if(a.get(left)<a.get(max)){
						index.add(max+1);
						direction.add('L');
						a.set(left, a.get(left)+a.get(max));
						a.remove(max);
						n--;
						flag=true;
						max = left;
						left = max-1;
						right = max+1;
					}
					else{
						break;
					}
				}
							
				while(right<n){
					if(a.get(right)<a.get(max)){
						index.add(max+1);
						direction.add('R');
						a.set(max, a.get(right)+a.get(max));
						a.remove(right);
						n--;
						left = max-1;
						right = max+1;
						flag = true;
					}
					else{
						break;
					}
				}
				
				if(!flag){
					if(lo==n-1){
						return true;
					}
					else{
						return false;
					}
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

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
