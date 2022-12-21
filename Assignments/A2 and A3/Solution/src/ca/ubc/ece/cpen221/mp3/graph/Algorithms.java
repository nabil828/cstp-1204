package ca.ubc.ece.cpen221.mp3.graph;

import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.Matchers.*;
import static org.junit.matchers.JUnitMatchers.*;
import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import Helpers.BFSHelperVertex;
import Helpers.DFSHelperVertex;
import Helpers.VertexDistanceComparator;
import Helpers.shortestDistanceHelper;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;
import static org.junit.Assert.*;
import Exceptions.NoPathException;
import static org.junit.Assert.*;

public class Algorithms {

    /**
     * *********************** Algorithms ****************************
     * 
     * Please see the README for the machine problem for a more detailed
     * specification of the behavior of each method that one should implement.
     */

    // procedure dijkstra(G, l, s)
    // Input: Graph G = (V, E), directed or undirected;
    // positive edge lengths {le : e ∈ E}; vertex s ∈ V
    // Output: For all vertices u reachable from s, dist(u) is set to the
    // distance from s to u.
    //
    // for all u ∈ V :
    // dist(u) = ∞
    // prev(u) = nil
    // dist(s) = 0
    // H = makequeue(V ) (using dist-values as keys)
    // while H is not empty:
    // u = deletemin(H)
    // for all edges (u, v) ∈ E:
    // if dist(v) > dist(u) + l(u, v):
    // dist(v) = dist(u) + l(u, v)
    // prev(v) = u
    // decreasekey(H, v)
    /**
     * This is provided as an example to indicate that this method and other
     * methods should be implemented here.
     * 
     * You should write the specs for this and all other methods.
     * 
     * @param graph
     * @param the
     *            starting vertex
     * @param the
     *            ending vertex
     * @return the shortest distance in number of hops between and b
     * @throws NoPathException
     *             if there is no path from a to b
     */
    public static int shortestDistance(Graph aGraph, Vertex a, Vertex b) throws NoPathException {
        if(a.equals(b)){
//            throw new NoPathException();
            return 0;
        }
        
        final int MAX_DISTANCE = 99999999;
        // get all the verticies
        List<Vertex> myVertices = aGraph.getVertices();
        // for all u ∈ V :
        // dist(u) = ∞
        // prev(u) = nil
//        System.out.println("Preparing Dikstra..");
        Map<Integer, shortestDistanceHelper> DistanceVertices = new HashMap<Integer, shortestDistanceHelper>();
        for (Vertex v : myVertices) {
            if (v.equals(a)) {
                DistanceVertices.put(v.hashCode(), new shortestDistanceHelper(v, 0, null));
            } else {
                DistanceVertices.put(v.hashCode(), new shortestDistanceHelper(v, MAX_DISTANCE, null));
            }

        }
//        System.out.println("Preparation Done.");

        // H = makequeue(V ) (using dist-values as keys)
        // TODO can I make the comparator to compare using the hashcode instead
        // of the whole object
        Comparator<shortestDistanceHelper> comparator = new VertexDistanceComparator();
        PriorityQueue<shortestDistanceHelper> priorityQueue = new PriorityQueue<shortestDistanceHelper>(10, comparator); // 10
                                                                                                                         // is
                                                                                                                         // the
                                                                                                                         // initial
                                                                                                                         // comprator size
        priorityQueue.addAll(DistanceVertices.values());
//        System.out.println("Priority Queue is ready");

        // while H is not empty:
        // u = deletemin(H)
        // for all edges (u, v) ∈ E:
        // if dist(v) > dist(u) + l(u, v):
        // dist(v) = dist(u) + l(u, v)
        // prev(v) = u
        // decreasekey(H, v)
        boolean toBreak = false; //break if b found
        while (!priorityQueue.isEmpty()) {
            shortestDistanceHelper u = priorityQueue.remove();
            // get u neighbors 
            Set<Integer> uNeighborsSet = aGraph.getNeighbors(u.aVertex.hashCode());
            List<shortestDistanceHelper> uNeighborsVertices = new ArrayList<shortestDistanceHelper>();

            for (Integer neighbor : uNeighborsSet) {
                shortestDistanceHelper neighborObj = DistanceVertices.get(neighbor);
                uNeighborsVertices.add(neighborObj);
            }

            for (shortestDistanceHelper v : uNeighborsVertices) {
                if (v.distance > u.distance + 1) {
                    v.distance = u.distance + 1;
                    v.prev = u.aVertex;
                    
                    // break if b found
                    if (v.aVertex.hashCode() == b.hashCode()) {
                        toBreak = true;
                    }
                    
                    // decreasekey(H, v)
                    priorityQueue.remove(v);
                    priorityQueue.add(v);
                }
                
            }
            
            // stop if you reach b
            if (toBreak) {
                break;
            }
        }

        // find b and return its distance
//        System.out.println("Searching for B");
        shortestDistanceHelper bFoundObj = DistanceVertices.get(b.hashCode());

        // assertNotNull(bFoundObj);
        if(bFoundObj == null){
            throw new NoPathException();
        }
        
        if (bFoundObj.distance == MAX_DISTANCE) {
            throw new NoPathException();
        }

        // print the path from b back to a
        System.out.print("Printing the path from " + b.getLabel()+ " to " + a.getLabel()+ ": ");
        shortestDistanceHelper pointerObj = bFoundObj;
        while (pointerObj.aVertex.hashCode() != a.hashCode()) {
            System.out.print(pointerObj.aVertex.getLabel() + " -> ");
            pointerObj = DistanceVertices.get(pointerObj.prev.hashCode());
        }
        System.out.println(a.getLabel());

        return bFoundObj.distance;
    }

