package edu.guilford;

import java.util.*;

/**
 * The PolynomialDriver class tests the functionality of the Polynomial class.
 * It includes operations such as addition, subtraction, evaluation, sorting, and searching.
 *
 * @author Brandon Hermes
 * @version 1.0
 */
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

        // Test sorting algorithms
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of polynomials to generate: ");
        int numPolynomials = scanner.nextInt();
        scanner.close();
    }

    /**
     * Sorts a list of polynomials using selection sort.
     *
     * @param list the list of polynomials to be sorted
     */
    public static void selectionSort(List<Polynomial> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Collections.swap(list, i, minIndex);
            }
        }
    }

    /**
     * Sorts a list of polynomials using quicksort.
     *
     * @param list the list of polynomials to be sorted
     * @param low  the starting index
     * @param high the ending index
     */
    public static void quickSort(List<Polynomial> list, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(list, low, high);
            quickSort(list, low, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, high);
        }
    }

    /**
     * Partitions the list for quicksort.
     *
     * @param list the list to be partitioned
     * @param low  the starting index
     * @param high the ending index
     * @return the partition index
     */
    public static int partition(List<Polynomial> list, int low, int high) {
        Polynomial pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    /**
     * Performs a sequential search for a polynomial in a list.
     *
     * @param list   the list of polynomials
     * @param target the polynomial to search for
     * @return the index of the polynomial if found, otherwise -1
     */
    public static int sequentialSearch(List<Polynomial> list, Polynomial target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(target) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Performs a binary search for a polynomial in a sorted list.
     *
     * @param list   the sorted list of polynomials
     * @param target the polynomial to search for
     * @return the index of the polynomial if found, otherwise -1
     */
    public static int binarySearch(List<Polynomial> list, Polynomial target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = list.get(mid).compareTo(target);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
