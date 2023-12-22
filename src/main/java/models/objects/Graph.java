package models.objects;

import java.util.*;

public class Graph {

	private City[] vertices;
	private int[][] adjMatrix;
	private int backIdx;
	private HashMap<String, Integer> vertexPosition;

	public Graph(int nVertices) {
		this.vertices = new City[nVertices];
		this.adjMatrix = new int[nVertices][nVertices];
		this.backIdx = 0;
		vertexPosition = new HashMap<>();
	}

	/**
	 * Menambahkan sebuah City / titik ke dalam graf dengan label vertex.
	 *
	 * @param vertex vertex yang sudah ada
	 */
	public void addVertex(City vertex) {
		vertices[vertex.id] = vertex;
		vertexPosition.put(vertex.label.toUpperCase(), vertex.id);
		backIdx++;
	}

	/**
	 * Menambahkan edge/penghubung vertex dengan nama label yang terdapat pada graf dengan berat 1.
	 *
	 * @param src label vertex 1
	 * @param dst label vertex 2
	 */
	public void addEdge(String src, String dst) {
		addEdge(
			vertexPosition.get(src.toUpperCase()),
			vertexPosition.get(dst.toUpperCase())
		);
	}

	/**
	 * Menambahkan edge/penghubung vertex dengan format index pada adjacency matrix dengan berat 1.
	 *
	 * @param src posisi vertex 1
	 * @param dst posisi vertex 2
	 */
	public void addEdge(int src, int dst) {
		addEdge(src, dst, 1);
	}

	/**
	 * Menambahkan edge/penghubung vertex dengan nama label yang terdapat pada graf.
	 *
	 * @param src    label vertex 1
	 * @param dst    label vertex 2
	 * @param weight bobot dari edge
	 */
	public void addEdge(String src, String dst, int weight) {
		addEdge(
			vertexPosition.get(src.toUpperCase()),
			vertexPosition.get(dst.toUpperCase()),
			weight
		);
	}

	/**
	 * Menambahkan edge/penghubung vertex dengan format index pada adjacency matrix.
	 *
	 * @param src    posisi vertex 1
	 * @param dst    posisi vertex 2
	 * @param weight bobot dari edge
	 */
	public void addEdge(int src, int dst, int weight) {
		adjMatrix[src][dst] = weight;
		adjMatrix[dst][src] = weight;
	}

	/**
	 * Menambahkan edge/penghubung searah dari vertex dengan nama label yang terdapat pada graf.
	 *
	 * @param src label vertex 1
	 * @param dst label vertex 2
	 */
	public void addDirectedEdge(String src, String dst) {
		addDirectedEdge(
			vertexPosition.get(src.toUpperCase()),
			vertexPosition.get(dst.toUpperCase()),
			1
		);
	}

	/**
	 * Menambahkan edge/penghubung searah dari vertex dengan nama label yang terdapat pada graf dengan bobot tertentu.
	 *
	 * @param src    label vertex 1
	 * @param dst    label vertex 2
	 * @param weight bobot dari edge
	 */
	public void addDirectedEdge(String src, String dst, int weight) {
		addDirectedEdge(
			vertexPosition.get(src.toUpperCase()),
			vertexPosition.get(dst.toUpperCase()),
			weight
		);
	}

	/**
	 * Menambahkan edge/penghubung searah dari vertex dengan format index pada adjacency matrix.
	 *
	 * @param src posisi vertex 1
	 * @param dst posisi vertex 2
	 */
	public void addDirectedEdge(int src, int dst, int weight) {
		adjMatrix[src][dst] = weight;
	}

	/**
	 * Menghapus edge/penghubung vertex dengan nama label yang terdapat pada graf.
	 *
	 * @param src label vertex 1
	 * @param dst label vertex 2
	 */
	public void removeEdge(String src, String dst) {
		removeEdge(
			vertexPosition.get(src.toUpperCase()),
			vertexPosition.get(dst.toUpperCase())
		);
	}

	/**
	 * Menghapus edge/penghubung vertex dengan format index pada adjacency matrix.
	 *
	 * @param src posisi vertex 1
	 * @param dst posisi vertex 2
	 */
	public void removeEdge(int src, int dst) {
		adjMatrix[src][dst] = 0;
		adjMatrix[dst][src] = 0;
	}

	/**
	 * Mengembalikan list vertices / vertex-vertex milik graf ini.
	 */
	public City[] getVertices() {
		return vertices;
	}

	/**
	 * Mengembalikan matriks adjacency milik graf ini.
	 */
	public int[][] getAdjMatrix() {
		return adjMatrix;
	}

	public int getWeight(int i, int j) {
		return adjMatrix[i][j];
	}

	/**
	 * Menampilkan seluruh vertex yang ada dalam graf.
	 */
	public void displayVertices() {
		System.out.print("Vertices: ");
		for (City v : vertices)
			System.out.print(v + " ");
		System.out.println();
	}

