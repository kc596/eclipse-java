package tries;

/**
 * Ternary Search Trie
 * @author Kunal
 */

public class TST<Value> {
	private Node root;
	
	private class Node{
		private char c;
		private Value value;
		private Node left, mid, right;
	}
	
	public void put(String key, Value value){
		root = put(root, key, value, 0);
	}
	
	private Node put(Node x, String key, Value value, int index){
		char c = key.charAt(index);
		if(x==null){
			x=new Node();
			x.c = c;
		}
		if		(c < x.c) x.left = put(x.left, key, value, index);
		else if	(c > x.c) x.right = put(x.right, key, value, index);
		else if	(index < key.length()-1) x.mid = put(x.mid, key, value, index+1);
		else x.value = value;
		
		return x;
	}
	
	public Value get(String key){
		Node x = get(root,key,0);
		if(x==null) return null;
		else return x.value;
	}
	
	private Node get(Node x, String key, int index){
		if(x == null) return null;
		char c = key.charAt(index);
		if		(c < x.c) return get(x.left, key, index);
		else if	(c > x.c) return get(x.right, key, index);
		else if	(index < key.length()-1) return get(x.mid, key, index+1);
		else return x;
	}
	
	public static void main(String[] main){
		TST<Integer> t = new TST<Integer>();
		t.put("hello", 10);
		t.put("hey", 11);
		t.put("hi", 12);
		t.put("alas", 15);
		
		System.out.println(t.root.c);
	}
}
