package Q1;

public class Term {
    private double coefficient;
    private int power;

    public Term(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getPower() {
        return power;
    }
}