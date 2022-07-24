package test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {

	public static void main(String[] args) throws IOException {
		File file = new File("Water lilies.jpg");
		BufferedImage image = ImageIO.read(file);

		BufferedImage imogi = new BufferedImage(400, 300, image.getType());

		Graphics2D g = imogi.createGraphics();
		g.drawImage(image, 0, 0, 400, 300, null);
		g.dispose();

		ImageIO.write(imogi, "jpg", new File("Lilies Water.jpg"));
		System.out.println("All tasks Completed");
	}
}