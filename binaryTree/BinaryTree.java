package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A class that implements Binary Tree Data Structure
 * @param <E>
 */
public class BinaryTree<E> {
    private TreeNode<E> root;

    private BinaryTree(E data){
        this.root = new TreeNode<E>(data, null);
    }

    /**
     * Defining the Pre-Order Traversal:
     * 1. Visit yourself
     * 2. Then Visit all your left sub tree
     * 3. Then Visit all your right sub tree
     * @param parent
     */
    private void preOrder(TreeNode<E> parent){
        TreeNode<E> traversalNode = parent;
        if(traversalNode != null){
            // Visit yourself
            System.out.print(traversalNode.getData() + " ");
            if(traversalNode.getLeft() != null) {
                preOrder(traversalNode.getLeft());
            }
            if(traversalNode.getRight() != null){
                preOrder(traversalNode.getRight());
            }
        }

    }
    // helper method to pass the argument
    public void preOrder(){
        this.preOrder(this.root);
    }

    /**
     * Defining Post Order Traversal:
     * 1. Visit all your left subtree
     * 2. Visit all your right subtree
     * 3. Visit yourself
     * @param parent
     */
    private void postOrder(TreeNode<E> parent){
        TreeNode<E> traversalNode = parent;
        if(traversalNode != null){
            if(traversalNode.getLeft() != null){
                postOrder(traversalNode.getLeft());
            }
            if(traversalNode.getRight() != null){
                postOrder(traversalNode.getRight());
            }
            // Visit yourself
            System.out.print(traversalNode.getData()+ " ");
        }
    }
    // helper method to pass the argument
    public void postOrder(){
        this.postOrder(this.root);
    }

    /**
     * Defining In Order Traversal:
     * 1. Visit all your left subtree
     * 2. Visit yourself
     * 3. Visit all your right subtree
     * @param parent
     */
    private void inOrder(TreeNode<E> parent){
        TreeNode<E> traversalNode = parent;
        if(traversalNode != null){
            if(traversalNode.getLeft() != null){
                inOrder(traversalNode.getLeft());
            }
            // Visit yourself
            System.out.print(traversalNode.getData() + " ");
            if(traversalNode.getRight() != null){
                inOrder(traversalNode.getRight());
            }
        }
    }
    // helper method to pass the argument
    public void inOrder(){
        this.inOrder(this.root);
    }

    /**
     * Defining In Order Traversal:
     * 1. Add starting node to Queue to begin Traversal
     * 2. Remove it from Queue, add its children to Queue
     * 3. Add that removed node to visited list.
     * 4. Repeat the process
     * @param parent
     */
    private void levelOrder(TreeNode<E> parent){
        TreeNode<E> traverseNode = parent;
        // Creating Queue Data Structure
        Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
        // Adding traverseNode to Queue
        q.add(traverseNode);

        // Creating temp to store removing TreeNode<E> from queue
        TreeNode<E> temp;
        // while queue is not empty
        while (!q.isEmpty()){
            // temp will be first element in the Queue
            temp = q.remove();
            // Add temp node's children to queue (It'll be added to back of the queue)
            if(temp.getLeft() != null){
                q.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                q.add(temp.getRight());
            }
            // Visit yourself
            System.out.print(temp.getData() + " ");
        }
    }
    // helper method to pass the argument
    public void levelOrder(){
        this.levelOrder(this.root);
    }

    public static void main(String[] args) {
        // Creating the Binary Tree
        BinaryTree<String> tree = new BinaryTree<String>("A");
        // Defining the root node of the tree
        TreeNode<String> node = tree.root;

        // Building the left subtree
        node.addLeftChild("B");
        node.getLeft().addLeftChild("D");
        node.getLeft().addRightChild("E");

        // Building the right subtree
        node.addRightChild("C");
        node.getRight().addLeftChild("F");
        node.getRight().addRightChild("G");

        // Pre-order Traversal
        System.out.print("Pre Order Traversal: ");
        tree.preOrder();

        System.out.println("");

        // Post-order Traversal
        System.out.print("Post Order Traversal: ");
        tree.postOrder();

        System.out.println("");

        // In-order Traversal
        System.out.print("In Order Traversal: ");
        tree.inOrder();

        System.out.println("");

        // Level-order Traversal
        System.out.print("Level Order Traversal: ");
        tree.levelOrder();

    }
}


/**
 * A class that implements Binary Tree Node
 * @param <E>
 */
class TreeNode<E>{
    private E data;
    private TreeNode<E> parent;
    private TreeNode<E> right;
    private TreeNode<E> left;

    public TreeNode(E data, TreeNode<E> parent){
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    /**
     *
     * @param data: Data of the left child node
     * @return: left child TreeNode
     */
    public TreeNode<E> addLeftChild(E data){
        this.left = new TreeNode<E>(data, this);
        return this.left;
    }

    /**
     *
     * @param data: Data of the right child node
     * @return: right child tree node
     */
    public TreeNode<E> addRightChild(E data){
        this.right = new TreeNode<E>(data, this);
        return this.right;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public E getData() {
        return data;
    }
}
