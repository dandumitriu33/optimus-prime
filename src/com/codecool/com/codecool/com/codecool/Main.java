package com.codecool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        // Exercise requirements details
        // your task is to count the number of prime numbers
        // less than a non-negative number (n) by using
        // the sieve of Eratosthenes
        // + optimization 1
        // You have infinite amount of memory but a slow CPU:
        // you can use as many and as large data structures as you want.
        // + optimization 2
        // You have infinite amount of CPU but limited memory:
        // store as few data as you can in variables while the program runs

        int n = 121;

        // Eratosthenes algorithm attempt
        // populating the list of numbers 2 to n
        primesEratosthenes(n);

        // optimization 1 attempt - low CPU, infinite memory
        primesEratosthenesOptimizationMemory(n);

    }

    private static void primesEratosthenesOptimizationMemory(int n) {
        // we build a primes cache
        long t0 = System.nanoTime();
        List<Integer> primes = new ArrayList<>();
        // we go through each number and
        // first % it by all previous primes - if pass,
        // then we check if it is a prime
        for (int i=2; i<n; i++) {
            for (int j=0; j<primes.size(); j++) {
                if (i%primes.get(j)==0) break;
            }
            if (isPrime(i)) primes.add(i);
        }
        long t1 = System.nanoTime();
        System.out.println("Total number of primes from 1 to " + n + " is: " + primes.size());
        System.out.println("Approximate time to complete: " + (t1-t0) + " nanoseconds.");
    }


    static boolean isPrime(int number) {
        if (number == 2) return true;
        for (int i=2; i<number; i++) {
            if (number%i == 0) return false;
        }
        return true;
    }

    private static void primesEratosthenes(int n) {
        long t0 = System.nanoTime();
        List<Integer> allNumbers = new ArrayList<>();
        for (int i=2; i<=n; i++) {
            allNumbers.add(i);
        }
        // instead of marking the numbers as composite we will move them to
        // a separate composite Array
        // not a necessary step, but simulating the algorithm
        // and we will be moving the primes to a primes list
        List<Integer> composites = new ArrayList<>();
        List<Integer> primes = new ArrayList<>();
        while(allNumbers.size()>0) {
            int currentNumber = allNumbers.get(0);
            if (isPrime(currentNumber)) {
                primes.add(currentNumber);
                allNumbers.remove(0);
                for (int i=0; i<allNumbers.size(); i++) {
                    if (allNumbers.get(i)%currentNumber==0) {
                        composites.add(allNumbers.get(i));
                        allNumbers.remove(allNumbers.get(i));
                    }
                }
            }
            else {
                System.out.println("Wow, how did you get here?");
            }
        }
        long t1 = System.nanoTime();
        System.out.println("The number of primes from 1 to " + n + " is: " + primes.size());
        System.out.println("Composites in between: " + composites.toString());
        System.out.println("Approximate time to complete: " + (t1-t0) + " nanoseconds.");

    }

}







// previous code
//
//    int n = 121;
//        System.out.println("Primes :" + Arrays.toString(generatePrimes(n).toArray()));
//                System.out.println("Amount of primes: " + countPrimes(generatePrimes(n)));
//                }
//
//static List<Integer> generatePrimes(int n) {
//        List<Integer> primes = new ArrayList<>();
//
//        for (int i = 2; i <= n; i++) {
//        primes.add(i);
//        }
//
//        for (int indx = 0; indx < primes.size(); indx++) {
//        for (int divider = 2; divider <= Math.sqrt(n); divider++) {
////                int newInt = primes.get(indx);
////                int rest = primes.get(indx) % divider;
////                boolean isIntFromPrimesGreaterThanDivider = primes.get(indx) > divider;
//        if (primes.get(indx) % divider == 0 && primes.get(indx) > divider) {
//        primes.remove(indx);
//        indx--; // we have to decrement the index cause we would miss the next element! other way is to use iterator or replace it to 0 and after all conditions remove all 0s
//        }
//        }
//        }
//
//        return primes;
//        }
//
//static int countPrimes(List<Integer> primes) {
//        return primes.size();
//        }
//
//private static boolean primeCheck(int n) {
//        if (n < 2) {
//        return false;
//        }
//        for (int i = 2; i * i <= n; i++) {
//        if (n % i == 0) {
//        return false;
//        }
//        }
//        return true;
//        }