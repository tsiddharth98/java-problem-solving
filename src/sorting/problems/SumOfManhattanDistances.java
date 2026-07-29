package sorting.problems;

import java.util.Arrays;

/*
Sum of Manhattan Distances Between All Pairs of Points

Problem Statement:
Given two integer arrays x[] and y[] of size n, where
(x[i], y[i]) represents the coordinates of the ith point.

Find the sum of Manhattan distances between every pair of points.

The Manhattan distance between two points
(x1, y1) and (x2, y2) is:

|x1 - x2| + |y1 - y2|

Examples:

Input:
x = {-1, 1, 3, 2}
y = {5, 6, 5, 3}
n = 4

Output:
22

Explanation:

(-1,5) ↔ (1,6) = 3
(-1,5) ↔ (3,5) = 4
(-1,5) ↔ (2,3) = 5
(1,6)  ↔ (3,5) = 3
(1,6)  ↔ (2,3) = 4
(3,5)  ↔ (2,3) = 3

Total = 22

Constraints:
1 <= n <= 10^5
-10^9 <= x[i], y[i] <= 10^9

Expected Complexities:

Naive:
Time Complexity: O(n²)
Space Complexity: O(1)

Optimized:
Time Complexity: O(n log n)
Space Complexity: O(n)
*/

public class SumOfManhattanDistances {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem example
                {
                        new int[]{-1, 1, 3, 2},
                        new int[]{5, 6, 5, 3},
                        4,
                        22
                },

                // Single point
                {
                        new int[]{5},
                        new int[]{7},
                        1,
                        0
                },

                // Two points
                {
                        new int[]{0, 3},
                        new int[]{0, 4},
                        2,
                        7
                },

                // Horizontal line
                {
                        new int[]{1, 4, 7},
                        new int[]{2, 2, 2},
                        3,
                        12
                },

                // Vertical line
                {
                        new int[]{5, 5, 5},
                        new int[]{1, 4, 8},
                        3,
                        14
                },

                // Square
                {
                        new int[]{0, 0, 1, 1},
                        new int[]{0, 1, 0, 1},
                        4,
                        8
                },

                // Duplicate points
                {
                        new int[]{2, 2},
                        new int[]{2, 2},
                        2,
                        0
                },

                {
                        new int[]{1, 1, 2},
                        new int[]{1, 1, 2},
                        3,
                        4
                },

                // Negative coordinates
                {
                        new int[]{-3, -1, 4},
                        new int[]{-2, -5, 1},
                        3,
                        26
                },

                // Mixed coordinates
                {
                        new int[]{-2, 3, 5, 1},
                        new int[]{4, -1, 2, 7},
                        4,
                        49
                },

                // Same x
                {
                        new int[]{2, 2, 2, 2},
                        new int[]{1, 5, 8, 10},
                        4,
                        30
                },

                // Same y
                {
                        new int[]{1, 5, 8, 10},
                        new int[]{3, 3, 3, 3},
                        4,
                        30
                }
        };

        int passed = 0;

        SumOfManhattanDistances solution = new SumOfManhattanDistances();

        for (Object[] test : testCases) {

            int[] x = (int[]) test[0];
            int[] y = (int[]) test[1];
            int n = (Integer) test[2];
            int expected = (Integer) test[3];

            int actual = solution.distanceSum(x, y, n);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> x: %s | y: %s | Expected: %d | Actual: %d%n",
                        Arrays.toString(x),
                        Arrays.toString(y),
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    // Naive Approach
    // Time Complexity: O(n²)
    // Space Complexity: O(1)
    int distanceSum1(int[] x, int[] y, int n) {

        int dist = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                dist += Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
            }
        }

        return dist;
    }

    // Optimized Approach (Sort x[] and y[] separately)
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    int distanceSum(int[] x, int[] y, int n) {

        return distance(x, n) + distance(y, n);
    }

    int distance(int[] arr, int n) {
        // sorting the array.
        Arrays.sort(arr);

        int dist = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            dist += (i * arr[i] - sum);
            sum += arr[i];
        }

        return dist;
    }

}