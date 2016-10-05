package tries;

import java.util.ArrayDeque;
import java.util.Queue;

public class TrieST<Value> {
	int R=256;
	Node root=new Node();
	
	static class Node{
		Object value;
		Node[] next=new Node[256];
	}
	
	public void put(String key, Value val){
		root=put(key, val, root, 0);
	}
	
	@SuppressWarnings("unchecked")
	public Value get(String key){
		Node x=get(root, key, 0);
		if(x==null) return null;
		return (Value)x.value;
	}

	public Iterable<String> keysWithPrefix(String s){
		Queue<String> q=new ArrayDeque<String>();
		Node x=get(root, s, 0);	//root for subtree for all strings beginning with s
		collect(x, s, q);
		return q;
	}
	
	private void collect(Node x, String prefix, Queue<String> q){
		if(x==null) return;
		if(x.value!=null) q.offer(prefix);
		for(char c=0; c<R; c++)
			collect(x.next[c], prefix+c, q);
	}
	
	private Node put(String key, Value val, Node x, int index){
		if(x==null) x=new Node();
		if(index==key.length()) x.value=val;
		else{
			char c=key.charAt(index);
			x.next[c]=put(key, val, x.next[c], index+1);
		}
		return x;
	}
	
	private Node get(Node x, String key, int index){
		if(index==key.length()) return x;
		char c=key.charAt(index);
		if(x.next[c]==null) return null;
		return get(x.next[c], key, index+1);
	}
	
	/*demo*/
	public static void main(String[] args){
		TrieST<Double> st=new TrieST<Double>();
		st.put("Kunal", 45.5);
		st.put("Kumbayasi", 15.5);
		st.put("Kunala", 46.6);
		st.put("Hero", 4.0);
		st.put("Bheem", 5.5);
		
		System.out.println(st.get("Z"));
		for(String s: st.keysWithPrefix("Ku"))
			System.out.println(s);
	}
}
