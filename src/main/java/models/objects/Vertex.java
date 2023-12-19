package models.objects;

public class Vertex {
    String label;
    boolean visited;
    
    public Vertex(String label) {
        this.label = label;
        this.visited = visited;
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }    
    
    public String displayCity(){
        return label + " ";
    }
}
