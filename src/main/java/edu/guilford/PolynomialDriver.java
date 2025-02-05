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
        List<Polynomial> randomPolynomials = new ArrayList<>();
        randomPolynomials.add(new Polynomial(3));
        randomPolynomials.add(new Polynomial(2));
        randomPolynomials.add(new Polynomial(4));
        randomPolynomials.add(new Polynomial(1));
        randomPolynomials.add(new Polynomial(5));

        // Display Unsorted List
        System.out.println("Unsorted Polynomials:");
        for (Polynomial p : randomPolynomials) {
            System.out.println(p);
        }

        // Sort the polynomials using compareTo()
        Collections.sort(randomPolynomials);

        // Display Sorted List
        System.out.println("\nSorted Polynomials (after Collections.sort):");
        for (Polynomial p : randomPolynomials) {
            System.out.println(p);
        }

        // Sequential Search
        System.out.println("Testing Sequential Search:");
        Polynomial searchTerm = randomPolynomials.get(2); // Pick a polynomial from the list
        System.out.println("Searching for: " + searchTerm);
        int indexSeq = sequentialSearch(randomPolynomials, searchTerm);
        if (indexSeq != -1) {
            System.out.println("Found at index " + indexSeq);
        } else {
            System.out.println("Not found.");
        }

        // Binary Search
        System.out.println("Testing Binary Search:");
        Polynomial searchTermBinary = randomPolynomials.get(4); // Pick another polynomial from the list
        System.out.println("Searching for: " + searchTermBinary);
        int indexBin = binarySearch(randomPolynomials, searchTermBinary);
        if (indexBin != -1) {
            System.out.println("Found at index " + indexBin);
        } else {
            System.out.println("Not found.");
        }

        // Test sorting algorithms
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of polynomials to generate: ");
        int numPolynomials = scanner.nextInt();

        // Generate an array of random polynomials
        List<Polynomial> polynomials = new ArrayList<>();
        for (int i = 0; i < numPolynomials; i++) {
            polynomials.add(new Polynomial(5)); // Random polynomial of degree 5
        }

        // Display Unsorted List (for small number of objects)
        if (numPolynomials <= 10) {
            System.out.println("Unsorted Polynomials:");
            for (Polynomial p : polynomials) {
                System.out.println(p);
            }
        }

        // Make a copy of the list for sorting
        List<Polynomial> polynomialsForSelectionSort = new ArrayList<>(polynomials);
        List<Polynomial> polynomialsForQuickSort = new ArrayList<>(polynomials);

        // Sort using Selection Sort (O(n^2))
        long startTime = System.nanoTime();
        selectionSort(polynomialsForSelectionSort);
        long endTime = System.nanoTime();
        long selectionSortTime = endTime - startTime;

        // Display Sorted List after Selection Sort (for small number of objects)
        if (numPolynomials <= 10) {
            System.out.println("\nSorted Polynomials (after Selection Sort):");
            for (Polynomial p : polynomialsForSelectionSort) {
                System.out.println(p);
            }
        }
        System.out.println("Selection Sort Time: " + selectionSortTime + " nanoseconds");

        // Sort using Quick Sort (O(n log n))
        startTime = System.nanoTime();
        quickSort(polynomialsForQuickSort, 0, polynomialsForQuickSort.size() - 1);
        endTime = System.nanoTime();
        long quickSortTime = endTime - startTime;

        // Display Sorted List after Quick Sort (for small number of objects)
        if (numPolynomials <= 10) {
            System.out.println("\nSorted Polynomials (after Quick Sort):");
            for (Polynomial p : polynomialsForQuickSort) {
                System.out.println(p);
            }
        }
        System.out.println("Quick Sort Time: " + quickSortTime + " nanoseconds");

        scanner.close();
    }

    // Selection Sort method (O(n^2))
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

    // Quick Sort method (O(n log n))
    public static void quickSort(List<Polynomial> list, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(list, low, high);
            quickSort(list, low, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, high);
        }
    }

    // Partition method for Quick Sort
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

    // Sequential Search (O(n))
    public static int sequentialSearch(List<Polynomial> list, Polynomial target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(target) == 0) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Binary Search (O(log n)) - assumes the list is sorted
    public static int binarySearch(List<Polynomial> list, Polynomial target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = list.get(mid).compareTo(target);

            if (comparison == 0) {
                return mid; // Found the target
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Not found
    }
}
