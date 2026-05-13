package tw.banana.tutor;


import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.Ban.apis.GamePanelV2;

public class BallGame extends JFrame{
	private GamePanelV2 panel;
	
	public BallGame() {
		setLayout(new BorderLayout());
		panel = new GamePanelV2();
		add(panel, BorderLayout.CENTER);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BallGame();
	}

}