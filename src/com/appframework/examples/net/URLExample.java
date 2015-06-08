/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: URLExample.java
 * @Package com.appframework.examples.net
 * @author jason.liu
 * @Date 2014-9-30 上午9:49:31
 * @Version v1.0
 */
package com.appframework.examples.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * TODO
 * 
 * @ClassName: URLExample
 * @author jason.liu
 */
public class URLExample {

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		urlConnectionRead();
	}

	/**
	 * In fact, URLs are a relatively high-level connection to the Web and use
	 * sockets as part of the underlying implementation. TODO
	 * 
	 * @Title: urlConnectionRead
	 */
	public static void urlConnectionRead() {

		URL oracleUrl;
		try {
			oracleUrl = new URL("http://www.oracle.com/");
			URLConnection uc = oracleUrl.openConnection();

			// getInputStream() 已隐式打开连接 uc.connect()
			BufferedReader in = new BufferedReader(new InputStreamReader(
					uc.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			in.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block

			// URL参数错误
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void urlConnectionWrite() {

		String urlStr = "";
		String queryDate = "";
		try {

			URL url = new URL(urlStr);
			URLConnection connection = url.openConnection();

			// Set the DoInput flag to true if you intend to use the URL
			// connection for input, false if not.
			// The default is true.
			connection.setDoInput(true);

			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream());

			// Translates a string into application/x-www-form-urlencoded format
			// using a specific encoding scheme.
			// This method uses the supplied encoding scheme to obtain the bytes
			// for unsafe characters(may contain spaces or other
			// non-alphanumeric characters).
			out.write("queryField=" + URLEncoder.encode(queryDate, "UTF-8"));
			// Closes the stream, flushing it first.
			out.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
