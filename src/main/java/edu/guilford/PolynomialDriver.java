package edu.guilford;

import java.util.*;

public class PolynomialDriver {
    public static void main(String[] args) {
        // Test constructors
        double[] coeffs1 = { 1.0, 2.5, 3.3, 4.6 };
        Polynomial p1 = new Polynomial(coeffs1);

        double[] coeffs2 = { 4.1, 5.6, 6.8 };
        Polynomial p2 = new Polynomial(coeffs2);

        double[] coeffs3 = { 1.0, 2.5, 3.3, 4.6 }; // Same as p1 to check equality
        Polynomial p3 = new Polynomial(coeffs3);

        System.out.println("Testing Polynomial Constructors:");
        System.out.println("Polynomial 1: " + p1);
        System.out.println("Polynomial 2: " + p2);
        System.out.println("Polynomial 3 (same as Polynomial 1): " + p3);
        System.out.println();

        // Test addition
        Polynomial sum = p1.add(p2);
        System.out.println("Testing Addition:");
        System.out.println("P1 + P2 = " + sum);
        System.out.println();

        // Test subtraction
        Polynomial difference = p1.subtract(p2);
        System.out.println("Testing Subtraction:");
        System.out.println("P1 - P2 = " + difference);
        System.out.println();

        // Test evaluation
        double x = 2.0;
        System.out.println("Testing Evaluation:");
        System.out.println("P1 evaluated at " + x + ": " + p1.evaluate(x));
        System.out.println("P2 evaluated at " + x + ": " + p2.evaluate(x));
        System.out.println();

        // Test compareTo method
        System.out.println("Testing CompareTo:");
        System.out.println("P1 compared to P2: " + p1.compareTo(p2));
        System.out.println("P2 compared to P1: " + p2.compareTo(p1));
        System.out.println("P1 compared to P3 (should be 0): " + p1.compareTo(p3));
        System.out.println();

        // Test random polynomial creation
        Polynomial randomPoly = new Polynomial(5);
        System.out.println("Testing Random Polynomial:");
        System.out.println("Random Polynomial: " + randomPoly);
        System.out.println();

        // Test sorting a list of polynomials
        System.out.println("Testing Sorting of Polynomials:");
        List<Polynomial> polynomials = new ArrayList<>();
        polynomials.add(new Polynomial(3));
        polynomials.add(new Polynomial(2));
        polynomials.add(new Polynomial(4));
        polynomials.add(new Polynomial(1));
        polynomials.add(new Polynomial(5));

        // Display Unsorted List
        System.out.println("Unsorted Polynomials:");
        for (Polynomial p : polynomials) {
            System.out.println(p);
        }

        // Sort the polynomials using compareTo()
        Collections.sort(polynomials);

        // Display Sorted List
        System.out.println("\nSorted Polynomials:");
        for (Polynomial p : polynomials) {
            System.out.println(p);
        }
    }
}
