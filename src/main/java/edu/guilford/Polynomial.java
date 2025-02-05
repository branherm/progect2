package edu.guilford;

import java.util.*;

/**
 * Represents a polynomial with various operations such as addition, subtraction,
 * evaluation, and comparison.
 * 
 * @author [Your Name]
 * @version 1.0
 */
class Polynomial implements Comparable<Polynomial> {
    private double[] coefficients;
    private int degree;

    /**
     * Default constructor that initializes an empty polynomial.
     */
    public Polynomial() {
        this.coefficients = new double[11]; // Max degree 10
        this.degree = -1;
    }

    /**
     * Constructs a polynomial from an array of coefficients.
     * 
     * @param coeffs The array of coefficients.
     */
    public Polynomial(double[] coeffs) {
        this.coefficients = Arrays.copyOf(coeffs, coeffs.length);
        this.degree = findDegree();
    }

    /**
     * Constructs a polynomial with random coefficients of given degree.
     * 
     * @param n The degree of the polynomial.
     */
    public Polynomial(int n) {
        this.degree = n;
        this.coefficients = new double[n + 1];
        Random rand = new Random();
        for (int i = 0; i <= n; i++) {
            this.coefficients[i] = -15 + (30 * rand.nextDouble());
        }
    }

    /**
     * Constructs a polynomial with a randomly generated degree and coefficients.
     * 
     * @param isRandom If true, generates a polynomial with random coefficients.
     */
    public Polynomial(boolean isRandom) {
        if (isRandom) {
            Random rand = new Random();
            this.degree = rand.nextInt(8) + 3; // Generates a value in [3, 10]
            this.coefficients = new double[this.degree + 1];
            for (int i = 0; i <= this.degree; i++) {
                this.coefficients[i] = -5.0 + (10.0 * rand.nextDouble());
            }
        }
    }

    /**
     * Finds the degree of the polynomial.
     * 
     * @return The degree of the polynomial.
     */
    private int findDegree() {
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0)
                return i;
        }
        return -1;
    }

    /**
     * Gets the degree of the polynomial.
     * 
     * @return The degree of the polynomial.
     */
    public int getDegree() {
        return degree;
    }

    /**
     * Gets the coefficients of the polynomial.
     * 
     * @return A copy of the coefficients array.
     */
    public double[] getCoefficients() {
        return coefficients.clone();
    }

    /**
     * Gets the coefficient of a specified power.
     * 
     * @param power The power of the term.
     * @return The coefficient of the term.
     */
    public double getCoefficient(int power) {
        return (power >= 0 && power < coefficients.length) ? coefficients[power] : 0;
    }

    /**
     * Sets the coefficient of a specific power.
     * 
     * @param power The power of the term.
     * @param value The new coefficient value.
     */
    public void setCoefficient(int power, double value) {
        if (power >= 0 && power < coefficients.length) {
            coefficients[power] = value;
            this.degree = findDegree();
        }
    }

    /**
     * Sets the coefficients of the polynomial.
     * 
     * @param newCoeffs The new coefficients array.
     */
    public void setCoefficients(double[] newCoeffs) {
        this.coefficients = Arrays.copyOf(newCoeffs, newCoeffs.length);
        this.degree = findDegree();
    }

    /**
     * Evaluates the polynomial at a given value of x.
     * 
     * @param x The value at which to evaluate the polynomial.
     * @return The computed result.
     */
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i <= degree; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    /**
     * Clears the polynomial by setting all coefficients to zero.
     */
    public void clear() {
        Arrays.fill(coefficients, 0);
        degree = -1;
    }

    /**
     * Adds another polynomial to this polynomial.
     * 
     * @param p The polynomial to add.
     * @return The resulting polynomial after addition.
     */
    public Polynomial add(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        double[] result = new double[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            result[i] = this.getCoefficient(i) + p.getCoefficient(i);
        }
        return new Polynomial(result);
    }

    /**
     * Subtracts another polynomial from this polynomial.
     * 
     * @param p The polynomial to subtract.
     * @return The resulting polynomial after subtraction.
     */
    public Polynomial subtract(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        double[] result = new double[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            result[i] = this.getCoefficient(i) - p.getCoefficient(i);
        }
        return new Polynomial(result);
    }

    /**
     * Returns a string representation of the polynomial.
     * 
     * @return The polynomial as a formatted string.
     */
    public String toString() {
        if (degree == -1)
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (sb.length() > 0)
                    sb.append(" + ");
                sb.append(coefficients[i]).append("x^").append(i);
            }
        }
        return sb.toString();
    }

    /**
     * Compares this polynomial with another polynomial.
     * 
     * @param other The polynomial to compare with.
     * @return A negative, zero, or positive integer based on the comparison.
     */
    @Override
    public int compareTo(Polynomial other) {
        if (this.degree > other.degree)
            return 1;
        if (this.degree < other.degree)
            return -1;
        return Double.compare(this.evaluate(1), other.evaluate(1));
    }
}
