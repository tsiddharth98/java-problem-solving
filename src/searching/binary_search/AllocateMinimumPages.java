package searching.binary_search;

import java.util.Arrays;

/*
Allocate Minimum Pages

Difficulty: Medium

Problem Statement:
Given an array arr[] where arr[i] represents the number of pages in the i-th book,
and an integer k representing the number of students.

Allocate books such that:

1. Each student gets at least one book.
2. Each student gets a contiguous sequence of books.
3. Every book is allocated exactly once.
4. No book is shared.

Return the minimum possible value of the maximum number of pages assigned
to any student.

If allocation is impossible (k > number of books), return -1.

Examples:

Input:
arr = [12, 34, 67, 90]
k = 2

Output:
113

Explanation:
Possible allocations:

[12] | [34,67,90]      -> 191
[12,34] | [67,90]      -> 157
[12,34,67] | [90]      -> 113

Minimum possible maximum = 113.

Input:
arr = [15,17,20]
k = 5

Output:
-1

Constraints:
1 <= arr.length <= 10^6
1 <= arr[i], k <= 10^4

Expected Time Complexity:
O(n log(sum(arr)))

Expected Auxiliary Space:
O(1)
*/

public class AllocateMinimumPages {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {new int[]{12, 34, 67, 90}, 2, 113},
                {new int[]{15, 17, 20}, 5, -1},

                // Single book
                {new int[]{100}, 1, 100},
                {new int[]{100}, 2, -1},

                // One student
                {new int[]{10, 20, 30, 40}, 1, 100},

                // One book per student
                {new int[]{10, 20, 30, 40}, 4, 40},

                // Equal pages
                {new int[]{10, 10, 10, 10}, 2, 20},
                {new int[]{10, 10, 10, 10}, 3, 20},

                // Increasing pages
                {new int[]{5, 10, 15, 20, 25}, 2, 45},
                {new int[]{5, 10, 15, 20, 25}, 3, 30},

                // Decreasing pages
                {new int[]{50, 40, 30, 20, 10}, 2, 90},
                {new int[]{50, 40, 30, 20, 10}, 3, 60},

                // Classic examples
                {new int[]{7, 2, 5, 10, 8}, 2, 18},
                {new int[]{1, 2, 3, 4, 5}, 2, 9},
                {new int[]{1, 2, 3, 4, 5}, 3, 6},

                // Large first book
                {new int[]{100, 1, 1, 1}, 2, 100},

                // Large last book
                {new int[]{1, 1, 1, 100}, 2, 100},

                // Mixed values
                {new int[]{10, 20, 30, 40, 50}, 2, 90},
                {new int[]{10, 20, 30, 40, 50}, 3, 60},

                // Two books
                {new int[]{8, 15}, 2, 15},
                {new int[]{8, 15}, 1, 23},

                // Impossible
                {new int[]{5, 10, 15}, 4, -1}
        };

        int passed = 0;

        AllocateMinimumPages solution = new AllocateMinimumPages();

        for (Object[] test : testCases) {

            int[] arr = ((int[]) test[0]).clone();
            int k = (Integer) test[1];
            int expected = (Integer) test[2];

            int actual = solution.findPages(arr, k);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Books: %s | Students: %d | Expected: %d | Actual: %d%n",
                        Arrays.toString((int[]) test[0]),
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

    // Helper method to check if a given pageLimit allows us to allocate books to <= k students
    public boolean isFeasible(int[] arr, int k, long pageLimit) {
        int studentRequired = 1;
        long currentPageSum = 0;

        for(int i = 0; i < arr.length; i++) {
            // If adding the current book exceeds pageLimit,
            // hand it over to the next student
            if(currentPageSum + arr[i] > pageLimit) {
                studentRequired++;
                currentPageSum = arr[i];
            } else {
                currentPageSum += arr[i];
            }
        }
        // If books can be allocated using <= k students, this page limit works!
        return studentRequired <= k;
    }

    // Linear Search on Answer
    // Time Complexity: O(n * (sum(arr) - max(arr)))
    // Space Complexity: O(1)

    /*public int findPages(int[] arr, int k) {
        // Edge Case: If students are more than total books, allocation is impossible
        if(k > arr.length) return -1;

        int minPageLimit = arr[0];// Maximum pages in a single book
        int maxPageLimit = 0;// Total sum of all pages

        for(int pages: arr) {
            minPageLimit = Math.max(minPageLimit, pages);
            maxPageLimit += pages;
        }

        // LINEAR SEARCH: Try every possible page limit from minPageLimit to maxPageLimit
        for(long limit = minPageLimit; limit <= maxPageLimit; limit++) {
            // The VERY FIRST page limit that works is our minimum possible maximum pages!
            if(isFeasible(arr, k, limit))
                return (int) limit;
        }

        return -1;
    }*/

    // Binary Search on Answer
    // Time Complexity: O(n * log(sum(arr) - max(arr)))
    // Space Complexity: O(1)

    public int findPages(int[] arr, int k) {
        // Edge Case: If students are more than total books, allocation is impossible
        if(k > arr.length) return -1;

        int minPageLimit = arr[0];// Maximum pages in a single book
        long maxPageLimit = 0;// Total sum of all pages

        for(int pages: arr) {
            minPageLimit = Math.max(minPageLimit, pages);
            maxPageLimit += pages;
        }

        // Binary SEARCH: Try every possible page limit from minPageLimit to maxPageLimit
        long low = minPageLimit;
        long high = maxPageLimit;

        while(low < high) {
            long mid = low + (high - low) / 2;

            if(isFeasible(arr, k, mid)) high = mid;
            else low = mid +1;
        }

        return (int) low;
    }

    /*
    public static int findPages(int[] arr, int k) {
        // Edge Case: If students are more than total books, allocation is impossible
        if (k > arr.length) return -1;

        long low = 0;  // max pages in a single book
        long high = 0; // sum of all pages

        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        long ans = -1;

        // BINARY SEARCH RANGE: [max(arr), sum(arr)]
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isFeasible(arr, k, mid)) {
                ans = mid;        // mid works! Record it as a candidate answer
                high = mid - 1;   // Try searching for a smaller valid limit on the left
            } else {
                low = mid + 1;    // mid is too small, search for a larger limit on the right
            }
        }

        return (int) ans;
    }
     */


}