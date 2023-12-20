package models.objects;

/**
 * Kelas yang merepresentasikan kota dalam graf peta.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public class City extends Vertex {

	private int mdpl;

	public City(String label, int id, int mdpl) {
		super(label, id);
		this.mdpl = mdpl;
	}

	public int getMdpl() {
		return mdpl;
	}

	public void setMdpl(int mdpl) {
		this.mdpl = mdpl;
	}
}
