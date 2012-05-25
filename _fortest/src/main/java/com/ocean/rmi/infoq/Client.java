package com.ocean.rmi.infoq;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *@author zhengzh
 *@version 1.0 2012-2-6
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Registry registry = null;
		final String host = "127.0.0.1";
		final String serviceName = "animalService"; //��������
		try {
		    registry = LocateRegistry.getRegistry(host); //��ȡԶ�̶�������ע��
		    //��ȡ��̬������
		    IAnimalService stub = (IAnimalService) registry.lookup(serviceName);
		    //Զ�̵���
		    String name = stub.getMonkeyName();
		    System.out.println("monkey name: " + name);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

}
