package edu.guilford;

import java.util.*;

public class PolynomialDriver {
    public static void main(String[] args) {
        // Test constructors
        double[] coeffs1 = {1.0, 2.5, 3.3, 4.6};
        Polynomial p1 = new Polynomial(coeffs1);
        double[] coeffs2 = {4.1, 5.6, 6.8};
        Polynomial p2 = new Polynomial(coeffs2);

        // Test toString
        System.out.println("Polynomial 1: " + p1);
        System.out.println("Polynomial 2: " + p2);

        // Test addition
        Polynomial sum = p1.add(p2);
        System.out.println("Addition result: " + sum);

        // Test subtraction
        Polynomial difference = p1.subtract(p2);
        System.out.println("Subtraction result: " + difference);

        // Test evaluation
        double x = 2.0;
        System.out.println("P1 evaluated at " + x + ": " + p1.evaluate(x));

        // Test comparison
        System.out.println("Comparison result: " + p1.compareTo(p2));

        // Test random polynomial creation
        Polynomial p3 = new Polynomial(5);
        System.out.println("Random Polynomial: " + p3);

        // Test sorting list of polynomials
        List<Polynomial> polynomials = new ArrayList<>();
        polynomials.add(new Polynomial(3));
        polynomials.add(new Polynomial(2));
        polynomials.add(new Polynomial(4));
        polynomials.add(new Polynomial(1));
        polynomials.add(new Polynomial(5));

        Collections.sort(polynomials);
        System.out.println("Sorted Polynomials:");
        for (Polynomial p : polynomials) {
            System.out.println(p);
        }
    }
}
