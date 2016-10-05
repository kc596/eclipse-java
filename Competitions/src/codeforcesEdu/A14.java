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

public class A14 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int n=in.nextInt();
			int count0=0;
			boolean status = false;
			for(int i=0; i<n; i++){
				int a=in.nextInt();
				if(a==0) count0++;
				if(i==n-1 && a==0) status=true; //last button tight
			}
			if(count0>1 || count0==0 || (count0==1 && n==1) || (status && count0==1)){
				out.println("NO");
			}
			else{
				out.println("YES");
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