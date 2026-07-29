package searching;

/*
378. Kth Smallest Element in a Sorted Matrix

Difficulty: Medium

Problem Statement:
Given an n x n matrix where each row and each column is sorted
in ascending order, return the kth smallest element in the matrix.

Note:
- It is the kth smallest element in sorted order.
- Not the kth distinct element.
- You must use memory better than O(n²).

Examples:

Input:
matrix = [
 [1, 5, 9],
 [10, 11, 13],
 [12, 13, 15]
]
k = 8

Output:
13

Explanation:
Sorted elements:
[1, 5, 9, 10, 11, 12, 13, 13, 15]

8th smallest = 13

Input:
matrix = [[-5]]
k = 1

Output:
-5

Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 300
-10^9 <= matrix[i][j] <= 10^9
1 <= k <= n²

Follow-up:
Can you solve it using:
1. O(1) extra space?
2. O(n) time?
*/

public class KthSmallestElementInSortedMatrix {

    public static void main(String[] args) {

        Object[][] testCases = {

                // LeetCode Examples
                {
                        new int[][]{
                                {1, 5, 9},
                                {10, 11, 13},
                                {12, 13, 15}
                        },
                        8,
                        13
                },

                {
                        new int[][]{
                                {-5}
                        },
                        1,
                        -5
                },

                // Single element
                {
                        new int[][]{
                                {7}
                        },
                        1,
                        7
                },

                // 2x2 matrix
                {
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        },
                        1,
                        1
                },

                {
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        },
                        2,
                        2
                },

                {
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        },
                        3,
                        3
                },

                {
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        },
                        4,
                        4
                },

                // Duplicates
                {
                        new int[][]{
                                {1, 2},
                                {2, 3}
                        },
                        2,
                        2
                },

                {
                        new int[][]{
                                {1, 2},
                                {2, 3}
                        },
                        3,
                        2
                },

                // All same values
                {
                        new int[][]{
                                {5, 5},
                                {5, 5}
                        },
                        1,
                        5
                },

                {
                        new int[][]{
                                {5, 5},
                                {5, 5}
                        },
                        4,
                        5
                },

                // Negative numbers
                {
                        new int[][]{
                                {-10, -5},
                                {-3, 0}
                        },
                        1,
                        -10
                },

                {
                        new int[][]{
                                {-10, -5},
                                {-3, 0}
                        },
                        4,
                        0
                },

                {
                        new int[][]{
                                {-10, -5},
                                {-3, 0}
                        },
                        3,
                        -3
                },

                // 3x3 matrix
                {
                        new int[][]{
                                {1, 3, 5},
                                {6, 7, 12},
                                {11, 14, 14}
                        },
                        6,
                        11
                },

                {
                        new int[][]{
                                {1, 3, 5},
                                {6, 7, 12},
                                {11, 14, 14}
                        },
                        9,
                        14
                },

                // Larger duplicate case
                {
                        new int[][]{
                                {1, 2, 2},
                                {2, 3, 3},
                                {3, 4, 5}
                        },
                        5,
                        3
                },

                // Edge values
                {
                        new int[][]{
                                {-1000000000, -999999999},
                                {999999999, 1000000000}
                        },
                        3,
                        999999999
                }
        };

        int passed = 0;

        KthSmallestElementInSortedMatrix solution =
                new KthSmallestElementInSortedMatrix();

        for (Object[] test : testCases) {

            int[][] matrix = (int[][]) test[0];
            int k = (Integer) test[1];
            int expected = (Integer) test[2];

            int actual = solution.kthSmallest(matrix, k);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> K: %d | Expected: %d | Actual: %d%n",
                        k,
                        expected,
                        actual
                );
            }
        }

        System.out.printf(
                "%nPassed %d/%d test cases.%n",
                passed,
                testCases.length
        );
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;

        int low = matrix[0][0];
        int high = matrix[n-1][m-1];

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int count = countSmallerEqual(matrix, mid);
            if(count < k) low = mid + 1;
            else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

    public int countSmallerEqual(int[][] matrix, int mid) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;
        int count = 0;

        while(row < n && col >= 0) {
            if(matrix[row][col] <= mid) {
                count += (col + 1);
                row++;
            } else {
                col--;
            }
        }

        return count;
    }

    // Binary Search on Answer Approach:
    // Time Complexity: O(n * log(maxValue - minValue))
    // Space Complexity: O(1)

    // Min Heap Approach:
    // Time Complexity: O(k log n)
    // Space Complexity: O(n)
}