    // 1 procedure DFS-iterative(G,v):
    // 2 let S be a stack
    // 3 S.push(v)
    // 4 while S is not empty
    // 5 v = S.pop()
    // 6 if v is not labeled as discovered:
    // 7 label v as discovered
    // 8 for all edges from v to w in G.adjacentEdges(v) do
    // 9 S.push(w)
    // public static Set<List<Vertex>> DFS(Graph aGraph){
    //
    // Set<List<Vertex>> myResultSet = new HashSet<List<Vertex>>();
    // Set<List<Integer>> myResultIntegerSet = new HashSet<List<Integer>>();
    //
    // List<Vertex> myVertices = aGraph.getVertices();
    // for(Vertex v : myVertices){ // no need in case of upstream!!!!!!!!!!!!!
    // //create Hashtable for discovery
    // List<Integer> discoveredIntegerVertices = new ArrayList<Integer>();
    //
    // Stack<Integer> myStack = new Stack<Integer>();
    // myStack.push(v.hashCode());
    // while(!myStack.isEmpty()){
    // int vHash= myStack.pop();
    // if(!discoveredIntegerVertices.contains(vHash)){
    // discoveredIntegerVertices.add(vHash);
    // }
    //
    // //get v neighbors
    // Set<Integer> verticesHashList =aGraph.getNeighbors(vHash);
    // for (int x : verticesHashList){
    // myStack.push(x);
    // }
    // }
    // myResultIntegerSet.add(discoveredIntegerVertices);
    // }
    //
    // for (List<Integer> l :myResultIntegerSet){
    // List<Vertex> listOfVerticex = new ArrayList<Vertex>();
    // for (int x : l){
    // listOfVerticex.add(aGraph.getVertixFromHashCode(x));
    // }
    // myResultSet.add(listOfVerticex);
    // }
    //
    // return myResultSet;
    // }

