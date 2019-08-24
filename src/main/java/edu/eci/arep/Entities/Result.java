package edu.eci.arep.Entities;

/**
 * Result class represents the result of computing the mean and the standard deviation
 * of a set of data.
 *
 * @author Carlos Medina
 */
public class Result {

    private int id;
    private double mean;
    private double standardDeviation;

    public Result() {

    }

    public Result(int id, double mean, double standardDeviation) {
        this.id = id;
        this.mean = mean;
        this.standardDeviation = standardDeviation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    @Override
    public String toString() {
        return "Result{id=" + id + ", mean=" + mean + ", standardDeviation=" + standardDeviation + "}";
    }
}
