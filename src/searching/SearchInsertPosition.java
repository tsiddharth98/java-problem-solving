package searching;


import java.util.Arrays;

/*
Problem:
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be inserted while maintaining the sorted order.

You must write an algorithm with O(log n) runtime complexity.

Examples:

Input  : nums = [1,3,5,6], target = 5
Output : 2

Input  : nums = [1,3,5,6], target = 2
Output : 1

Input  : nums = [1,3,5,6], target = 7
Output : 4

Constraints:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums contains distinct values sorted in ascending order.
-10^4 <= target <= 10^4

Expected Time Complexity: O(log n)
Expected Auxiliary Space: O(1)

Platform: LeetCode
Difficulty: Easy
Link: https://leetcode.com/problems/search-insert-position/
*/
public class SearchInsertPosition {

    public static void main(String[] args) {

        class TestCase {
            int[] nums;
            int target;
            int expected;

            TestCase(int[] nums, int target, int expected) {
                this.nums = nums;
                this.target = target;
                this.expected = expected;
            }
        }

        TestCase[] testCases = {

                // ==========================
                // Sample Test Cases
                // ==========================
                new TestCase(new int[]{1,3,5,6}, 5, 2),
                new TestCase(new int[]{1,3,5,6}, 2, 1),
                new TestCase(new int[]{1,3,5,6}, 7, 4),

                // ==========================
                // Single Element
                // ==========================
                new TestCase(new int[]{5}, 5, 0),
                new TestCase(new int[]{5}, 3, 0),
                new TestCase(new int[]{5}, 8, 1),

                // ==========================
                // Insert at Beginning
                // ==========================
                new TestCase(new int[]{2,4,6,8}, 1, 0),
                new TestCase(new int[]{10,20,30}, -5, 0),

                // ==========================
                // Insert at End
                // ==========================
                new TestCase(new int[]{2,4,6,8}, 10, 4),
                new TestCase(new int[]{1,2,3}, 100, 3),

                // ==========================
                // Insert in Middle
                // ==========================
                new TestCase(new int[]{1,3,5,7}, 4, 2),
                new TestCase(new int[]{10,20,30,40}, 35, 3),
                new TestCase(new int[]{10,20,30,40}, 25, 2),

                // ==========================
                // Existing Elements
                // ==========================
                new TestCase(new int[]{1,2,3,4,5}, 1, 0),
                new TestCase(new int[]{1,2,3,4,5}, 3, 2),
                new TestCase(new int[]{1,2,3,4,5}, 5, 4),

                // ==========================
                // Negative Numbers
                // ==========================
                new TestCase(new int[]{-10,-5,0,5,10}, -10, 0),
                new TestCase(new int[]{-10,-5,0,5,10}, -7, 1),
                new TestCase(new int[]{-10,-5,0,5,10}, 2, 3),
                new TestCase(new int[]{-10,-5,0,5,10}, 15, 5),

                // ==========================
                // Boundary Values
                // ==========================
                new TestCase(new int[]{-10000,0,10000}, -10000, 0),
                new TestCase(new int[]{-10000,0,10000}, 10000, 2),
                new TestCase(new int[]{-10000,0,10000}, -9999, 1),
                new TestCase(new int[]{-10000,0,10000}, 9999, 2),

                // ==========================
                // Hidden / Tricky Cases
                // ==========================
                new TestCase(new int[]{1,2}, 0, 0),
                new TestCase(new int[]{1,2}, 1, 0),
                new TestCase(new int[]{1,2}, 2, 1),
                new TestCase(new int[]{1,2}, 3, 2),

                new TestCase(new int[]{1,3}, 2, 1),
                new TestCase(new int[]{3,5,7,9,11}, 8, 3),
                new TestCase(new int[]{2,4,6,8,10}, 9, 4),
                new TestCase(new int[]{2,4,6,8,10}, 5, 2),
                new TestCase(new int[]{2,4,6,8,10}, 6, 2)
        };

        int passed = 0;

        for (int i = 0; i < testCases.length; i++) {

            int actual = searchInsert(testCases[i].nums, testCases[i].target);

            if (actual == testCases[i].expected) {
                passed++;
            } else {

                System.out.println("❌ Test Case " + (i + 1) + " Failed");
                System.out.println("Input    : nums = " + Arrays.toString(testCases[i].nums)
                        + ", target = " + testCases[i].target);
                System.out.println("Expected : " + testCases[i].expected);
                System.out.println("Actual   : " + actual);
                System.out.println();
            }
        }

        System.out.println("✅ Passed " + passed + "/" + testCases.length + " Test Cases");
    }

    private static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        int asInt = Arrays.stream(nums).min().getAsInt();

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) start = mid+1;
            else end = mid-1;
        }

        return start;
    }
}
