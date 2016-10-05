package binarysearchtree;

/**
 * @author Kunal
 *
 */

public class BSTDemo {
	public static void main(String[] args) {
		BST<Integer, Character> b=new BST<Integer, Character>();
		b.put(0, 'k');
		b.put(3, 'u');
		b.put(5, 'n');
		b.put(7, 'a');
		b.put(9, 'l');
		
		System.out.println(b.ceil(6)+" "+b.size()+" "+b.rank(3));
		b.deleteMin();
		System.out.println(b.get(5)+" "+b.floor(4)+" "+b.ceil(4));
		
	}

}
