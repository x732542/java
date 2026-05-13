package tw.Ban.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanelV2 extends JPanel {
	private int viewW, viewH;
	private Timer timer;
	private String[] source = {"dir1/ball0.png","dir1/ball1.png",
						"dir1/ball2.png","dir1/ball3.png"};
	private BufferedImage[] ballImgs = new BufferedImage[source.length];
	private int[] ballWs = new int[source.length];
	private int[] ballHs = new int[source.length];
	private ArrayList<BallTask> balls;
	
	public GamePanelV2() {
		setBackground(new Color(250,247,240));
		
		try {
			for (int i=0; i<source.length; i++) {
				ballImgs[i] = ImageIO.read(new File(source[i]));
				ballWs[i] = ballImgs[i].getWidth(); 
				ballHs[i] = ballImgs[i].getHeight();				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		addMouseListener(new MyMouseListener());
		balls = new ArrayList<>();
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		}, 0, 16);	// 60 fps
	}
	
	private class BallTask extends TimerTask {
		int ballW, ballH;
		int ballX, ballY;
		int dx, dy;
		int ball;
		
		BallTask(int ballX, int ballY){
			dx = (int)(Math.random()*17-8);
			dy = (int)(Math.random()*17-8);
			ball = (int)(Math.random()*source.length);
			ballW = ballWs[ball]; 
			ballH = ballHs[ball];
			
			this.ballX = ballX - (int)(ballW / 2.0);
			this.ballY = ballY - (int)(ballH / 2.0);
		}
		@Override
		public void run() {
			if (ballX < 0 || ballX + ballW  > viewW) {
				dx *= -1;
			}
			if (ballY < 0 || ballY + ballH  > viewH) {
				dy *= -1;
			}
			
			ballX += dx;
			ballY += dy;			
		}
	}
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			BallTask ball = new BallTask(e.getX(), e.getY());
			timer.schedule(ball, 100, 30);
			balls.add(ball);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth(); viewH = getHeight();
		
		for (BallTask ball : balls) {
			g.drawImage(ballImgs[ball.ball], ball.ballX, ball.ballY, null);
		}
	}
}