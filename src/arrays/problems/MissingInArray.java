package arrays.problems;

import java.util.Arrays;

/*
Missing in Array

Difficulty: Easy

Problem Statement:
You are given an array arr[] of size n - 1 that contains distinct
integers in the range from 1 to n (inclusive).

The array represents a permutation of the integers from 1 to n
with exactly one element missing.

Return the missing element.

Examples:

Input:
arr[] = [1, 2, 3, 5]

Output:
4

Explanation:
Numbers from 1 to 5 are present except 4.

Input:
arr[] = [8, 2, 4, 5, 3, 7, 1]

Output:
6

Input:
arr[] = [1]

Output:
2

Constraints:
1 <= arr.length <= 10^6
1 <= arr[i] <= arr.length + 1

Expected Time Complexity:
O(n)

Expected Auxiliary Space:
O(1)
*/

public class MissingInArray {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{1, 2, 3, 5}, 4},
                {new int[]{8, 2, 4, 5, 3, 7, 1}, 6},
                {new int[]{1}, 2},

                // Missing first number
                {new int[]{2, 3, 4, 5}, 1},
                {new int[]{2}, 1},

                // Missing last number
                {new int[]{1, 2, 3, 4}, 5},
                {new int[]{1, 2}, 3},

                // Missing in middle
                {new int[]{1, 2, 4}, 3},
                {new int[]{1, 3, 4, 5}, 2},
                {new int[]{2, 3, 4, 5, 6}, 1},
                {new int[]{1, 2, 3, 4, 6}, 5},

                // Unsorted arrays
                {new int[]{5, 4, 1, 2}, 3},
                {new int[]{6, 3, 1, 2, 5}, 4},
                {new int[]{4, 2, 1}, 3},

                // Larger examples
                {new int[]{9, 1, 5, 2, 6, 3, 7, 8}, 4},
                {new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2}, 1},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10}
        };

        int passed = 0;

        MissingInArray solution = new MissingInArray();

        for (Object[] test : testCases) {

            int[] arr = ((int[]) test[0]).clone();
            int expected = (int) test[1];

            int actual = solution.missingNum(arr);

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

        System.out.printf(
                "%nPassed %d/%d test cases.%n",
                passed,
                testCases.length
        );
    }

    int missingNum(int arr[]) {
        // code here
        int n = arr.length + 1;
        long sum = (long) n * (n + 1) / 2;
        for(int num: arr) {
            sum -= num;
        }

        return (int) sum;
    }

    // Sum Formula / XOR Approach
    //
    // Time Complexity: O(n)
    //
    // Space Complexity: O(1)
}