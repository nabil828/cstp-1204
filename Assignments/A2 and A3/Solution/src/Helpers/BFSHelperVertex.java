package Helpers;
import ca.ubc.ece.cpen221.mp3.staff.*;

public class BFSHelperVertex {
    public Vertex aVertex;
    public Vertex parent;
    public int Distance;
    
    public BFSHelperVertex(Vertex aVertex, Vertex parent, int distance){
        this.aVertex = aVertex;
        this.parent = parent;
        this.Distance = distance;
    }
    
    
}
