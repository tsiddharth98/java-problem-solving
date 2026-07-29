package searching.binary_search;

import java.util.Arrays;

/*
668. Kth Smallest Number in Multiplication Table

Difficulty: Hard

Problem Statement:
Nearly everyone has used the Multiplication Table.

The multiplication table of size m x n is an integer matrix where

table[i][j] = (i + 1) * (j + 1)

(1-indexed)

Given three integers m, n, and k, return the kth smallest element
in the m x n multiplication table.

Note:
Duplicate values are counted separately.

Examples:

Input:
m = 3, n = 3, k = 5

Output:
3

Explanation:
Multiplication Table:

1 2 3
2 4 6
3 6 9

Sorted:
1 2 2 3 3 4 6 6 9

5th smallest = 3

Input:
m = 2, n = 3, k = 6

Output:
6

Explanation:

1 2 3
2 4 6

Sorted:
1 2 2 3 4 6

6th smallest = 6

Constraints:
1 <= m, n <= 30000
1 <= k <= m * n

Expected Time Complexity:
O(m * log(m * n))

Expected Auxiliary Space:
O(1)
*/

public class KthSmallestInMultiplicationTable {

    public static void main(String[] args) {

        int[][] testCases = {

                // {m, n, k, expected}

                // Problem examples
                {3, 3, 5, 3},
                {2, 3, 6, 6},

                // Single cell
                {1, 1, 1, 1},

                // Single row
                {1, 5, 1, 1},
                {1, 5, 3, 3},
                {1, 5, 5, 5},

                // Single column
                {5, 1, 1, 1},
                {5, 1, 4, 4},
                {5, 1, 5, 5},

                // Small square tables
                {2, 2, 1, 1},
                {2, 2, 2, 2},
                {2, 2, 3, 2},
                {2, 2, 4, 4},

                {3, 3, 1, 1},
                {3, 3, 2, 2},
                {3, 3, 3, 2},
                {3, 3, 4, 3},
                {3, 3, 9, 9},

                // Rectangular tables
                {3, 5, 7, 4},
                {3, 5, 10, 6},
                {4, 6, 12, 6},

                {5, 5, 13, 8},
                {5, 5, 25, 25},

                // Duplicate-heavy cases
                {4, 4, 8, 4},
                {4, 4, 10, 6},

                // Larger values
                {10, 10, 1, 1},
                {10, 10, 100, 100},

                // Rectangular larger
                {7, 9, 20, 9},
                {8, 12, 30, 12}
        };

        int passed = 0;

        KthSmallestInMultiplicationTable solution =
                new KthSmallestInMultiplicationTable();

        for (int[] test : testCases) {

            int m = test[0];
            int n = test[1];
            int k = test[2];
            int expected = test[3];

            int actual = solution.findKthNumber(m, n, k);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> m: %d, n: %d, k: %d | Expected: %d | Actual: %d%n",
                        m, n, k, expected, actual
                );
            }
        }

        System.out.printf(
                "%nPassed %d/%d test cases.%n",
                passed,
                testCases.length
        );
    }

    public int findKthNumber(int m, int n, int k) {

        int low = 1;
        int high = m * n;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(countLessOrEqual(mid, m, n) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int countLessOrEqual(int x, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {// Go row by row (from row 1 to row m)
            count += Math.min(x / i, n);// Add how many valid numbers are in row i
        }
        return count;// Return total count across all rows
    }

    // Binary Search on Answer
    // Time Complexity: O(m * log(m * n))
    //
    // Space Complexity: O(1)
}
