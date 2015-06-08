/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: MulticastServerThread.java
 * @Package com.appframework.examples.net
 * @author jason.liu
 * @Date 2014-10-9 上午9:51:43
 * @Version v1.0
 */
package com.appframework.examples.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;

/**
 * TODO
 * 
 * @ClassName: MulticastServerThread
 * @author jason.liu
 */
public class MulticastServerThread extends QuoteServerThread {

	private long FIVE_SECOND = 5000;

	// Default constructor cannot handle exception type IOException thrown by
	// implicit super
	// constructor. Must define an explicit constructor
	public MulticastServerThread() throws IOException {
		super("MulticastServerThread");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (moreQuotes) {

			try {

				byte[] buf = new byte[256];

				// construct quote
				String dString = null;
				if (in == null)
					dString = new Date().toString();
				else
					dString = getNextQuote();
				buf = dString.getBytes();

				// send it
				/**
				 * The hard-coded InetAddress of the DatagramPacket is
				 * "230.0.0.1" and is a group identifier (rather than the
				 * Internet address of the machine on which a single client is
				 * running). This particular address was arbitrarily chosen from
				 * the reserved for this purpose.
				 */
				InetAddress group = InetAddress.getByName("230.0.0.1");
				DatagramPacket packet = new DatagramPacket(buf, buf.length,
						group, 4446);
				socket.send(packet);

				try {
					// Causes the currently executing thread to sleep
					// (temporarily cease execution) for the specified number of
					// milliseconds, subject to the precision and accuracy of
					// system timers and schedulers.
					sleep((long) Math.random() * FIVE_SECOND);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} catch (IOException e) {
				e.printStackTrace();
				moreQuotes = false;
			}
		}
		socket.close();

	}

}
