package basic.prime_numbers;

/*
Sieve of Eratosthenes

Difficulty: Medium

Problem Statement:
Given a positive integer n, calculate and return all prime numbers less than or equal to n
using the Sieve of Eratosthenes algorithm.

Examples:

Input: n = 10
Output: [2, 3, 5, 7]

Explanation:
Prime numbers less than or equal to 10 are 2, 3, 5 and 7.

Input: n = 35
Output: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]

Explanation:
Prime numbers less than or equal to 35 are
2, 3, 5, 7, 11, 13, 17, 19, 23, 29 and 31.

Constraints:
1 <= n <= 10^4
*/

import java.util.ArrayList;

public class SieveOfEratosthenes2 {

    public static void main(String[] args) {

        int[][] testCases = {
                // {input, expectedPrimeCount}

                {1, 0},
                {2, 1},
                {3, 2},
                {4, 2},
                {5, 3},
                {6, 3},
                {7, 4},
                {8, 4},
                {9, 4},
                {10, 4},

                {11, 5},
                {12, 5},
                {13, 6},
                {15, 6},
                {20, 8},
                {25, 9},
                {30, 10},
                {35, 11},
                {50, 15},
                {100, 25},

                {101, 26},
                {500, 95},
                {1000, 168},
                {5000, 669},
                {10000, 1229}
        };

        int passed = 0;

        for (int[] test : testCases) {

            int input = test[0];
            int expectedPrimeCount = test[1];

            // Replace this with your implementation
            int actualPrimeCount = sieve(input).size();

            if (actualPrimeCount == expectedPrimeCount) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Input: %d | Expected Prime Count: %d | Actual: %d%n",
                        input,
                        expectedPrimeCount,
                        actualPrimeCount
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed, testCases.length);
    }

    private static ArrayList<Integer> sieve(int n) {
        // code here
        ArrayList<Integer> sieve = new ArrayList<>();
        boolean[] arr = new boolean[n+1];

        for(int i=2;i<=n;i++) {
            arr[i] = true;
        }

        for(int i=2;i*i<=n;i++) {
            if(arr[i]) {
                for(int j=i*i;j<=n;j+=i) {
                    arr[j] = false;
                }
            }
        }

        for(int i=2;i<=n;i++) {
            if(arr[i]) {
                sieve.add(i);
            }
        }

        return sieve;
    }
}