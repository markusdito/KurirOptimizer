package models.objects;

/**
 * Kelas ini adalah dasar kelas yang merepresentasikan titik dalam graf secara sederhana.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * @author <a href="https://github.com/BoniRaDityA">Ditya</a>
 * */

public class Vertex {

	String label;
	int id;

	public Vertex(String label, int id) {
		this.label = label;
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String displayCity() {
		return label + " ";
	}

	@Override
	public String toString() {
		return "{%s}".formatted(label);
	}
}
