/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: Safelock.java
 * @Package com.appframework.examples.concurrency
 * @author jason.liu
 * @Date 2014-10-13 上午10:11:05
 * @Version v1.0
 */
package com.appframework.examples.concurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 * 
 * @ClassName: Safelock
 * @author jason.liu
 */
public class Safelock {

	static class Friend {

		private String name;
		private final Lock lock = new ReentrantLock();

		public Friend(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public boolean impendingBow(Friend bower) {

			Boolean myLock = false;
			Boolean yourLock = false;

			try {
				/**
				 * Acquires the lock if it is available and returns immediately
				 * with the value true. If the lock is not available then this
				 * method will return immediately with the value false.
				 */
				myLock = lock.tryLock();
				yourLock = bower.lock.tryLock();
			} finally {

				if (!(myLock && yourLock)) {
					if (myLock) {
						// Releases the lock.
						lock.unlock();
					}
					if (yourLock) {
						bower.lock.unlock();
					}
				}
			}

			return myLock && yourLock;
		}

		public void bow(Friend bower) {

			if (impendingBow(bower)) {
				try {
					System.out.format("%s: %s has bowed to me!%n", this.name,
							bower.name);

					bower.bowBack(this);
				} finally {

					lock.unlock();
					bower.lock.unlock();
				}
			} else {
				System.out
						.format("%s: %s started to bow to me, but saw that I was already bowing to him.%n",
								this.name, bower.getName());
			}

		}

		public void bowBack(Friend bower) {
			System.out.format("%s: %s has bowed back to me!%n", this.name,
					bower.getName());
		}
	}

	static class BowLoop implements Runnable {

		private Friend bower;
		private Friend bowee;

		public BowLoop(Friend bower, Friend bowee) {
			this.bower = bower;
			this.bowee = bowee;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Random random = new Random();

			for (;;) {
				try {
					Thread.sleep(random.nextInt(10));
				} catch (InterruptedException e) {
					bowee.bow(bower);
				}
			}
		}

	}

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");

		new Thread(new BowLoop(alphonse, gaston)).start();
		new Thread(new BowLoop(gaston, alphonse)).start();
		
	}
}
