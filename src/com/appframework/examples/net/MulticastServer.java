/**
* TODO
* @Project: javaTutorialProject
* @Title: MulticastServer.java
* @Package com.appframework.examples.net
* @author jason.liu
* @Date 2014-10-9 上午10:05:44
* @Version v1.0
*/
package com.appframework.examples.net;

import java.io.IOException;

/**
 * TODO
 * @ClassName: MulticastServer
 * @author jason.liu
 */
public class MulticastServer {

	/**
	 * TODO
	 * @Title: main
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		new MulticastServerThread().start();
	}

}
