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
		    final int port = 8009; //�󶨵Ķ˿ں�
		    final String host = "127.0.0.1"; //������Ϊ����host
		    final String serviceName = "animalService"; //��������
		    IAnimalService obj = new AnimalServiceImp();
		    IAnimalService stub = (IAnimalService) UnicastRemoteObject.exportObject(obj, port); //�˿ڰ�Զ�̶���
		    Registry registry = LocateRegistry.getRegistry();
		    registry.unbind(serviceName);
		    registry.bind(serviceName, stub); //ע������ַ
		    System.out.println("Server Start...");
		} catch (Exception e) {
		    System.err.println("Server exception: " + e.toString());
		    e.printStackTrace();
		}
	}

}
