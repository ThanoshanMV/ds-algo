package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements a directed graph.
 *
 * The graph may have self-loops, parallel edges.
 * Vertices are labeled by integers 0 .. n-1
 * and don't have String labels.
 * The edges of the graph are not labeled.
 *
 * Representation of edges via an adjacency matrix.
 */
public class AdjacencyMatrix extends Graph{
    // Adjacency Matrix is represented as a 2D Array
    private int[][] adjMatrix;

    public AdjacencyMatrix(){
        adjMatrix = new int[5][5];
    }


    /**
     * Implement the abstract method for adding an edge.
     * Allows for multiple edges between two points:
     * the entry at row vertex1, column vertex2 stores the number of such edges.
     * @param vertex1 the index of the start point for the edge.
     * @param vertex2 the index of the end point for the edge.
     */
    @Override
    public void implementAddEdge(int vertex1, int vertex2) {
        adjMatrix[vertex1][vertex2] += 1;
    }

    /**
     * Implement the abstract method for adding a vertex.
     * If need to increase dimensions of matrix, double them to amortize cost.
     */
    @Override
    public void implementAddVertex() {
        // Getting the number of vertices in the Graph
        int vertex = getVertices();
        /**
         * 1. check vertex number if it's equal or larger than adjMatrix's size.
         *
         * a)
         * 1. if it's equal or larger we can't create a new vertex and add that to adjMatrix.
         * 2. So we need to create a new matrix with bigger size and add all those previous values to
         * the new matrix (As a rule of thumb the new matrix's size will be 2*vertices always
         * as it prevents not frequently creating a new array).
         * 3. finally assign our adjMatrix to the newly created matrix.
         *
         * b)
         * 1. if the vertex number is less than adjMatrix's size, we don't need to create new matrix
         * 2. we can add that vertex to matrix
         */
        if(vertex >= adjMatrix.length){
            // Creating new 2D array with bigger size
            int[][] matrix = new int[vertex*2][vertex*2];
            // Copying all the previous values from adjMatrix to new matrix
            for (int i=0; i<matrix.length; i++){
                for (int j=0; j<matrix.length; j++){
                    matrix[i][j] = adjMatrix[i][j];
                }
            }
            // Assign AdjacencyMatrix to created new matrix
            adjMatrix = matrix;
        }
    }

    /**
     * Implement the abstract method for finding all
     * out-neighbors of a vertex.
     * If there are multiple edges between the vertex
     * and one of its out-neighbors, this neighbor
     * appears once in the list for each of these edges.
     *
     * @param v the index of vertex.
     * @return List<Integer> a list of indices of vertices.
     */
    @Override
    public List<Integer> getNeighbors(int v) {
        // Declare and initialize List to store and return out neighbors
        List<Integer> outNeighbors = new ArrayList<Integer>();
        // Go to row v to find all out neighbors
        for (int i=0; i<adjMatrix.length; i++){
            int edges = adjMatrix[v][i];
            while (edges > 0){
                outNeighbors.add(i);
                edges--;
            }
        }
        return outNeighbors;
    }

    /**
     * Implement the abstract method for finding all
     * in-neighbors of a vertex.
     * If there are multiple edges from another vertex
     * to this one, the neighbor
     * appears once in the list for each of these edges.
     *
     * @param v the index of vertex.
     * @return List<Integer> a list of indices of vertices.
     */
    @Override
    public List<Integer> getInNeighbors(int v) {
        // Declare and initialize List to store and return in neighbors
        List<Integer> inNeighbors = new ArrayList<Integer>();
        // Go to column v to find all in neighbors
        for (int i = 0; i < adjMatrix.length; i++) {
            int edges =  adjMatrix[i][v];
            while (edges > 0){
                inNeighbors.add(i);
                edges--;
            }
        }
        return inNeighbors;
    }

    /**
     * Implement the abstract method for finding all
     * vertices reachable by two hops from v.
     *
     * @param v the index of vertex.
     * @return List<Integer> a list of indices of vertices.
     */
    @Override
    public List<Integer> getDistance2(int v) {
        List<Integer> oneHop = this.getNeighbors(v);
        List<Integer> twoHop = new ArrayList<Integer>();
        List<Integer> neighbors;
        for (Integer i: oneHop){
            neighbors = this.getNeighbors(i);
            twoHop.addAll(neighbors);
        }
        return twoHop;
    }

    public static void main(String[] args) {
        Graph gh = new AdjacencyMatrix();
        System.out.println("Initial Vertices in the Graph " + gh.getVertices());
        System.out.println("Initial Edges in the Graph " + gh.getEdges());
        System.out.println("");

        // Add verices 0,1,2,3
        gh.addVertex(); // 0
        gh.addVertex(); // 1
        gh.addVertex(); // 2
        gh.addVertex(); // 3

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

        // Total Graph Representation:
        // 0 -> 1
        // 0 -> 2 -> 3

        // Checking out neighbors
        System.out.println("Vertex 0's out neighbour should be Vertex 1 and Vertex 2: " + gh.getNeighbors(0));
        System.out.println("Vertex 1's out neighbour should be none: " + gh.getNeighbors(1));
        System.out.println("Vertex 2's out neighbour should be Vertex 3: " + gh.getNeighbors(2));
        System.out.println("Vertex 3's out neighbour should be none: " + gh.getNeighbors(3));
        System.out.println("");

        // Checking in neighbors
        System.out.println("Vertex 0's in neighbour should be none: " + gh.getInNeighbors(0));
        System.out.println("Vertex 1's in neighbour should be Vertex 0: " + gh.getInNeighbors(1));
        System.out.println("Vertex 2's in neighbour should be Vertex 0: " + gh.getInNeighbors(2));
        System.out.println("Vertex 3's in neighbour should be Vertex 2: " + gh.getInNeighbors(3));
        System.out.println("");

        // Checking two hop neighbors
        System.out.println("Vertex 0's two hop neighbors should be Vertex 3: " + gh.getDistance2(0));


    }
}
