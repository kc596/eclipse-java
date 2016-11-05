package codeforcesExtras;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B727 {
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
			String s=in.next();
			
			String curr="", cent="", final_ans="";
			Double ans=0.0;
			boolean mayBeCent=false;
			
			for(int i=0; i<s.length(); i++){
				char a=s.charAt(i);
				//out.println(a+" "+curr);
				if(a>='0' && a<='9'){
					if(mayBeCent) cent+=a;
					else curr+=a;
				}
				else if(a=='.'){
					if(i+1<s.length() && (s.charAt(i+1)>='0' && s.charAt(i+1)<='9')) curr+=cent;
					cent="";
					mayBeCent=true;
				}
				else{
					if(curr.length()>0){
						if(cent.length()==2) curr+="."+cent;
						else curr+=cent;
						ans+=Double.parseDouble(curr);
						curr="";
						mayBeCent=false;
						cent="";
					}
				}
			}
			
			if(curr.length()>0){
				if(cent.length()==2) curr+="."+cent;
				else curr+=cent;
				ans+=Double.parseDouble(curr);
			}
			long new_ans=Math.round(ans*100);
			//out.println(new_ans);
			
			curr=""+(new_ans);
			if(curr.length()>2) curr=curr.substring(0, curr.length()-2);
			else curr="0";
			
			cent=""+new_ans;
			if(cent.length()>=2) cent=cent.substring(cent.length()-2);
			if(cent.length()<2 && Integer.parseInt(cent)<10) cent="0"+cent;
			if(Integer.parseInt(cent)==0)cent="";
			
			//out.println(curr+" "+cent);
			
			int first=(curr.length()%3);
			if(first!=0) final_ans+=curr.substring(0, first)+".";
			
			for(int i=first; i<curr.length(); i+=3){
				if(i+3<=curr.length()) final_ans+=curr.substring(i, i+3)+".";
				else final_ans+=curr.substring(i)+".";
			}
			
			if(cent.length()>0) final_ans+=cent.substring(0, 2);
			else final_ans=final_ans.substring(0, final_ans.length()-1);
			out.println(final_ans);
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
