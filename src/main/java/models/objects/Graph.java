package models.objects;

import java.util.*;

public class Graph {

	private Vertex[] vertices;
	private int[][] adjMatrix;
	private int backIdx;
	private HashMap<String, Integer> vertexPosition;

	public Graph(int nVertices) {
		this.vertices = new Vertex[nVertices];
		this.adjMatrix = new int[nVertices][nVertices];
		this.backIdx = 0;
		vertexPosition = new HashMap<>();
	}

	/**
	 * Menambahkan sebuah vertex / titik ke dalam graf dengan label vertex.
	 *
	 * @param label label vertex
	 */
	public void addVertex(String label) {
		vertices[backIdx] = new Vertex(label, backIdx);
		vertexPosition.put(label.toUpperCase(), backIdx);
		backIdx++;
	}

	/**
	 * Menambahkan sebuah vertex / titik ke dalam graf dengan label vertex.
	 *
	 * @param vertex vertex yang sudah ada
	 */
	public void addVertex(Vertex vertex) {
		vertices[backIdx] = vertex;
		vertexPosition.put(vertex.label.toUpperCase(), backIdx);
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
	public Vertex[] getVertices() {
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
		for (Vertex v : vertices)
			System.out.print(v + " ");
		System.out.println();
	}

	/**
	 * Menggambarkan adjacency matrix hubungan antar vertex.
	 */
	public void displayMatrix() {
		System.out.print(" % ");
		for (Vertex vertex : vertices) {
			if (vertex != null) {
				System.out.printf("%2s ", vertex.label);
			}
		}
		System.out.println();

		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i] != null) {
				System.out.printf("%2s ", vertices[i].label);
				for (int j = 0; j < vertices.length; j++) {
					if (vertices[j] != null)
						System.out.printf("%2s ", (adjMatrix[i][j]));
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
	public void dijkstra(String src, String dst) {
		dijkstra(
			vertexPosition.get(src.toUpperCase()),
			vertexPosition.get(dst.toUpperCase())
		);
	}

	/**
	 * Inner method untuk melakukan pencarian shortest path dari vertex src ke vertex dst dengan algoritma Dijkstra.
	 *
	 * @param src posisi vertex awal
	 * @param dst posisi vertex akhir
	 * */
	private void dijkstra(int src, int dst) {
		int[] distance = new int[vertices.length];
		int[] previous = new int[vertices.length];
		boolean[] visited = new boolean[vertices.length];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[src] = 0;
		previous[src] = -1;

		for (int i = 0; i < vertices.length - 1; i++) {
			int u = findMinDist(distance, visited);
			visited[u] = true;

			for (int v = 0; v < vertices.length; v++)
				/*
				 * Jika terdapat koneksi antar vertex u dan v DAN v belum true di visited DAN distance pada u
				 * ditambah bobot vektor u v lebih kecil dari distance pada v.
				 * */
				if ((!visited[v] && adjMatrix[u][v] != 0)
					&& (distance[u] != Integer.MAX_VALUE && distance[u] + adjMatrix[u][v] < distance[v])) {
					distance[v] = distance[u] + adjMatrix[u][v];// Isi distance pada v dengan distance u + bobot
					previous[v] = u;							// Isi previous pada v dengan u
				}
		}

		/* Cetak harga dan urutan */
		System.out.println("Shortest distance from "
			+ vertices[src].label + " to " + vertices[dst].label + " costs " + distance[dst]);
		printPath(previous, dst);
	}

	/**
	 * Mencetak alur path dari vertex awal ke vertex akhir dengan algoritma Dijkstra secara rekursif.
	 *
	 * @param previous list previous dari vertex
	 * @param currentVertex index vertex yang ingin dicetak pada previous
	 * */
	private void printPath(int[] previous, int currentVertex) {
		/* Base case: index vertex sudah outbound */
		if (currentVertex == -1) {
			return;
		}

		// Secara rekurisf mencetak previous dari vertex sebelumnya
		printPath(previous, previous[currentVertex]);

		// Cetak label vertex
		System.out.print(vertices[currentVertex].label + " ");
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
}
