package priorityqueue;

/**
* @author Kunal Chaudhary
*
*/
public class IndexMinPQ<Key extends Comparable<Key>>{
	private int[] a;		//inverse of b
	private int[] b;		//binary heap using 0 based indexing
	private Key[] keys;		//keys[i]=priority of i
	private int N;			//Number of elements on the heap
	private int maxN;		//maximum index of N (capacity-1)
	/**
	* Note that in API also index will be from 0 to N-1.
	* Array b is for storing the index by which we will retive our key.
	* Array a is a converter that converts "API index" to index of heap.
	* Basically what we will do is that we will insert the key into "keys" array and the index into array "b".
	*	i.e., b[a[i]]=index through which we will retrive the key.
	*/
	@SuppressWarnings("unchecked")
	public IndexMinPQ(int capacity){
		this.maxN=capacity-1;					//minN==0 && maxN==capacity-1
		this.N=0;								//number of elements on the heap=0
		this.a=new int[maxN+1];					//inverse of b
		this.b=new int[maxN+1];					//our binary heap
		this.keys=(Key[])new Comparable[maxN+1];

		for(int i=0; i<maxN+1; i++) a[i]=-1;	
	}
	
	public boolean isEmpty(){ return N==0; }

	public int size(){ return N; }

	public boolean contains(int index){
		if(index<0 || index>maxN) throw new IndexOutOfBoundsException();
		return a[index] != -1;
	}

	public void insert(int index, Key key){
		if(index<0 || index>maxN) throw new IndexOutOfBoundsException();
		if(contains(index)) throw new IllegalArgumentException("Index is alreay on the queue.");
		N++;									//increase the number of elements on heap
		a[index]=N-1;							//API index handler (or API to heap index)
		b[N-1]=index;							//put the index on heap
		keys[index]=key;						//store the key according to its API index
		swim(N-1);								//swim the element to appropriate position on heap
	}

	public int minIndex(){ return b[0]; }

	public Key minKey(){ return keys[b[0]]; }

	public Key keyOf(int index){ return keys[index]; }

	public int delMin(){
		int min=b[0];
		exch(0,--N);
		sink(0);
		a[min]= -1;			//delete
		b[N]= -1;			//not needed since N is already decremented
		return min;
	}

	public void changeKey(int index, Key newKey){
		if(contains(index)){
			keys[index]=newKey;
			swim(a[index]);
			sink(a[index]);
		}
		else throw new IllegalArgumentException("There is no key associated with this index.");
	}

	/**********************************************************************************************
	General Helper Functions
	**********************************************************************************************/
	private boolean greater(int i, int j){
		/* i and j are heap indices */
		return keys[b[i]].compareTo( keys[b[j]] ) > 0;
	}

	private void exch(int i, int j){
		/* i and j are heap indices */
		int swap=b[i];
		b[i]=b[j];
		b[j]=swap;

		a[b[i]]=i;
		a[b[j]]=j;
	}

	/**********************************************************************************************
	Heap Helper Functions
	Since this is a min-heap so root should be smaller than children.
	**********************************************************************************************/
	private void swim(int child){
		int root=(child-1)/2;
		while(greater(root, child)){
			exch(root, child);
			child=root;
			root=(child-1)/2;
		}
	}

	private void sink(int root){
		int child=2*root +1;
		while(child<N){
			if(child<N-1)
				if(greater(child, child+1)) child++;	//smaller child
			if(greater(root, child))
				exch(root, child);
			else break;

			root=child;
			child=2*root+1;
		}
	}

	/**********************************************************************************************
	demo
	**********************************************************************************************/
	public static void main(String[] args){
		IndexMinPQ<Integer> PQ=new IndexMinPQ<Integer>(10);
		PQ.insert(1,10);
		PQ.insert(2,20);
		PQ.insert(3,30);
		PQ.insert(4,5);
		PQ.insert(5,2);
		PQ.insert(6,6);

		while(!PQ.isEmpty()) System.out.println(" Element: "+PQ.keyOf(PQ.delMin()));
		//System.out.println(PQ.isEmpty());
		//System.out.println(PQ.contains(4));

		PQ.insert(4,10);
		PQ.insert(2,20);
		PQ.insert(3,30);
		PQ.insert(9,5);
		PQ.insert(5,2);
		PQ.insert(6,6);
		PQ.changeKey(4,44);
		//PQ.changeKey(8,44);
		System.out.println(PQ.contains(9));
		while(!PQ.isEmpty()) System.out.println(" Element: "+PQ.keyOf(PQ.delMin()));
	}
}