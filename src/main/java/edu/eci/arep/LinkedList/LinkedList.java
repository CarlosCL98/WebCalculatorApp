package edu.eci.arep.LinkedList;

/**
 * This class represent a LinkedList.
 *
 * @author Carlos Medina
 */
public class LinkedList {

    private Node firstNode;
    private Node lastNode;

    /**
     * Constructor for LinkedList Class.
     */
    public LinkedList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    /**
     * Add data to the LinkedList.
     *
     * @param data is the data that you want to add.
     */
    public void add(double data) {
        if (firstNode != null) {
            Node newNode = new Node(data, null, lastNode);
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        } else {
            firstNode = new Node(data, null, null);
            lastNode = firstNode;
        }
    }

    /**
     * Remove data to the LinkedList.
     *
     * @param data is the data that you want to remove.
     */
    public void remove(double data) {
        int size = getSize();
        if (size > 0) {
            double dataFound = 0;
            Node tempNode = firstNode;
            if (firstNode.getData() == data) {
                firstNode = tempNode.getNextNode();
            }
            while (dataFound != data && tempNode != null) {
                dataFound = tempNode.getData();
                if (dataFound == data) {
                    Node priorTempNode = tempNode.getPriorNode();
                    Node nextTempNode = tempNode.getNextNode();
                    if (priorTempNode != null) {
                        priorTempNode.setNextNode(nextTempNode);
                    }
                    if (nextTempNode != null) {
                        nextTempNode.setPriorNode(priorTempNode);
                    }
                }
                tempNode = tempNode.getNextNode();
            }
        }
    }

    /**
     * Finds and returns the data of the node indicated by the index.
     *
     * @param index of the data to get
     * @return double : the data of the node indicated by the index.
     */
    public double get(int index) {
        Node node = firstNode;
        for (int i = 0; i < index && node != null; i++) {
            node = node.getNextNode();
        }
        double data = 0;
        if (node != null) {
            data = node.getData();
        }
        return data;
    }

    /**
     * Returns the size of the LinkedList.
     *
     * @return int : the size of the LinkedList.
     */
    public int getSize() {
        int sizeCount = 0;
        Node node = firstNode;
        while (node != null) {
            node = node.getNextNode();
            sizeCount++;
        }
        return sizeCount;
    }

    /**
     * Returns the first node of the LinkedList.
     *
     * @return Node : the first node of the linkedList.
     */
    public Node getFirstNode() {
        return firstNode;
    }

    /**
     * Returns the last node of the LinkedList.
     *
     * @return Node : the last node of the linkedList.
     */
    public Node getLastNode() {
        return lastNode;
    }
}
