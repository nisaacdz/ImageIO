package test;

import java.io.File;
import java.io.IOException;

import stream.IcapIO;

public class CreateFile {

	private static File file = new File("houseNtree.jpg");

	public static void main(String[] args) throws IOException {

		IcapIO.parse(file, new File(file.getName() + ".icap"));

	}

	public static File getCurrentFile() {
		return file;
	}

}
