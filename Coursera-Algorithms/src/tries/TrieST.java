package tries;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Kunal
 *
 * @param <Value>
 */

public class TrieST<Value> {
	private static final int R = 256;	//extended ASCII radix
	private Node root = new Node();
	
	private static class Node{
		private Object value;			//since no generic array creation in java
		private Node[] next = new Node[R];
	}
	
	public void put(String key, Value value){
		root = put(root, key, value, 0);
	}
	
	private Node put(Node x, String key, Value value, int index){
		if(x==null) x=new Node();
		if(index == key.length()) x.value=value;
		else{
			char c = key.charAt(index);
			x.next[c]=put(x.next[c], key, value, index+1);
		}
		return x;
	}
	
	/*@SuppressWarnings("unchecked")
	public Value get(String key){		//iterative version
		int index = 0;
		Node temp = root;
		while(index<key.length()){
			if(temp==null) return null;
			else temp=temp.next[key.charAt(index)];
			index++;
		}
		if(temp==null) return null;
		else return (Value)temp.value;
	}*/
	
	public boolean contains(String key){
		return get(key)!=null;
	}
	
	@SuppressWarnings("unchecked")
	public Value get(String key){		//recursive version
		Node x = get(root, key, 0);
		if (x == null) return null;
		return (Value)x.value;
	}
	
	private Node get(Node x, String key, int index){
		if (x == null) return null;
		if (index == key.length()) return x;
		char c = key.charAt(index);
		return get(x.next[c], key, index+1);
	}
	
	public Iterable<String> keys(){
		Queue<String> queue = new LinkedList<String>();
		collect(root, "", queue);
		return queue;
	}
	
	public Iterable<String> keysWithPrefix(String prefix){
		Queue<String> queue = new LinkedList<String>();
		Node x = get(root, prefix, 0);
		collect(x, prefix, queue);
		return queue;
	}
	
	public String longestPrefixOf(String query){
		int length = search(root, query, 0, 0);
		return query.substring(0, length);
	}
	
	
	private void collect(Node x, String prefix, Queue<String> queue){
		/**
		 * prefix = sequence of characters from root to x
		 */
		if(x==null) return;
		if(x.value!=null) queue.offer(prefix);		//collecting complete keys only
		for(char i=0; i<R; i++)
			collect(x.next[i], prefix+i, queue);
	}
	
	private int search(Node x, String query, int index, int length){
		if(x==null) return length;
		if(x.value!=null) length = index;
		if(index == query.length()) return length; 
		char c = query.charAt(index);
		return search(x.next[c], query, index+1, length);
	}
	
	public static void main(String[] args){
		TrieST<Double> t = new TrieST<Double>();
		t.put("one", 1.00);
		t.put("oneandhalf", 1.50);
		t.put("two", 2.00);
		t.put("twopointfive", 2.50);
		t.put("three", 3.00);
		t.put("four", 4.00);
		t.put("five", 5.00);
		t.put("six", 6.00);
		t.put("seven", 7.00);
		t.put("eight", 8.00);
		t.put("nine", 9.00);
		t.put("ten", 10.00);
		t.put("tenandone", 11.00);
		t.put("tenandtwo", 12.00);
		t.put("tenandthree", 13.00);
		t.put("tenandfour", 14.00);
		
		/*printing keys - ordered iteration*/
		for(String s: t.keys())
			System.out.print(s+" ");
		System.out.println();
		
		/*keysWithPrefix*/
		for(String s: t.keysWithPrefix("ch"))
			System.out.print(s+" ");
		System.out.println();
		
		/*longestPrefixOf*/
		System.out.println(t.longestPrefixOf("eightysixpointfive"));
		System.out.println(t.longestPrefixOf("onehundred"));
		System.out.println(t.longestPrefixOf("maruti").equals(""));
	}
}
