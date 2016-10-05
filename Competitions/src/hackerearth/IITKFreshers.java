package hackerearth;

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

public class IITKFreshers {
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
		static class Rank implements Comparable<Rank>{
			char c;
			Integer value;
			public Rank(char c, int v){
				this.c=c;
				this.value=v;
			}
			@Override
			public int compareTo(Rank x) {
				return value.compareTo(x.value);
			}
		}
		public void solve(InputReader in, PrintWriter out) {
			boolean[] status=new boolean[26];
			boolean[][] count=new boolean[26][26];
			int n=in.nextInt();
			for(int i=0; i<n; i++){
				int a=(in.next().charAt(0)-'a'), b=(in.next().charAt(0)-'a'), c=(in.next().charAt(0)-'a');
				status[a]=status[b]=status[c]=true;
				count[a][b]=count[a][c]=count[b][c]=true;
			}
			
			Rank[] rank=new Rank[26];
			for(int i=0; i<26; i++)	rank[i]=new Rank((char)(i+'a'), -1);

			for(int i=0; i<26; i++){
				if(status[i]){
					rank[i].value=0;
					for(int j=0; j<26; j++){
						if(count[i][j]) rank[i].value=rank[i].value+1;
					}
				}
			}
			Arrays.sort(rank);
			
			for(int i=25; i>0; i--){
				if(rank[i].value==-1) break;
				Rank[] q=new Rank[26];
				int j=i,k=0, val=rank[i].value;
				while(j>0 && val==rank[j].value) q[k++]=rank[j--];
				//for(int iii=0; iii<k; iii++) out.print(q[iii].c+" "+q[iii].value+" ");
				if(k>1){
					for(int ii=0; ii<k; ii++){
						for(int jj=0; jj<k; jj++){
							if(count[q[ii].c-'a'][q[jj].c-'a']){
								q[ii].value=q[jj].value+1;
							}
						}
					}
				}
				/*for(int iii=0; iii<k; iii++) out.print(q[iii].c+" "+q[iii].value+" ");
				out.println();*/
			}
			
			Arrays.sort(rank);
			
			for(int i=25; i>=0; i--){
				if(rank[i].value<0) break;
				out.print(rank[i].c);
			}
			out.println();
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
