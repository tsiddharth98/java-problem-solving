package searching;

/*
Maximum Subarray Size Having All Subarrays Sum Less Than or Equal to K
link: https://www.geeksforgeeks.org/dsa/maximum-subarray-size-subarrays-size-sum-less-k/#naive-approach-using-nested-loops-on-3-time-and-o1-space

Problem Statement:
Given an array of positive integers arr[] of size n and an integer k,
find the maximum subarray size such that EVERY subarray of that size
has sum less than or equal to k.

If no such subarray size exists, return -1.

Examples:

Input:
arr = [1, 2, 3, 4]
k = 8

Output:
2

Explanation:
Subarrays of size 1:
[1], [2], [3], [4]
Sums: 1, 2, 3, 4

Subarrays of size 2:
[1,2], [2,3], [3,4]
Sums: 3, 5, 7

Subarrays of size 3:
[1,2,3], [2,3,4]
Sums: 6, 9

Since 9 > 8, size 3 is invalid.
Maximum valid size = 2.

Input:
arr = [1, 2, 10, 4]
k = 8

Output:
-1

Explanation:
Element 10 > 8, therefore even a subarray of size 1 is invalid.

Input:
arr = [1, 2, 10, 4]
k = 14

Output:
2

Constraints:
1 <= n <= 10^5
1 <= arr[i] <= 10^9
1 <= k <= 10^15

Expected Time Complexity:
O(n log n)

Expected Auxiliary Space:
O(1)
*/

import java.util.Arrays;

public class MaximumSubarraySize {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{1, 2, 3, 4}, 8L, 2},
                {new int[]{1, 2, 10, 4}, 8L, -1},
                {new int[]{1, 2, 10, 4}, 14L, 2},

                // Single element
                {new int[]{5}, 5L, 1},
                {new int[]{5}, 4L, -1},

                // All elements equal
                {new int[]{2, 2, 2, 2}, 2L, 1},
                {new int[]{2, 2, 2, 2}, 4L, 2},
                {new int[]{2, 2, 2, 2}, 6L, 3},
                {new int[]{2, 2, 2, 2}, 8L, 4},

                // Increasing
                {new int[]{1, 2, 3, 4, 5}, 5L, 1},
                {new int[]{1, 2, 3, 4, 5}, 9L, 2},
                {new int[]{1, 2, 3, 4, 5}, 15L, 5},

                // Decreasing
                {new int[]{5, 4, 3, 2, 1}, 9L, 2},
                {new int[]{5, 4, 3, 2, 1}, 15L, 5},

                // Every size valid
                {new int[]{1, 1, 1, 1, 1}, 100L, 5},

                // No size valid
                {new int[]{20, 30, 40}, 10L, -1},

                // Mixed
                {new int[]{3, 1, 2, 1, 4}, 7L, 3},
                {new int[]{4, 1, 1, 1}, 6L, 3},
                {new int[]{1, 3, 2, 2, 1}, 8L, 4},

                // Large values
                {new int[]{1000000000, 1000000000}, 2000000000L, 2},
                {new int[]{1000000000, 1000000000}, 1999999999L, 1},

                // Boundary cases
                {new int[]{1, 1, 1, 1}, 1L, 1},
                {new int[]{1, 1, 1, 1}, 2L, 2},
                {new int[]{1, 1, 1, 1}, 3L, 3},
                {new int[]{1, 1, 1, 1}, 4L, 4}
        };

        int passed = 0;

        MaximumSubarraySize solution = new MaximumSubarraySize();

        for (Object[] test : testCases) {

            int[] arr = (int[]) test[0];
            long k = (Long) test[1];
            int expected = (Integer) test[2];

//            int actual = solution.maxSubarraySize1(arr, k);
//            int actual = solution.maxSubarraySize2(arr, k);
//            int actual = solution.maxSubarraySize3(arr, k);
            int actual = solution.maxSubarraySize(arr, k);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Array: %s | K: %d | Expected: %d | Actual: %d%n",
                        Arrays.toString(arr),
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

    // Brute Force Approach
    public int maxSubarraySize1(int[] arr, long k) {

        int ans = -1;
        int n = arr.length;

        // size
        for(int size = 1; size <= n ; size++) {

            int maxSum = Integer.MIN_VALUE;
            //starting point
            for(int i = 0; i < n - size + 1; i++) {
                int sum = 0;
                // cal sum
                for(int j = i; j < i + size; j++) {
                    sum += arr[j];
                }
                maxSum = Math.max(maxSum, sum);
            }

            if(maxSum <= k) ans = Math.max(ans, size);
        }

        return ans;
    }
    // Time Complexity: O(n^3)
    // Space Complexity: O(1)

    // Brute Force Approach + sliding window
    public int maxSubarraySize2(int[] arr, long k) {

        int ans = -1;
        int n = arr.length;

        // size
        for(int size = 1; size <= n ; size++) {

            int windowSum = 0;

            for(int i = 0; i < size ; i++)
                windowSum += arr[i];

            int maxSum = windowSum;
            for(int i = size; i < n; i++) {
                windowSum += arr[i];
                windowSum -= arr[i - size];
                maxSum = Math.max(maxSum, windowSum);
            }

            if(maxSum <= k) ans = Math.max(ans, size);
            else break;
        }

        return ans;
    }
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)

    // Binary Search + Sliding Window Approach
    public int maxSubarraySize3(int[] arr, long k) {

        int ans = -1;
        int n = arr.length;

        // size
        int low = 1;
        int high = n;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int windowSum = 0;

            for(int i = 0; i < mid ; i++)
                windowSum += arr[i];

            int maxSum = windowSum;
            for(int i = mid; i < n; i++) {
                windowSum += arr[i];
                windowSum -= arr[i - mid];
                maxSum = Math.max(maxSum, windowSum);
            }

            if(maxSum <= k) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }

        return ans;
    }
    // Time Complexity: O(n * log n)
    // Space Complexity: O(1)

    // Using Sliding Window (most efficient)
    public int maxSubarraySize(int[] arr, long k) {
        int n = arr.length;

        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = n + 1;
        while(end < n) {
            sum += arr[end];
            end++;
            while(sum > k) {
                minLength = Math.min(minLength, end - start);
                sum -= arr[start];
                start++;
            }
        }
        int ans = minLength - 1;
        if(ans == 0) return -1;
        return ans;
    }
    // Time Complexity: O(n)
    // Space Complexity: O(1)

}