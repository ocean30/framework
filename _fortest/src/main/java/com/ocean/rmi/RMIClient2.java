package com.ocean.rmi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
class RMIClient2 extends JFrame implements ActionListener {

	JLabel text, clicked;
	JButton button;
	JPanel panel;
	JTextArea textArea;
	Socket socket = null;
	PrintWriter out = null;
	static Send send;

	RMIClient2() { // Begin Constructor
		text = new JLabel("Text received:");
		textArea = new JTextArea();
		button = new JButton("Click Me");
		button.addActionListener(this);

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.white);
		getContentPane().add(panel);
		panel.add("North", text);
		panel.add("Center", textArea);
		panel.add("South", button);
	} // End Constructor

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == button) {
			try {
				String text = send.getData();
				textArea.append(text);
			} catch (java.rmi.RemoteException e) {
				System.out.println("Cannot access data in server");
			}
		}
	}

	public static void main(String[] args) {
		RMIClient2 frame = new RMIClient2();
		frame.setTitle("Client Two");
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};

		frame.addWindowListener(l);
		frame.pack();
		frame.setVisible(true);

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			String name = "//" + args[0] + "/Send";
			send = ((Send) Naming.lookup(name));
		} catch (java.rmi.NotBoundException e) {
			System.out.println("Cannot access data in server");
		} catch (java.rmi.RemoteException e) {
			System.out.println("Cannot access data in server");
		} catch (java.net.MalformedURLException e) {
			System.out.println("Cannot access data in server");
		}
	}
}
