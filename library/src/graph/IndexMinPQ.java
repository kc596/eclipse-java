package graph;

public class IndexMinPQ<Key extends Comparable<Key>>{
	private int[] a, b;
	private Key[] keys;
	private int N, maxN;
	
	@SuppressWarnings("unchecked")
	public IndexMinPQ(int capacity){
		this.maxN=capacity-1; this.N=0;
		this.a=new int[maxN+1];	this.b=new int[maxN+1];
		this.keys=(Key[])new Comparable[maxN+1];
		for(int i=0; i<maxN+1; i++) a[i]=-1;	
	}
	
	public boolean isEmpty(){ return N==0; }

	public int size(){ return N; }

	public boolean contains(int index){ return a[index] != -1; }

	public void insert(int index, Key key){
		N++;
		a[index]=N-1; b[N-1]=index;
		keys[index]=key;
		swim(N-1);
	}

	public int minIndex(){ return b[0]; }

	public Key minKey(){ return keys[b[0]]; }

	public Key keyOf(int index){ return keys[index]; }

	public int delMin(){
		int min=b[0];
		exch(0,--N);
		sink(0);
		a[min]= -1;
		b[N]= -1;
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

	/* General Helper Functions */
	private boolean greater(int i, int j){
		return keys[b[i]].compareTo( keys[b[j]] ) > 0;
	}

	private void exch(int i, int j){
		int swap=b[i];
		b[i]=b[j];	b[j]=swap;
		a[b[i]]=i;	a[b[j]]=j;
	}

	/* Heap Helper Functions */
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
				if(greater(child, child+1)) child++;
			if(greater(root, child))
				exch(root, child);
			else break;

			root=child;
			child=2*root+1;
		}
	}
}