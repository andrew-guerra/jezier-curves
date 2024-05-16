package com.github.andrewguerra.lib.math;

public class MathTools {
    public static int factorial(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Factorial argument must be zero or positive");
        }

        if(n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static double binomialCoefficient(int n, int k) {
        return ((double) factorial(n)) / (factorial(k) * factorial(n - k));
    }
}
