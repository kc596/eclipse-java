package random;

/**
 * @author Kunal
 *
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;

import java.util.StringTokenizer;

public class Temp {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			/**
			 * Gets a calendar using the default time zone and locale.
			 * The Calendar returned is based on the current time in the default time zone.
			 */
			Calendar c=Calendar.getInstance();
			int year=c.get(Calendar.YEAR);
		    int mod=year/100;
		    if(mod*100==year) System.out.println("YO");
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