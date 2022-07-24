package stream;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import stream.icap.Icap;

public class IcapIO {

	private static volatile ArrayList<ArrayList<Color>> arrayOfCollumsArrayOfColors;
	private static volatile BufferedImage image;

	public static void parse(File file, File wFile) throws IOException {
		arrayOfCollumsArrayOfColors = new ArrayList<>();
		image = ImageIO.read(file);
		int width = image.getWidth();
		int height = image.getHeight();
		System.out.println("Encoding started");
		long t11 = System.currentTimeMillis();
		for (int x = 0; x < width; x++) {
			ArrayList<Color> columns = new ArrayList<>();
			for (int y = 0; y < height; y++) {
				Color temp = new Color(image.getRGB(x, y));
				columns.add(temp);
			}
			arrayOfCollumsArrayOfColors.add(columns);
		}
		long t12 = System.currentTimeMillis();
		System.out.println("Encoding ended : " + (t12 - t11) + " milliseconds");
		Icap icap1 = new Icap(arrayOfCollumsArrayOfColors, file.getName());
		System.out.println("Serializing started");
		long t21 = System.currentTimeMillis();
		IcapMethods.serialize(icap1, wFile);
		long t22 = System.currentTimeMillis();
		System.out.println("Serializing ended : " + (t22 - t21) / 1000);
	}

	public static JPanel display(File file) {
		System.out.println("Deserializing started");
		long t11 = System.currentTimeMillis();
		Icap icap = IcapMethods.deserialize(file);
		long t12 = System.currentTimeMillis();
		System.out.println("Deserializing ended : " + (t12 - t11) / 1000);
		System.out.println("Deserialized File : " + icap.toString());
		int width = icap.getWidth();
		int height = icap.getHeight();

		System.out.println("Decoding started");
		long t21 = System.currentTimeMillis();
		JPanel returnValue = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (int x = 0; x < width; x++) {
					for (int y = 0; y < height; y++) {
						g.setColor(icap.getRGB(x, y));
						g.fillRect(x, y, 1, 1);
					}
				}
			}
		};
		long t22 = System.currentTimeMillis();
		System.out.println("Decoding Ended : " + (t22 - t21) + " milliseconds");
		returnValue.setSize(icap.getSize());
		return returnValue;
	}
}