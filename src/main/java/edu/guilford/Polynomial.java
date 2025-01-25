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
    
    // Find the degree of the polynomial
    private int findDegree() {
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) return i;
        }
        return -1;
    }
    
    // Getters
    public int getDegree() { return degree; }
    public double[] getCoefficients() { return coefficients.clone(); }
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
        if (degree == -1) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (sb.length() > 0) sb.append(" + ");
                sb.append(coefficients[i]).append("x^").append(i);
            }
        }
        return sb.toString();
    }
    
    // CompareTo method
    public int compareTo(Polynomial other) {
        if (this.degree > other.degree) return 1;
        if (this.degree < other.degree) return -1;
        
        for (int i = degree; i >= 0; i--) {
            if (this.coefficients[i] > other.coefficients[i]) return 1;
            if (this.coefficients[i] < other.coefficients[i]) return -1;
        }
        
        return 0;
    }
}
