package tries;

import java.util.ArrayDeque;
import java.util.Queue;

public class TST<Value> {
	Node root;
	
	static class Node{
		char c;
		Object value;
		Node left, mid, right;
	}
	
	public void put(String key, Value val){
		root=put(root, key, val, 0);
	}
	
	@SuppressWarnings("unchecked")
	public Value get(String key){
		Node x=get(root, key, 0);
		if(x==null) return null;
		return (Value)x.value;
	}
	
	public Iterable<String> keys(){
		Queue<String> q=new ArrayDeque<String>();
		collectKeys(root , "" , q);
		return q;
	}
	
	public Iterable<String> keysWithPrefix(String prefix){
		Queue<String> q=new ArrayDeque<String>();
		Node x=get(root, prefix, 0);
		collectPrefix(x, prefix, q);
		return q;
	}
	
	public String longestPrefixOf(String s){
		Node x=root;
		int length=0, i=0;
		while(i<s.length()){
			if(x==null) break;
			if(s.charAt(i)==x.c){
				if(x.value!=null) length = i+1;
				x=x.mid;
				i++;
			}
			else if(s.charAt(i)<x.c) x=x.left;
			else if(s.charAt(i)>x.c) x=x.right;
		}
		return s.substring(0, length);
	}
	
	private void collectKeys(Node x, String prefix, Queue<String> q){
		if(x==null) return;
		if(x.value!=null) q.offer(prefix+x.c);
		if(x.mid!=null) collectKeys(x.mid, prefix+x.c, q);
		if(x.left!=null) collectKeys(x.left, prefix, q);
		if(x.right!=null) collectKeys(x.right, prefix, q);
	}
	
	private void collectPrefix(Node x, String prefix, Queue<String> q){
		if(x==null) return;
		if(x.value!=null) q.offer(prefix);
		if(x.mid!=null) collectPrefix(x.mid, prefix+x.mid.c, q);
	}
	
	private Node put(Node x, String key, Value val, int index){
		char c=key.charAt(index);
		if(x==null){
			x=new Node();
			x.c=c;
		}
		if(index==key.length()-1) x.value=val;
		else if(c < x.c) x.left=put(x.left, key, val, index);
		else if(c > x.c) x.right=put(x.right, key, val, index);
		else x.mid=put(x.mid, key, val, index+1);
		
		return x;
	}
	
	private Node get(Node x, String key, int index){
		if(x==null) return null;
		char c=key.charAt(index);
		if(index==key.length()-1) return x;
		else if(c > x.c) return get(x.right, key, index);
		else if(c < x.c) return get(x.left, key, index);
		else return get(x.mid, key, index+1);
	}
	
	/*demo*/
	public static void main(String[] args){
		TST<Double> st=new TST<Double>();
		st.put("Kunal", 45.5);
		st.put("Kunala", 46.6);
		st.put("Hero", 4.0);
		st.put("Bheem", 5.5);
		
		//System.out.println(st.get("Bheem"));
		/*for(String s: st.keys()){
			System.out.println(s);
		}*/
		System.out.println(st.longestPrefixOf("KunalChaudhary"));
	}
}
