package models.objects;

/**
 * Kelas dasar yang merepresentasikan sisi pada graf, menghubungkan antar dua {@link Vertex}.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * @author <a href="https://github.com/BoniRaDityA">Ditya</a>
 * */

public class Edge {
    
    Vertex source;
    Vertex destination;
    int weight;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{%s -> %s: %d}".formatted(source, destination, weight);
    }
}
