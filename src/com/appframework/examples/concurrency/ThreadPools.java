/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: ThreadPools.java
 * @Package com.appframework.examples.concurrency
 * @author jason.liu
 * @Date 2014-10-17 下午2:25:32
 * @Version v1.0
 */
package com.appframework.examples.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * TODO
 * 
 * @ClassName: ThreadPools
 * @author jason.liu
 */
public class ThreadPools {

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * Creates a thread pool that reuses a fixed number of threads operating
		 * off a shared unbounded queue.The threads in the pool will exist until
		 * it is explicitly shutdown.
		 */
		ExecutorService fixES = Executors.newFixedThreadPool(10);

		/**
		 * Creates a thread pool that creates new threads as needed, but will
		 * reuse previously constructed threads when they are available. These
		 * pools will typically improve the performance of programs that execute
		 * many short-lived asynchronous tasks. Calls to execute will reuse
		 * previously constructed threads if available. If no existing thread is
		 * available, a new thread will be created and added to the pool.
		 * Threads that have not been used for sixty seconds are terminated and
		 * removed from the cache. Thus, a pool that remains idle for long
		 * enough will not consume any resources.
		 */
		ExecutorService cachedES = Executors.newCachedThreadPool();

		/**
		 * Creates an Executor that uses a single worker thread operating off an
		 * unbounded queue. Unlike the otherwise equivalent
		 * newFixedThreadPool(1) the returned executor is guaranteed not to be
		 * reconfigurable to use additional threads.
		 */
		ExecutorService singleES = Executors.newSingleThreadExecutor();

		/**
		 * Creates a thread pool that can schedule commands to run after a given
		 * delay, or to execute periodically.
		 */
		ScheduledExecutorService scheduledES = Executors
				.newScheduledThreadPool(10);

		/**
		 * The ThreadPoolExecutor class provides an extensible thread pool
		 * implementation. ThreadPoolExecutor(int corePoolSize, int
		 * maximumPoolSize, long keepAliveTime, TimeUnit unit,
		 * BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler)
		 */

		/**
		 * public interface Callable<V> A task that returns a result and may
		 * throw an exception. Implementors define a single method with no
		 * arguments called call.
		 * 
		 * The Callable interface is similar to Runnable, in that both are
		 * designed for classes whose instances are potentially executed by
		 * another thread. A Runnable, however, does not return a result and
		 * cannot throw a checked exception.
		 */
		FutureTask<String> future = new FutureTask<String>(
				new Callable<String>() {

					@Override
					public String call() throws Exception {
						// TODO Auto-generated method stub
						// excute task
						Thread.sleep(5000);
						return "call method is invoked";
					}

				});

		fixES.execute(future);

		try {
			/**
			 * Waits if necessary for at most the given time for the computation
			 * to complete, and then retrieves its result, if available.
			 */
			System.out.println("future task is done,return:"
					+ future.get(3l, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("future task execute timeout.");

			while (!future.isCancelled()) {

//				try {
//					Thread.sleep(4000);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				future.cancel(false);
			}

			if (future.isCancelled()) {
				System.out.println("future task is cancelled.");
			}
			if (!future.isCancelled() && future.isDone()) {
				
				try {
					System.out.println("future task is done,return:"
							+ future.get());
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExecutionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

	}

}
