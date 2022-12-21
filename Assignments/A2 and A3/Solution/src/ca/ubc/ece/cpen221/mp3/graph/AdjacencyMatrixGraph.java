package ca.ubc.ece.cpen221.mp3.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Helpers.AdjacencyListHelper;
import Helpers.AdjacencyMatrixHelper;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyMatrixGraph implements Graph {
    private final int DEFAULT_CAPACITY = 10;
    private boolean[][] adjMatrix; // adjacency matrix
    private int numVertices; // number of vertices in the graph
    // protected Vertex[] vertices; // values of vertices
    protected AdjacencyMatrixHelper[] vertices; // values of vertices

    public AdjacencyMatrixGraph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        // this.vertices = Vertex[DEFAULT_CAPACITY];
        this.vertices = new AdjacencyMatrixHelper[DEFAULT_CAPACITY];
    }

    /**
     * Adds a vertex to the graph.
     *
     * Precondition: v is not already a vertex in the graph
     */
    @Override
    public void addVertex(Vertex v) {
        // check if vertex exist
        boolean found = false;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null) {
                if (vertices[i].aVertex.equals(v)) {
                    found = true;
                }
            }

        }

        // only if not found
        if (!found) {
            if (numVertices == vertices.length)
                expandCapacity();

            vertices[numVertices] = new AdjacencyMatrixHelper(v, new Integer[0]);
            for (int i = 0; i <= numVertices; i++) {
                adjMatrix[i][numVertices] = false;
                adjMatrix[numVertices][i] = false;
            }
            numVertices++;
        }

    }

    /**
     * Expand the capacity of vertices && adjMatrix to the double
     */
    private void expandCapacity() {
        System.gc();
        AdjacencyMatrixHelper[] largerVertices = new AdjacencyMatrixHelper[vertices.length * 2];
        System.out.println("vertices.length: " + vertices.length);
        boolean[][] largerAdjMatrix = new boolean[vertices.length * 2][vertices.length * 2];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                largerAdjMatrix[i][j] = adjMatrix[i][j];
            }
            largerVertices[i] = vertices[i];
        }

        vertices = largerVertices;
        adjMatrix = largerAdjMatrix;
    }

    /**
     * Adds an edge from v1 to v2.
     *
     * Precondition: v1 and v2 are vertices in the graph
     */
    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        int index1 = getIndexOfaVertex(v1);
        int index2 = getIndexOfaVertex(v2);
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            // adjMatrix[index2][index1] = true;
        }
    }

    /**
     * 
     * @param a
     *            Vertex
     * @return the Index of a Vertex
     */
    private int getIndexOfaVertex(Vertex v1) {
        int index = -1;
        for (int i = 0; (i < vertices.length) && (index == -1) && vertices[i] != null; i++) {
            // if (vertices[i].equals(v1)) {
            if (vertices[i].aVertex.equals(v1)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * @param index
     * @return true if the index between 0 and the size of the array
     */
    protected boolean indexIsValid(int index) {
        return ((index < numVertices) && (index >= 0));
    }

    /**
     * Check if there is an edge from v1 to v2.
     *
     * Precondition: v1 and v2 are vertices in the graph Postcondition: return
     * true iff an edge from v1 connects to v2
     */
    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        int v1Index = getIndexOfaVertex(v1);
        int v2Index = getIndexOfaVertex(v2);
        if (indexIsValid(v1Index) && indexIsValid(v2Index)) {
            return adjMatrix[v1Index][v2Index];
        }else{
            return false;
        }
        
        // || adjMatrix[getIndexOfaVertex(v2)][getIndexOfaVertex(v1)]

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
    @Override
    public List<Vertex> getDownstreamNeighbors(Vertex v) {
        List<Vertex> downstreamList = new ArrayList<Vertex>();
        // // perform DFS search
        // List<Vertex> resultList = Algorithms.DFSforAVertex(this, v);
        //
        // if (resultList.get(0).hashCode() == (v.hashCode())) {
        // downstreamList = resultList;
        // downstreamList = downstreamList.subList(1, downstreamList.size());
        // }

        Set<Integer> downstreamNeighbors = getNeighbors(v.hashCode());
        for (Integer neighborHash : downstreamNeighbors) {
            downstreamList.add(getVertixFromHashCode(neighborHash));
        }

        return downstreamList;
    }

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
    public List<Vertex> getUpstreamNeighbors(Vertex v) {
        List<Vertex> upstreamList = new ArrayList<Vertex>();
        // perform DFS search
        // List<Vertex> resultlist = Algorithms.DFSforAVertex(this.reverse(),
        // v);
        //
        // if (resultlist.get(0) == (v)) {
        // upstreamList = resultlist;
        // }
        //
        // if (upstreamList.size() != 0) {
        // upstreamList = upstreamList.subList(1, upstreamList.size());
        // }
        for (int i = 0; i < vertices.length && vertices[i] != null; i++) {
            Set<Integer> downstreamNeighbors = getNeighbors(((AdjacencyMatrixHelper) vertices[i]).aVertex.hashCode());
            for (Integer neighborHash : downstreamNeighbors) {
                if (neighborHash.equals(v.hashCode())) {
                    upstreamList.add(getVertixFromHashCode(((AdjacencyMatrixHelper) vertices[i]).aVertex.hashCode()));
                }
            }
        }

        return upstreamList;
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
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null) {
                // resultList.add(vertices[i]);
                resultList.add(vertices[i].aVertex);
            }

        }
        return resultList;
    }

    /**
     * get the neighbors of a Vertex (by its hashCode)
     */
    @Override
    public Set<Integer> getNeighbors(int hashChode) {
        Vertex aVertex = getVertixFromHashCode(hashChode);
        int anIndex = getIndexOfaVertex(aVertex);
        Set<Integer> getSetOfVerticie = new HashSet<Integer>();
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[anIndex][i]) {
                // getSetOfVerticie.add(vertices[i].hashCode());
                getSetOfVerticie.add(vertices[i].aVertex.hashCode());
            }
        }
        return getSetOfVerticie;
    }

    /**
     * @param hashCode
     *            the hashcode of a vertix
     * @return the Vertex object of an index
     * @throw an Exception if the hashcode not found
     */
    public Vertex getVertixFromHashCode(int hashCode) {
        for (int i = 0; i < vertices.length; i++) {
            // if (vertices[i].hashCode() == hashCode) {
            if (vertices[i].aVertex.hashCode() == hashCode) {
                return vertices[i].aVertex;
            }
        }
        throw new RuntimeException();
    }

    /**
     * return the size
     */
    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        int size = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null) {
                size++;
            }
        }
        return size;
    }

    @Override
    public boolean hasNextIterator(int vHash) {
        AdjacencyMatrixHelper obj = vertices[getIndexOfaVertex(getVertixFromHashCode(vHash))];
        return obj.neighbourIterator.hasNext();
    }

    /**
     * return the hashcode of the next neighbor
     */
    @Override
    public int nextIterator(int vHash) {
        AdjacencyMatrixHelper obj = vertices[getIndexOfaVertex(getVertixFromHashCode(vHash))];
        int indexOfresult = obj.neighbourIterator.next();
        vertices[getIndexOfaVertex(getVertixFromHashCode(vHash))] = obj;
        return vertices[indexOfresult].aVertex.hashCode();
    }

    @Override
    public void resetIterator(int vHash) {
        AdjacencyMatrixHelper obj = vertices[getIndexOfaVertex(getVertixFromHashCode(vHash))];
        obj.neighbourIterator = Arrays
                .asList(getNeighborHashesFromARow(getIndexOfaVertex(getVertixFromHashCode(vHash)))).iterator();
        vertices[getIndexOfaVertex(getVertixFromHashCode(vHash))] = obj;
    }

    private Integer[] getNeighborHashesFromARow(int indexOfaVertex) {
        List<Integer> aList = new ArrayList<Integer>();
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[indexOfaVertex][i]) {
                aList.add(i);
            }
        }
        Integer resultArr[] = aList.toArray(new Integer[aList.size()]);
        return resultArr;
    }

    private Graph reverse() {
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
}
