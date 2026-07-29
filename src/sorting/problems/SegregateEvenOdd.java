package sorting.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Segregate Even and Odd Numbers

Difficulty: Basic

Problem Statement:
Given an integer array arr[], rearrange it such that:

1. All even numbers appear first in sorted order.
2. All odd numbers appear next in sorted order.
3. Modify the array in-place.

Examples:

Input:
arr = [12, 34, 45, 9, 8, 90, 3]

Output:
[8, 12, 34, 90, 3, 9, 45]

Explanation:
Even numbers = [12, 34, 8, 90] -> [8, 12, 34, 90]
Odd numbers = [45, 9, 3] -> [3, 9, 45]

Input:
arr = [0, 1, 2, 3, 4]

Output:
[0, 2, 4, 1, 3]

Input:
arr = [10, 22, 4, 6]

Output:
[4, 6, 10, 22]

Constraints:
1 <= arr.length <= 10^6
0 <= arr[i] <= 10^5

Expected Time Complexity:
O(n log n)

Expected Auxiliary Space:
O(n)
*/

public class SegregateEvenOdd {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {
                        new int[]{12, 34, 45, 9, 8, 90, 3},
                        new int[]{8, 12, 34, 90, 3, 9, 45}
                },

                {
                        new int[]{0, 1, 2, 3, 4},
                        new int[]{0, 2, 4, 1, 3}
                },

                {
                        new int[]{10, 22, 4, 6},
                        new int[]{4, 6, 10, 22}
                },

                // Single element
                {
                        new int[]{2},
                        new int[]{2}
                },

                {
                        new int[]{7},
                        new int[]{7}
                },

                // All even
                {
                        new int[]{8, 6, 4, 2},
                        new int[]{2, 4, 6, 8}
                },

                // All odd
                {
                        new int[]{9, 7, 5, 3},
                        new int[]{3, 5, 7, 9}
                },

                // Already segregated
                {
                        new int[]{2, 4, 6, 1, 3, 5},
                        new int[]{2, 4, 6, 1, 3, 5}
                },

                // Reverse order
                {
                        new int[]{9, 7, 5, 4, 2},
                        new int[]{2, 4, 5, 7, 9}
                },

                // Mixed
                {
                        new int[]{5, 2, 9, 4, 7, 6},
                        new int[]{2, 4, 6, 5, 7, 9}
                },

                {
                        new int[]{11, 8, 15, 6, 10, 1},
                        new int[]{6, 8, 10, 1, 11, 15}
                },

                // Duplicates
                {
                        new int[]{2, 2, 1, 1},
                        new int[]{2, 2, 1, 1}
                },

                {
                        new int[]{4, 3, 4, 3, 2, 1},
                        new int[]{2, 4, 4, 1, 3, 3}
                },

                // Zeros
                {
                        new int[]{0, 5, 0, 7, 2},
                        new int[]{0, 0, 2, 5, 7}
                },

                // Larger values
                {
                        new int[]{100000, 99999, 50000, 1},
                        new int[]{50000, 100000, 1, 99999}
                }
        };

        int passed = 0;

        SegregateEvenOdd solution = new SegregateEvenOdd();

        for (Object[] test : testCases) {

            int[] input = ((int[]) test[0]).clone();
            int[] expected = (int[]) test[1];

            solution.segregateEvenOdd(input);

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

    void segregateEvenOdd(int arr[]) {
        // code here
        int n=arr.length;
        ArrayList<Integer> even=new ArrayList<Integer>();
        ArrayList<Integer> odd=new ArrayList<Integer>();

        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                even.add(arr[i]);
            }
            if(arr[i]%2!=0){
                odd.add(arr[i]);
            }

        }
        Collections.sort(even);
        Collections.sort(odd);
        for(int i=0;i<even.size();i++){
            arr[i]=even.get(i);
        }
        int j=even.size();
        for(int i=0;i<odd.size();i++){
            arr[j]=odd.get(i);
            j++;
        }
    }

    // Your Approach (Using Two ArrayLists + Sorting)
    // Time Complexity: O(n log n)
    // - O(n) to separate even and odd numbers.
    // - O(e log e) to sort even numbers.
    // - O(o log o) to sort odd numbers.
    // Since e + o = n, overall complexity is O(n log n).
    //
    // Space Complexity: O(n)
    // - O(n) extra space for the two ArrayLists.
}