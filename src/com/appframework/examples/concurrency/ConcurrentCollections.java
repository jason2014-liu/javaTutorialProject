/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: ConcurrentCollections.java
 * @Package com.appframework.examples.concurrency
 * @author jason.liu
 * @Date 2014-10-20 下午4:35:51
 * @Version v1.0
 */
package com.appframework.examples.concurrency;

/**
 * TODO
 * 
 * @ClassName: ConcurrentCollections
 * @author jason.liu
 */
public class ConcurrentCollections {

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * CopyOnWriteArraySet is a Set implementation backed up by a
		 * copy-on-write array. All mutative operations, such as add, set, and
		 * remove, are implemented by making a new copy of the array; no locking
		 * is ever required. Even iteration may safely proceed concurrently with
		 * element insertion and deletion. Unlike most Set implementations, the
		 * add, remove, and contains methods require time proportional to the
		 * size of the set. This implementation is only appropriate for sets
		 * that are rarely modified but frequently iterated. It is well suited
		 * to maintaining event-handler lists that must prevent duplicates.
		 */

		/**
		 * CopyOnWriteArrayList is a List implementation backed up by a
		 * copy-on-write array. This implementation is similar in nature to
		 * CopyOnWriteArraySet. No synchronization is necessary, even during
		 * iteration, and iterators are guaranteed never to throw
		 * ConcurrentModificationException. This implementation is well suited
		 * to maintaining event-handler lists, in which change is infrequent,
		 * and traversal is frequent and potentially time-consuming.
		 */

		/**
		 * WeakHashMap is an implementation of the Map interface that stores
		 * only weak references to its keys. Storing only weak references allows
		 * a key-value pair to be garbage-collected when its key is no longer
		 * referenced outside of the WeakHashMap. This class provides the
		 * easiest way to harness the power of weak references. It is useful for
		 * implementing "registry-like" data structures, where the utility of an
		 * entry vanishes when its key is no longer reachable by any thread.
		 */

		/**
		 * The java.util.concurrent package contains the ConcurrentMap
		 * interface, which extends Map with atomic putIfAbsent, remove, and
		 * replace methods, and the ConcurrentHashMap implementation of that
		 * interface.
		 * 
		 * ConcurrentHashMap is a highly concurrent, high-performance
		 * implementation backed up by a hash table. This implementation never
		 * blocks when performing retrievals and allows the client to select the
		 * concurrency level for updates. It is intended as a drop-in
		 * replacement for Hashtable: in addition to implementing ConcurrentMap,
		 * it supports all the legacy methods peculiar to Hashtable. Again, if
		 * you don't need the legacy operations, be careful to manipulate it
		 * with the ConcurrentMap interface.
		 */

		/**
		 * LinkedBlockingQueue — an optionally bounded FIFO blocking queue
		 * backed by linked nodes ArrayBlockingQueue — a bounded FIFO blocking
		 * queue backed by an array PriorityBlockingQueue — an unbounded
		 * blocking priority queue backed by a heap DelayQueue — a time-based
		 * scheduling queue backed by a heap SynchronousQueue — a simple
		 * rendezvous mechanism that uses the BlockingQueue interface
		 */
	}

}
