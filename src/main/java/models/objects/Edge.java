package models.objects;

public class Edge {
    String sourceVertex;
    String destinationVertex;
    int weight;

    public Edge(String sourceVertex, String destinationVertex, int weight) {
        this.sourceVertex = sourceVertex;
        this.destinationVertex = destinationVertex;
        this.weight = weight;
    }

    public String getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(String sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    public String getDestinationVertex() {
        return destinationVertex;
    }

    public void setDestinationVertex(String destinationVertex) {
        this.destinationVertex = destinationVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" + "Path : Kota Asal = " + sourceVertex + 
                ", Kota Tujuan = " + destinationVertex + " , Jarak = " + weight + '}';
    }
}
