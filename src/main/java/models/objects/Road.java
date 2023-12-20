package models.objects;

/**
 * Kelas yang merepresentasikan jalan antara dua buah {@link City} dalam graf peta.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public class Road extends Edge {
    Traffic traffic;

    public Road(Vertex source, Vertex destination, int weight, Traffic traffic) {
        super(source, destination, weight);
        this.traffic = traffic;
    }

    public Traffic getTraffic() {
        return traffic;
    }

    public void setTraffic(Traffic traffic) {
        this.traffic = traffic;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + traffic;
    }
}
