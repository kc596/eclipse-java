package classical.unsolved;

/**
 * @author Kunal Chaudhary
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SortingBankAccounts {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver=new Task();
		solver.solve(in, out);
		out.close();
	}
	class Account{
		int control;	//2 digits
		int bankcode;	//8 digits
		int customer1;	//4 digits
		int customer2;	//4 digits
		int customer3;	//4 digits
		int customer4;	//4 digits
		int count=1;
	}
	@SuppressWarnings("all")
	static class Task{
		public void solve(InputReader in, PrintWriter out){
			Account[] arr=new Account[5];
		}
		
		static class ShellSort implements Comparable{
			public static void sort(Comparable[] a){
				int N=a.length, h=1;
				while(h<N/3){
					h=3*h+1;	//1,4,13,40,121,364,..
				}
				while(h>=1){
					//h-sort (insertion sort) the array
					for(int i=h; i<N; i++){
						for(int j=i; j>=h; j-=h){
							if(less(a[j],a[j-h])) swap(a,j,j-h);
							else break;
						}
						h=h/3;
					}
				}
			}
			private static boolean less(Comparable a, Comparable b){
				return a.compareTo(b)<0;
			}
			public static void swap(Comparable[] a, int i, int j){	//copies reference to array
				Comparable swap=a[i];
				a[i]=a[j];
				a[j]=swap;
			}
			
			@Override
			public int compareTo(Object arg0) {
				//if(this.control<arg0.control) return -1;
				
				return 0;
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