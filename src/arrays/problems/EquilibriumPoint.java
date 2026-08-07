package arrays.problems;

import java.util.Arrays;

/*
Equilibrium Point

Difficulty: Easy

Problem Statement:
Given an array of integers arr[], find the first equilibrium point
(0-based indexing).

An equilibrium point is an index such that:

Sum of elements before it == Sum of elements after it

Return the first equilibrium index.
Return -1 if no such index exists.

Examples:

Input:
arr[] = [1, 2, 0, 3]

Output:
2

Explanation:
Left sum = 1 + 2 = 3
Right sum = 3

Input:
arr[] = [1, 1, 1, 1]

Output:
-1

Input:
arr[] = [-7, 1, 5, 2, -4, 3, 0]

Output:
3

Explanation:
Left sum = -7 + 1 + 5 = -1
Right sum = -4 + 3 + 0 = -1

Constraints:
3 <= arr.length <= 10^5
-10^4 <= arr[i] <= 10^4

Expected Time Complexity:
O(n)

Expected Auxiliary Space:
O(1)
*/

public class EquilibriumPoint {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{1, 2, 0, 3}, 2},
                {new int[]{1, 1, 1, 1}, -1},
                {new int[]{-7, 1, 5, 2, -4, 3, 0}, 3},

                // Equilibrium at beginning
                {new int[]{0, -3, 3}, 0},

                // Equilibrium at end
                {new int[]{5, -5, 0}, 2},

                // Middle
                {new int[]{2, 3, -1, 4, 0}, -1},
                {new int[]{1, 3, 5, 2, 2}, 2},

                // No equilibrium
                {new int[]{1, 2, 3}, -1},
                {new int[]{2, 4, 6, 8}, -1},
                {new int[]{10, 20, 30, 40, 50}, -1},

                // All zeros
                {new int[]{0, 0, 0}, 0},
                {new int[]{0, 0, 0, 0}, 0},

                // Negative numbers
                {new int[]{-1, -1, -2, -1, -1}, 2},
                {new int[]{-2, 2, 0}, 2},

                // Multiple equilibrium points (return first)
                {new int[]{0, 0, 0, 0, 0}, 0},

                // Large values
                {new int[]{10000, -10000, 5000, -5000, 0}, 4},
                {new int[]{10000, 0, -10000}, -1}
        };

        int passed = 0;

        EquilibriumPoint solution = new EquilibriumPoint();

        for (Object[] test : testCases) {

            int[] arr = ((int[]) test[0]).clone();
            int expected = (int) test[1];

            int actual = solution.findEquilibrium(arr);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Array: %s | Expected: %d | Actual: %d%n",
                        Arrays.toString((int[]) test[0]),
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    public static int findEquilibrium(int arr[]) {
        // code here
        int n = arr.length;
        int leftSum = 0;
        int rightSum = 0;

        for(int num: arr) {
            rightSum += num;
        }

        for(int i = 0; i < n; i++) {
            rightSum -= arr[i];
            if(i > 0) leftSum += arr[i - 1];
            if(leftSum == rightSum) return i;
        }

        return -1;
    }

    // Prefix Sum / Running Sum
    //
    // Time Complexity: O(n)
    //
    // Space Complexity: O(1)
}