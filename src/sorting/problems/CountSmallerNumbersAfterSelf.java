package sorting.problems;

import java.util.*;

/*
315. Count of Smaller Numbers After Self

Difficulty: Hard

Problem Statement:
Given an integer array nums, return an integer array counts where
counts[i] is the number of smaller elements to the right of nums[i].

Examples:

Input:
nums = [5,2,6,1]

Output:
[2,1,1,0]

Explanation:
5 -> 2 smaller numbers (2,1)
2 -> 1 smaller number (1)
6 -> 1 smaller number (1)
1 -> 0

Input:
nums = [-1]

Output:
[0]

Input:
nums = [-1,-1]

Output:
[0,0]

Constraints:
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

Expected Time Complexity:
O(n log n)

Expected Auxiliary Space:
O(n)
*/

public class CountSmallerNumbersAfterSelf {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{5, 2, 6, 1}, Arrays.asList(2, 1, 1, 0)},
                {new int[]{-1}, Arrays.asList(0)},
                {new int[]{-1, -1}, Arrays.asList(0, 0)},

                // Single element
                {new int[]{10}, Arrays.asList(0)},

                // Increasing
                {new int[]{1, 2, 3, 4, 5}, Arrays.asList(0, 0, 0, 0, 0)},

                // Decreasing
                {new int[]{5, 4, 3, 2, 1}, Arrays.asList(4, 3, 2, 1, 0)},

                // All equal
                {new int[]{7, 7, 7, 7}, Arrays.asList(0, 0, 0, 0)},

                // Duplicates
                {new int[]{2, 1, 2, 1}, Arrays.asList(2, 0, 1, 0)},
                {new int[]{3, 2, 2, 1}, Arrays.asList(3, 1, 1, 0)},
                {new int[]{1, 2, 1, 2}, Arrays.asList(0, 1, 0, 0)},

                // Negative numbers
                {new int[]{-2, -3, -1}, Arrays.asList(1, 0, 0)},
                {new int[]{-5, -1, -3}, Arrays.asList(0, 1, 0)},

                // Mixed values
                {new int[]{10, 5, 8, 3}, Arrays.asList(3, 1, 1, 0)},
                {new int[]{4, 9, 5, 1, 7}, Arrays.asList(1, 3, 1, 0, 0)},
                {new int[]{8, 1, 2, 2, 3}, Arrays.asList(4, 0, 0, 0, 0)},

                // Edge values
                {new int[]{10000, -10000}, Arrays.asList(1, 0)},
                {new int[]{-10000, 10000}, Arrays.asList(0, 0)}
        };

        int passed = 0;

        CountSmallerNumbersAfterSelf solution = new CountSmallerNumbersAfterSelf();

        for (Object[] test : testCases) {

            int[] nums = ((int[]) test[0]).clone();
            List<Integer> expected = (List<Integer>) test[1];

            List<Integer> actual = solution.countSmaller(nums);

            if (actual.equals(expected)) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Array: %s | Expected: %s | Actual: %s%n",
                        Arrays.toString((int[]) test[0]),
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

    private class Element{
        int val;
        int index;

        public Element(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<Integer>();
        int[] counts = new int[n];
        Element[] elements = new Element[n];

        for(int i = 0; i < n; i++) {
            elements[i] = new Element(nums[i], i);
        }

        mergeSort(elements, 0, n - 1, counts);

        for(int count: counts) {
            result.add(count);
        }

        return result;
    }

    public void mergeSort(Element[] elements, int left, int right, int[] counts) {
        if(left >= right) return;
        int mid = left + (right - left) / 2;

        mergeSort(elements, left, mid, counts);
        mergeSort(elements, mid + 1, right, counts);

        merge(elements, left, mid, right, counts);
    }

    public void merge(Element[] elements, int left, int mid, int right, int[] counts) {
        int n = right - left + 1;
        int i = left;
        int j = mid + 1;
        Element[] temp = new Element[n];
        int k = 0;
        while(i <= mid && j <= right) {
            if(elements[i].val > elements[j].val &&
                    elements[i].index < elements[j].index) {
                temp[k] = elements[i];
                counts[elements[i].index] += right - j + 1;
                i++;
            } else {
                temp[k] = elements[j];
                j++;
            }
            k++;
        }
        while(i <= mid) {
            temp[k] = elements[i];
            i++;
            k++;
        }
        while(j <= right) {
            temp[k] = elements[j];
            j++;
            k++;
        }
        k = 0;
        i = left;
        while(k < n) {
            elements[i] = temp[k];
            i++;
            k++;
        }
    }

    // Merge Sort Based Solution
    //
    // Time Complexity: O(n log n)
    //
    // Space Complexity: O(n)
}