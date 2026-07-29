package searching;

import java.util.Arrays;

/*
Kth Smallest Element in an Array using Constant Extra Space
link: https://www.geeksforgeeks.org/dsa/kth-smallest-element-in-the-array-using-constant-space-when-array-cant-be-modified/
(Array Cannot Be Modified)

Problem Statement:
Given an array arr[] of size N having distinct elements and an integer K,
find the Kth smallest element in the array.

Constraints:
- The array cannot be modified.
- Only constant extra space can be used.

Examples:

Input:
arr = {7, 10, 4, 3, 20, 15}
K = 3

Output:
7

Explanation:
Sorted array:
{3, 4, 7, 10, 15, 20}

The 3rd smallest element is 7.

Input:
arr = {12, 3, 5, 7, 19}
K = 2

Output:
5

Explanation:
Sorted array:
{3, 5, 7, 12, 19}

The 2nd smallest element is 5.

Expected Time Complexity:
O(N * K)

Expected Auxiliary Space:
O(1)

Note:
The array must NOT be modified.
*/

public class KthSmallestConstantSpace {

    public static void main(String[] args) {

        Object[][] testCases = {
                // {array, k, expected}

                {new int[]{7, 10, 4, 3, 20, 15}, 1, 3},
                {new int[]{7, 10, 4, 3, 20, 15}, 2, 4},
                {new int[]{7, 10, 4, 3, 20, 15}, 3, 7},
                {new int[]{7, 10, 4, 3, 20, 15}, 4, 10},
                {new int[]{7, 10, 4, 3, 20, 15}, 5, 15},
                {new int[]{7, 10, 4, 3, 20, 15}, 6, 20},

                {new int[]{12, 3, 5, 7, 19}, 1, 3},
                {new int[]{12, 3, 5, 7, 19}, 2, 5},
                {new int[]{12, 3, 5, 7, 19}, 3, 7},
                {new int[]{12, 3, 5, 7, 19}, 4, 12},
                {new int[]{12, 3, 5, 7, 19}, 5, 19},

                {new int[]{1}, 1, 1},
                {new int[]{2, 1}, 1, 1},
                {new int[]{2, 1}, 2, 2},

                {new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 5, 5},
                {new int[]{100, 50, 25, 75, 10}, 3, 50},

                {new int[]{-5, -10, 0, 20, 15}, 1, -10},
                {new int[]{-5, -10, 0, 20, 15}, 2, -5},
                {new int[]{-5, -10, 0, 20, 15}, 3, 0},
                {new int[]{-5, -10, 0, 20, 15}, 4, 15},
                {new int[]{-5, -10, 0, 20, 15}, 5, 20},

                {new int[]{1000, 500, 300, 700, 200, 900, 100}, 4, 500}
        };

        int passed = 0;

        KthSmallestConstantSpace solution = new KthSmallestConstantSpace();

        for (Object[] test : testCases) {

            int[] input = (int[]) test[0];
            int k = (Integer) test[1];
            int expected = (Integer) test[2];

            // Copy only for verifying that the solution doesn't modify the array.
            int[] original = input.clone();

            int actual = solution.kthSmallest(input, k);

            boolean arrayModified = !Arrays.equals(original, input);

            if (actual == expected && !arrayModified) {
                passed++;
            } else {

                if (arrayModified) {
                    System.out.printf(
                            "❌ Failed -> Array was modified! Input: %s%n",
                            Arrays.toString(original)
                    );
                } else {
                    System.out.printf(
                            "❌ Failed -> Array: %s | K: %d | Expected: %d | Actual: %d%n",
                            Arrays.toString(input),
                            k,
                            expected,
                            actual
                    );
                }
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    public int kthSmallest(int[] arr, int k) {

        int low = Arrays.stream(arr).min().getAsInt();
        int high = Arrays.stream(arr).max().getAsInt();

        while(low < high) {
            int mid = low + (high - low) / 2;

            int count = 0;
            for(int x : arr) {
                if(x <= mid) count++;
            }

            if (count >= k) high = mid;
            else low = mid + 1;
        }

        return low;
    }

//    public int kthSmallest(int[] arr, int k) {
//
//        int low = Arrays.stream(arr).min().getAsInt();
//        int high = Arrays.stream(arr).max().getAsInt();
//
//        while(low <= high) {
//            int mid = low + (high - low) / 2;
//
//            int countless = 0;
//            int countequal = 0;
//            for(int i = 0; i < arr.length; i++) {
//                if(arr[i] < mid) countless++;
//                else if(arr[i] == mid) countequal++;
//            }
//
//            if(countless < k && countless + countequal == k) return mid;
//            else if (countless >= k) high = mid - 1;
//            else low = mid + 1;
//        }
//
//        return -1;
//    }

    // Time Complexity: O(N * Log(max - min))
    // Space Complexity: O(1)

    /*
    * arr[] = {7, 10, 4, 3, 20, 15}, K = 3
    *
    * if sorted -> 3 4 7 8 10 15 20
     * low = 3
    * high =20
    *
    * mid = 11
    *
    * cl = 4 ce = 0
    *
    *
    * low = 3
    * high = mid -1 = 10
    * mid = 6
    *
    * cl = 2 ce = 0
    *
    *
    * low = mid + 1 = 7
    * high = 10
    * mid = 8
    *
    * cl = 3 ce = 0
    *
    * low = 7
    * high mid - 1 = 7
    * mid = 7
    *
    * cl = 2 ce = 1
    *
    *
    * ex 2:
    * arr[] = {7, 10, 7, 7, 20, 15}, K = 3
    * if sorted -> 5 7 7 8 10 15 20
    *
    * cl = 1 ce = 2
    *
    * if(countless < k && countless + countequal == k) return mid;
            else if (countless >= k) high = mid - 1;
            else low = mid + 1;
     * */
}