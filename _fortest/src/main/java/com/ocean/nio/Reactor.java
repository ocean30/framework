package com.ocean.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

public class Reactor implements Runnable {
	
	private static Logger logger = Logger.getLogger(Reactor.class);

	final Selector selector;
	final ServerSocketChannel serverSocket;

	Reactor(int port) throws IOException {
		selector = Selector.open();
		serverSocket = ServerSocketChannel.open();
		InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), port);
		serverSocket.socket().bind(address);

		serverSocket.configureBlocking(false);
		// ��selectorע���channel
		SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);

		logger.debug("-->Start serverSocket.register!");

		// ����sk��attache���ܰ�Acceptor ��������飬����Acceptor
		sk.attach(new Acceptor());
		logger.debug("-->attach(new Acceptor()!");
	}

	public void run() { // normally in a new Thread
		try {
			while (!Thread.interrupted()) {
				selector.select();
				Set<SelectionKey> selected = selector.selectedKeys();
				Iterator<SelectionKey> it = selected.iterator();
				// Selector�������channel��OP_ACCEPT��READ�¼����������б����ͻ���С�
				while (it.hasNext())
					// ��һ���¼� ��һ�δ���һ��accepter�߳�
					// �Ժ󴥷�SocketReadHandler
					dispatch((it.next()));
				selected.clear();
			}
		} catch (IOException ex) {
			logger.debug("reactor stop!" + ex);
		}
	}

	// ����Acceptor��SocketReadHandler
	void dispatch(SelectionKey k) {
		Runnable r = (Runnable) (k.attachment());
		if (r != null) {
			// r.run();

		}
	}

	class Acceptor implements Runnable { // inner
		public void run() {
			try {
				logger.debug("-->ready for accept!");
				SocketChannel c = serverSocket.accept();
				if (c != null)
					// ����Handler������channel
					new SocketReadHandler(selector, c);
			} catch (IOException ex) {
				logger.debug("accept stop!" + ex);
			}
		}
	}
}