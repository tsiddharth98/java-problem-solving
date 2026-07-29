package searching.binary_search;

import java.util.Arrays;

/*
878. Nth Magical Number

Difficulty: Hard

Problem Statement:
A positive integer is called magical if it is divisible by either a or b.

Given three integers:
- n
- a
- b

Return the nth magical number.

Since the answer may be very large, return it modulo (10^9 + 7).

Examples:

Input:
n = 1, a = 2, b = 3

Output:
2

Explanation:
Magical numbers:
2, 3, 4, 6, 8, 9, ...

1st magical number = 2

Input:
n = 4, a = 2, b = 3

Output:
6

Explanation:
Magical numbers:
2, 3, 4, 6, 8, ...

4th magical number = 6

Constraints:
1 <= n <= 10^9
2 <= a, b <= 40000

Expected Time Complexity:
O(log(n * min(a,b)))

Expected Auxiliary Space:
O(1)
*/

public class NthMagicalNumber {

    public static void main(String[] args) {

        int[][] testCases = {

                // {n, a, b, expected}

                // Problem examples
                {1, 2, 3, 2},
                {4, 2, 3, 6},

                // Same divisor
                {1, 5, 5, 5},
                {5, 5, 5, 25},

                // One divides the other
                {5, 2, 4, 10},
                {7, 3, 6, 21},
                {10, 4, 8, 40},

                // Coprime numbers
                {5, 3, 5, 10},
                {10, 3, 5, 21},
                {8, 4, 7, 21},

                // Equal frequency overlap
                {6, 2, 6, 12},
                {8, 6, 8, 32},

                // Small values
                {2, 2, 3, 3},
                {3, 2, 3, 4},
                {5, 2, 3, 8},
                {6, 2, 3, 9},
                {7, 2, 3, 10},
                {8, 2, 3, 12},

                // Prime divisors
                {10, 7, 11, 44},
                {15, 7, 13, 70},

                // Larger n
                {20, 2, 3, 30},
                {25, 4, 6, 76},
                {30, 5, 7, 95},

                // a > b
                {10, 8, 3, 24},
                {15, 10, 4, 50},

                // Equal large values
                {3, 40000, 40000, 120000}
        };

        int passed = 0;

        NthMagicalNumber solution = new NthMagicalNumber();

        for (int[] test : testCases) {

            int n = test[0];
            int a = test[1];
            int b = test[2];
            int expected = test[3];

            int actual = solution.nthMagicalNumber(n, a, b);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> n: %d, a: %d, b: %d | Expected: %d | Actual: %d%n",
                        n, a, b, expected, actual
                );
            }
        }

        System.out.printf(
                "%nPassed %d/%d test cases.%n",
                passed,
                testCases.length
        );
    }

    // Binary Search + LCM
    //
    // Time Complexity: O(log(n * min(a, b)))
    //
    // Space Complexity: O(1)
    public int nthMagicalNumber(int n, int a, int b) {
        long MOD = 1_000_000_007L;

        // Calculate LCM: lcm(a, b) = (a * b) / gcd(a, b)
        long lcm = ((long) a * b) / gcd(a, b);

        // Binary search bounds
        long low = Math.min(a, b);
        long high = (long) n * Math.min(a, b);

        while (low < high) {
            long mid = low + (high - low) / 2;

            // Count how many magical numbers are <= mid
            long count = (mid / a) + (mid / b) - (mid / lcm);

            if (count >= n) {
                high = mid; // Try finding a smaller valid number
            } else {
                low = mid + 1; // Need a larger number
            }
        }

        return (int) (low % MOD);
    }

    // Helper method to find Greatest Common Divisor (GCD) using Euclidean algorithm
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}