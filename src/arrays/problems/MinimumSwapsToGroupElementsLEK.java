package arrays.problems;

import java.util.Arrays;

/*
Minimum Swaps to Group Elements <= K

Difficulty: Medium

Problem Statement:
Given an array arr[] and an integer k.

You may swap any two elements in the array any number of times.

Find the minimum number of swaps required to bring all elements
less than or equal to k together (contiguously).

Examples:

Input:
arr = [2, 1, 5, 6, 3], k = 3

Output:
1

Explanation:
Elements <= 3 are {2,1,3}.
Swap 5 and 3 to obtain:
[2,1,3,6,5]

----------------------------------------------------

Input:
arr = [2,7,9,5,8,7,4], k = 6

Output:
2

----------------------------------------------------

Input:
arr = [2,4,5,3,6,1,8], k = 6

Output:
0

Constraints:
1 <= arr.length <= 10^6
1 <= arr[i] <= 10^6
1 <= k <= 10^6

Expected Time Complexity:
O(n)

Expected Auxiliary Space:
O(1)
*/

public class MinimumSwapsToGroupElementsLEK {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{2,1,5,6,3}, 3, 1},
                {new int[]{2,7,9,5,8,7,4}, 6, 2},
                {new int[]{2,4,5,3,6,1,8}, 6, 0},

                // Single element
                {new int[]{5}, 5, 0},
                {new int[]{10}, 5, 0},

                // All elements <= k
                {new int[]{1,2,3,4}, 5, 0},

                // No element <= k
                {new int[]{7,8,9}, 5, 0},

                // Already grouped
                {new int[]{1,2,3,7,8,9}, 3, 0},
                {new int[]{7,8,1,2,3}, 3, 0},

                // One swap needed
                {new int[]{1,7,2,3}, 3, 1},
                {new int[]{2,7,1,3}, 3, 1},

                // Multiple swaps
                {new int[]{1,7,2,8,3,9}, 3, 1},
                {new int[]{7,1,8,2,9,3}, 3, 1},
                {new int[]{7,1,8,2,9,3,10,4}, 4, 2},

                // Duplicates
                {new int[]{2,2,7,7,2,2}, 2, 2},
                {new int[]{1,5,1,5,1}, 1, 1},
                {new int[]{5,1,5,1,5,1}, 1, 1},

                // Edge cases
                {new int[]{1,6,2,7,3,8,4,9}, 4, 2},
                {new int[]{4,3,2,1}, 2, 0},
                {new int[]{3,1,4,2,5}, 3, 1},
                {new int[]{5,4,3,2,1}, 3, 0}
        };

        int passed = 0;

        MinimumSwapsToGroupElementsLEK solution = new MinimumSwapsToGroupElementsLEK();

        for (Object[] test : testCases) {

            int[] arr = (int[]) test[0];
            int k = (Integer) test[1];
            int expected = (Integer) test[2];

            int actual = solution.minSwap(arr.clone(), k);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Array: %s | k: %d | Expected: %d | Actual: %d%n",
                        Arrays.toString(arr),
                        k,
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    int minSwap(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        int bad = 0;
        int count =0;
        for(int i = 0; i < n; i++) {
            if(arr[i] <= k) count++;
        }
        for(int i = 0; i < count; i++) {
            if(arr[i] > k) bad++;
        }

        int swaps = bad;
        for(int i = 0, j = count; j < n; i++, j++) {
            if(arr[i] > k) --bad;
            if(arr[j] > k) ++bad;
            swaps = Math.min(bad, swaps);
        }

        return swaps;
    }

    /*
     * Time Complexity: O(n)
     *
     * Space Complexity: O(1)
     */
}