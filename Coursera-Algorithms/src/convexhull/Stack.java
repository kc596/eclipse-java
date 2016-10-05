/*
 * Generic Stack
 * @author Kunal Chaudhary
 * Features implemented:
 	- push
 	- pop
 	- isEmpty
 	- top / peek
 	- nextToTop
 */
package convexhull;

public class Stack<T>{
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
	public T top(){
		if(head==null) return null;
		return head.data;
	}
	public T nextToTop(){
		if(head.next==null) return null;
		return head.next.data;
	}
	public boolean isEmpty(){
		return head==null;
	}
}