package models.objects;

/**
 * Kelas berisi konstanta yang merepresentasikan tingkat kemacetan. Konstanta ini berisi
 * faktor pengali yang digunakan untuk menghitung bobot jarak antar kota.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public enum Traffic {

	NORMAL(0.075),
	HEAVY(0.1),
	VERY_HEAVY(0.125);

	private final double value;

	Traffic(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
}
