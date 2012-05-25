package com.ocean.rmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
class RemoteServer extends UnicastRemoteObject implements Send {

	private String text;

	public RemoteServer() throws RemoteException {
		super();
	}

	public void sendData(String gotText) {
		text = gotText;
	}

	public String getData() {
		return text;
	}

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		String name = "//kq6py.eng.sun.com/Send";
		try {
			Send remoteServer = new RemoteServer();
			Naming.rebind(name, remoteServer);
			System.out.println("RemoteServer bound");
		} catch (java.rmi.RemoteException e) {
			System.out.println("Cannot create remote server object");
		} catch (java.net.MalformedURLException e) {
			System.out.println("Cannot look up server object");
		}
	}
}
