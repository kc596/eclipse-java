package stack;

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

	public boolean isEmpty(){
		return head==null;
	}
}