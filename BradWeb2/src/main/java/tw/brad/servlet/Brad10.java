package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@WebServlet("/Brad10")
public class Brad10 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String source = "C:\\Users\\User\\eclipse-workspace\\BradWeb2\\src\\main\\webapp\\upload\\coffee.jpg";
		String target = "C:\\Users\\User\\eclipse-workspace\\BradWeb2\\src\\main\\webapp\\upload\\coffee2.jpg";
		BufferedImage img = ImageIO.read(new File(source));

		Graphics2D g2d = img.createGraphics();
		g2d.setColor(Color.yellow);

		Font f1 = new Font(null, Font.BOLD, 72);
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(-30));
		Font f2 = f1.deriveFont(transform);

		g2d.setFont(f2);
		
		g2d.drawString("香dd蕉", 200, 200);

		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
		
		ImageIO.write(img, "JPEG", new File(target));
	}
}
