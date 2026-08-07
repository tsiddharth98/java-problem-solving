package searching.binary_search;

import java.util.Arrays;

/*
1201. Ugly Number III

Difficulty: Medium

Problem Statement:
An ugly number is a positive integer that is divisible by
a, b, or c.

Given four integers n, a, b, and c,
return the nth ugly number.

Examples:

Input:
n = 3, a = 2, b = 3, c = 5

Output:
4

Explanation:
Ugly numbers:
2, 3, 4, 5, 6, 8, 9, ...

The 3rd ugly number is 4.

Input:
n = 4, a = 2, b = 3, c = 4

Output:
6

Input:
n = 5, a = 2, b = 11, c = 13

Output:
10

Constraints:
1 <= n, a, b, c <= 10^9
1 <= a * b * c <= 10^18

Expected Time Complexity:
O(log(2 * 10^9))

Expected Auxiliary Space:
O(1)
*/

public class UglyNumberIII {

    public static void main(String[] args) {

        int[][] testCases = {

                // {n, a, b, c, expected}

                // Problem examples
                {3, 2, 3, 5, 4},
                {4, 2, 3, 4, 6},
                {5, 2, 11, 13, 10},

                // Same divisors
                {1, 5, 5, 5, 5},
                {5, 5, 5, 5, 25},

                // One divides another
                {6, 2, 4, 8, 12},
                {8, 3, 6, 9, 24},

                // Pairwise coprime
                {10, 2, 3, 5, 14},
                {15, 3, 5, 7, 27},

                // Small values
                {1, 2, 3, 5, 2},
                {2, 2, 3, 5, 3},
                {3, 2, 3, 5, 4},
                {4, 2, 3, 5, 5},
                {5, 2, 3, 5, 6},
                {6, 2, 3, 5, 8},
                {7, 2, 3, 5, 9},
                {8, 2, 3, 5, 10},
                {9, 2, 3, 5, 12},
                {10, 2, 3, 5, 14},

                // Larger divisors
                {10, 7, 11, 13, 35},
                {20, 7, 11, 13, 66},

                // Mixed
                {12, 4, 6, 9, 30},
                {15, 4, 10, 25, 48},

        };

        int passed = 0;

        UglyNumberIII solution = new UglyNumberIII();

        for (int[] test : testCases) {

            int n = test[0];
            int a = test[1];
            int b = test[2];
            int c = test[3];
            int expected = test[4];

            int actual = solution.nthUglyNumber(n, a, b, c);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> n: %d, a: %d, b: %d, c: %d | Expected: %d | Actual: %d%n",
                        n, a, b, c, expected, actual
                );
            }
        }

        System.out.printf(
                "%nPassed %d/%d test cases.%n",
                passed,
                testCases.length
        );
    }

    public int nthUglyNumber(int n, int a, int b, int c) {

        long lcmAB = lcm(a, b);
        long lcmBC = lcm(b, c);
        long lcmAC = lcm(a, c);
        long lcmABC = lcm(lcmAB, c);

        long low = Math.min(Math.min(a, b), c);
        long high = (long) n * Math.min(Math.min(a, b), c);

        while(low < high) {
            long mid = low + (high - low) / 2;
            long count = (mid / a) + (mid / b) + (mid / c)
                    - (mid / lcmAB) - (mid / lcmBC) - (mid / lcmAC)
                    + (mid / lcmABC);

            if(count >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return ((long) a * b) / gcd(a, b);
    }

    // Binary Search + Inclusion-Exclusion + LCM
    //
    // Time Complexity: O(log(2 * 10^9))
    //
    // Space Complexity: O(1)
}