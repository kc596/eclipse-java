package classical;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class TheLastDigit {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		int t=Integer.parseInt(in.readLine());
		for(int i=0; i<t; i++){
			tokenizer = new StringTokenizer(in.readLine());
			int a=Integer.parseInt(tokenizer.nextToken());
			int b=Integer.parseInt(tokenizer.nextToken());
			if(b==0){a=1;}
			else{
				b=b%4;if(b==0){b=4;}
				a=(int)Math.pow(a, b);
			}
			System.out.println(a%10);
		}
	}
}