    /**
     * @param aGraph
     *            is the the input graph
     * @return set of List of vertieces in order of traversal. Each List for
     *         each node
     */
    public static Set<List<Vertex>> DFS(Graph aGraph) {
        Set<List<Vertex>> myResultSet = new HashSet<List<Vertex>>();
        for (Vertex x : aGraph.getVertices()) {
            myResultSet.add(DFSforAVertex(aGraph, x));
        }
        return myResultSet;
    }

    /**
     * 
     * Inspired from http://algs4.cs.princeton.edu/41graph/NonrecursiveDFS.java
     * 
     * @param aGraph
     *            is the the input graph
     * @param v
     *            is the vertex to start the search at
     * @return List of vertieces in order of traversal
     */
    public static List<Vertex> DFSforAVertex(Graph aGraph, Vertex v) {
        // create Hashtable for visited nodes for a quick access
        Map<Integer, Boolean> visitedMAp = new HashMap<Integer, Boolean>();
        // we need the list to preserve the order of the visited vertices
        List<Integer> discoveredIntegerVerticesSet = new ArrayList<Integer>();

        // Initilize the HashMap
        for (Vertex x : aGraph.getVertices()) {
            visitedMAp.put(x.hashCode(), false);
        }

        // reset the iterators
        for (Vertex x : aGraph.getVertices()) {
            aGraph.resetIterator(x.hashCode());
        }

        Stack<Integer> myStack = new Stack<Integer>();
        visitedMAp.put(v.hashCode(), true);
        discoveredIntegerVerticesSet.add(v.hashCode());
        myStack.push(v.hashCode());

        while (!myStack.isEmpty()) {
            int vHash = myStack.peek();
            // Itrator used to speed up DFS somehow
            if (aGraph.hasNextIterator(vHash)) {
                int w = aGraph.nextIterator(vHash);
                if (!visitedMAp.get(w)) {
                    visitedMAp.put(w, true);
                    discoveredIntegerVerticesSet.add(w);
                    myStack.push(w);
                    System.out.println("push()" + "myStack.size()= " + myStack.size());
                }
            } else {
                myStack.pop();
                System.out.println("pop()" + "myStack.size()= " + myStack.size());
            }
        }

        // Get the Vertex object from the its hashCode
        List<Vertex> listOfVerticex = new ArrayList<Vertex>();
        for (int x : discoveredIntegerVerticesSet) {
            listOfVerticex.add(aGraph.getVertixFromHashCode(x));
        }
        return listOfVerticex;
    }

    // Breadth-First-Search(G, v):
    // 2
    // 3 for each node n in G:
    // 4 n.distance = INFINITY
    // 5 n.parent = NIL
    // 6
    // 7 create empty queue Q
    // 8
    // 9 v.distance = 0
    // 10 Q.enqueue(v)
    // 11
    // 12 while Q is not empty:
    // 13
    // 14 u = Q.dequeue()
    // 15
    // 16 for each node n that is adjacent to u:
    // 17 if n.distance == INFINITY:
    // 18 n.distance = u.distance + 1
    // 19 n.parent = u
    // 20 Q.enqueue(n)

//    private Set<Integer> getUnvisitedNeighbors(Set<DFSHelperVertex> verticesHashSet) {
//        Set<Integer> result = new HashSet<Integer>();
//        for (DFSHelperVertex x : verticesHashSet) {
//            if (!x.visited) {
//                result.add(x.aVertexHash);
//            }
//        }
//        return result;
//    }
    
