package edu.guilford;

public class Polynomial {
        int degree;

        double[] coefficeint;

        // generate constructor to instantiate a polynomial object with all the
        // coefficients set to 0

        public Polynomial() {
                this.coefficeint = new double[1];
                this.coefficeint[0] = 0;
        }

        // generate a construtor that accepts an array of double values and instantiates
        // a polynomial object with that information

        public Polynomial(double[] coefficeint) {
                this.coefficeint = coefficeint;
        }

        public Polynomial(int degree) {
                this.coefficeint = new double[degree + 1];
                for (int i = 0; i < this.coefficeint.length; i++) {
                        this.coefficeint[i] = Math.random() * 30 - 15;
                }
                this.degree = degree;
        }

        // generate a getter that returns the degree

        public int getDegree() {
                return this.coefficeint.length - 1;
        }

        // generate a getter that returns an array of all coefficients up to the degree

        public double[] getCoefficients() {
                return this.coefficeint;
        }

        // generate a getter that Return a coefficient for any specified power

        public double getCoefficient(int power) {
                return this.coefficeint[power];
        }

        // generate a setter that has 2 parameters, the power, k of the coefficient to
        // change and the new value.

        public void setCoefficient(int power, double value) {
                this.coefficeint[power] = value;
        }

        // method to add two polynomials together

        public Polynomial add(Polynomial p) {
                int max = Math.max(this.coefficeint.length, p.coefficeint.length);
                double[] sum = new double[max];
                for (int i = 0; i < max; i++) {
                        if (i < this.coefficeint.length && i < p.coefficeint.length) {
                                sum[i] = this.coefficeint[i] + p.coefficeint[i];
                        } else if (i < this.coefficeint.length) {
                                sum[i] = this.coefficeint[i];
                        } else {
                                sum[i] = p.coefficeint[i];
                        }
                }
                return new Polynomial(sum);
        }

        // method to subtract two polynomials

        public Polynomial subtract(Polynomial p) {
                int max = Math.max(this.coefficeint.length, p.coefficeint.length);
                double[] sum = new double[max];
                for (int i = 0; i < max; i++) {
                        if (i < this.coefficeint.length && i < p.coefficeint.length) {
                                sum[i] = this.coefficeint[i] - p.coefficeint[i];
                        } else if (i < this.coefficeint.length) {
                                sum[i] = this.coefficeint[i];
                        } else {
                                sum[i] = -p.coefficeint[i];
                        }
                }
                return new Polynomial(sum);
        }

        // evaluation method that has parameter x and returns the value of the
        // polynomial at that point

        public double evaluate(double x) {
                double sum = 0;
                for (int i = 0; i < this.coefficeint.length; i++) {
                        sum += this.coefficeint[i] * Math.pow(x, i);
                }
                return sum;
        }

        // a clear method that sets all coefficients to 0

        public void clear() {
                for (int i = 0; i < this.coefficeint.length; i++) {
                        this.coefficeint[i] = 0;
                }
        }

        // compairTo method that compairs the current polynomial object with another
        // polynomial object and establishes an order

        public int compareTo(Polynomial p) {
                if (this.coefficeint.length > p.coefficeint.length) {
                        return 1;
                } else if (this.coefficeint.length < p.coefficeint.length) {
                        return -1;
                } else {
                        if (this.evaluate(1) > p.evaluate(1)) {
                                return 1;
                        } else if (this.evaluate(1) < p.evaluate(1)) {
                                return -1;
                        }
                        if (this.evaluate(2) > p.evaluate(2)) {
                                return 1;
                        } else if (this.evaluate(2) < p.evaluate(2)) {
                                return -1;
                        }
                        return 0;
                }
        }

        // create a constructor that creates a random polynomial with a random degree of
        // betweed 3 and 10 and each coefficient is a random number between -5 and 5

        public static Polynomial randomPolynomial() {
                int degree = (int) (Math.random() * 8) + 3;
                double[] coefficeint = new double[degree + 1];
                for (int i = 0; i < coefficeint.length; i++) {
                        coefficeint[i] = Math.random() * 10 - 5;
                }
                return new Polynomial(coefficeint);
        }

        //create a compairTo method that compairs the random polynomial with another polynomial object and establishes an order

        public int compareToRandom(Polynomial p) {
                if (this.coefficeint.length > p.coefficeint.length) {
                        return 1;
                } else if (this.coefficeint.length < p.coefficeint.length) {
                        return -1;
                } else {
                        if (this.evaluate(1) > p.evaluate(1)) {
                                return 1;
                        } else if (this.evaluate(1) < p.evaluate(1)) {
                                return -1;
                        }
                        if (this.evaluate(2) > p.evaluate(2)) {
                                return 1;
                        } else if (this.evaluate(2) < p.evaluate(2)) {
                                return -1;
                        }
                        return 0;
                }
        }

        // toString method that returns a string representation of the polynomial

        public String toString() {
                String s = "";
                for (int i = this.coefficeint.length - 1; i >= 0; i--) {
                        if (this.coefficeint[i] != 0) {
                                if (i == 0) {
                                        s += this.coefficeint[i];
                                } else if (i == 1) {
                                        s += this.coefficeint[i] + "x + ";
                                } else {
                                        s += this.coefficeint[i] + "x^" + i + " + ";
                                }
                        }
                }
                return s;
        }

}