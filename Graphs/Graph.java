package Graphs;


import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class that implements a directed graph.
 *
 * The graph may have self-loops, parallel edges.
 * Vertices are labeled by integers 0 .. n-1
 * and don't have String labels.
 * The edges of the graph are not labeled.
 *
 * Representation of edges is left abstract.
 */
public abstract class Graph {
    // Number of vertices
    private int vertices;
    // Number of edges
    private int edges;

    /**
     * Create a new empty Graph
     */
    public Graph(){
        this.vertices = 0;
        this.edges = 0;
    }

    /**
     * Add new vertex to the Graph.
     * This vertex will have as its index the next available integer.
     */
    public int addVertex(){
        implementAddVertex();
        this.vertices++;
        return (this.vertices-1);
    }

    /**
     * Add new edge to the graph between given vertices,
     * @param vertex1 the index of the start point for the edge.
     * @param vertex2 the index of the end point for the edge.
     */
    public void addEdges(int vertex1, int vertex2){
        // Check if given two vertices are in the Graph by checking its number
        if(vertex1 < getVertices() && vertex2 < getVertices()){
            implementAddEdge(vertex1, vertex2);
            this.edges++;
        }
        else {
            throw new IndexOutOfBoundsException();
        }

    }

    /**
     * Abstract method to add a vertex to the Graph
     */
    public abstract void implementAddVertex();


    /**
     * Abstract method to add edge to the Graph
     */
    public abstract void implementAddEdge(int vertex1, int vertex2);

    /**
     * Get all (out-)neighbors of a given vertex.
     * @param v Index of vertex.
     * @return List of indices of all vertices that are adjacent to v
     * 	via outgoing edges from v.
     */
    public abstract List<Integer> getNeighbors(int v);

    /**
     * Get all in-neighbors of a given vertex.
     * @param v Index of vertex.
     * @return List of indices of all vertices that are adjacent to v
     * 	via incoming edges to v.
     */
    public abstract List<Integer> getInNeighbors(int v);

    /**
     * The degree sequence of a graph is a sorted (organized in numerical order
     * from largest to smallest, possibly with repetitions) list of the degrees
     * of the vertices in the graph.
     *
     * @return The degree sequence of this graph.
     */
    public List<Integer> degreeSequence() {
        List<Integer> degreeSeq = new ArrayList<Integer>();
        int inDegree, outDegree, degree;
        for(int i=0; i<getVertices(); i++) {
            inDegree = this.getInNeighbors(i).size();
            outDegree = this.getNeighbors(i).size();
            degree = inDegree + outDegree;
            degreeSeq.add(degree);
        }
        // sort the list in non-increasing order using insertion sort
        for(int pos = 1; pos < degreeSeq.size(); pos++) {
            int current = pos;
            while(current > 0 && degreeSeq.get(current) > degreeSeq.get(current-1)) {
                // swap
                int temp = degreeSeq.get(current);
                degreeSeq.set(current, degreeSeq.get(current-1));
                degreeSeq.set(current-1, temp);
                // set current into current-1
                current = current-1;
            }
        }
        return degreeSeq;
    }

    /**
     * Get all the vertices that are 2 away from the vertex.
     *
     * @param v The starting vertex
     * @return A list of the vertices that can be reached in exactly two hops (by
     * following two edges) from vertex v.
     */
    public abstract List<Integer> getDistance2(int v);

    /***
     * Getter methods
     */

    public int getEdges() {
        return edges;
    }

    public int getVertices() {
        return vertices;
    }

}
