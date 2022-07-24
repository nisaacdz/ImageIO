package stream.icap;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;

public class Icap implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<ArrayList<Color>> coordinates = new ArrayList<>();

	String name;
	int width;
	int height;

	public Icap(ArrayList<ArrayList<Color>> cordinates, String name) {
		this.coordinates = cordinates;
		setHeight(this.coordinates);
		setWidth(this.coordinates);
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name + " [width = " + width + " height = " + height;
	}

	public ArrayList<ArrayList<Color>> getcoordinates() {
		return coordinates;
	}

	public int getWidth() {
		return this.width;
	}

	public Dimension getSize() {
		return new Dimension(this.width, this.height);
	}

	public Color getRGB(int x, int y) {
		return coordinates.get(x).get(y);
	}

	public int getHeight() {
		return this.height;
	}

	public void setWidth(ArrayList<ArrayList<Color>> coordinates) {
		this.width = coordinates.size();
	}

	public void setHeight(ArrayList<ArrayList<Color>> coordinates) {
		this.height = coordinates.get(0).size();
	}
}
