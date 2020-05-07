package com.codecool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int n = 121;
        System.out.println("Primes :" + Arrays.toString(generatePrimes(n).toArray()));
        System.out.println("Amount of primes: " + countPrimes(generatePrimes(n)));
    }

    static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            primes.add(i);
        }

        for (int indx = 0; indx < primes.size(); indx++) {
            for (int divider = 2; divider <= Math.sqrt(n); divider++) {
//                int newInt = primes.get(indx);
//                int rest = primes.get(indx) % divider;
//                boolean isIntFromPrimesGreaterThanDivider = primes.get(indx) > divider;
                if (primes.get(indx) % divider == 0 && primes.get(indx) > divider) {
                    primes.remove(indx);
                    indx--; // we have to decrement the index cause we would miss the next element! other way is to use iterator or replace it to 0 and after all conditions remove all 0s
                }
            }
        }

        return primes;
    }

    static int countPrimes(List<Integer> primes) {
        return primes.size();
    }

    private static boolean primeCheck(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
