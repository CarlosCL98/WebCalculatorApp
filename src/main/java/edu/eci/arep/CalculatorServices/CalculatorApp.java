package edu.eci.arep.CalculatorServices;

import edu.eci.arep.LinkedList.LinkedList;

/**
 * Main class of CalculatorApp.
 *
 * @author Carlos Medina
 */
public class CalculatorApp {

    /**
     * Calculate the mean of a set of data.
     *
     * @param list with de data.
     * @return double : the mean of the data.
     */
    public static double mean(LinkedList list) {
        double mean = 0;
        for (int i = 0; i < list.getSize(); i++) {
            mean += list.get(i);
        }
        mean = mean / list.getSize();
        mean = Math.round(mean * 100.0) / 100.0;
        return mean;
    }

    /**
     * Calculate the standard deviation of a set of data.
     *
     * @param list with de data.
     * @param mean mean of the data.
     * @return double : the standard deviation of the data.
     */
    public static double standardDeviation(LinkedList list, double mean) {
        double standardDeviation = 0;
        for (int i = 0; i < list.getSize(); i++) {
            standardDeviation += Math.pow(list.get(i) - mean, 2);
        }
        standardDeviation = Math.sqrt(standardDeviation / (list.getSize() - 1));
        standardDeviation = Math.round(standardDeviation * 100.0) / 100.0;
        return standardDeviation;
    }
}
