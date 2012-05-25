package com.ocean.rmi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class SwingUI extends JFrame implements ActionListener {

	JLabel text, clicked;
	JButton button, clickButton;
	JPanel panel;
	private boolean _clickMeMode = true;

	SwingUI() { // Begin Constructor
		text = new JLabel("I'm a Simple Program");
		button = new JButton("Click Me");
		button.addActionListener(this);

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.white);
		getContentPane().add(panel);
		panel.add(BorderLayout.CENTER, text);
		panel.add(BorderLayout.SOUTH, button);
	} // End Constructor

	public void actionPerformed(ActionEvent event) {
//		Object source = event.getSource();
		if (_clickMeMode) {
			text.setText("Button Clicked");
			button.setText("Click Again");
			_clickMeMode = false;
		} else {
			text.setText("I'm a Simple Program");
			button.setText("Click Me");
			_clickMeMode = true;
		}
	}

	public static void main(String[] args) {
		SwingUI frame = new SwingUI();
		frame.setTitle("Example");
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};

		frame.addWindowListener(l);
		frame.pack();
		frame.setVisible(true);
	}

}
