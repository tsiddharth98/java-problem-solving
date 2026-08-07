package arrays.problems;

import java.util.Arrays;

/*
769. Max Chunks To Make Sorted

Difficulty: Medium

Problem Statement:
You are given an integer array arr of length n that represents a permutation
of the integers in the range [0, n - 1].

Split the array into the maximum number of chunks such that after sorting
each chunk individually and concatenating them, the entire array becomes sorted.

Return the maximum number of chunks.

Examples:

Input:
arr = [4,3,2,1,0]

Output:
1

Explanation:
The whole array must be one chunk.

Input:
arr = [1,0,2,3,4]

Output:
4

Explanation:
One optimal partition:
[1,0] [2] [3] [4]

Constraints:
1 <= arr.length <= 10
0 <= arr[i] < n
All elements are unique.

Expected Time Complexity:
O(n)

Expected Auxiliary Space:
O(1)
*/

public class MaxChunksToMakeSorted {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{4,3,2,1,0}, 1},
                {new int[]{1,0,2,3,4}, 4},

                // Single element
                {new int[]{0}, 1},

                // Already sorted
                {new int[]{0,1}, 2},
                {new int[]{0,1,2}, 3},
                {new int[]{0,1,2,3,4}, 5},

                // Completely reversed
                {new int[]{2,1,0}, 1},
                {new int[]{3,2,1,0}, 1},

                // Mixed permutations
                {new int[]{2,0,1}, 1},
                {new int[]{1,2,0}, 1},
                {new int[]{0,2,1}, 2},
                {new int[]{2,1,3,4,0}, 1},
                {new int[]{1,0,3,2,4}, 3},
                {new int[]{0,2,1,4,3}, 3},
                {new int[]{1,0,2,4,3}, 3},
                {new int[]{2,0,1,3,4}, 3},
                {new int[]{3,0,1,2,4}, 2},
                {new int[]{0,3,2,1,4}, 3},
                {new int[]{1,2,3,4,0}, 1},

                // Maximum constraint example (n = 10)
                {new int[]{9,8,7,6,5,4,3,2,1,0}, 1},
                {new int[]{0,1,2,3,4,5,6,7,8,9}, 10},
                {new int[]{1,0,2,4,3,5,7,6,8,9}, 7}
        };

        int passed = 0;

        MaxChunksToMakeSorted solution = new MaxChunksToMakeSorted();

        for (Object[] test : testCases) {

            int[] arr = (int[]) test[0];
            int expected = (int) test[1];

            int actual = solution.maxChunksToSorted(arr.clone());

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

    //method 1
    /*public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        int chunks = 0;
        for(int i = 0; i < n; i++) {
            int preMax = i > 0 ? prefixMax[i - 1] : -1;
            prefixMax[i] = preMax < arr[i] ? arr[i] : preMax;
        }
        for(int i = n - 1; i >= 0; i--) {
            int sufMin = i < n - 1 ? suffixMin[i + 1] : n + 1;
            suffixMin[i] = sufMin > arr[i] ? arr[i] : sufMin;
        }
        for(int i = 0; i < n; i++) {
            int preMax = i > 0 ? prefixMax[i - 1] : -1;
            int sufMin = suffixMin[i];
            if(preMax < sufMin) chunks++;
        }
        return chunks;
    }*/
    /*
     * Time Complexity: O(n)
     *
     * Space Complexity: O(n)
     */

//    //method 2
//    public int maxChunksToSorted(int[] arr) {
//        int n = arr.length;
//        int indexSum = 0;
//        int valueSum = 0;
//        int chunks = 0;
//        for(int i = 0; i < n; i++) {
//            indexSum += i;
//            valueSum += arr[i];
//            if(indexSum == valueSum) chunks++;
//        }
//
//        return chunks;
//    }

    /*
     * Time Complexity: O(n)
     *
     * Space Complexity: O(1)
     */

    //method 3
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int maxValue = 0;
        int chunks = 0;
        for(int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            if(maxValue == i) chunks++;
        }
        return chunks;
    }
    /*
     * Time Complexity: O(n)
     *
     * Space Complexity: O(1)
     */
}