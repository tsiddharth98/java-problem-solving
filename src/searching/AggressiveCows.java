package searching;

import java.util.Arrays;

/*
Aggressive Cows

Difficulty: Medium

Problem Statement:
Given an integer array arr[] representing the positions of stalls.
All stall positions are distinct.

There are k aggressive cows.

Place the cows in the stalls such that the minimum distance
between any two cows is maximized.

Return the maximum possible minimum distance.

Examples:

Input:
arr = [1, 2, 4, 8, 9]
k = 3

Output:
3

Explanation:
Place cows at positions 1, 4 and 8.
Minimum distance = min(3, 4) = 3.

Input:
arr = [10, 1, 2, 7, 5]
k = 3

Output:
4

Explanation:
After sorting:
[1, 2, 5, 7, 10]

Place cows at:
1, 5 and 10

Minimum distance = 4.

Constraints:
2 <= arr.length <= 10^6
0 <= arr[i] <= 10^8
2 <= k <= arr.length

Expected Time Complexity:
O(n log m)

Expected Auxiliary Space:
O(1)

where m = max(arr) - min(arr)
*/

public class AggressiveCows {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{1, 2, 4, 8, 9}, 3, 3},
                {new int[]{10, 1, 2, 7, 5}, 3, 4},

                // Smallest valid input
                {new int[]{1, 2}, 2, 1},

                // Consecutive positions
                {new int[]{1, 2, 3, 4, 5}, 2, 4},
                {new int[]{1, 2, 3, 4, 5}, 3, 2},
                {new int[]{1, 2, 3, 4, 5}, 4, 1},
                {new int[]{1, 2, 3, 4, 5}, 5, 1},

                // Unsorted input
                {new int[]{8, 1, 4, 2, 9}, 3, 3},

                // Evenly spaced stalls
                {new int[]{5, 10, 15, 20, 25}, 3, 10},
                {new int[]{5, 10, 15, 20, 25}, 5, 5},

                // Large gaps
                {new int[]{1, 100, 200, 300}, 2, 299},
                {new int[]{1, 100, 200, 300}, 3, 100},
                {new int[]{1, 100, 200, 300}, 4, 99},

                // Mixed spacing
                {new int[]{1, 3, 7, 9, 13}, 3, 6},
                {new int[]{2, 5, 11, 17, 21}, 3, 9},

                // Large coordinates
                {new int[]{0, 100000000}, 2, 100000000},
                {new int[]{0, 50000000, 100000000}, 2, 100000000},
                {new int[]{0, 50000000, 100000000}, 3, 50000000},

                // k = n
                {new int[]{2, 6, 12, 19}, 4, 4},

                // Random verified cases
                {new int[]{4, 7, 9, 15, 20}, 3, 5},
                {new int[]{3, 6, 14, 19, 25}, 3, 11},
                {new int[]{1, 4, 8, 12, 17, 20}, 4, 4}
        };

        int passed = 0;

        AggressiveCows solution = new AggressiveCows();

        for (Object[] test : testCases) {

            int[] stalls = (int[]) test[0];
            int k = (Integer) test[1];
            int expected = (Integer) test[2];

            int actual = solution.aggressiveCows(stalls.clone(), k);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Stalls: %s | k = %d | Expected: %d | Actual: %d%n",
                        Arrays.toString(stalls),
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

    //brute force
    public int aggressiveCows1(int[] stalls, int k) {
        // sorting the array to ensure stalls in sequence
        Arrays.sort(stalls);
        int res = 0;
        // Minimum and maximum possible minimum distance
        // between two stalls
        int minDist = 1;
        int maxDist = stalls[stalls.length - 1] - stalls[0];
        // Iterating through all possible distances
        for(int i = minDist; i <= maxDist; i++) {
            // If we can place k cows with the
            // current distance i, update the res
            if (check(stalls, k, i)) res = i;
        }

        return res;
    }
    // Time Complexity: O(n*(max(stalls) - min(stalls)))
    // Space Complexity: O(1)

    public int aggressiveCows(int[] stalls, int k) {
        // sorting the array to ensure stalls in sequence
        Arrays.sort(stalls);
        int res = 0;
        // Minimum and maximum possible minimum distance
        // Search Space for Binary Search
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        while(low <= high) {
            int mid = low + (high - low) / 2;
            // If the mid distance is possible, update
            // the result and search for larger distance
            if(check(stalls, k, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }

    // function to check if we can place k cows
    // with at least dist distance apart
    public boolean check(int[] stalls, int k, int dist) {
        // Place first cow at 0th index
        int cnt = 1;
        int prev = stalls[0];
        for(int i = 1; i < stalls.length; i++) {
            // If the current stall is at least dist away
            // from the previous one place the cow here
            if(stalls[i] - prev >= dist) {
                prev = stalls[i];
                cnt++;
            }
        }
        // Return true if we are able to place all 'k' cows
        return cnt >= k;
    }

    // Time Complexity: O(n log(maxPosition - minPosition))
    // Space Complexity: O(1)
}
