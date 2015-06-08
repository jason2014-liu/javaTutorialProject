/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: MulticastClient.java
 * @Package com.appframework.examples.net
 * @author jason.liu
 * @Date 2014-10-9 上午10:07:28
 * @Version v1.0
 */
package com.appframework.examples.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * TODO
 * 
 * @ClassName: MulticastClient
 * @author jason.liu
 */
public class MulticastClient {

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
		 * In addition to DatagramSocket, which lets programs send packets to
		 * one another, java.net includes a class called MulticastSocket. This
		 * kind of socket is used on the client-side to listen for packets that
		 * the server broadcasts to multiple clients.
		 */

		/**
		 * 多播地址 编辑
		 * 
		 * 224.0.0.0--239.255.255.255，没有像单播ip段那样有广播地址和网络地址之分了。
		 * 具体：224.0.0.0--224.0.0.255
		 * 本地保留，给知名协议使用，ttl=1。其中224.0.0.1是本网所有主机接收，224.0.0.2是本网所有路由器接收。
		 * 224.0.1.0～238.255.255.255 预留组播地址，[1] 多播地址应从此范围内选择。
		 * 239.0.0.0--239.255.255.255 私有组播地址。 232.0.0.0--232.255.255.255 特定源多播
		 */
		MulticastSocket socket = new MulticastSocket(4446);

		InetAddress address = InetAddress.getByName("230.0.0.1");
		socket.joinGroup(address);

		DatagramPacket packet;

		for (int i = 0; i < 5; i++) {

			byte[] buf = new byte[256];
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);

			String received = new String(packet.getData(), 0,
					packet.getLength());
			System.out.println("Quote of the Moment:" + received);
		}

		socket.leaveGroup(address);
		socket.close();

	}

}
