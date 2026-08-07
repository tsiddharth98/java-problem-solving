package arrays.problems;

/*
Sum of Subarrays

Difficulty: Medium

Problem Statement:
Given an array arr[], find the sum of all the subarrays of the given array.

Note:
It is guaranteed that the total sum will fit within a 32-bit integer range.

Examples:

Input:
arr[] = [1, 2, 3]

Output:
20

Explanation:
Subarrays:
[1] = 1
[2] = 2
[3] = 3
[1,2] = 3
[2,3] = 5
[1,2,3] = 6

Total = 1 + 2 + 3 + 3 + 5 + 6 = 20

Input:
arr[] = [1, 3]

Output:
8

Explanation:
Subarrays:
[1] = 1
[3] = 3
[1,3] = 4

Total = 8

Constraints:
1 <= arr.length <= 10^5
0 <= arr[i] <= 10^4

Expected Time Complexity:
O(n)

Expected Auxiliary Space:
O(1)
*/

import java.util.Arrays;

public class SumOfSubarrays {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{1, 2, 3}, 20L},
                {new int[]{1, 3}, 8L},

                // Single element
                {new int[]{5}, 5L},
                {new int[]{0}, 0L},

                // Two elements
                {new int[]{2, 2}, 8L},
                {new int[]{5, 10}, 30L},

                // Three elements
                {new int[]{1, 1, 1}, 10L},
                {new int[]{3, 2, 1}, 20L},
                {new int[]{2, 4, 6}, 40L},

                // Four elements
                {new int[]{1, 2, 3, 4}, 50L},
                {new int[]{4, 3, 2, 1}, 50L},
                {new int[]{5, 5, 5, 5}, 100L},

                // Contains zeros
                {new int[]{0, 0, 0}, 0L},
                {new int[]{0, 1, 0}, 4L},
                {new int[]{1, 0, 2}, 9L},

                // Larger values
                {new int[]{10, 20, 30}, 200L},
                {new int[]{100, 200}, 600L},

                // Miscellaneous
                {new int[]{7, 8, 9, 10}, 170L},
                {new int[]{2, 1, 3, 4}, 46L},
                {new int[]{9, 1, 5}, 40L}
        };

        int passed = 0;

        SumOfSubarrays solution = new SumOfSubarrays();

        for (Object[] test : testCases) {

            int[] arr = (int[]) test[0];
            long expected = (long) test[1];

            long actual = solution.subarraySum(arr);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Array: %s | Expected: %d | Actual: %d%n",
                        Arrays.toString(arr),
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    public long subarraySum(int[] arr) {

        // Paste your solution here

        return 0;
    }

    /*
     * Time Complexity: O(n)
     *
     * Space Complexity: O(1)
     */
}