package utils;

import models.objects.City;
import models.objects.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Kelas ini menyimpan metode inisialisasi graf dengan vertex yang sudah ada pada {@link #cities}.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public class CityInitializer {
	public static Map<String, City> cities = initCities();

	public static Map<String, City> initCities() {
		Map<String, City> cities = new HashMap<>();
		initCities(cities);
		return cities;
	}

    /**
	 * Melakukan pengisian data kota-kota yang ada di Jawa Tengah sesuai dengan nama dan MDPL/2 dari:
	 * <a href="https://jateng.bps.go.id/statictable/2017/10/26/1513/tinggi-wilayah-di-atas-permukaan-laut-dpl-menurut-kabupaten-kota-di-provinsi-jawa-tengah-2015---2018.html">
     *     BPS Provinsi Jawa Tengah
     * </a>
	 * */
    public static void initCities(Map<String, City> cities) {
        cities.put("BREBES", new City("BREBES", 0, 100));
        cities.put("TEGAL", new City("TEGAL", 1, 850));
        cities.put("CILACAP", new City("CILACAP", 2, 6));
        cities.put("BANYUMAS", new City("BANYUMAS", 3, 200 + 650));
        cities.put("PURBALINGGA", new City("PURBALINGGA", 4, 55));
        cities.put("PEMALANG", new City("PEMALANG", 5, 50));
        cities.put("PEKALONGAN", new City("PEKALONGAN", 6, 647));
        cities.put("KEBUMEN", new City("KEBUMEN", 7, 369));
        cities.put("PURWOREJO", new City("PURWOREJO", 8, 700));
        cities.put("BANJARNEGARA", new City("BANJARNEGARA", 9, 298 + 897));
        cities.put("KENDAL", new City("KENDAL", 10, 1289));
        cities.put("BATANG", new City("BATANG", 11, 4));
        cities.put("WONOSOBO", new City("WONOSOBO", 12, 275 + 906));
        cities.put("TEMANGGUNG", new City("TEMANGGUNG", 13, 458 + 1419));
        cities.put("MAGELANG", new City("MAGELANG", 14, 190));
        cities.put("SEMARANG", new City("SEMARANG", 15, 500 + 750));
        cities.put("DEMAK", new City("DEMAK", 16, 150));
        cities.put("BOYOLALI", new City("BOYOLALI", 17, 75 + 712));
        cities.put("KLATEN", new City("KLATEN", 18, 1250));
        cities.put("KUDUS", new City("KUDUS", 19, 7));
        cities.put("JEPARA", new City("JEPARA", 20, 650));
        cities.put("REMBANG", new City("REMBANG", 21, 1));
        cities.put("PATI", new City("PATI", 22, 7));
        cities.put("BLORA", new City("BLORA", 23, 25 + 237));
        cities.put("GROBOGAN", new City("GROBOGAN", 24, 50 + 237));
        cities.put("SRAGEN", new City("SRAGEN", 25, 54));
        cities.put("SUKOHARJO", new City("SUKOHARJO", 26, 80 + 22));
        cities.put("KARANGANYAR", new City("KARANGANYAR", 27, 86));
		cities.put("WONOGIRI", new City("WONOGIRI", 28, 100));
    }

	/**
	 * Menginisialisasi graf dengan vertex yang sudah ada pada {@link #cities}.
	 * */
    public static void initGraph(Graph graph, Map<String, City> cities) {
        for (City city : cities.values()) {
            graph.addVertex(city);
        }
    }

	/**
	 * Menginisialisasi edge pada graf.
	 *
	 * @param graph graf yang akan diinisialisasi.
	 */
	public static void initEdges(Graph graph) {
		graph.addEdge("BREBES", "TEGAL", 25);
		graph.addEdge("BREBES", "CILACAP", 51);
		graph.addEdge("BREBES", "BANYUMAS", 66);

		graph.addEdge("CILACAP", "BANYUMAS", 40);

		graph.addEdge("TEGAL", "PEMALANG", 25);
		graph.addEdge("TEGAL", "PURBALINGGA", 32);
		graph.addEdge("TEGAL", "BANYUMAS", 41);

		graph.addEdge("BANYUMAS", "PURBALINGGA", 31);
		graph.addEdge("BANYUMAS", "BANJARNEGARA", 25);
		graph.addEdge("BANYUMAS", "KEBUMEN", 59);

		graph.addEdge("PEMALANG", "PEKALONGAN", 25);
		graph.addEdge("PEMALANG", "PURBALINGGA", 32);

		graph.addEdge("PURBALINGGA", "PEKALONGAN", 31);
		graph.addEdge("PURBALINGGA", "BANJARNEGARA", 25);

		graph.addEdge("BANJARNEGARA", "KEBUMEN", 37);
		graph.addEdge("BANJARNEGARA", "WONOSOBO", 25);
		graph.addEdge("BANJARNEGARA", "BATANG", 42);

		graph.addEdge("KEBUMEN", "WONOSOBO", 50);
		graph.addEdge("KEBUMEN", "PURWOREJO", 40);

		graph.addEdge("BATANG", "KENDAL", 33);
		graph.addEdge("BATANG", "WONOSOBO", 53);

		graph.addEdge("WONOSOBO", "KENDAL", 65);
		graph.addEdge("WONOSOBO", "TEMANGGUNG", 31);
		graph.addEdge("WONOSOBO", "MAGELANG", 40);
		graph.addEdge("WONOSOBO", "PURWOREJO", 35);

		graph.addEdge("KENDAL", "SEMARANG", 45);
		graph.addEdge("KENDAL", "TEMANGGUNG", 32);

		graph.addEdge("TEMANGGUNG", "SEMARANG", 34);
		graph.addEdge("TEMANGGUNG", "MAGELANG", 32);

		graph.addEdge("MAGELANG", "SEMARANG", 41);
		graph.addEdge("MAGELANG", "BOYOLALI", 56);

		graph.addEdge("SEMARANG", "DEMAK", 43);
		graph.addEdge("SEMARANG", "GROBOGAN", 48);
		graph.addEdge("SEMARANG", "BOYOLALI", 24);

		graph.addEdge("BOYOLALI", "GROBOGAN", 31);
		graph.addEdge("BOYOLALI", "SRAGEN", 22);
		graph.addEdge("BOYOLALI", "KARANGANYAR", 35);
		graph.addEdge("BOYOLALI", "SUKOHARJO", 29);
		graph.addEdge("BOYOLALI", "KLATEN", 26);

		graph.addEdge("KLATEN", "SUKOHARJO", 23);

		graph.addEdge("JEPARA", "DEMAK", 32);
		graph.addEdge("JEPARA", "PATI", 27);
		graph.addEdge("JEPARA", "KUDUS", 25);

		graph.addEdge("KUDUS", "PATI", 25);
		graph.addEdge("KUDUS", "GROBOGAN", 35);

		graph.addEdge("GROBOGAN", "SRAGEN", 26);
		graph.addEdge("GROBOGAN", "PATI", 50);
		graph.addEdge("GROBOGAN", "BLORA", 63);

		graph.addEdge("SRAGEN", "KARANGANYAR", 35);

		graph.addEdge("KARANGANYAR", "SUKOHARJO", 28);
		graph.addEdge("KARANGANYAR", "WONOGIRI", 33);

		graph.addEdge("PATI", "REMBANG", 39);
		graph.addEdge("PATI", "BLORA", 38);

		graph.addEdge("REMBANG", "BLORA", 30);
	}
}
