package test;

import java.awt.Color;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import stream.IcapIO;

public class DisplayFile {

	private static File file = new File("water lilies.jpg" + ".icap");

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Icap example");
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				init(frame);
			}
		});
	}

	private static void init(JFrame frame) {
		frame.setBackground(Color.BLACK);
		frame.setLayout(null);

		JPanel pic = IcapIO.display(file);
		frame.getContentPane().add(pic);

		frame.setSize(pic.getWidth() + 5, pic.getHeight() + 35);
		frame.setVisible(true);
	}
}