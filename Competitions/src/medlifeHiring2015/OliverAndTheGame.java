package medlifeHiring2015;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class OliverAndTheGame {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		boolean[] marked;
		LinkedList<Integer>[] adj;
		int edgeTo[];
		
		@SuppressWarnings("unchecked")
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			adj=new LinkedList[n];
			for(int i=0; i<n; i++) adj[i]=new LinkedList<Integer>();
			
			for(int i=0; i<n-1; i++){
				int a=in.nextInt(), b=in.nextInt();
				a--; b--;
				adj[a].add(b);
				adj[b].add(a);
			}
			
			int q=in.nextInt();
			for(int i=0; i<q; i++){
				int king=in.nextInt();	//0-> Yes, 1-> No
				int x=in.nextInt();		//hiding spot
				int y=in.nextInt();		//starting posn
				x--; y--;
				
				marked=new boolean[n];
				edgeTo=new int[n];
				boolean flag=false;
				dfs(y);
				if(king==0){
					for(int j=0; j!=y; j=edgeTo[j]){
						if(j==x){
							out.println("YES");							
							flag=true;
							break;
						}
					}
					if(!flag) out.println("NO");
				}
				else{
					for(int j=0; j!=y; j=edgeTo[j]){
						if(j==x){
							out.println("NO");							
							flag=true;
							break;
						}
					}
					if(!flag){
						for(int j=x; j!=y; j=edgeTo[j]){
							if(j==0){
								out.println("NO");							
								flag=true;
								break;
							}
						}
					}
					if(!flag) out.println("YES");
				}
			}
		}
		
		public void dfs(int v){
			marked[v]=true;
			for(Integer i: adj[v]){
				if(!marked[i]){
					dfs(i);
					edgeTo[i]=v;
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


/****************************************************************************************************
*                                                                                         ,----,.   *
*                                                                                       ,'   ,' |   *
*          ,-.                                              ,--,        ,----..       ,'   .'   |   *
*      ,--/ /|                                            ,--.'|       /   /   \    ,----.'    .'   *
*    ,--. :/ |           ,--,        ,---,                |  | :      /   .     :   |    |   .'     *
*    :  : ' /          ,'_ /|    ,-+-. /  |               :  : '     .   /   ;.  \  :    :  |--,    *
*    |  '  /      .--. |  | :   ,--.'|'   |    ,--.--.    |  ' |    .   ;   /  ` ;  :    |  ;.' \   *
*    '  |  :    ,'_ /| :  . |  |   |  ,"' |   /       \   '  | |    ;   |  ; \ ; |  |    |      |   *
*    |  |   \   |  ' | |  . .  |   | /  | |  .--.  .-. |  |  | :    |   :  | ; | '  `----'.'\   ;   *
*    '  : |. \  |  | ' |  | |  |   | |  | |   \__\/: . .  '  : |__  .   |  ' ' ' :    __  \  .  |   *
*    |  | ' \ \ :  | : ;  ; |  |   | |  |/    ," .--.; |  |  | '.'| '   ;  \; /  |  /   /\/  /  :   *
*    '  : |--'  '  :  `--'   \ |   | |--'    /  /  ,.  |  ;  :    ;  \   \  ',  /  / ,,/  ',-   .   *
*    ;  |,'     :  ,      .-./ |   |/       ;  :   .'   \ |  ,   /    ;   :    /   \ ''\       ;    *
*    '--'        `--`----'     '---'        |  ,     .-./  ---`-'      \   \ .'     \   \    .'     *
*                                            `--`---'                   `---`        `--`-,-'       *
*                                                                                                   *
*                                                                                                   *
****************************************************************************************************/