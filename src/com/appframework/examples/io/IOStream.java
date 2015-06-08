/**
 * TODO
 * @Project: javaTutorialProject
 * @Title: IOStream.java
 * @Package com.appframework.examples.io
 * @author jason.liu
 * @Date 2014-9-28 上午10:34:37
 * @Version v1.0
 */
package com.appframework.examples.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * TODO
 * 
 * @ClassName: IOStream
 * @author jason.liu
 */
public class IOStream {

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// t_byteStream();
		// t_characterStream();
		// t_characterStream_line();
		t_scan();

	}

	// all other stream types are built on byte streams
	public static void t_byteStream() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("xanadu.txt");
			out = new FileOutputStream("outagain.txt");// 在 工程名目录下,文件不存在时，会新建一个

			int c;

			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {

			if (in != null) {
				in.close();
			}

			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * The Java platform stores character values using Unicode conventions.
	 * Character stream I/O automatically translates this internal format to and
	 * from the local character set. In Western locales, the local character set
	 * is usually an 8-bit superset of ASCII. Input and output done with stream
	 * classes automatically translates to and from the local character set TODO
	 * 
	 * @Title: t_characterStream
	 * @throws IOException
	 */
	public static void t_characterStream() throws IOException {

		FileReader inputStream = null;
		FileWriter outputStream = null;

		try {
			inputStream = new FileReader("xanadu.txt");
			outputStream = new FileWriter("characteroutput.txt");

			int c;
			while ((c = inputStream.read()) != -1) {
				// in CopyCharacters, the int variable holds a character value
				// in its last 16 bits;
				// in CopyBytes, the int variable holds a byte value in its last
				// 8 bits.
				outputStream.write(c);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

	// Character I/O usually occurs in bigger units than single characters.
	// One common unit is the line: a string of characters with a line
	// terminator at the end.
	public static void t_characterStream_line() throws IOException {

		BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		try {

			/**
			 * each such request often triggers disk access, network activity,
			 * or some other operation that is relatively expensive. Buffered
			 * input streams read data from a memory area known as a buffer; the
			 * native input API is called only when the buffer is empty.
			 * Similarly, buffered output streams write data to a buffer, and
			 * the native output API is called only when the buffer is full.
			 */
			inputStream = new BufferedReader(new FileReader("xanadu.txt"));
			outputStream = new PrintWriter(
					new FileWriter("characteroutput.txt"));

			String l;
			while ((l = inputStream.readLine()) != null) {

				/**
				 * Some buffered output classes support autoflush, specified by
				 * an optional constructor argument. When autoflush is enabled,
				 * certain key events cause the buffer to be flushed. For
				 * example, an autoflush PrintWriter object flushes the buffer
				 * on every invocation of println or format. To flush a stream
				 * manually, invoke its flush method. The flush method is valid
				 * on any output stream, but has no effect unless the stream is
				 * buffered.
				 */
				outputStream.println(l);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

	// By default, a scanner uses white space to separate tokens. (White space
	// characters include blanks, tabs, and line terminators. For the full list,
	// refer to the documentation for Character.isWhitespace.)
	public static void t_scan() throws IOException {

		Scanner s = null;

		try {
			// To use a different token separator, invoke useDelimiter()
			s = new Scanner(new BufferedReader(new FileReader(("xanadu.txt"))));

			while (s.hasNext()) {
				System.out.println(s.next());
			}
		} finally {

			if (s != null) {
				s.close();
			}
		}
	}

	/**
	 * Stream objects that implement formatting are instances of either
	 * PrintWriter, a character stream class, or PrintStream, a byte stream
	 * class. The only PrintStream objects you are likely to need are System.out
	 * and System.err. TODO
	 * 
	 * @Title: t_format
	 */
	public static void t_format() {
		int i = 2;
		double r = Math.sqrt(i);

		/**
		 * d formats an integer value as a decimal value. f formats a floating
		 * point value as a decimal value. n outputs a platform-specific line
		 * terminator.
		 */
		System.out.format("The square root of %d is %f.%n", i, r);
	}

}
