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
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class D375 {
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
		static class Water{
			int x,y;
			public Water(int x, int y){
				this.x=x; this.y=y;
			}
		}
		static class Comp implements Comparator<ArrayList<Integer>>{

			@Override
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				// TODO Auto-generated method stub
				return ((Integer)a.size()).compareTo((Integer)b.size());
			}
			
		}
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt(), m=in.nextInt(), k=in.nextInt();
			QuickUnion lake=new QuickUnion(n*m);
			
			char[][] world=new char[n][m];
			boolean[][] isWater=new boolean[n][m];
			
			for(int i=0; i<n; i++){
				String s=in.next();
				world[i]=s.toCharArray();
				if(i>0){
					for(int j=0; j<m; j++){
						if(j>0){
							if(world[i][j]=='.'){
								isWater[i][j]=true;
								int index=m*i+j;
								if(world[i-1][j]=='.'){
									lake.union(index, m*(i-1)+j);
								}
								if(world[i][j-1]=='.'){
									lake.union(index, m*i+j-1);
								}
							}
						}
					}
				}
			}
			for(int i=0; i<m; i++){
				isWater[0][i]=false;
				isWater[n-1][i]=false;
			}
			for(int i=0; i<n; i++){
				isWater[i][0]=false;
				isWater[i][m-1]=false;
			}
			
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(isWater[i][j]) out.print('.');
					else out.print('*');
				}
				out.println();
			}
			
			ArrayList<ArrayList<Integer>> final_lake=new ArrayList<ArrayList<Integer>>();
			boolean[] marked=new boolean[m*n];
			
			
			
			for(int i=0; i<m; i++){
				
				
				int temp_id=lake.id[i];
				if(!marked[temp_id]){
					int x=temp_id/m;
					int y=temp_id-x*m;
					out.println(x+" "+y);
					boolean flag=true;
					
					if(isWater[x][y]){
						ArrayList<Integer> curr=new ArrayList<Integer>();
						for(int ii=0; ii<m*n; ii++){
							int temp_idd=lake.id[ii];
							if(temp_id==temp_idd){
								int xx=temp_idd/m;
								int yy=temp_idd-xx*m;
								
								if(isWater[xx][yy]) curr.add(ii);
								else{
									//out.println(xx+" "+yy);
									flag=false;
									break;
								}
							}
						}
						if(flag){
							final_lake.add(curr);
						}
					}
					marked[temp_id]=true;
				}
			}

			
			int count=0;
			Collections.sort(final_lake, new Comp());
			for(int i=0; i<final_lake.size()-k; i++){
				ArrayList<Integer> curr=final_lake.get(i);
				for(int j=0; j<curr.size(); j++){
					int x=curr.get(j)/m;
					int y=curr.get(j)-m*x;
					world[x][y]='*';
					count++;
				}
			}
			
			out.println(count);
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					out.print(world[i][j]);
				}
				out.println();
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
	static class QuickUnion{
		public int[] id;
		private int[] size;
		
		public QuickUnion(int a){
			id=new int[a];
			size=new int[a];
			for(int i=0; i<a; i++){
				size[i]=1;
				id[i]=i;
			}
		}
		
		private int root(int i){
			while(id[i]!=i){
				id[i]=id[id[i]];
				i=id[i];
			}
			return i;
		}
		
		public boolean isConnected(int p, int q){
			return root(p)==root(q);
		}
		
		public void union(int p, int q){
			int pid=root(p);
			int qid=root(q);
			if(pid==qid) return;
			
			if(size[p]>size[q]){
				id[qid]=pid;
				size[pid]+=size[qid];
			}
			else{
				id[pid]=qid;
				size[qid]+=size[pid];
			}
		}
	}
}