    /**
     * 
     * @param aGraph
     * @return
     */
    public static Set<List<Vertex>> BFS(Graph aGraph) {

        Set<List<Vertex>> myResultSet = new HashSet<List<Vertex>>();
        List<Vertex> myVertices = aGraph.getVertices();

        // 3 for each node n in G:
        // 4 n.distance = INFINITY
        // 5 n.parent = NIL
        List<BFSHelperVertex> BFSVertices = new ArrayList<BFSHelperVertex>();
        for (Vertex e : myVertices) {
            BFSVertices.add(new BFSHelperVertex(e, null, -1));
        }

        for (BFSHelperVertex v : BFSVertices) {
            for (BFSHelperVertex e : BFSVertices) {
                e.Distance = -1;
                e.parent = null;
            }

            // 6
            // 7 create empty queue Q
            // 8
            Queue<BFSHelperVertex> helperVerticesQ = new LinkedList<BFSHelperVertex>();
            List<Vertex> discoveredVertex = new LinkedList<Vertex>();

            // 9 v.distance = 0
            // 10 Q.enqueue(v)
            v.Distance = 0;
            helperVerticesQ.add(v);
            discoveredVertex.add(v.aVertex);

            // 12 while Q is not empty:
            // 13
            // 14 u = Q.dequeue()
            // 15
            while (!helperVerticesQ.isEmpty()) {
                BFSHelperVertex u = helperVerticesQ.poll();
                // discoveredVertex.remove(u.aVertex);
                // 16 for each node n that is adjacent to u:
                // 17 if n.distance == INFINITY:
                // 18 n.distance = u.distance + 1
                // 19 n.parent = u
                // 20 Q.enqueue(n)
                for (BFSHelperVertex n : BFSVertices) {
                    // get adjacent
                    if (aGraph.edgeExists(u.aVertex, n.aVertex)) {
                        if (n.Distance == -1) {
                            n.Distance = u.Distance + 1;
                            n.parent = u.aVertex;
                            helperVerticesQ.add(n);
                            discoveredVertex.add(n.aVertex);
                        }
                    }

                }
            }

            myResultSet.add(discoveredVertex);
        }
        return myResultSet;
    }
    
    public static List<Vertex> commonDownStream(Graph aGraph, Vertex a, Vertex b) {
        List<Vertex> aDownstreamList = aGraph.getDownstreamNeighbors(a);
        List<Vertex> bDownstreamList = aGraph.getDownstreamNeighbors(b);
        List<Vertex> intersectionList = new ArrayList<Vertex>();

        System.out.println("aDownstreamList length:" + aDownstreamList.size());
        System.out.println("bDownstreamList length:" + bDownstreamList.size());

        System.out.println("Calculating the intersection");
        for (Vertex t : aDownstreamList) {
            if (bDownstreamList.contains(t)) {
                intersectionList.add(t);
            }
        }
        return intersectionList;
    }
    
    public static List<Vertex> commonUpStream(Graph aGraph, Vertex a, Vertex b) {
        List<Vertex> aUpStreamList = aGraph.getUpstreamNeighbors(a);
        List<Vertex> bUpStreamList = aGraph.getUpstreamNeighbors(b);
        List<Vertex> intersectionList = new ArrayList<Vertex>();

        System.out.println("aDownstreamList length:" + aUpStreamList.size());
        System.out.println("bDownstreamList length:" + bUpStreamList.size());

        System.out.println("Calculating the intersection");
        for (Vertex t : aUpStreamList) {
            if (bUpStreamList.contains(t)) {
                intersectionList.add(t);
            }
        }
        return intersectionList;
    }
    
//    /**
//     * 
//     * @param aGraph
//     * @param userA
//     * @param userB
//     * @return
//     */
//
//    public static List<Vertex> commonInfluencers(Graph aGraph, Vertex userA, Vertex userB) {
//        List<Vertex> aDownstreamList = aGraph.getDownstreamNeighbors(userA);
//        List<Vertex> bDownstreamList = aGraph.getDownstreamNeighbors(userB);
//        List<Vertex> intersectionList = new ArrayList<Vertex>();
//
//        System.out.println("aDownstreamList length:" + aDownstreamList.size());
//        System.out.println("bDownstreamList length:" + bDownstreamList.size());
//
//        System.out.println("Calculating the intersection");
//        for (Vertex t : aDownstreamList) {
//            if (bDownstreamList.contains(t)) {
//                intersectionList.add(t);
//            }
//        }
//        return intersectionList;
//    }
    

}
