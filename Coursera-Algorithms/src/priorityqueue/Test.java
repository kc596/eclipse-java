package priorityqueue;

/**
 * @author Kunal
 *
 */

public class Test {
	public static void main(String[] args){
		MaxPQ<Integer> q=new MaxPQ<Integer>(10);
		q.insert(5);
		q.insert(10);
		q.insert(15);
		q.insert(20);
		q.insert(25);
		
		q.printQueue();
		System.out.println(q.delMax());
		q.printQueue();
	}
}
