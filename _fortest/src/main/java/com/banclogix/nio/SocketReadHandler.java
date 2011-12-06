package com.banclogix.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

import org.apache.log4j.Logger;

import com.banclogix.blockingqueue.Test;

public class SocketReadHandler implements Runnable {

	private static Logger logger = Logger.getLogger(SocketReadHandler.class);

	private Test test = new Test();

	final SocketChannel socket;
	final SelectionKey sk;

	static final int READING = 0, SENDING = 1;
	int state = READING;

	public SocketReadHandler(Selector sel, SocketChannel c) throws IOException {

		socket = c;

		socket.configureBlocking(false);
		sk = socket.register(sel, 0);

		// ��SelectionKey��Ϊ��Handler ��һ�����¼�����ʱ�������ñ����run������
		// �ο�dispatch(SelectionKey k)
		sk.attach(this);

		// ͬʱ��SelectionKey���Ϊ�ɶ����Ա��ȡ��
		sk.interestOps(SelectionKey.OP_READ);
		sel.wakeup();
	}

	public void run() {
		try {
			// test.read(socket,input);
			readRequest();
		} catch (Exception ex) {
			logger.debug("readRequest error" + ex);
		}
	}

	/**
	 * �����ȡdata
	 * 
	 * @param key
	 * @throws Exception
	 */
	private void readRequest() throws Exception {

		ByteBuffer input = ByteBuffer.allocate(1024);
		input.clear();
		try {

			int bytesRead = socket.read(input);

			// �����̳߳� ������Щrequest
			// requestHandle(new Request(socket,btt));

		} catch (Exception e) {
		}

	}
}