/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: NomalCollections.java
 * @Package com.appframework.examples.concurrency
 * @author jason.liu
 * @Date 2014-10-20 下午4:37:55
 * @Version v1.0
 */
package com.appframework.examples.concurrency;

/**
 * TODO
 * 
 * @ClassName: NomalCollections
 * @author jason.liu
 */
public class NomalCollections {

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * The iterators returned by the iterator method of the collections
		 * returned by all of this class's "collection view methods" are
		 * fail-fast: if the Hashtable is structurally modified at any time
		 * after the iterator is created, in any way except through the
		 * iterator's own remove method, the iterator will throw a
		 * ConcurrentModificationException. Thus, in the face of concurrent
		 * modification, the iterator fails quickly and cleanly, rather than
		 * risking arbitrary, non-deterministic behavior at an undetermined time
		 * in the future. The Enumerations returned by Hashtable's keys and
		 * elements methods are not fail-fast.
		 * 
		 * Note that the fail-fast behavior of an iterator cannot be guaranteed
		 * as it is, generally speaking, impossible to make any hard guarantees
		 * in the presence of unsynchronized concurrent modification. Fail-fast
		 * iterators throw ConcurrentModificationException on a best-effort
		 * basis. Therefore, it would be wrong to write a program that depended
		 * on this exception for its correctness: the fail-fast behavior of
		 * iterators should be used only to detect bugs.
		 */
	}

}
