package Helpers;

import java.util.Iterator;

public class DFSHelperVertex {
    public DFSHelperVertex(int hashCode, boolean b, Iterator<Integer> i) {
        this.aVertexHash = hashCode;
        this.visited = b;
        this.neighbourIterator = i;
    }
    public Integer aVertexHash;
    public boolean visited;
    public Iterator<Integer> neighbourIterator;
    
}
