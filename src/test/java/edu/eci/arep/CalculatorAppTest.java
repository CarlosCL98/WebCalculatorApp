package edu.eci.arep;

import edu.eci.arep.LinkedList.LinkedList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Calculator App.
 *
 * @author Carlos Medina
 */
public class CalculatorAppTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculatorAppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CalculatorAppTest.class);
    }
    
    /**
     * It should calculate the mean.
     */
    public void testItShouldCalculateTheMean() {
        boolean ok = true;
        LinkedList list1 = new LinkedList();
        list1.add(160);
        list1.add(591);
        list1.add(114);
        list1.add(229);
        list1.add(230);
        list1.add(270);
        list1.add(128);
        list1.add(1657);
        list1.add(624);
        list1.add(1503);
        
        double mean1 = CalculatorApp.mean(list1);
        ok = ok && mean1 == 550.6;
        
        LinkedList list2 = new LinkedList();
        list2.add(15.0);
        list2.add(69.9);
        list2.add(6.5);
        list2.add(22.4);
        list2.add(28.4);
        list2.add(65.9);
        list2.add(19.4);
        list2.add(198.7);
        list2.add(38.8);
        list2.add(138.2);

        double mean2 = CalculatorApp.mean(list2);
        ok = ok && mean2 == 60.32;

        assertTrue(ok);
    }
    
    /**
     * It should calculate the standard deviation.
     */
    public void testItShouldCalculateTheStandardDeviation() {
        boolean ok = true;
        LinkedList list1 = new LinkedList();
        list1.add(160);
        list1.add(591);
        list1.add(114);
        list1.add(229);
        list1.add(230);
        list1.add(270);
        list1.add(128);
        list1.add(1657);
        list1.add(624);
        list1.add(1503);
        
        double standardDeviation1 = CalculatorApp.standardDeviation(list1, CalculatorApp.mean(list1));
        ok = ok && standardDeviation1 == 572.03;
        
        LinkedList list2 = new LinkedList();
        list2.add(15.0);
        list2.add(69.9);
        list2.add(6.5);
        list2.add(22.4);
        list2.add(28.4);
        list2.add(65.9);
        list2.add(19.4);
        list2.add(198.7);
        list2.add(38.8);
        list2.add(138.2);

        double standardDeviation2 = CalculatorApp.standardDeviation(list2, CalculatorApp.mean(list2));
        ok = ok && standardDeviation2 == 62.26;

        assertTrue(ok);
    }

}
