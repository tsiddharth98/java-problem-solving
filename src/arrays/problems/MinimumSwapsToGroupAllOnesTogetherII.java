package arrays.problems;

import java.util.Arrays;

/*
2134. Minimum Swaps to Group All 1's Together II

Difficulty: Medium

Problem Statement:
A swap is defined as taking two distinct positions in an array and swapping
their values.

A circular array is defined as an array where the first and last elements
are considered adjacent.

Given a binary circular array nums, return the minimum number of swaps
required to group all the 1's together at any location.

Examples:

Input:
nums = [0,1,0,1,1,0,0]

Output:
1

Explanation:
Swap one 0 with one 1 to obtain:
[0,0,1,1,1,0,0]

---------------------------------------------------

Input:
nums = [0,1,1,1,0,0,1,1,0]

Output:
2

---------------------------------------------------

Input:
nums = [1,1,0,0,1]

Output:
0

Explanation:
Using the circular property, all 1's are already together.

Constraints:
1 <= nums.length <= 10^5
nums[i] is either 0 or 1

Expected Time Complexity:
O(n)

Expected Auxiliary Space:
O(1)
*/

public class MinimumSwapsToGroupAllOnesTogetherII {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{0,1,0,1,1,0,0}, 1},
                {new int[]{0,1,1,1,0,0,1,1,0}, 2},
                {new int[]{1,1,0,0,1}, 0},

                // Single element
                {new int[]{0}, 0},
                {new int[]{1}, 0},

                // All zeros
                {new int[]{0,0,0,0}, 0},

                // All ones
                {new int[]{1,1,1,1}, 0},

                // Already grouped
                {new int[]{1,1,1,0,0}, 0},
                {new int[]{0,0,1,1,1}, 0},

                // Circular grouping
                {new int[]{1,0,0,1}, 0},
                {new int[]{1,0,0,0,1}, 0},
                {new int[]{1,0,1,0,1}, 1},

                // One swap
                {new int[]{1,0,1,1,0}, 1},
                {new int[]{0,1,1,0,1}, 1},
                {new int[]{0,1,0,1}, 1},

                // Multiple swaps
                {new int[]{1,0,1,0,1,0,1}, 1},
                {new int[]{0,1,0,1,0,1,0,1}, 2},
                {new int[]{1,0,0,1,0,0,1}, 1},

                // Edge cases
                {new int[]{1,0}, 0},
                {new int[]{0,1}, 0},
                {new int[]{1,0,1,0,0,1,0,1,1}, 1},
                {new int[]{0,0,1,0,1,0,1,0,0}, 1}
        };

        int passed = 0;

        MinimumSwapsToGroupAllOnesTogetherII solution =
                new MinimumSwapsToGroupAllOnesTogetherII();

        for (Object[] test : testCases) {

            int[] nums = (int[]) test[0];
            int expected = (Integer) test[1];

            int actual = solution.minSwaps(nums.clone());

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

    public int minSwaps(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        int k = 0;
        for(int i = 0; i < n; i++) {
            k += nums[i];
        }
        if(k == 0 || k == n) return 0;

        for(int i = 0; i < k; i++) {
            if(nums[i] == 0) zeros++;
        }
        int swaps = zeros;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) zeros--;
            if(nums[(i + k) % n] == 0) zeros++;
            swaps = Math.min(swaps, zeros);
        }

        return swaps;
    }

    /*
     * Time Complexity: O(n)
     *
     * Space Complexity: O(1)
     */
}
