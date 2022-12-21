package Helpers;
import ca.ubc.ece.cpen221.mp3.staff.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AdjacencyListHelper {
    public Vertex aVertex;
    public Set<Integer> verticeSet;
    public Iterator<Integer> neighbourIterator;
    
    /**
     * 
     * Constructor
     */
    public AdjacencyListHelper(Vertex aVertex) {
        this.aVertex = aVertex;
        this.verticeSet = new HashSet<Integer>();
        this.neighbourIterator = verticeSet.iterator();
    }
    
    public void addVertex(Integer vertexHash){
        this.verticeSet.add(vertexHash);
    }
    
    public Set<Integer> getListOfVerticies(){
        return verticeSet;
    }
    
    public boolean contains(Integer vertexHash){
        return verticeSet.contains(vertexHash);
    }

}
