package searching;

import java.util.Arrays;

/*
Problem:
Given a sorted array of integers nums (in non-decreasing order) and a target value,
find the starting and ending position of the target value.

If the target is not found, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Examples:

Input  : nums = [5,7,7,8,8,10], target = 8
Output : [3,4]

Input  : nums = [5,7,7,8,8,10], target = 6
Output : [-1,-1]

Input  : nums = [], target = 0
Output : [-1,-1]

Constraints:
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is sorted in non-decreasing order.
-10^9 <= target <= 10^9

Expected Time Complexity: O(log n)
Expected Auxiliary Space: O(1)

Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {

        class TestCase {
            int[] nums;
            int target;
            int[] expected;

            TestCase(int[] nums, int target, int[] expected) {
                this.nums = nums;
                this.target = target;
                this.expected = expected;
            }
        }

        TestCase[] testCases = {

                // ==========================
                // Sample Test Cases
                // ==========================
                new TestCase(new int[]{5,7,7,8,8,10}, 8, new int[]{3,4}),
                new TestCase(new int[]{5,7,7,8,8,10}, 6, new int[]{-1,-1}),
                new TestCase(new int[]{}, 0, new int[]{-1,-1}),

                // ==========================
                // Single Element
                // ==========================
                new TestCase(new int[]{5}, 5, new int[]{0,0}),
                new TestCase(new int[]{5}, 3, new int[]{-1,-1}),

                // ==========================
                // Two Elements
                // ==========================
                new TestCase(new int[]{2,2}, 2, new int[]{0,1}),
                new TestCase(new int[]{2,3}, 2, new int[]{0,0}),
                new TestCase(new int[]{2,3}, 3, new int[]{1,1}),
                new TestCase(new int[]{2,3}, 4, new int[]{-1,-1}),

                // ==========================
                // Target at Beginning
                // ==========================
                new TestCase(new int[]{2,2,2,3,4,5}, 2, new int[]{0,2}),

                // ==========================
                // Target at End
                // ==========================
                new TestCase(new int[]{1,2,3,4,5,5,5}, 5, new int[]{4,6}),

                // ==========================
                // Target in Middle
                // ==========================
                new TestCase(new int[]{1,2,3,3,3,4,5}, 3, new int[]{2,4}),

                // ==========================
                // All Elements Same
                // ==========================
                new TestCase(new int[]{8,8,8,8,8}, 8, new int[]{0,4}),
                new TestCase(new int[]{8,8,8,8,8}, 5, new int[]{-1,-1}),

                // ==========================
                // No Duplicates
                // ==========================
                new TestCase(new int[]{1,2,3,4,5,6}, 4, new int[]{3,3}),
                new TestCase(new int[]{1,2,3,4,5,6}, 7, new int[]{-1,-1}),

                // ==========================
                // Multiple Duplicates
                // ==========================
                new TestCase(new int[]{1,1,2,2,2,3,4,4,5}, 2, new int[]{2,4}),
                new TestCase(new int[]{1,1,2,2,2,3,4,4,5}, 4, new int[]{6,7}),
                new TestCase(new int[]{1,1,2,2,2,3,4,4,5}, 1, new int[]{0,1}),
                new TestCase(new int[]{1,1,2,2,2,3,4,4,5}, 5, new int[]{8,8}),

                // ==========================
                // Negative Numbers
                // ==========================
                new TestCase(new int[]{-10,-5,-5,-5,-2,0,1}, -5, new int[]{1,3}),
                new TestCase(new int[]{-10,-5,-5,-5,-2,0,1}, -10, new int[]{0,0}),
                new TestCase(new int[]{-10,-5,-5,-5,-2,0,1}, 2, new int[]{-1,-1}),

                // ==========================
                // Zero Values
                // ==========================
                new TestCase(new int[]{0,0,0,1,2,3}, 0, new int[]{0,2}),

                // ==========================
                // Large Values
                // ==========================
                new TestCase(new int[]{-1000000000,0,1000000000}, 1000000000, new int[]{2,2}),
                new TestCase(new int[]{-1000000000,0,1000000000}, -1000000000, new int[]{0,0}),

                // ==========================
                // Hidden/Tricky Cases
                // ==========================
                new TestCase(new int[]{1,2,2,2,2}, 2, new int[]{1,4}),
                new TestCase(new int[]{2,2,2,2,3}, 2, new int[]{0,3}),
                new TestCase(new int[]{2,2,2,2}, 2, new int[]{0,3}),
                new TestCase(new int[]{1,3,5,7,9}, 8, new int[]{-1,-1}),
                new TestCase(new int[]{1,2,3,4,5}, 1, new int[]{0,0}),
                new TestCase(new int[]{1,2,3,4,5}, 5, new int[]{4,4}),
                new TestCase(new int[]{1,1,1,2,3,4}, 1, new int[]{0,2}),
                new TestCase(new int[]{1,2,3,4,5,5,5,5}, 5, new int[]{4,7}),
                new TestCase(new int[]{1,1,1,1,1,1}, 1, new int[]{0,5})
        };

        int passed = 0;

        for (int i = 0; i < testCases.length; i++) {

            int[] actual = searchRange(testCases[i].nums, testCases[i].target);

            if (Arrays.equals(actual, testCases[i].expected)) {
                passed++;
            } else {

                System.out.println("❌ Test Case " + (i + 1) + " Failed");
                System.out.println("Input    : nums = " + Arrays.toString(testCases[i].nums)
                        + ", target = " + testCases[i].target);
                System.out.println("Expected : " + Arrays.toString(testCases[i].expected));
                System.out.println("Actual   : " + Arrays.toString(actual));
                System.out.println();
            }
        }

        System.out.println("✅ Passed " + passed + "/" + testCases.length + " Test Cases");
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};

        int start = 0;
        int end = nums.length-1;

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == target) {
                ans[0] = mid;
                end = mid-1;
            } else if(nums[mid]<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        start = 0;
        end = nums.length-1;

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(nums[mid]==target) {
                ans[1] = mid;
                start=mid+1;
            } else if(nums[mid]<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }
}
