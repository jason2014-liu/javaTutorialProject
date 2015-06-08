/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: SimpleThreads.java
 * @Package com.appframework.examples.concurrency
 * @author jason.liu
 * @Date 2014-10-10 下午2:13:54
 * @Version v1.0
 */
package com.appframework.examples.concurrency;

/**
 * TODO
 * 
 * @ClassName: SimpleThreads
 * @author jason.liu
 */
public class SimpleThreads {

	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();

		System.out.format("%s:%s%n", threadName, message);
	}

	private static class MessageLoop implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String importantInfo[] = { "Mares eat oats", "Does eat oats",
					"Little lambs eat ivy", "A kid will eat ivy too" };

			try {
				for (int i = 0; i < importantInfo.length; i++) {

					// pause for 4 seconds
					Thread.sleep(4000);

					threadMessage(importantInfo[i]);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				threadMessage("I wasn't done!");
			}
		}

	}

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// delay,in milliseconds before we interrupt MessageLoop thread(default
		// one hour)
		long patience = 1000 * 60 * 60;

		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();

		threadMessage("Waiting for MessageLoop thread to finish");
		// loop until MessageLoop thread exits
		while (t.isAlive()) {
			threadMessage("Still waiting ...");
			/**
			 * If t is a Thread object whose thread is currently executing,
			 * t.join(); causes the current thread to pause execution until t's
			 * thread terminates.
			 */
			// wait maximum of 1 second for MessageLoop thread to finish
			t.join(1000);
			if (((System.currentTimeMillis() - startTime) > patience)
					&& t.isAlive()) {

				threadMessage("Tired of waiting!");

				// Interrupts this thread.
				t.interrupt();

				// Shouldn't be long now -- wait indefinitely
				// A timeout of 0 means to wait forever.
				t.join();
			}
		}

		threadMessage("Finally!");

	}

}
