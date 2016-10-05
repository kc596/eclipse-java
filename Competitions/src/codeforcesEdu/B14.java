package codeforcesEdu;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B14 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			boolean hash[] = new boolean[256];
			boolean ahash[] = new boolean[256];
			boolean spl_hash[] = new boolean[256];
			hash['A']=hash['H']=hash['I']=hash['M']=hash['O']=hash['T']=hash['U']=hash['V']=hash['W']=hash['X']=hash['Y']=true;
			hash['o']=hash['v']=hash['w']=hash['x']=hash['b']=hash['d']=hash['p']=hash['q']=true;
			ahash['A']=ahash['H']=ahash['I']=ahash['M']=ahash['O']=ahash['T']=ahash['U']=ahash['V']=ahash['W']=ahash['X']=ahash['Y']=true;
			ahash['o']=ahash['v']=ahash['w']=ahash['x']=true;
			spl_hash['b']=spl_hash['d']=spl_hash['p']=spl_hash['q']=true;
			
			boolean flag=false;
			String txt = in.next();
			int len=txt.length();
			int mid=len/2;
			if(len%2==0){
				String p1=txt.substring(0, mid);
				String p2=txt.substring(mid);
				for(int i=0; i<mid; i++){
					char a=p1.charAt(i), b=p2.charAt(mid-i-1);
					if(hash[a] && hash[b]){
						if(spl_hash[a] || spl_hash[b]){
							if((a=='b' && b=='d') || (a=='d' && b=='b') || (a=='p' && b=='q') || (a=='q' && b=='p')){
								continue;
							}
							else{
								//reject
								flag=true;
								out.println("NIE");
								break;
							}
						}
						else{
							if(a==b) continue;
							else{
								flag=true;
								out.println("NIE");
								break;
							}
						}
						
					}
					else{
						flag=true;
						out.println("NIE");
						break;
					}
				}
			}
			else{
				//odd length
				String p1=txt.substring(0, mid);
				String p2=txt.substring(mid+1);
				char central=txt.charAt(mid);
				if(ahash[central]){
					for(int i=0; i<mid; i++){
						char a=p1.charAt(i), b=p2.charAt(mid-i-1);
						if(hash[a] && hash[b]){
							if(spl_hash[a] || spl_hash[b]){
								if((a=='b' && b=='d') || (a=='d' && b=='b') || (a=='p' && b=='q') || (a=='q' && b=='p')){
									continue;
								}
								else{
									//reject
									flag=true;
									out.println("NIE");
									break;
								}
							}
							else{
								if(a==b) continue;
								else{
									flag=true;
									out.println("NIE");
									break;
								}
							}
							
						}
						else{
							flag=true;
							out.println("NIE");
							break;
						}
					}
				}
				else{
					flag=true;
					out.println("NIE");
				}
			}
			if(!flag){
				out.println("TAK");
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