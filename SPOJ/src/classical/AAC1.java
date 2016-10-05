package classical;

/**
 * @author Kunal
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


public class AAC1 {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();
		Task1 solver = new Task1();
		solver.solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis() - start;
		out.close();
	}
	
	static class DirectedEdge {
		private int v, w;
		private double weight;
		
		public DirectedEdge(int v, int w, double weight){
			this.v=v;
			this.w=w;
			this.weight=weight;
		}
		
		public int from(){
			return v;
		}
		
		public int to(){
			return w;
		}
		
		public double weight(){
			return weight;
		}
	}
	
	static class EdgeWeightedDigraph {
		private final int V;
		private LinkedList<DirectedEdge>[] adj;
		
		@SuppressWarnings("unchecked")
		public EdgeWeightedDigraph(int V){
			this.V=V;
			adj=(LinkedList<DirectedEdge>[])new LinkedList[V];
			for(int i=0; i<V; i++){
				adj[i]=new LinkedList<DirectedEdge>();
			}
		}
		
		public void addEdge(DirectedEdge e){
			adj[e.from()].add(e);
		}
		
		public Iterable<DirectedEdge> adj(int v){
			return adj[v];
		}
		
		public int V(){
			return V;	//number of vertices
		}
	}

	static class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
	    private int maxN;        // maximum number of elements on PQ
	    private int N;           // number of elements on PQ
	    private int[] pq;        // binary heap using 1-based indexing
	    private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
	    private Key[] keys;      // keys[i] = priority of i

	    /**
	     * Initializes an empty indexed priority queue with indices between <tt>0</tt>
	     * and <tt>maxN - 1</tt>.
	     * @param  maxN the keys on this priority queue are index from <tt>0</tt>
	     *         <tt>maxN - 1</tt>
	     * @throws IllegalArgumentException if <tt>maxN</tt> &lt; <tt>0</tt>
	     */
	    @SuppressWarnings("unchecked")
		public IndexMinPQ(int maxN) {
	        if (maxN < 0) throw new IllegalArgumentException();
	        this.maxN = maxN;
	        keys = (Key[]) new Comparable[maxN + 1];    // make this of length maxN??
	        pq   = new int[maxN + 1];
	        qp   = new int[maxN + 1];                   // make this of length maxN??
	        for (int i = 0; i <= maxN; i++)
	            qp[i] = -1;
	    }

	    /**
	     * Returns true if this priority queue is empty.
	     *
	     * @return <tt>true</tt> if this priority queue is empty;
	     *         <tt>false</tt> otherwise
	     */
	    public boolean isEmpty() {
	        return N == 0;
	    }

	    /**
	     * Is <tt>i</tt> an index on this priority queue?
	     *
	     * @param  i an index
	     * @return <tt>true</tt> if <tt>i</tt> is an index on this priority queue;
	     *         <tt>false</tt> otherwise
	     * @throws IndexOutOfBoundsException unless 0 &le; <tt>i</tt> &lt; <tt>maxN</tt>
	     */
	    public boolean contains(int i) {
	        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
	        return qp[i] != -1;
	    }

	    /**
	     * Returns the number of keys on this priority queue.
	     *
	     * @return the number of keys on this priority queue
	     */
	    public int size() {
	        return N;
	    }

	    /**
	     * Associates key with index <tt>i</tt>.
	     *
	     * @param  i an index
	     * @param  key the key to associate with index <tt>i</tt>
	     * @throws IndexOutOfBoundsException unless 0 &le; <tt>i</tt> &lt; <tt>maxN</tt>
	     * @throws IllegalArgumentException if there already is an item associated
	     *         with index <tt>i</tt>
	     */
	    public void insert(int i, Key key) {
	        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
	        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
	        N++;
	        qp[i] = N;
	        pq[N] = i;
	        keys[i] = key;
	        swim(N);
	    }

	    /**
	     * Returns an index associated with a minimum key.
	     *
	     * @return an index associated with a minimum key
	     * @throws NoSuchElementException if this priority queue is empty
	     */
	    public int minIndex() {
	        if (N == 0) throw new NoSuchElementException("Priority queue underflow");
	        return pq[1];
	    }

	    /**
	     * Returns a minimum key.
	     *
	     * @return a minimum key
	     * @throws NoSuchElementException if this priority queue is empty
	     */
	    public Key minKey() {
	        if (N == 0) throw new NoSuchElementException("Priority queue underflow");
	        return keys[pq[1]];
	    }

	    /**
	     * Removes a minimum key and returns its associated index.
	     * @return an index associated with a minimum key
	     * @throws NoSuchElementException if this priority queue is empty
	     */
	    public int delMin() {
	        if (N == 0) throw new NoSuchElementException("Priority queue underflow");
	        int min = pq[1];
	        exch(1, N--);
	        sink(1);
	        assert min == pq[N+1];
	        qp[min] = -1;        // delete
	        keys[min] = null;    // to help with garbage collection
	        pq[N+1] = -1;        // not needed
	        return min;
	    }

	    /**
	     * Returns the key associated with index <tt>i</tt>.
	     *
	     * @param  i the index of the key to return
	     * @return the key associated with index <tt>i</tt>
	     * @throws IndexOutOfBoundsException unless 0 &le; <tt>i</tt> &lt; <tt>maxN</tt>
	     * @throws NoSuchElementException no key is associated with index <tt>i</tt>
	     */
	    public Key keyOf(int i) {
	        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
	        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
	        else return keys[i];
	    }

	    /**
	     * Change the key associated with index <tt>i</tt> to the specified value.
	     *
	     * @param  i the index of the key to change
	     * @param  key change the key associated with index <tt>i</tt> to this key
	     * @throws IndexOutOfBoundsException unless 0 &le; <tt>i</tt> &lt; <tt>maxN</tt>
	     * @throws NoSuchElementException no key is associated with index <tt>i</tt>
	     */
	    public void changeKey(int i, Key key) {
	        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
	        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
	        keys[i] = key;
	        swim(qp[i]);
	        sink(qp[i]);
	    }

	    /**
	     * Change the key associated with index <tt>i</tt> to the specified value.
	     *
	     * @param  i the index of the key to change
	     * @param  key change the key associated with index <tt>i</tt> to this key
	     * @throws IndexOutOfBoundsException unless 0 &le; <tt>i</tt> &lt; <tt>maxN</tt>
	     * @deprecated Replaced by {@link #changeKey(int, Key)}.
	     */
	    public void change(int i, Key key) {
	        changeKey(i, key);
	    }

	    /**
	     * Decrease the key associated with index <tt>i</tt> to the specified value.
	     *
	     * @param  i the index of the key to decrease
	     * @param  key decrease the key associated with index <tt>i</tt> to this key
	     * @throws IndexOutOfBoundsException unless 0 &le; <tt>i</tt> &lt; <tt>maxN</tt>
	     * @throws IllegalArgumentException if key &ge; key associated with index <tt>i</tt>
	     * @throws NoSuchElementException no key is associated with index <tt>i</tt>
	     */
	    public void decreaseKey(int i, Key key) {
	        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
	        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
	        if (keys[i].compareTo(key) <= 0)
	            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
	        keys[i] = key;
	        swim(qp[i]);
	    }

	    /**
	     * Increase the key associated with index <tt>i</tt> to the specified value.
	     *
	     * @param  i the index of the key to increase
	     * @param  key increase the key associated with index <tt>i</tt> to this key
	     * @throws IndexOutOfBoundsException unless 0 &le; <tt>i</tt> &lt; <tt>maxN</tt>
	     * @throws IllegalArgumentException if key &le; key associated with index <tt>i</tt>
	     * @throws NoSuchElementException no key is associated with index <tt>i</tt>
	     */
	    public void increaseKey(int i, Key key) {
	        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
	        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
	        if (keys[i].compareTo(key) >= 0)
	            throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
	        keys[i] = key;
	        sink(qp[i]);
	    }

	    /**
	     * Remove the key associated with index <tt>i</tt>.
	     *
	     * @param  i the index of the key to remove
	     * @throws IndexOutOfBoundsException unless 0 &le; <tt>i</tt> &lt; <tt>maxN</tt>
	     * @throws NoSuchElementException no key is associated with index <t>i</tt>
	     */
	    public void delete(int i) {
	        if (i < 0 || i >= maxN) throw new IndexOutOfBoundsException();
	        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
	        int index = qp[i];
	        exch(index, N--);
	        swim(index);
	        sink(index);
	        keys[i] = null;
	        qp[i] = -1;
	    }


	   /***************************************************************************
	    * General helper functions.
	    ***************************************************************************/
	    private boolean greater(int i, int j) {
	        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	    }

	    private void exch(int i, int j) {
	        int swap = pq[i];
	        pq[i] = pq[j];
	        pq[j] = swap;
	        qp[pq[i]] = i;
	        qp[pq[j]] = j;
	    }


	   /***************************************************************************
	    * Heap helper functions.
	    ***************************************************************************/
	    private void swim(int k) {
	        while (k > 1 && greater(k/2, k)) {
	            exch(k, k/2);
	            k = k/2;
	        }
	    }

	    private void sink(int k) {
	        while (2*k <= N) {
	            int j = 2*k;
	            if (j < N && greater(j, j+1)) j++;
	            if (!greater(k, j)) break;
	            exch(k, j);
	            k = j;
	        }
	    }


	   /***************************************************************************
	    * Iterators.
	    ***************************************************************************/

	    /**
	     * Returns an iterator that iterates over the keys on the
	     * priority queue in ascending order.
	     * The iterator doesn't implement <tt>remove()</tt> since it's optional.
	     *
	     * @return an iterator that iterates over the keys in ascending order
	     */
	    public Iterator<Integer> iterator() { return new HeapIterator(); }

	    private class HeapIterator implements Iterator<Integer> {
	        // create a new pq
	        private IndexMinPQ<Key> copy;

	        // add all elements to copy of heap
	        // takes linear time since already in heap order so no keys move
	        public HeapIterator() {
	            copy = new IndexMinPQ<Key>(pq.length - 1);
	            for (int i = 1; i <= N; i++)
	                copy.insert(pq[i], keys[pq[i]]);
	        }

	        public boolean hasNext()  { return !copy.isEmpty();                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public Integer next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            return copy.delMin();
	        }
	    }
	}
	
	static class DijkstraSP {
		private double[] distTo;
		private DirectedEdge[] edgeTo;
		private IndexMinPQ<Double> pq;
		
		public DijkstraSP(EdgeWeightedDigraph G, int s){
			distTo= new double[G.V()];
			edgeTo= new DirectedEdge[G.V()];
			pq= new IndexMinPQ<Double>(G.V());			//maxN = G.V()
			
			for(int i=0; i<G.V(); i++){
				distTo[i]=Double.POSITIVE_INFINITY;
			}
			distTo[s]=0.0;
			
			pq.insert(s, 0.0);
			while(!pq.isEmpty()){
				int v = pq.delMin();
				for(DirectedEdge e: G.adj(v)){
					relax(e);
				}
			}
		}
		
		private void relax(DirectedEdge e){
			int v=e.from(), w=e.to();
			if(distTo[w] > distTo[v]+e.weight()){
				distTo[w]= distTo[v]+e.weight();
				edgeTo[w]= e;
				
				if(pq.contains(w))	pq.decreaseKey(w, distTo[w]);
				else				pq.insert(w, distTo[w]);
			}
		}
		
		public double distTo(int v){
			return distTo[v];
		}
	}
	
	static class Task1 {
		public void solve(InputReader in, PrintWriter out) {
			int t=in.nextInt();
			for(int i=0; i<t; i++){
				int n=in.nextInt(), m=in.nextInt();
				EdgeWeightedDigraph G=new EdgeWeightedDigraph(n+1);
				for(int j=0; j<m; j++){
					int a=in.nextInt();
					int b=in.nextInt();
					G.addEdge(new DirectedEdge(a,b,1.0));
					G.addEdge(new DirectedEdge(b,a,1.0));
				}
				
				DijkstraSP d=new DijkstraSP(G, 1);
				out.println((int)d.distTo(n));
			}
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