	/**
	 * Menggambarkan adjacency matrix hubungan antar vertex.
	 */
	public void displayMatrix() {
		System.out.print(" %\t\t\t  ");
		for (City vertex : vertices) {
			if (vertex != null) {
				System.out.printf("%13s ", vertex.label);
			}
		}
		System.out.println();

		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i] != null) {
				System.out.printf("%13s ", vertices[i].label);
				for (int j = 0; j < vertices.length; j++) {
					if (vertices[j] != null)
						System.out.printf("%13s ", (adjMatrix[i][j]));
				}
			}
			System.out.println();
		}
	}

	/**
	 * Mengembalikan indikator koneksi atau berat antara dua posisi vertex.
	 *
	 * @return boolean
	 */
	private boolean isConnected(int vertex1, int vertex2) {
		return getWeight(vertex1, vertex2) >= 1;
	}

	/**
	 * Metode untuk mencari jarak terpendek dari vertex src ke vertex dst dengan algoritma Dijkstra. Menggunakan
	 * matrix adjacency.
	 *
	 * @param src label asal
	 * @param dst tujuan tujuan
	 */
	public List<City> dijkstra(String src, String dst) {
		return dijkstra(
			vertexPosition.get(src.toUpperCase()),
			vertexPosition.get(dst.toUpperCase())
		);
	}

	/**
	 * Inner method untuk melakukan pencarian shortest path dari vertex src ke vertex dst dengan algoritma Dijkstra.
	 *
	 * @param src posisi vertex awal
	 * @param dst posisi vertex akhir
	 *
	 * @return vertex kota yang dilewati
	 * */
	private List<City> dijkstra(int src, int dst) {
		int[] distance = new int[vertices.length];
		int[] previous = new int[vertices.length];
		boolean[] visited = new boolean[vertices.length];
		int actualCost = 0;

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[src] = 0;
		previous[src] = -1;

		for (int i = 0; i < vertices.length - 1; i++) {
			int u = findMinDist(distance, visited);
			visited[u] = true;

			for (int v = 0; v < vertices.length; v++) {
				// Menghitung perbedaan ketinggian antara kota u dan v
				int mdplDiff = vertices[v].getMdpl() - vertices[u].getMdpl();
				int adjustedDistance = adjMatrix[u][v] + (mdplDiff / 100) * adjMatrix[u][v];
				/*
				 * Jika terdapat koneksi antar vertex u dan v DAN v belum true di visited DAN distance pada u
				 * ditambah bobot vektor u v lebih kecil dari distance pada v.
				 * */
				if ((!visited[v] && adjMatrix[u][v] != 0)
					&& (distance[u] != Integer.MAX_VALUE && distance[u] + adjMatrix[u][v] < distance[v])) {
					distance[v] = distance[u] + adjustedDistance;
					actualCost = distance[u] + adjMatrix[u][v];
					previous[v] = u;
				}
			}
		}

		/* Cetak harga dan urutan */
		System.out.println("Shortest distance from "
			+ vertices[src].label + " to " + vertices[dst].label + " costs " + actualCost);
		List<City> orderedVertex = getVertexOrder(previous, dst, new ArrayList<>());
		return orderedVertex;
	}

	/**
	 * Mendapatkan urutan vertex yang sudah terurut dari perhitungan successor pengembalian dijkstra.
	 * */
	public List<City> getVertexOrder(int[] previous, int currentVertex, List<City> vertexOrder) {
		/* Base case: index vertex sudah outbound */
		if (currentVertex == -1) {
			return null;
		}

		// Secara rekurisf mencetak previous dari vertex sebelumnya
		getVertexOrder(previous, previous[currentVertex], vertexOrder);

		vertexOrder.add(vertices[currentVertex]);
		return vertexOrder;
	}

	/**
	 * Mendapatkan jarak asli (tanpa perhitungan MDPL) dari sebuah list city terurut.
	 * */
	public int[] getVertexDistances(List<City> vertexOrder) {
		int[] distances = new int[vertexOrder.size() - 1];
		for (int i = 0; i < vertexOrder.size() - 1; i++) {
			distances[i] = adjMatrix[vertexOrder.get(i).getId()][vertexOrder.get(i + 1).getId()];
		}
		return distances;
	}

	/**
	 * Mencetak seluruh kota yang sudah terurut dengan jarak yang berelasi dengan kota sebelumnya (indexnya).
	 * */
	public void printEachVertexDistance(List<City> vertexOrder, int[] distances) {
		for (int i = 0; i < vertexOrder.size() - 1; i++) {
			System.out.printf("%s -> %s: %d\n", vertexOrder.get(i).getLabel(), vertexOrder.get(i + 1).getLabel(), distances[i]);
		}
	}

	/**
	 * Mendapatkan posisi vertex dengan jarak terpendek dari vertex src ke vertex dst dengan algoritma Dijkstra.
	 *
	 * @return posisi vertex dengan jarak terpendek
	 */
	private int findMinDist(int[] distance, boolean[] visited) {
		int min = Integer.MAX_VALUE;               		
		int minimumIndex = -1;

		for (int i = 0; i < distance.length; i++) {    	
			if (!visited[i] && distance[i] <= min) {  	
				min = distance[i];                    	
				minimumIndex = i;                      	
			}
		}

		return minimumIndex;                         	
	}

	/* Metode untuk mencetak isi Queue */
	private void printListContent(Queue<Integer> list) {
		System.out.print("; Queue: ");
		for (int v : list) {
			System.out.print(vertices[v].label + " ");
		}
		System.out.println();
	}

	/* Metode untuk mencetak isi Stack */
	private void printListContent(Stack<Integer> list) {
		System.out.print("; Stack: ");
		for (int v : list) {
			System.out.print(vertices[v].label + " ");
		}
		System.out.println();
	}

	/* Metode untuk mencetak isi Stack */
	private void printListContent(boolean[] list) {
		System.out.print("; Visited: ");
		for (int v = 0; v < list.length; v++) {
			if (list[v])
				System.out.print(vertices[v].label + " ");
		}
		System.out.println();
	}

	/* Getter for vertex */
	public int getVertex(String vertexLabel) {
		return vertexPosition.get(vertexLabel.toUpperCase());
	}
}
