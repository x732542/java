package tw.Ban.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class SignPanel extends JPanel{
	private List<Point> line;
	
	 public SignPanel () {
		 setBackground(Color.yellow);
		 
	 }
	 
	 protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 
		 System.out.println("OK");
	 }
	 
	 
	 
}
