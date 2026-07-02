package basic;

import java.util.Arrays;

/*
Problem:
Given two integers a and b, compute their Least Common Multiple (LCM) and Greatest Common Divisor (GCD).
Return an array containing the LCM as the first element and the GCD as the second element.

Examples:

Input  : a = 5, b = 10
Output : [10, 5]

Input  : a = 14, b = 8
Output : [56, 2]

Input  : a = 1, b = 1
Output : [1, 1]

Constraints:
1 <= a, b <= 10^4

Expected Time Complexity: O(log(min(a, b)))
Expected Auxiliary Space: O(1)

Platform: GFG
Difficulty: Basic
Link: https://www.geeksforgeeks.org/problems/lcm-and-gcd4516/1
*/
public class LCMAndGCD {

    public static void main(String[] args) {

        // {a, b, expectedLCM, expectedGCD}
        int[][] testCases = {

                // Sample Test Cases
                {5, 10, 10, 5},
                {14, 8, 56, 2},
                {1, 1, 1, 1},

                // Equal Numbers
                {5, 5, 5, 5},
                {100, 100, 100, 100},
                {9999, 9999, 9999, 9999},

                // One Number is 1
                {1, 25, 25, 1},
                {100, 1, 100, 1},
                {1, 9999, 9999, 1},

                // Coprime Numbers (GCD = 1)
                {7, 9, 63, 1},
                {13, 17, 221, 1},
                {19, 20, 380, 1},
                {97, 89, 8633, 1},

                // One Divides the Other
                {3, 12, 12, 3},
                {16, 4, 16, 4},
                {50, 10, 50, 10},
                {81, 9, 81, 9},

                // Common Factors
                {18, 24, 72, 6},
                {36, 60, 180, 12},
                {48, 180, 720, 12},
                {72, 120, 360, 24},

                // Prime Numbers
                {17, 19, 323, 1},
                {29, 31, 899, 1},

                // Even/Odd Combination
                {15, 20, 60, 5},
                {27, 18, 54, 9},
                {45, 30, 90, 15},

                // Large Values
                {10000, 5000, 10000, 5000},
                {9999, 10000, 99990000, 1},
                {9998, 10000, 49990000, 2},

                // Consecutive Numbers
                {99, 100, 9900, 1},
                {1000, 1001, 1001000, 1},

                // Perfect Squares
                {36, 144, 144, 36},
                {49, 98, 98, 49},

                // Powers of Two
                {64, 128, 128, 64},
                {256, 1024, 1024, 256}
        };

        int passed = 0;

        for (int[] test : testCases) {

            int a = test[0];
            int b = test[1];

            int[] expected = {test[2], test[3]};
            int[] actual = lcmAndGcd(a, b);

            if (Arrays.equals(actual, expected)) {
                passed++;
            } else {
                System.out.println("❌ Failed");
                System.out.println("Input    : a = " + a + ", b = " + b);
                System.out.println("Expected : " + Arrays.toString(expected));
                System.out.println("Actual   : " + Arrays.toString(actual));
                System.out.println();
            }
        }

        System.out.printf("✅ Passed %d/%d test cases.%n", passed, testCases.length);
    }

    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int[] arr = new int[2];

        return arr;
    }

    public static int getLCM(int a, int b) {
        int lcm = 0;

        return lcm;
    }

    public static int getGCD(int a, int b) {
        int gcd = 0;
        
        return gcd;
    }
}
