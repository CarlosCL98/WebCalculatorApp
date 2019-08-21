package edu.eci.arep;

import edu.eci.arep.LinkedList.LinkedList;
import edu.eci.arep.LinkedList.Node;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for LinkedList.
 *
 * @author Carlos Medina
 */
public class LinkedListTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LinkedListTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(LinkedListTest.class);
    }

    /**
     * It should create an empty LinkedList.
     */
    public void testItShouldCreateAnEmptyLinkedList() {
        LinkedList list = new LinkedList();
        assertTrue(list.getSize() == 0);
    }

    /**
     * It should add an element to the LinkedList and it size must increment.
     */
    public void testItShouldAddAnElementToTheLinkedList() {
        boolean ok = true;
        LinkedList list = new LinkedList();

        double data = 5;
        list.add(data);
        ok = ok && list.getSize() == 1 && list.getFirstNode().getData() == 5;

        data = 10;
        list.add(data);
        ok = ok && list.getSize() == 2 && list.getLastNode().getData() == 10;

        assertTrue(ok);
    }

    /**
     * It should find an added element to the LinkedList.
     */
    public void testItShouldFindAnAddedElementInTheLinkedList() {
        boolean ok = true;
        LinkedList list = new LinkedList();

        double data = 2;
        list.add(data);
        data = 3;
        list.add(data);
        data = 4;
        list.add(data);
        ok = ok && list.getSize() == 3;

        double dataFound = 0;
        double dataResult = 3;
        Node tempNode = list.getFirstNode();
        while (dataFound != dataResult && tempNode != null) {
            dataFound = tempNode.getData();
            tempNode = tempNode.getNextNode();
        }
        ok = ok && dataFound == dataResult;

        assertTrue(ok);
    }

    /**
     * It should remove an element to the LinkedList and it size must decrement.
     */
    public void testItShouldRemoveAnElementToTheLinkedList() {
        boolean ok = true;
        LinkedList list = new LinkedList();

        double data = 5;
        list.add(data);
        data = 10;
        list.add(data);
        data = 15;
        list.add(data);
        ok = ok && list.getSize() == 3;

        list.remove(15);
        ok = ok && list.getSize() == 2;

        assertTrue(ok);
    }

    /**
     * It shouldn't find a removed element in the LinkedList.
     */
    public void testItShouldntFindARemovedElementInTheLinkedList() {
        boolean ok = true;
        LinkedList list = new LinkedList();

        double data = 25;
        list.add(data);
        data = 67;
        list.add(data);
        data = 0.5;
        list.add(data);
        ok = ok && list.getSize() == 3;

        list.remove(25);
        ok = ok && list.getSize() == 2;

        double dataFound = 0;
        double dataResult = 25;
        Node tempNode = list.getFirstNode();
        while (dataFound != dataResult && tempNode != null) {
            dataFound = tempNode.getData();
            tempNode = tempNode.getNextNode();
        }
        ok = ok && dataFound != dataResult;

        assertTrue(ok);
    }

    /**
     * It should get the element in the LinkedList indicated by an index.
     */
    public void testItShouldGetTheElementInTheLinkedListIndicatedByAnIndex() {
        boolean ok = true;
        LinkedList list = new LinkedList();

        double data = 125;
        list.add(data);
        data = 65;
        list.add(data);
        data = 78;
        list.add(data);
        data = 32;
        list.add(data);
        ok = ok && list.getSize() == 4;
        
        double resultToCompare1 = list.get(2);
        double result1 = 78;
        ok = ok && resultToCompare1 == result1;
        
        double resultToCompare2 = list.get(3);
        double result2 = 32;
        ok = ok && resultToCompare2 == result2;
        
        double resultToCompare3 = list.get(0);
        double result3 = 125;
        ok = ok && resultToCompare3 == result3;

        assertTrue(ok);
    }
}
