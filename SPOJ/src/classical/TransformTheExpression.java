package classical;
/**
 * @author Kunal Chaudhary
 */

import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TransformTheExpression {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver=new Task();
		solver.solve(in, out);
		out.close();
	}
	
	static class Task{
		public void solve(InputReader in, PrintWriter out){
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				String exp=in.next();
				int len=exp.length();
				char[] ans=new char[len];
				Stack<Character> s=new Stack<Character>();
				int k=0;
				for(int j=0; j<len; j++){
					Character hero=exp.charAt(j);
					if(isOperand(hero)){
						ans[k++]=hero;
					}
					else
						if(isOperator(hero)){
							s.push(hero);
						}
						else
							if(isClosingBracket(hero)){
								while(s.top() != '('){
									ans[k++]=s.pop();
								}
								s.pop();
							}
							else{
								ans[k++]=s.pop();
							}
				}
				for(int j=0; j<k; j++){
					out.print(ans[j]);
				}
				out.println();
			}
		}
		private boolean isOperand(char a){
			if(a>=97 && a<=122) return true;
			return false;
		}
		private boolean isOperator(char a){
			return (a=='+' || a=='-' || a=='*' || a=='/' || a=='^' || a=='(');
		}
		private boolean isClosingBracket(char a){
			return (a==')');
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
	static class Stack<T>{
		private class Node{
			T data;
			Node next;
		}	
		private Node head=null;

		public void push(T data){
			Node temp=new Node();
			temp.data=data;
			temp.next=head;
			head=temp;
		}
		public T pop(){
			if(isEmpty()) return null; //empty stack
			T temp=head.data;
			head=head.next;
			return temp;
		}
		public boolean isEmpty(){
			return head==null;
		}
		public T top(){
			if(isEmpty()) return null;
			return head.data;
		}
	}
}