/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: QuoteServer.java
 * @Package com.appframework.examples.net
 * @author jason.liu
 * @Date 2014-10-8 下午3:24:40
 * @Version v1.0
 */
package com.appframework.examples.net;

import java.io.IOException;

/**
 * TODO
 * 
 * @ClassName: QuoteServer
 * @author jason.liu
 */
public class QuoteServer {

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/**
		 * Causes this thread to begin execution; the Java Virtual Machine calls
		 * the run method of this thread. The result is that two threads are
		 * running concurrently: the current thread (which returns from the call
		 * to the start method) and the other thread (which executes its run
		 * method). It is never legal to start a thread more than once. In
		 * particular, a thread may not be restarted once it has completed
		 * execution. 
		 * Throws: IllegalThreadStateException - if the thread was
		 * already started.
		 */
		new QuoteServerThread().start();
	}

}
