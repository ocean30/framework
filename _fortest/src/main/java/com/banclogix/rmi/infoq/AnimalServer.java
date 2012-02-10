package com.banclogix.rmi.infoq;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *@author zhengzh
 *@version 1.0 2012-2-6
 */
public class AnimalServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		    final int port = 8009; //绑定的端口号
		    final String host = "127.0.0.1"; //本机作为服务host
		    final String serviceName = "animalService"; //服务名称
		    IAnimalService obj = new AnimalServiceImp();
		    IAnimalService stub = (IAnimalService) UnicastRemoteObject.exportObject(obj, port); //端口绑定远程对象
		    Registry registry = LocateRegistry.getRegistry();
		    registry.unbind(serviceName);
		    registry.bind(serviceName, stub); //注册服务地址
		    System.out.println("Server Start...");
		} catch (Exception e) {
		    System.err.println("Server exception: " + e.toString());
		    e.printStackTrace();
		}
	}

}
