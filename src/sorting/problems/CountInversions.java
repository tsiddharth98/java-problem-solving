package sorting.problems;

import java.util.Arrays;

/*
Count Inversions

Difficulty: Medium

Problem Statement:
Given an array of integers arr[], find the inversion count of the array.

An inversion is a pair (i, j) such that:
1. i < j
2. arr[i] > arr[j]

Examples:

Input:
arr = [2, 4, 1, 3, 5]

Output:
3

Explanation:
The inversions are:
(2,1)
(4,1)
(4,3)

Input:
arr = [2, 3, 4, 5, 6]

Output:
0

Input:
arr = [10, 10, 10]

Output:
0

Constraints:
1 <= arr.length <= 10^5
1 <= arr[i] <= 10^4

Expected Time Complexity:
O(n log n)

Expected Auxiliary Space:
O(n)
*/

public class CountInversions {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{2, 4, 1, 3, 5}, 3},
                {new int[]{2, 3, 4, 5, 6}, 0},
                {new int[]{10, 10, 10}, 0},

                // Single element
                {new int[]{1}, 0},

                // Two elements
                {new int[]{2, 1}, 1},
                {new int[]{1, 2}, 0},

                // Completely reversed
                {new int[]{5, 4, 3, 2, 1}, 10},

                // Already sorted
                {new int[]{1, 2, 3, 4, 5}, 0},

                // Duplicates
                {new int[]{2, 2, 1}, 2},
                {new int[]{3, 3, 2, 2}, 4},
                {new int[]{1, 1, 1, 1}, 0},
                {new int[]{1, 2, 2, 1}, 2},

                // Mixed
                {new int[]{8, 4, 2, 1}, 6},
                {new int[]{1, 20, 6, 4, 5}, 5},
                {new int[]{3, 1, 2}, 2},
                {new int[]{4, 1, 3, 2}, 4},
                {new int[]{7, 5, 3, 1}, 6},
                {new int[]{5, 3, 2, 4, 1}, 8},

                // Larger examples
                {new int[]{9, 1, 8, 2, 7, 3}, 9},
                {new int[]{6, 5, 4, 3, 2, 1}, 15},

                // Edge cases
                {new int[]{10000, 1}, 1},
                {new int[]{1, 10000}, 0},
                {new int[]{10000, 9999, 9998}, 3}
        };

        int passed = 0;

        CountInversions solution = new CountInversions();

        for (Object[] test : testCases) {

            int[] arr = (int[]) test[0];
            int expected = (Integer) test[1];

            int actual = solution.inversionCount(arr.clone());

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

    public int inversionCount(int arr[]) {
        // code here

        return mergeSort(arr, 0, arr.length - 1);
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
            if(leftarr[i] <= rightarr[j]) {
                arr[k++] = leftarr[i++];
            } else {
                count += n1 - i;
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