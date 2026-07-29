package sorting.problems;

import java.util.*;

/*
Sort Elements by Decreasing Frequency

Difficulty: Medium

Problem Statement:
Given an array of integers arr[], sort the array according to the frequency
of elements.

Rules:
1. Elements with higher frequency should come first.
2. If two elements have the same frequency, the smaller element comes first.

Examples:

Input:
arr = [5, 5, 4, 6, 4]

Output:
[4, 4, 5, 5, 6]

Explanation:
Frequency:
4 -> 2
5 -> 2
6 -> 1

Since 4 and 5 have the same frequency, the smaller element (4) comes first.

Input:
arr = [9, 9, 9, 2, 5]

Output:
[9, 9, 9, 2, 5]

Explanation:
Frequency:
9 -> 3
2 -> 1
5 -> 1

9 has the highest frequency.
2 and 5 have the same frequency, so the smaller one comes first.

Constraints:
1 <= arr.length <= 10^5
1 <= arr[i] <= 10^5

Expected Time Complexity:
O(n log n)

Expected Auxiliary Space:
O(n)
*/

public class SortByFrequency {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {
                        new int[]{5, 5, 4, 6, 4},
                        new int[]{4, 4, 5, 5, 6}
                },

                {
                        new int[]{9, 9, 9, 2, 5},
                        new int[]{9, 9, 9, 2, 5}
                },

                // Single element
                {
                        new int[]{7},
                        new int[]{7}
                },

                // All unique
                {
                        new int[]{5, 3, 1, 2, 4},
                        new int[]{1, 2, 3, 4, 5}
                },

                // All same
                {
                        new int[]{8, 8, 8, 8},
                        new int[]{8, 8, 8, 8}
                },

                // Two frequencies
                {
                        new int[]{1, 1, 2, 2, 3},
                        new int[]{1, 1, 2, 2, 3}
                },

                {
                        new int[]{3, 3, 2, 2, 1},
                        new int[]{2, 2, 3, 3, 1}
                },

                // Mixed frequencies
                {
                        new int[]{4, 6, 2, 4, 3, 2, 2},
                        new int[]{2, 2, 2, 4, 4, 3, 6}
                },

                {
                        new int[]{10, 20, 10, 30, 20, 10},
                        new int[]{10, 10, 10, 20, 20, 30}
                },

                {
                        new int[]{7, 5, 5, 7, 3, 3, 3},
                        new int[]{3, 3, 3, 5, 5, 7, 7}
                },

                // Same frequency -> smaller first
                {
                        new int[]{8, 4, 6, 2},
                        new int[]{2, 4, 6, 8}
                },

                {
                        new int[]{9, 8, 8, 9, 7, 7},
                        new int[]{7, 7, 8, 8, 9, 9}
                },

                // Larger frequency differences
                {
                        new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4},
                        new int[]{4, 4, 4, 4, 3, 3, 3, 2, 2, 1}
                },

                // Multiple duplicates
                {
                        new int[]{5, 5, 5, 2, 2, 1, 1, 1},
                        new int[]{1, 1, 1, 5, 5, 5, 2, 2}
                },

                // Maximum value check
                {
                        new int[]{100000, 1, 100000, 2, 2},
                        new int[]{2, 2, 100000, 100000, 1}
                }
        };

        int passed = 0;

        SortByFrequency solution = new SortByFrequency();

        for (Object[] test : testCases) {

            int[] input = ((int[]) test[0]).clone();
            int[] expected = (int[]) test[1];

            ArrayList<Integer> actual = solution.sortByFreq(input);

            int[] actualArray = actual.stream().mapToInt(Integer::intValue).toArray();

            if (Arrays.equals(actualArray, expected)) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Input: %s | Expected: %s | Actual: %s%n",
                        Arrays.toString((int[]) test[0]),
                        Arrays.toString(expected),
                        Arrays.toString(actualArray)
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    //TC: O(n * log n) Time and O(n) Space
    public ArrayList<Integer> sortByFreq(int arr[]) {
        int n = arr.length;

        //sort the array
        Arrays.sort(arr);

        //creating 2-d array to store freq and value of each element
        ArrayList<ArrayList<Integer>> freq = new ArrayList<>();

        //making comparator to sort the array
        // Comparator<ArrayList<Integer>> comp = new Comparator<ArrayList<Integer>>() {
        //     public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        //         if(a.get(0).equals(b.get(0)))
        //             return a.get(1) - b.get(1);
        //         return b.get(0) - a.get(0);
        //     }
        // };

        Comparator<ArrayList<Integer>> comp2 = (a, b) -> {
            if(a.get(0).equals(b.get(0)))
                return Integer.compare(a.get(1), b.get(1));
            return Integer.compare(b.get(0), a.get(0));
        };

        for(int i = 0; i < n; i++) {

            int cnt = 1;
            while(i < n - 1 && arr[i] == arr[i + 1]) {
                cnt++;
                i++;
            }

            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(cnt);
            temp.add(arr[i]);
            freq.add(temp);
        }

        // sort the frequency array
        Collections.sort(freq, comp2);

        // to store the answer
        ArrayList<Integer> ans = new ArrayList<>();

        // push the elements in the answer array
        for(int i = 0; i < freq.size(); i++) {
            int count = freq.get(i).get(0);
            int value = freq.get(i).get(1);
            for(int j = 0; j < count; j++) {
                ans.add(value);
            }
        }

        return ans;
    }

    // HashMap + Sorting Approach
    // Time Complexity: O(n log n)
    // - O(n) to count frequencies.
    // - O(n log n) to sort according to frequency and value.
    //
    // Space Complexity: O(n)
    // - HashMap + output list.
}
