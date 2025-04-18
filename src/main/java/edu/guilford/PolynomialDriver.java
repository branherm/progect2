package edu.guilford;

import java.util.Scanner;

public class PolynomialDriver {

   public static void main(String[] args) {
      double[] coeff1 = { 1.0, 2.5, 3.3, 4.6 };
      Polynomial p1 = new Polynomial(coeff1);
      double[] coeff2 = { 4.1, 5.6, 6.8 };
      Polynomial p2 = new Polynomial(coeff2);
      Polynomial p3 = p1.add(p2);

      // print the toString method

      System.out.println(p1.toString());

      System.out.println(p2.toString());

      System.out.println(p3.toString());

      // print the evaluate method

      System.out.println(p1.evaluate(1));

      System.out.println(p2.evaluate(2));

      // print the add method

      System.out.println(p1.add(p2));

      // print the subtract method

      System.out.println(p1.subtract(p2));

      // test the compareTo method

      System.out.println(p1.compareTo(p2));

      System.out.println(p2.compareTo(p1));

      System.out.println(p1.compareTo(p1));

      // print out the random polynomial
      System.out.println("Random Polynomial: " + Polynomial.randomPolynomial());

      // test the compareToRandom method with the random polynomials

      System.out.println(Polynomial.randomPolynomial().compareToRandom(Polynomial.randomPolynomial()));

      Scanner in = new Scanner(System.in);

      int a = in.nextInt();
      System.out.println("Number imputed: " + a);
      in.close();

      // create an array of all the random polynomials and print them out

      Polynomial[] randomPolynomials = new Polynomial[a];
      for (int i = 0; i < a; i++) {
         randomPolynomials[i] = Polynomial.randomPolynomial();
         System.out.println(randomPolynomials[i]);
      }

      // use the compareToRandom method to compare all the random polynomials
      for (int i = 0; i < a; i++) {
         System.out.println(Polynomial.randomPolynomial().compareToRandom(Polynomial.randomPolynomial()));
      }

      // print out an unsorted list of the random polynomials
      System.out.println("Unsorted list of random polynomials: ");
      for (int i = 0; i < a; i++) {
         System.out.println(randomPolynomials[i]);
      }

      // print out the selection sorted list of random polynomials
      selectionSort(randomPolynomials);
      System.out.println("\nSorted list of random polynomials Using Selection Sort: ");
      for (int i = 0; i < a; i++) {
         System.out.println(randomPolynomials[i]);
      }

      // time the selection sort method and print out the time
      long startTime = System.nanoTime();
      selectionSort(randomPolynomials);
      long endTime = System.nanoTime();
      long duration = (endTime - startTime);
      System.out.println("\nTime to sort using Selection Sort: " + duration + " nanoseconds");

      // print out the quick sorted list of random polynomials
      quickSort(randomPolynomials, 0, randomPolynomials.length - 1);
      System.out.println("\nSorted list of random polynomials Using Quick Sort: ");
      for (int i = 0; i < a; i++) {
         System.out.println(randomPolynomials[i]);
      }

      // time the quick sort method and print out the time
      long startTime2 = System.nanoTime();
      quickSort(randomPolynomials, 0, randomPolynomials.length - 1);
      long endTime2 = System.nanoTime();
      long duration2 = (endTime2 - startTime2);
      System.out.println("\nTime to sort using Quick Sort: " + duration2 + " nanoseconds");

      // print out the polynomial with the highest degree
      System.out
            .println("\nPolynomial with the highest degree: " + randomPolynomials[binarySearch(randomPolynomials)]);

      // time the sequential search method and print out the time
      long startTime3 = System.nanoTime();
      binarySearch(randomPolynomials);
      long endTime3 = System.nanoTime();
      long duration3 = (endTime3 - startTime3);
      System.out.println("\nTime to search for the polynomial with the highest degree: " + duration3 + " nanoseconds");

      // print out the polynomial with the lowest degree
      System.out.println("\nPolynomial with the lowest degree: " + randomPolynomials[binarySearch(randomPolynomials)]);

      // print out the binary search method and print out the time
      long startTime4 = System.nanoTime();
      binarySearch(randomPolynomials);
      long endTime4 = System.nanoTime();
      long duration4 = (endTime4 - startTime4);
      System.out.println("\nTime to search for the polynomial with the highest degree: " + duration4 + " nanoseconds");

   }

   // build a selection sort method

   public static void selectionSort(Polynomial[] randomPolynomials) {
      for (int i = 0; i < randomPolynomials.length - 1; i++) {
         int min = i;
         for (int j = i + 1; j < randomPolynomials.length; j++) {
            if (randomPolynomials[j].compareTo(randomPolynomials[min]) < 0) {
               min = j;
            }
         }
         if (min != i) {
            Polynomial temp = randomPolynomials[i];
            randomPolynomials[i] = randomPolynomials[min];
            randomPolynomials[min] = temp;
         }

      }
   }

   // build a quick sort method

   public static void quickSort(Polynomial[] randomPolynomials, int low, int high) {
      if (low < high) {
         int pi = partition(randomPolynomials, low, high);
         quickSort(randomPolynomials, low, pi - 1);
         quickSort(randomPolynomials, pi + 1, high);
      }
   }

   public static int partition(Polynomial[] randomPolynomials, int low, int high) {
      Polynomial pivot = randomPolynomials[high];
      int i = (low - 1);
      for (int j = low; j < high; j++) {
         if (randomPolynomials[j].compareTo(pivot) < 0) {
            i++;
            Polynomial temp = randomPolynomials[i];
            randomPolynomials[i] = randomPolynomials[j];
            randomPolynomials[j] = temp;
         }
      }
      Polynomial temp = randomPolynomials[i + 1];
      randomPolynomials[i + 1] = randomPolynomials[high];
      randomPolynomials[high] = temp;
      return i + 1;
   }

   // build a binary search method that searches for the polynomail with the highest degree

   public static int binarySearch(Polynomial[] randomPolynomials) {
      int low = 0;
      int high = randomPolynomials.length - 1;
      int max = 0;
      while (low <= high) {
         int mid = (low + high) / 2;
         if (randomPolynomials[mid].compareTo(randomPolynomials[max]) > 0) {
            max = mid;
         }
         if (randomPolynomials[mid].compareTo(randomPolynomials[max]) < 0) {
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }
      return max;
   }


  

}