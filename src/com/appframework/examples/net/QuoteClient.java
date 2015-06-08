/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: QuoteClient.java
 * @Package com.appframework.examples.net
 * @author jason.liu
 * @Date 2014-10-8 下午3:35:52
 * @Version v1.0
 */
package com.appframework.examples.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * TODO
 * 
 * @ClassName: QuoteClient
 * @author jason.liu
 */
public class QuoteClient {

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		if (args.length != 1) {
//			System.out.println("Usage: java QuoteClient <hostname>");
//			return;
//		}

		// server host name
		String hostName = "localhost";

		// Constructs a datagram socket and binds it to any available port on
		// the local host machine.
		DatagramSocket socket = new DatagramSocket();

		// send request
		byte[] buf = new byte[256];

		/**
		 * Determines the IP address of a host, given the host's name. The host
		 * name can either be a machine name, such as "java.sun.com", or a
		 * textual representation of its IP address. If a literal IP address is
		 * supplied, only the validity of the address format is checked.
		 * Returns:an IP address for the given host name.
		 */
		InetAddress address = InetAddress.getByName(hostName);
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address,
				4445);
		socket.send(packet);

		// get response
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);

		// display response
		String received = new String(packet.getData(), 0, packet.getLength());
		System.out.println("Quote of the Moment:" + received);

		socket.close();
	}
}
