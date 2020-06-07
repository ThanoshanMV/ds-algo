package binarySearchTree;

import java.util.TreeSet;

/**
 * A class that implements Binary Search Tree data Structure
 */
public class BinarySearchTree<E extends Comparable<? super E>> {
    private TreeNode<E> root;

    public BinarySearchTree(E data) {
        this.root = new TreeNode<E>(data, null);
    }

    /**
     * Implementing BST Search iteratively
     *
     * @param data toFind
     * @return true if found else false
     */
    public boolean contains(E data) {
        TreeNode<E> traverseNode = this.root;
        // while traverseNode not a null
        while (traverseNode != null) {
            int compare = data.compareTo(traverseNode.getData());
            if (compare > 0) {
                // toFind is greater than node's data. Go to right subtree
                traverseNode = traverseNode.getRight();
            } else if (compare < 0) {
                // toFind is less than node's data. Go to left subtree
                traverseNode = traverseNode.getLeft();
            } else {
                // toFind is found
                return true;
            }
        }
        // traverseNode is null, so the node containing that data isn't in the Tree.
        return false;
    }

    /**
     * Implementing iteratively
     *
     * @param data toAdd
     * @return true if added to the BST
     */
    public boolean add(E data) {
        TreeNode<E> traverseNode = this.root;
        while (traverseNode != null) {
            int compare = data.compareTo(traverseNode.getData());
            if (compare > 0) {
                // toAdd is greater than node's data. Go to right subtree
                if (traverseNode.getRight() == null) {
                    traverseNode.addRightChild(data);
                    return true;
                } else {
                    traverseNode = traverseNode.getRight();
                }
            } else if (compare < 0) {
                // toAdd is less than node's data. Go to left subtree
                if (traverseNode.getLeft() == null) {
                    traverseNode.addLeftChild(data);
                    return true;
                } else {
                    traverseNode = traverseNode.getLeft();
                }
            } else {
                // toAdd is already exists in the Tree
                return false;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        // Creating the Binary Search Tree
        BinarySearchTree<String> tree = new BinarySearchTree<String>("E");
        // Defining the root node of the tree
        TreeNode<String> node = tree.root;

        // Building the left subtree
        node.addLeftChild("B");
        node.getLeft().addLeftChild("A");
        node.getLeft().addRightChild("C");

        // Building the right subtree
        node.addRightChild("M");
        node.getRight().addLeftChild("L");
        node.getRight().addRightChild("Q");

        // BST Search
        System.out.println("BST Search Starts: ");

        System.out.println("Does Tree contains E ? : " + tree.contains("E"));
        System.out.println("Does Tree contains B ? : " + tree.contains("B"));
        System.out.println("Does Tree contains A ? : " + tree.contains("A"));
        System.out.println("Does Tree contains C ? : " + tree.contains("C"));
        System.out.println("Does Tree contains M ? : " + tree.contains("M"));
        System.out.println("Does Tree contains L ? : " + tree.contains("L"));
        System.out.println("Does Tree contains Q ? : " + tree.contains("Q"));
        System.out.println("Does Tree contains H ? : " + tree.contains("H"));
        System.out.println("Does Tree contains Z ? : " + tree.contains("Z"));

        System.out.println("BST Search Ends...");

        System.out.println("");

        // BST Add
        System.out.println("BST Add Starts...");

        System.out.println("Add to E Tree ? : " + tree.add("E"));
        System.out.println("Add to X Tree ? : " + tree.add("X"));
        System.out.println("Add to S Tree ? : " + tree.add("S"));
        System.out.println("Add to A Tree ? : " + tree.add("A"));
        System.out.println("Add to B Tree ? : " + tree.add("B"));

        System.out.println("BST Add Ends...");
    }

}

/**
 * A class that implements Binary Search Tree Node
 *
 * @param <E>
 */
class TreeNode<E> {
    private E data;
    private TreeNode<E> parent;
    private TreeNode<E> right;
    private TreeNode<E> left;

    public TreeNode(E data, TreeNode<E> parent) {
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    /**
     * @param data: Data of the left child node
     * @return: left child TreeNode
     */
    public TreeNode<E> addLeftChild(E data) {
        this.left = new TreeNode<E>(data, this);
        return this.left;
    }

    /**
     * @param data: Data of the right child node
     * @return: right child tree node
     */
    public TreeNode<E> addRightChild(E data) {
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

