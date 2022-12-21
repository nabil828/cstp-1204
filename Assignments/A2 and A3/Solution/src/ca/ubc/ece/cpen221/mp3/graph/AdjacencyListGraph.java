package ca.ubc.ece.cpen221.mp3.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Helpers.AdjacencyListHelper;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListGraph implements Graph {
    private Map<Integer, AdjacencyListHelper> myAdjacencyMap;

    public AdjacencyListGraph() {
        // TODO Auto-generated constructor stub
        this.myAdjacencyMap = new HashMap<Integer, AdjacencyListHelper>();
    }

    /**
     * Adds a vertex to the graph.
     *
     * Precondition: v is not already a vertex in the graph
     */
    @Override
    public void addVertex(Vertex v) {
        if (!myAdjacencyMap.containsKey(v.hashCode())) {
            myAdjacencyMap.put(v.hashCode(), new AdjacencyListHelper(v));
        }
    }

    /**
     * Adds an edge from v1 to v2.
     *
     * Precondition: v1 and v2 are vertices in the graph
     */
    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        // add v2 in the list of v1
        if (myAdjacencyMap.containsKey(v1.hashCode()) && myAdjacencyMap.containsKey(v2.hashCode())) {
            AdjacencyListHelper mapValue = (AdjacencyListHelper) myAdjacencyMap.get(v1.hashCode());
            mapValue.addVertex(v2.hashCode());
            mapValue.neighbourIterator = mapValue.verticeSet.iterator();
            myAdjacencyMap.put(v1.hashCode(), mapValue);
        }
//        else {
//            throw new RuntimeException("Add the vertexL" + v1.toString() + "first");
//        }
    }

    /**
     * Check if there is an edge from v1 to v2.
     *
     * Precondition: v1 and v2 are vertices in the graph Postcondition: return
     * true iff an edge from v1 connects to v2
     */
    public boolean edgeExists(Vertex v1, Vertex v2) {
        AdjacencyListHelper aTempSet = (AdjacencyListHelper) myAdjacencyMap.get(v1.hashCode());
        return aTempSet.contains(v2.hashCode());
    }

    /**
     * Get an array containing all downstream vertices adjacent to v.
     *
     * Precondition: v is a vertex in the graph
     * 
     * Postcondition: returns a list containing each vertex w such that there is
     * an edge from v to w. The size of the list must be as small as possible
     * (No trailing null elements). This method should return a list of size 0
     * iff v has no downstream neighbors.
     */
    public List<Vertex> getDownstreamNeighbors(Vertex v) {
        List<Vertex> downstreamList = new ArrayList<Vertex>();
        Set<Integer> downstreamListIntegers = getNeighbors(v.hashCode());
        for (Integer neighborHash : downstreamListIntegers){
            downstreamList.add(getVertixFromHashCode(neighborHash));
        }
//         perform DFS search
//        List<Vertex> resultList = Algorithms.DFSforAVertex(this, v);
//        // debugging
//        // v should at andex 0
//        int firstIndexOfV = resultList.indexOf(v);
//        int lastIndexOfV = resultList.lastIndexOf(v);
//        if (firstIndexOfV != lastIndexOfV) {
//            System.out.println("v:" + v.getLabel());
//            System.out.println("firstIndexOfV: " + firstIndexOfV);
//            System.out.println("lastIndexOfV: " + lastIndexOfV);
//        }
//
//        if (resultList.get(0).hashCode() == (v.hashCode())) {
//            downstreamList = resultList;
//            downstreamList = downstreamList.subList(1, downstreamList.size());
//        }
        
        
        return downstreamList;
    }

    // used in getDownstreamNeighbors
    // private Set<Vertex> getMeAllChilds(Set<Vertex> setOfChilds) {
    // Set<Vertex> resultSet= new HashSet<Vertex>();
    // for(Vertex x : setOfChilds){
    // SetOfVertices aTempSetObj= (SetOfVertices) myAdjacencyMap.get(x);
    // Set<Vertex> setOfGrandChilds = aTempSetObj.getListOfVerticies();
    //
    // resultSet.addAll(getMeAllChilds(setOfGrandChilds));
    // }
    // return resultSet;
    // }

    /**
     * Get an array containing all upstream vertices adjacent to v.
     *
     * Precondition: v is a vertex in the graph
     * 
     * Postcondition: returns a list containing each vertex u such that there is
     * an edge from u to v. The size of the list must be as small as possible
     * (No trailing null elements). This method should return a list of size 0
     * iff v has no upstream neighbors.
     */
    @Override
    public List<Vertex> getUpstreamNeighbors(Vertex v) {
//        List<Vertex> upstreamList = new ArrayList<Vertex>();
//        // perform DFS search
//        List<Vertex> resultlist = Algorithms.DFSforAVertex(this.reverse(), v);
//
//        if (resultlist.get(0) == (v)) {
//            upstreamList = resultlist;
//        }
//
//        if (upstreamList.size() != 0) {
//            upstreamList = upstreamList.subList(1, upstreamList.size());
//        }
//        return upstreamList;
        List<Vertex> upstreamList = new ArrayList<Vertex>();
        
        for (Map.Entry<Integer, AdjacencyListHelper> entry : myAdjacencyMap.entrySet()) {
            Set<Integer> downstreamListIntegers = getNeighbors(entry.getKey());
            for (Integer neighborHash : downstreamListIntegers){
                if(neighborHash.equals(v.hashCode())){
                    upstreamList.add(getVertixFromHashCode(entry.getKey()));
                }                
            }            
        }
        
        
      
        return upstreamList;

    }

    private Graph reverse() {
        // TODO Auto-generated method stub
        // Digraph R = new Digraph(V);
        // for (int v = 0; v < V; v++) {
        // for (int w : adj(v)) {
        // R.addEdge(w, v);
        // }
        // }
        // return R;
        Graph reversedGraph = new AdjacencyListGraph();
        List<Vertex> listOfVertices = this.getVertices();

        for (Vertex v : listOfVertices) {
            reversedGraph.addVertex(v);
        }

        for (Vertex v : listOfVertices) {
            Set<Integer> neoghborsList = getNeighbors(v.hashCode());
            for (int w : neoghborsList) {
                reversedGraph.addEdge(getVertixFromHashCode(w), v);
            }
        }

        return reversedGraph;
    }

    /**
     * Down stream neibors
     */
    @Override
    public Set<Integer> getNeighbors(int hashCode) {
        AdjacencyListHelper mapValue = myAdjacencyMap.get(hashCode);
        Set<Integer> getListOfVerticie = mapValue.getListOfVerticies();
        return getListOfVerticie;
    }

    /**
     * Get all vertices in the graph.
     *
     * Postcondition: returns a list containing all vertices in the graph. This
     * method should return a list of size 0 iff the graph has no vertices.
     */
    @Override
    public List<Vertex> getVertices() {
        List<Vertex> resultList = new ArrayList<Vertex>();
        for (Map.Entry<Integer, AdjacencyListHelper> entry : myAdjacencyMap.entrySet()) {
            AdjacencyListHelper x = entry.getValue();
            resultList.add(x.aVertex);
        }

        return resultList;
    }

    public Vertex getVertixFromHashCode(int hashCode) {
        AdjacencyListHelper obj = myAdjacencyMap.get(hashCode);
        return obj.aVertex;
    }

    @Override
    public int getSize() {
        return myAdjacencyMap.size();
    }

    @Override
    public boolean hasNextIterator(int vHash) {
        AdjacencyListHelper obj = myAdjacencyMap.get(vHash);
        return obj.neighbourIterator.hasNext();
    }

    @Override
    public int nextIterator(int vHash) {
        AdjacencyListHelper obj = myAdjacencyMap.get(vHash);
        int result = obj.neighbourIterator.next();
        myAdjacencyMap.put(vHash, obj);
        return result;
    }

    @Override
    public void resetIterator(int hashCode) {
        AdjacencyListHelper obj = myAdjacencyMap.get(hashCode);
        obj.neighbourIterator = obj.verticeSet.iterator();
        myAdjacencyMap.put(hashCode, obj);
    }
}
