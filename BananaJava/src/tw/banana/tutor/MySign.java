package tw.banana.tutor;


import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.Ban.apis.SignPanel;

public class MySign extends JFrame{
	private SignPanel panel;
	
	public MySign() {
		
		setLayout(new BorderLayout());
		panel = new SignPanel();
		add(panel, BorderLayout.CENTER);
		
		setSize(800,  600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MySign();
	}

}