package edu.eci.arep.LinkedList;

/**
 * This class represent a Node of the LinkedList.
 *
 * @author Carlos Medina
 */
public class Node {

    private double data;
    private Node nextNode;
    private Node priorNode;

    /**
     * Constructor with parameters for Node class.
     *
     * @param data value of the node.
     * @param nextNode next node of the node.
     * @param priorNode prior node of the node.
     */
    public Node(double data, Node nextNode, Node priorNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.priorNode = priorNode;
    }

    /**
     * Returns the data of this node.
     *
     * @return double : value of the node.
     */
    public double getData() {
        return data;
    }

    /**
     * Sets the data of this node.
     *
     * @param data value of the node.
     */
    public void setData(double data) {
        this.data = data;
    }

    /**
     * Returns the next node of this node.
     *
     * @return Node : next node.
     */
    public Node getNextNode() {
        return nextNode;
    }

    /**
     * Sets the next node of this node.
     *
     * @param nextNode next node of the node.
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Returns the prior node of this node.
     *
     * @return Node : prior node.
     */
    public Node getPriorNode() {
        return priorNode;
    }

    /**
     * Sets the prior node of this node.
     *
     * @param priorNode prior node of the node.
     */
    public void setPriorNode(Node priorNode) {
        this.priorNode = priorNode;
    }

}
