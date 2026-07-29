package searching.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
719. Find K-th Smallest Pair Distance

Difficulty: Hard

Problem Statement:
The distance of a pair of integers a and b is defined as the absolute
difference between a and b.

Given an integer array nums and an integer k, return the kth smallest
distance among all the pairs nums[i] and nums[j] where
0 <= i < j < nums.length.

Examples:

Input:
nums = [1,3,1]
k = 1

Output:
0

Explanation:
Pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2

Sorted distances:
[0,2,2]

1st smallest = 0

Input:
nums = [1,1,1]
k = 2

Output:
0

Input:
nums = [1,6,1]
k = 3

Output:
5

Constraints:
2 <= nums.length <= 10^4
0 <= nums[i] <= 10^6
1 <= k <= n * (n - 1) / 2
*/

public class KthSmallestPairDistance {

    public static void main(String[] args) {

        Object[][] testCases = {

                // LeetCode examples
                {new int[]{1, 3, 1}, 1, 0},
                {new int[]{1, 1, 1}, 2, 0},
                {new int[]{1, 6, 1}, 3, 5},

                // Two elements
                {new int[]{1, 2}, 1, 1},
                {new int[]{5, 5}, 1, 0},

                // Three elements
                {new int[]{1, 2, 3}, 1, 1},
                {new int[]{1, 2, 3}, 2, 1},
                {new int[]{1, 2, 3}, 3, 2},

                // Duplicates
                {new int[]{1, 1, 2}, 1, 0},
                {new int[]{1, 1, 2}, 2, 1},
                {new int[]{1, 1, 2}, 3, 1},

                {new int[]{1, 2, 2}, 1, 0},
                {new int[]{1, 2, 2}, 2, 1},
                {new int[]{1, 2, 2}, 3, 1},

                // All same
                {new int[]{7, 7, 7, 7}, 1, 0},
                {new int[]{7, 7, 7, 7}, 6, 0},

                // Increasing numbers
                {new int[]{1, 4, 7, 10}, 1, 3},
                {new int[]{1, 4, 7, 10}, 3, 3},
                {new int[]{1, 4, 7, 10}, 4, 6},
                {new int[]{1, 4, 7, 10}, 6, 9},

                // Unsorted input
                {new int[]{8, 1, 5}, 1, 3},
                {new int[]{8, 1, 5}, 2, 4},
                {new int[]{8, 1, 5}, 3, 7},

                // Mixed duplicates
                {new int[]{4, 4, 8, 10}, 1, 0},
                {new int[]{4, 4, 8, 10}, 2, 2},
                {new int[]{4, 4, 8, 10}, 4, 4},
                {new int[]{4, 4, 8, 10}, 6, 6},

                // Large values
                {new int[]{0, 1000000}, 1, 1000000},
                {new int[]{0, 500000, 1000000}, 2, 500000},

                // Negative not allowed by constraints, so minimum values
                {new int[]{0, 0, 1}, 1, 0},
                {new int[]{0, 0, 1}, 2, 1},
                {new int[]{0, 0, 1}, 3, 1}
        };

        int passed = 0;

        KthSmallestPairDistance solution = new KthSmallestPairDistance();

        for (Object[] test : testCases) {

            int[] nums = (int[]) test[0];
            int k = (Integer) test[1];
            int expected = (Integer) test[2];

            int actual = solution.smallestDistancePair(nums.clone(), k);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> nums: %s | k = %d | Expected: %d | Actual: %d%n",
                        Arrays.toString(nums),
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

    public int smallestDistancePair1(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer>diff = new ArrayList<>();
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int d = Math.abs(nums[i] - nums[j]);
                diff.add(d);
            }
        }

        Collections.sort(diff);
        return diff.get(k - 1);
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int low = 0;
        int high = nums[n - 1] - nums[0];

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(countPairsWithDistanceLessThanOrEqual(nums, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int countPairsWithDistanceLessThanOrEqual(int[] nums, int targetDistance) {
        int count = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            while(Math.abs(nums[right] - nums[left]) > targetDistance) {
                left++;
            }
            count += right - left;
        }

        return count;
    }

    // Binary Search + Sliding Window Approach
    // Time Complexity: O(n log n + n log W)
    // where W = max(nums) - min(nums)
    //
    // Space Complexity: O(1)
}