package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kunal
 *
 */

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int count;
		public Node(Key key, Value val){
			this.key=key;
			this.val=val;
		}
	}
	
	public Value get(Key key){
		Node x=root;
		while(x!=null){
			int cmp=key.compareTo(x.key);
			if(cmp<0) x=x.left;				//key is less than x.key
			else if(cmp>0) x=x.right;		//key is greater than x.key
			else return x.val;				//key equal to x.key
		}
		return null;
	}
	
	public void put(Key key, Value val){
		root=put(root, key, val);
	}
	private Node put(Node x, Key key, Value val){
		if(x==null) return new Node(key,val);
		
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.left=put(x.left, key, val);			//go to left if key is smaller
		else if(cmp>0) x.right=put(x.right, key, val);	//go to right if key is greater
		else x.val=val;									//replace val if key already existing
		
		x.count=1+size(x.left)+size(x.right);
		return x;
	}

	public int size(){
		return size(root);
	}
	private int size(Node x){
		if(x==null) return 0;
		return x.count;
	}

	public Key floor(Key key){
		Node x=floor(root, key);
		if(x==null) return null;
		return x.key;
	}
	private Node floor(Node x, Key key){
		if(x==null) return null;
		
		int cmp=key.compareTo(x.key);
		if(cmp==0) return x;
		
		if(cmp<0) return floor(x.left, key);
		
		Node t=floor(x.right, key);
		if(t!=null) return t;
		else return x;
	}
	
	public Key ceil(Key key){
		Node x=ceil(root, key);
		if(x==null) return null;
		return x.key;
	}
	private Node ceil(Node x, Key key){
		if(x==null) return null;
		
		int cmp=key.compareTo(x.key);
		if(cmp==0) return x;
		
		if(cmp>0) return ceil(x.right, key);	//key > root data
		
		Node t=ceil(x.left, key);
		if(t!=null) return t;
		else return x;
	}
	
	public int rank(Key key){
		return rank(key,root);
	}
	private int rank(Key key, Node x){
		if(x==null) return 0;
		
		int cmp=key.compareTo(x.key);
		if(cmp<0) return rank(key,x.left);
		else if(cmp>0) return 1+size(x.left)+rank(key,x.right);
		else return size(x.left);								//cmp==0
	}
	
	public Iterable<Key> keys(){
		Queue<Key> q=new LinkedList<Key>();
		inorder(root, q);
		return q;
	}
	private void inorder(Node x, Queue<Key> q){
		if(x==null) return;
		inorder(x.left, q);
		q.offer(x.key);
		inorder(x.right,q);
	}

	public void deleteMin(){
		root=deleteMin(root);
	}
	private Node deleteMin(Node x){
		if(x.left==null) return x.right;
		x.left=deleteMin(x.left);
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
}
