package edu.guilford;

import java.util.*;

class Polynomial implements Comparable<Polynomial> {
    private double[] coefficients;
    private int degree;

    // Default constructor
    public Polynomial() {
        this.coefficients = new double[11]; // Max degree 10
        this.degree = -1;
    }

    // Constructor with coefficients array
    public Polynomial(double[] coeffs) {
        this.coefficients = Arrays.copyOf(coeffs, coeffs.length);
        this.degree = findDegree();
    }

    // Constructor with random coefficients
    public Polynomial(int n) {
        this.degree = n;
        this.coefficients = new double[n + 1];
        Random rand = new Random();
        for (int i = 0; i <= n; i++) {
            this.coefficients[i] = -15 + (30 * rand.nextDouble());
        }
    }

    public Polynomial(boolean isRandom) {
        if (isRandom) {
            Random rand = new Random();
    
            // Ensure the degree is in the range [3, 10]
            this.degree = rand.nextInt(8) + 3;  // Generates a value in [3, 10]
    
            // Debugging print
            System.out.println("Generated degree: " + this.degree);  // Make sure degree is between 3 and 10
    
            // Initialize the coefficients array
            this.coefficients = new double[this.degree + 1];
    
            // Assign random coefficients in range [-5, 5]
            for (int i = 0; i <= this.degree; i++) {
                this.coefficients[i] = -5.0 + (10.0 * rand.nextDouble());  // Random coefficients in [-5, 5]
            }
        }
    }
    
    

    // Find the degree of the polynomial
    private int findDegree() {
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0)
                return i;
        }
        return -1;
    }

    // Getters
    public int getDegree() {
        return degree;
    }

    public double[] getCoefficients() {
        return coefficients.clone();
    }

    public double getCoefficient(int power) {
        return (power >= 0 && power < coefficients.length) ? coefficients[power] : 0;
    }

    // Setters
    public void setCoefficient(int power, double value) {
        if (power >= 0 && power < coefficients.length) {
            coefficients[power] = value;
            this.degree = findDegree();
        }
    }

    public void setCoefficients(double[] newCoeffs) {
        this.coefficients = Arrays.copyOf(newCoeffs, newCoeffs.length);
        this.degree = findDegree();
    }

    // Evaluate polynomial at x
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i <= degree; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    // Clear method
    public void clear() {
        Arrays.fill(coefficients, 0);
        degree = -1;
    }

    // Addition method
    public Polynomial add(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        double[] result = new double[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            result[i] = this.getCoefficient(i) + p.getCoefficient(i);
        }

        return new Polynomial(result);
    }

    // Subtraction method
    public Polynomial subtract(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        double[] result = new double[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            result[i] = this.getCoefficient(i) - p.getCoefficient(i);
        }

        return new Polynomial(result);
    }

    // toString method
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

    // CompareTo method
    @Override
    public int compareTo(Polynomial other) {
        // Step 1: Compare degrees
        if (this.degree > other.degree)
            return 1;
        if (this.degree < other.degree)
            return -1;

        // Step 2: Compare coefficients (if degrees are the same)
        boolean allEqual = true;
        for (int i = degree; i >= 0; i--) {
            if (this.coefficients[i] != other.coefficients[i]) {
                allEqual = false;
                break;
            }
        }
        if (allEqual)
            return 0;

        // Step 3: Compare evaluation at x = 1
        double thisAt1 = this.evaluate(1);
        double otherAt1 = other.evaluate(1);
        if (thisAt1 > otherAt1)
            return 1;
        if (thisAt1 < otherAt1)
            return -1;

        // Step 4: Compare evaluation at x = -1
        double thisAtNeg1 = this.evaluate(-1);
        double otherAtNeg1 = other.evaluate(-1);
        if (thisAtNeg1 > otherAtNeg1)
            return 1;
        if (thisAtNeg1 < otherAtNeg1)
            return -1;

        // If needed, more tie-breaking steps could be added here
        return 0;
    }

}
