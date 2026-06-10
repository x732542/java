package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

@WebServlet("/Brad09")
public class Brad09 extends HttpServlet {
	private final static int W = 400;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int rate = 0;
		try {
			String r = request.getParameter("rate");
			rate = Integer.parseInt(r);
		} catch (Exception e) {
			System.out.println(e);
		}

		// -------------------------------------
		BufferedImage img = new BufferedImage(400, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();

		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0, 0, W, 20);

		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, (int) (W * rate / 100.0), 20);

		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();

	}
}
