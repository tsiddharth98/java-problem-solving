package sorting.problems;

import java.util.Arrays;

/*
493. Reverse Pairs

Difficulty: Hard

Problem Statement:
Given an integer array nums, return the number of reverse pairs.

A reverse pair is a pair (i, j) such that:

1. 0 <= i < j < nums.length
2. nums[i] > 2 * nums[j]

Examples:

Input:
nums = [1,3,2,3,1]

Output:
2

Explanation:
The reverse pairs are:
(3,1)
(3,1)

Input:
nums = [2,4,3,5,1]

Output:
3

Explanation:
The reverse pairs are:
(4,1)
(3,1)
(5,1)

Constraints:
1 <= nums.length <= 5 * 10^4
-2^31 <= nums[i] <= 2^31 - 1

Expected Time Complexity:
O(n log n)

Expected Auxiliary Space:
O(n)
*/

public class ReversePairs {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{1, 3, 2, 3, 1}, 2},
                {new int[]{2, 4, 3, 5, 1}, 3},

                // Single element
                {new int[]{1}, 0},

                // Two elements
                {new int[]{2, 1}, 0},
                {new int[]{3, 1}, 1},
                {new int[]{1, 2}, 0},

                // Already sorted
                {new int[]{1, 2, 3, 4, 5}, 0},

                // Reverse sorted
                {new int[]{5, 4, 3, 2, 1}, 4},

                // Duplicates
                {new int[]{1, 1, 1, 1}, 0},
                {new int[]{2, 2, 2, 1}, 0},
                {new int[]{4, 2, 2, 1}, 1},

                // Mixed
                {new int[]{5, 1, 2, 3}, 2},
                {new int[]{10, 5, 2, 1}, 4},
                {new int[]{9, 4, 1}, 3},
                {new int[]{8, 4, 2, 1}, 3},
                {new int[]{1, 6, 2, 3}, 1},
                {new int[]{7, 3, 2, 6, 1}, 5},

                // Negative numbers
                {new int[]{-5, -5}, 1},
                {new int[]{-2, -1}, 0},
                {new int[]{-1, -2}, 1},
                {new int[]{-5, -4, -3, -2}, 4},

                // Mixed positive & negative
                {new int[]{-2, -1, 0, 1, 2}, 0},
                {new int[]{2, -1}, 1},
                {new int[]{4, -2, 1}, 2},

                // Overflow check
                {new int[]{2147483647, 2147483647}, 0},
                {new int[]{2147483647, 1}, 1},
                {new int[]{2147483647, -2147483648}, 1}
        };

        int passed = 0;

        ReversePairs solution = new ReversePairs();

        for (Object[] test : testCases) {

            int[] nums = (int[]) test[0];
            int expected = (Integer) test[1];

            int actual = solution.reversePairs(nums.clone());

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Array: %s | Expected: %d | Actual: %d%n",
                        Arrays.toString(nums),
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int arr[], int left, int right) {
        int count = 0;
        if(left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }

        return count;
    }

    public int merge(int[] arr, int left, int mid, int right) {
        int count = 0;
        int n1 = mid - left + 1, n2 = right - mid;
        int[] leftarr = new int[n1];
        int[] rightarr = new int[n2];

        int j = left;
        for(int i = 0; i < n1; i++) {
            leftarr[i] = arr[j++];
        }

        j = mid + 1;
        for(int i = 0; i < n2; i++) {
            rightarr[i] = arr[j++];
        }

        int i = 0;
        j=0;
        int k = left;

        while(i < n1 && j < n2) {
            if(leftarr[i] <= 2 * (long) rightarr[j]) {
                i++;
            } else {
                count += n1 - i;
                j++;
            }
        }
        i=0;
        j=0;
        while(i < n1 && j < n2) {
            if(leftarr[i] <= rightarr[j]) {
                arr[k++] = leftarr[i++];
            } else {
                arr[k++] = rightarr[j++];
            }
        }
        while(i < n1) {
            arr[k++] = leftarr[i++];
        }
        while(j < n2) {
            arr[k++] = rightarr[j++];
        }

        return count;
    }

    // Merge Sort Approach
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
}