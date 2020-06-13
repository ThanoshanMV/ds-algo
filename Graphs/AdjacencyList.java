package Graphs;

import java.util.*;

/**
 * A class that implements a directed graph.
 *
 * The graph may have self-loops, parallel edges.
 * Vertices are labeled by integers 0 .. n-1
 * and don't have String labels.
 * The edges of the graph are not labeled.
 *
 * Representation of edges via Adjacency List.
 */
public class AdjacencyList extends Graph{
    // Mapping each vertex to its neighbor vertices
    Map<Integer, List<Integer>> adjMap;

    public AdjacencyList(){
        adjMap = new HashMap<Integer, List<Integer>>();
    }

    /**
     * Implement the abstract method for adding a vertex.
     */
    @Override
    public void implementAddVertex() {
        // Get vertices number in the Graph
        int v = getVertices();
        List<Integer> neighbor = new ArrayList<Integer>();
        adjMap.put(v,neighbor);
    }

    /**
     * Implement the abstract method for adding an edge.
     * @param vertex1 the index of the start point for the edge.
     * @param vertex2 the index of the end point for the edge.
     */
    @Override
    public void implementAddEdge(int vertex1, int vertex2) {
        adjMap.get(vertex1).add(vertex2);
    }

    /**
     * Implement the abstract method for finding all
     * out-neighbors of a vertex.
     * If there are multiple edges between the vertex
     * and one of its out-neighbors, this neighbor
     * appears once in the list for each of these edges.
     * @param v Index of vertex.
     * @return  List<Integer> a list of indices of vertices.
     */
    @Override
    public List<Integer> getNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<Integer>();
        neighbors = adjMap.get(v);
        return neighbors;
        /*
        Note: return adjMap.get(v); will do the work for us but
        it exposes our internal Graph structure.
         */
    }

    /**
     * Implement the abstract method for finding all
     * in-neighbors of a vertex.
     * If there are multiple edges between the vertex
     * and one of its in-neighbors, this neighbor
     * appears once in the list for each of these edges.
     * @param v Index of vertex.
     * @return  List<Integer> a list of indices of vertices.
     */
    @Override
    public List<Integer> getInNeighbors(int v) {
        List<Integer> inNeighbor = new ArrayList<Integer>();
        Set<Integer> keys = adjMap.keySet();
        for(Integer u: keys){
            //iterate through all edges in u's adjacency list and
            //add u to the inNeighbor list of v whenever an edge
            //with startpoint u has endpoint v.
            for(Integer z: adjMap.get(u)){
                if (v == z){
                    inNeighbor.add(u);
                }
            }
        }
        return inNeighbor;
    }

    /**
     * Implement the abstract method for finding all
     * vertices reachable by two hops from v.
     * @param v The starting vertex
     * @return List<Integer> a list of indices of vertices.
     */
    @Override
    public List<Integer> getDistance2(int v) {
        List<Integer> twoHop = new ArrayList<Integer>();
        List<Integer> oneHop = this.getNeighbors(v);
        for (Integer i: oneHop){
            twoHop.addAll(this.getNeighbors(i));
        }
        return twoHop;
    }

    public static void main(String[] args) {
        Graph gh = new AdjacencyMatrix();
        System.out.println("Initial Vertices in the Graph " + gh.getVertices());
        System.out.println("Initial Edges in the Graph " + gh.getEdges());
        System.out.println("");

        // Add vertices 0,1,2,3,4,5,6,7,8,9,10,11,12
        gh.addVertex(); // 0
        gh.addVertex(); // 1
        gh.addVertex(); // 2
        gh.addVertex(); // 3
        gh.addVertex(); // 4
        gh.addVertex(); // 5
        gh.addVertex(); // 6
        gh.addVertex(); // 7
        gh.addVertex(); // 8
        gh.addVertex(); // 9
        gh.addVertex(); // 10
        gh.addVertex(); // 11
        gh.addVertex(); // 12

        System.out.println("Vertices Count in the Graph " + gh.getVertices());
        System.out.println("");

        /*
         * Adding Edges to Vertices in this Graph
         */
        // 0 -> 1
        gh.addEdges(0,1);
        // 0 -> 2
        gh.addEdges(0,2);
        // 2 -> 3
        gh.addEdges(2,3);
        // 3 -> 4
        gh.addEdges(3,4);
        // 3 -> 5
        gh.addEdges(3, 5);
        // 4 -> 6
        gh.addEdges(4, 6);
        // 4 -> 7
        gh.addEdges(4, 7);
        // 6 -> 8
        gh.addEdges(6, 8);
        // 5 -> 10
        gh.addEdges(5,10);
        // 5 -> 9
        gh.addEdges(5, 9);
        // 9 -> 11
        gh.addEdges(9, 11);
        // 9 -> 12
        gh.addEdges(9, 12);

        // Total Graph Representation: It's a directed graph.
        // So try to draw them before running main method to see the output.

        // Checking out neighbors
        System.out.println("Vertex 0's out neighbour should be Vertex 1 and Vertex 2: " + gh.getNeighbors(0));
        System.out.println("Vertex 1's out neighbour should be none: " + gh.getNeighbors(1));
        System.out.println("Vertex 2's out neighbour should be Vertex 3: " + gh.getNeighbors(2));
        System.out.println("Vertex 3's out neighbour should be Vertex 4 and Vertex 5: " + gh.getNeighbors(3));
        System.out.println("Vertex 9's out neighbour should be Vertex 11 and Vertex 12: " + gh.getNeighbors(9));
        System.out.println("");

        // Checking in neighbors
        System.out.println("Vertex 0's in neighbour should be none: " + gh.getInNeighbors(0));
        System.out.println("Vertex 1's in neighbour should be Vertex 0: " + gh.getInNeighbors(1));
        System.out.println("Vertex 2's in neighbour should be Vertex 0: " + gh.getInNeighbors(2));
        System.out.println("Vertex 3's in neighbour should be Vertex 2: " + gh.getInNeighbors(3));
        System.out.println("Vertex 7's in neighbour should be Vertex 4: " + gh.getInNeighbors(7));
        System.out.println("");

        // Checking two hop neighbors
        System.out.println("Vertex 0's two hop neighbors should be Vertex 3: " + gh.getDistance2(0));
        System.out.println("Vertex 4's two hop neighbors should be Vertex 8: " + gh.getDistance2(4));
        System.out.println("Vertex 5's two hop neighbors should be Vertex 11 and Vertex 12: " + gh.getDistance2(5));
        System.out.println("");

        // Depth First Search
        System.out.println("Path should be found: " + gh.depthFirstSearch(0,10));
        System.out.println("Path should not be found: " + gh.depthFirstSearch(1,3));

        System.out.println("");

        // Breadth First Search
        System.out.println("Path should be found: " + gh.breadthFirstSearch(0,10));
        System.out.println("Path should not be found: " + gh.breadthFirstSearch(1,3));


    }
}
