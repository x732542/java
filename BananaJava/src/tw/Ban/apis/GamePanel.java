package tw.Ban.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private BufferedImage img;
	private int ballX, ballY, ballW, ballH, viewW, viewH, dx, dy;
	private Timer timer;

	public GamePanel() {
		setBackground(new Color(250, 247, 240));
		try {
			img = ImageIO.read(new File("dir1/ball1.png"));
			ballW = img.getWidth();
			ballY = img.getHeight();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(ballW + ";" + ballY);

		timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				moveBall();
			}
		}, 1000, 1);
		dx = dy = 1;
	}

	private void moveBall() {
		if (ballX < 0 || ballX + ballW > viewW) {
			dx *= -1;
		}
		if (ballY < 0 || ballY + ballH > viewH) {
			dy *= -1;
		}
		ballX += dx;
		ballY += dy;
		repaint();

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println(getWidth() + ";" + getHeight());
		viewW = getWidth();
		viewH = getHeight();

		g.drawImage(img, ballX, ballY, null);
	}
}