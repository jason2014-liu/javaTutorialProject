/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: QuoteServerThread.java
 * @Package com.appframework.examples.net
 * @author jason.liu
 * @Date 2014-10-8 下午2:50:51
 * @Version v1.0
 */
package com.appframework.examples.net;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/**
 * TODO
 * 
 * @ClassName: QuoteServerThread
 * @author jason.liu
 */
public class QuoteServerThread extends Thread {

	protected DatagramSocket socket = null;
	protected BufferedReader in = null;
	protected boolean moreQuotes = true;

	public QuoteServerThread() throws IOException {

		this("QuoteServerThread");
		// TODO Auto-generated constructor stub
	}

	public QuoteServerThread(String name) throws IOException {
		super(name);

		socket = new DatagramSocket(4445);

		try {
			in = new BufferedReader(new FileReader("one-liners.txt"));
		} catch (FileNotFoundException e) {
			System.err
					.println("Could not open quote file. Serving time instead");
		}

		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		while (moreQuotes) {

			try {
				byte[] buf = new byte[256];

				// receive request
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				/**
				 * Receives a datagram packet from this socket. When this method
				 * returns, the DatagramPacket's buffer is filled with the data
				 * received. The datagram packet also contains the sender's IP
				 * address, and the port number on the sender's machine.
				 * 
				 * This method blocks until a datagram is received. The length
				 * field of the datagram packet object contains the length of
				 * the received message. If the message is longer than the
				 * packet's length, the message is truncated.
				 */
				socket.receive(packet);

				// figure out response
				String dString = null;
				if (in == null) {
					dString = new Date().toString();
				} else {
					dString = getNextQuote();
				}

				buf = dString.getBytes();

				// 返回此数据报发送或接收该数据包的计算机的IP地址。
				InetAddress address = packet.getAddress();
				// 返回此数据报发送或接收该数据报的远程主机的端口号。
				int port = packet.getPort();

				packet = new DatagramPacket(buf, buf.length, address, port);

				socket.send(packet);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				moreQuotes = false;
			}
		}

		socket.close();
	}

	protected String getNextQuote() {
		String returnValue = null;
		try {
			if ((returnValue = in.readLine()) == null) {
				in.close();
				moreQuotes = false;
				returnValue = "No more quotes. Goodbye";
			}
		} catch (IOException e) {
			returnValue = "IOException occurred in server";
		}

		return returnValue;

	}

}
