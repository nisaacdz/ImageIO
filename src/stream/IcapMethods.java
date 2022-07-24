package stream;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import stream.icap.Icap;

public class IcapMethods {

	public static void serialize(Icap icap, File file) {
		try (FileOutputStream fs = new FileOutputStream(file)) {
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(icap);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Icap deserialize(File file) {
		Icap icap = null;
		try (FileInputStream fi = new FileInputStream(file)) {
			ObjectInputStream os = new ObjectInputStream(fi);
			icap = (Icap) os.readObject();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return icap;
	}

	public static Color getRandomColor() {
		int r = (int) (255 * Math.random());
		int g = (int) (255 * Math.random());
		int b = (int) (255 * Math.random());
		return new Color(r, g, b);
	}
}