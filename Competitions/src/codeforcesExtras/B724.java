package codeforcesExtras;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B724 {
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
		static class Pair implements Comparable<Pair>{
			int x, y;
			public Pair(int x, int y){
				this.x=x; this.y=y;
			}
			@Override
			public int compareTo(Pair o) {
				if(x>o.x) return 1;
				else if(x<o.x) return -1;
				else {
					if(o.y==y) return 0;
					else if(y>o.y) return 1;
					else return -1;
				}
			}
			public boolean equals(Object o){
				if(((Pair)o).x==x && ((Pair)o).y==y) return true;
				return false;
			}
			public int hashCode(){
				return 31*x+y;
			}
		}
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt(), m=in.nextInt();	//r c
			int[][] a=new int[n+1][m+1];
			int[] deviation=new int[n+1];
			/*
			TreeSet<Pair> devPair=new TreeSet<Pair>();
			TreeSet<Pair> devPair2nd=new TreeSet<Pair>();
			*/
			HashMap<Pair, Integer> map=new HashMap<Pair, Integer>();
			HashMap<Pair, Integer> map2=new HashMap<Pair, Integer>();
			
			boolean status=true;
			
			for(int i=1; i<=n; i++){
				deviation[i]=0;
				for(int j=1; j<=m; j++){
					a[i][j]=in.nextInt();
					if(a[i][j]!=j) deviation[i]++;
				}
				if(deviation[i]>4) status=false;
				else if(deviation[i]==4){
					for(int ii=1; ii<=m; ii++){
						if(a[i][a[i][ii]]!=ii){ status=false;}			//should be pairwise exchangeable
						if(a[i][ii]!=ii){
							if( !(map.containsKey(new Pair(ii, a[i][ii])) || map.containsKey(new Pair(a[i][ii], ii)) ) ){
								map.put(new Pair(a[i][ii], ii), 1);
							}
							else map.put(new Pair(ii, a[i][ii]), map.get(new Pair(ii, a[i][ii]))+1);
						}
					}
				}
				else if(deviation[i]==3){
					for(int ii=1; ii<=m; ii++){
						if(a[i][ii]!=ii){
							if( !(map.containsKey(new Pair(ii, a[i][ii])) || map.containsKey(new Pair(a[i][ii], ii))) ){
								map.put(new Pair(a[i][ii], ii), 1);
							}
							else map.put(new Pair(ii, a[i][ii]), map.get(new Pair(ii, a[i][ii]))+1);
						}
					}
				}
				else if(deviation[i]==2){
					for(int ii=1; ii<=m; ii++){
						if(a[i][ii]!=ii){
							//out.println(ii+" "+map2.containsKey(new Pair(ii, a[i][ii])));
							if( !(map2.containsKey(new Pair(ii, a[i][ii])) || map2.containsKey(new Pair(a[i][ii], ii))) ){
								map2.put(new Pair(a[i][ii], ii), 1);
							}
							else map2.put(new Pair(ii, a[i][ii]), map2.get(new Pair(ii, a[i][ii]))+1);
						}
					}
				}
			}
			
			if(!status){
				out.println("NO");
				return;
			}
			
			//finding the key with maximum value
			int max=0;
			ArrayList<Pair> max_keys=new ArrayList<Pair>();
			for(Pair p: map.keySet()){
				//out.println(p.x+" "+p.y+" "+map.get(p));
				if(map.get(p)>max) max=map.get(p);
			}
			for(Pair p: map.keySet()){
				if(map.get(p)==max) max_keys.add(p);
			}
			
			//deciding on the basis of 2 deviations
			for(Pair p: map2.keySet()){
				out.println(p.x+" "+p.y+" "+map2.get(p));
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
