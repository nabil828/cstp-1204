package Helpers;

import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class shortestDistanceHelper {
    public Vertex aVertex;
    public int distance;
    public Vertex prev;
    
    public shortestDistanceHelper(Vertex aVertex, int distance, Vertex prev) {
        this.aVertex = aVertex;
        this.distance = distance;
        this.prev = prev;
    }
}
