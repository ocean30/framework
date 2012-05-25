package com.ocean.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * inputstream to outputstream
 * 
 * @author zhengzh
 * @version 1.0 2012-3-5
 */
public class StreamConvert {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream(StreamConvert.class.getResource("").getPath() + "StreamConvert.class");
		OutputStream out = convertIn2Out(in);
//		OutputStream out = System.out;
//		int nextChar;
//		while ((nextChar = in.read()) != -1)
//			out.write(Character.toUpperCase((char) nextChar));
//		out.write('\n');
//		out.flush();
	}

	private static OutputStream convertIn2Out(InputStream in) {
		return null;
	}

}
