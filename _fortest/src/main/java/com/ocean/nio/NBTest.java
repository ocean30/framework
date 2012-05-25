package com.ocean.nio;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NBTest {

	/** Creates new NBTest */
	public NBTest() {
	}

	public void startServer() throws Exception {
		int channels = 0;
		int nKeys = 0;
		//int currentSelector = 0;

		// ʹ��Selector
		Selector selector = Selector.open();

		// ����Channel ���󶨵�9000�˿�
		ServerSocketChannel ssc = ServerSocketChannel.open();
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9000);
//		System.out.println(InetAddress.getLocalHost());		//return B-01-039/172.20.1.129
//		System.out.println(Inet4Address.getLocalHost());	//return B-01-039/172.20.1.129
//		System.out.println(Inet6Address.getLocalHost());	//return B-01-039/172.20.1.129
		ssc.socket().bind(address);

		// ʹ�趨non-blocking�ķ�ʽ��
		ssc.configureBlocking(false);

		// ��Selectorע��Channel����������Ȥ���¼�
		SelectionKey s = ssc.register(selector, SelectionKey.OP_ACCEPT);
		printKeyInfo(s);

		while (true) // ���ϵ���ѯ
		{
			debug("NBTest: Starting select");

			// Selectorͨ��select����֪ͨ�������Ǹ���Ȥ���¼������ˡ�
			nKeys = selector.select();
			// ���������ע������鷢���ˣ����Ĵ���ֵ�ͻ����0
			if (nKeys > 0) {
				debug("NBTest: Number of keys after select operation: " + nKeys);

				// Selector����һ��SelectionKeys
				// ���Ǵ���Щkey�е�channel()������ȡ�����Ǹո�ע���channel��
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> i = selectedKeys.iterator();
				while (i.hasNext()) {
					s = i.next();
					printKeyInfo(s);
					debug("NBTest: Nr Keys in selector: " + selector.keys().size());

					// һ��key��������ɺ󣬾Ͷ����Ӿ����ؼ��֣�ready keys���б��г�ȥ�����ԣ�
					i.remove();
					if (s.isAcceptable()) {
						// ��channel()��ȡ�����Ǹո�ע���channel��
						Socket socket = ((ServerSocketChannel) s.channel()).accept().socket();
						SocketChannel sc = socket.getChannel();

						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
						System.out.println(++channels);
					} else {
						debug("NBTest: Channel not acceptable");
					}
				}
			} else {
				debug("NBTest: Select finished without any keys.");
			}

		}

	}

	private static void debug(String s) {
		System.out.println(s);
	}

	private static void printKeyInfo(SelectionKey sk) {
		String s = new String();

		s = "Att: " + (sk.attachment() == null ? "no" : "yes");
		s += ", Read: " + sk.isReadable();
		s += ", Acpt: " + sk.isAcceptable();
		s += ", Cnct: " + sk.isConnectable();
		s += ", Wrt: " + sk.isWritable();
		s += ", Valid: " + sk.isValid();
		s += ", Ops: " + sk.interestOps();
		debug(s);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		NBTest nbTest = new NBTest();
		try {
			nbTest.startServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}