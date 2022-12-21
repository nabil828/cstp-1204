package Helpers;

import ca.ubc.ece.cpen221.mp3.staff.*;

import java.util.Arrays;
import java.util.Iterator;

public class AdjacencyMatrixHelper {
    public Vertex aVertex;
    public Iterator<Integer> neighbourIterator;
    
    /**
     * 
     * Constructor
     */
    public AdjacencyMatrixHelper(Vertex vertex, Integer arr[]) {
        this.aVertex = vertex;
        this.neighbourIterator = Arrays.asList(arr).iterator();
    }    
}
