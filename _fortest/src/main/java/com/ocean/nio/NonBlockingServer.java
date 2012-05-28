package com.ocean.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;

/**
 * 对 JDK 1.4 中的非阻塞 I/O 的介绍的最后一部分留给您：运行这个示例。
在这个简单的非阻塞服务器-套接字示例中，服务器读取发送自客户机的文件名，显示该文件的内容，然后将内容写回到客户机。
这里是您运行这个示例需要做的事情：
安装 JDK 1.4。 
将两个 源代码文件 复制到您的目录。 
编译和运行服务器，  java NonBlockingServer 。 
编译和运行客户机，  java Client 。 
输入类文件所在目录的一个文本文件或 java 文件的名称。
服务器将读取该文件并将其内容发送到客户机。
客户机将把从服务器接收到的数据打印出来。（由于所用的  ByteBuffer 的限制，所以将只读取 1024 字节。） 
输入 quit 或 shutdown 命令关闭客户机。
 * @author zhengzh
 *
 */
public class NonBlockingServer
{
    public Selector sel = null;
    public ServerSocketChannel server = null;
    public SocketChannel socket = null;
    public int port = 4900;
    String result = null;


    public NonBlockingServer()
    {
		System.out.println("Inside default ctor");
    }
    
	public NonBlockingServer(int port)
    {
		System.out.println("Inside the other ctor");
		this.port = port;
    }

    public void initializeOperations() throws IOException,UnknownHostException
    {
		System.out.println("Inside initialization");
		sel = Selector.open();
		server = ServerSocketChannel.open();
		server.configureBlocking(false);
		InetAddress ia = InetAddress.getLocalHost();
		InetSocketAddress isa = new InetSocketAddress(ia,port);
		server.socket().bind(isa);
    }
    
	public void startServer() throws IOException
    {
		System.out.println("Inside startserver");
        initializeOperations();
		System.out.println("Abt to block on select()");
		SelectionKey acceptKey = server.register(sel, SelectionKey.OP_ACCEPT );	
	
		while (acceptKey.selector().select() > 0 )
		{	
	    
			Set readyKeys = sel.selectedKeys();
			Iterator it = readyKeys.iterator();

			while (it.hasNext()) {
				SelectionKey key = (SelectionKey)it.next();
				it.remove();
                
				if (key.isAcceptable()) {
					System.out.println("Key is Acceptable");
					ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
					socket = (SocketChannel) ssc.accept();
					socket.configureBlocking(false);
					SelectionKey another = socket.register(sel,SelectionKey.OP_READ|SelectionKey.OP_WRITE);
				}
				if (key.isReadable()) {
					System.out.println("Key is readable");
					String ret = readMessage(key);
					if (ret.length() > 0) {
						writeMessage(socket,ret);
					}
				}
				if (key.isWritable()) {
					System.out.println("THe key is writable");
					String ret = readMessage(key);
					socket = (SocketChannel)key.channel();
					if (result.length() > 0 ) {
						writeMessage(socket,ret);
					}
				}
			}
		}
    }

    public void writeMessage(SocketChannel socket,String ret)
    {
		System.out.println("Inside the loop");

		if (ret.equals("quit") || ret.equals("shutdown")) {
			return;
		}
		File file = new File(ret);
		try
		{
		
			RandomAccessFile rdm = new RandomAccessFile(file,"r");
			FileChannel fc = rdm.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			fc.read(buffer);
			buffer.flip();
    
			Charset set = Charset.forName("us-ascii");
			CharsetDecoder dec = set.newDecoder();
			CharBuffer charBuf = dec.decode(buffer);
			System.out.println(charBuf.toString());
			buffer = ByteBuffer.wrap((charBuf.toString()).getBytes());
			int nBytes = socket.write(buffer);
			System.out.println("nBytes = "+nBytes);
				result = null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }
  
    public String readMessage(SelectionKey key)
    {
		int nBytes = 0;
		socket = (SocketChannel)key.channel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
		try
		{
            nBytes = socket.read(buf);
			buf.flip();
			Charset charset = Charset.forName("us-ascii");
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer charBuffer = decoder.decode(buf);
			result = charBuffer.toString();
	    
        }
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return result;
    }

    public static void main(String args[])
    {
		NonBlockingServer nb = new NonBlockingServer();
		try
		{
			nb.startServer();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
		
	}
}



