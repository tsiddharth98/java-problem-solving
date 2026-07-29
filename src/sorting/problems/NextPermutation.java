package sorting.problems;

import java.util.Arrays;

/*
31. Next Permutation

Difficulty: Medium

Problem Statement:
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

The next permutation of an array is the next lexicographically greater permutation.
If such arrangement is not possible, rearrange it as the lowest possible order
(i.e., sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Examples:

Input:
nums = [1,2,3]

Output:
[1,3,2]

Input:
nums = [3,2,1]

Output:
[1,2,3]

Input:
nums = [1,1,5]

Output:
[1,5,1]

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 100

Expected Time Complexity:
O(n)

Expected Auxiliary Space:
O(1)
*/

public class NextPermutation {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{1, 2, 3}, new int[]{1, 3, 2}},
                {new int[]{3, 2, 1}, new int[]{1, 2, 3}},
                {new int[]{1, 1, 5}, new int[]{1, 5, 1}},

                // Single element
                {new int[]{1}, new int[]{1}},

                // Two elements
                {new int[]{1, 2}, new int[]{2, 1}},
                {new int[]{2, 1}, new int[]{1, 2}},

                // Already highest permutation
                {new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}},

                // Pivot in middle
                {new int[]{1, 3, 2}, new int[]{2, 1, 3}},
                {new int[]{2, 1, 3}, new int[]{2, 3, 1}},
                {new int[]{2, 3, 1}, new int[]{3, 1, 2}},
                {new int[]{1, 5, 1}, new int[]{5, 1, 1}},

                // Duplicates
                {new int[]{1, 2, 2}, new int[]{2, 1, 2}},
                {new int[]{2, 2, 1}, new int[]{1, 2, 2}},
                {new int[]{1, 5, 5}, new int[]{5, 1, 5}},
                {new int[]{2, 3, 3}, new int[]{3, 2, 3}},
                {new int[]{3, 3, 2}, new int[]{2, 3, 3}},

                // Larger examples
                {new int[]{1, 2, 3, 6, 5, 4}, new int[]{1, 2, 4, 3, 5, 6}},
                {new int[]{1, 4, 3, 2}, new int[]{2, 1, 3, 4}},
                {new int[]{2, 4, 3, 1}, new int[]{3, 1, 2, 4}},
                {new int[]{1, 3, 5, 4, 2}, new int[]{1, 4, 2, 3, 5}},

                // All equal
                {new int[]{7, 7, 7}, new int[]{7, 7, 7}},

                // Zeros
                {new int[]{0, 1, 0}, new int[]{1, 0, 0}},
                {new int[]{0, 0, 1}, new int[]{0, 1, 0}}
        };

        int passed = 0;

        NextPermutation solution = new NextPermutation();

        for (Object[] test : testCases) {

            int[] input = ((int[]) test[0]).clone();
            int[] expected = (int[]) test[1];

            solution.nextPermutation(input);

            if (Arrays.equals(input, expected)) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Input: %s | Expected: %s | Actual: %s%n",
                        Arrays.toString((int[]) test[0]),
                        Arrays.toString(expected),
                        Arrays.toString(input)
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;

        //finding the pivot
        for(int i = n - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                idx = i - 1;
                break;
            }
        }

        //finding next bigger than pivot from last and swapping it
        if(idx >= 0) {
            for(int i = n - 1; i > 0; i--) {
                if(nums[i] > nums[idx]) {
                    swap(nums, i, idx);
                    break;
                }
            }
        }

        //reverse the array from idx + 1 till last
        int j = idx + 1;
        for(int i = n - 1; i > j; i--) {
            swap(nums, i, j);
            j++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Optimal Approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
}