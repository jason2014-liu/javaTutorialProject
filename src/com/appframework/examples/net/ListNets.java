/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: ListNets.java
 * @Package com.appframework.examples.net
 * @author jason.liu
 * @Date 2014-10-9 上午10:52:50
 * @Version v1.0
 */
package com.appframework.examples.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

/**
 * TODO
 * 
 * @ClassName: ListNets
 * @author jason.liu
 */
public class ListNets {

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 * @throws SocketException
	 */
	public static void main(String[] args) throws SocketException {
		// TODO Auto-generated method stub

		/**
		 * A network interface is the point of interconnection between a
		 * computer and a private or public network. A network interface is
		 * generally a network interface card (NIC), but does not have to have a
		 * physical form. Instead, the network interface can be implemented in
		 * software.
		 */
		Enumeration<NetworkInterface> nets = NetworkInterface
				.getNetworkInterfaces();

		for (NetworkInterface netint : Collections.list(nets)) {

			displayInterfaceinformation(netint);
		}

	}

	static void displayInterfaceinformation(NetworkInterface netint) {

		/**
		 * A convenience method to write a formatted string to this output
		 * stream using the specified format string and arguments. An invocation
		 * of this method of the form out.printf(format, args) behaves in
		 * exactly the same way as the invocation out.format(format, args)
		 */
		System.out.printf("Display name: %s\n", netint.getDisplayName());
		System.out.printf("Name:%s\n", netint.getName());

		Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
		for (InetAddress inetAddress : Collections.list(inetAddresses)) {
			System.out.printf("InetAddress: %s\n", inetAddress);
		}

		System.out.printf("\n");
	}

}
