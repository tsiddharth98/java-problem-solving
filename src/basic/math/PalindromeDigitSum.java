package basic.maths;

/*
Palindrome Digit Sum

Difficulty: Basic

Problem Statement:
Given a number n, return true if the digit sum (sum of all digits)
of n is a palindrome number; otherwise return false.

A palindrome number is a number that remains the same when reversed.

Examples:

Input:
n = 56

Output:
true

Explanation:
Digit sum = 5 + 6 = 11
11 is a palindrome.

Input:
n = 98

Output:
false

Explanation:
Digit sum = 9 + 8 = 17
17 is not a palindrome.

Constraints:
1 <= n <= 10^9

Expected Time Complexity:
O(log n)

Expected Auxiliary Space:
O(1)
*/

public class PalindromeDigitSum {

    public static void main(String[] args) {

        int[][] testCases = {
                // {input, expectedOutput (1 = true, 0 = false)}

                {1, 1},          // Sum = 1
                {5, 1},          // Sum = 5
                {9, 1},          // Sum = 9

                {10, 1},         // Sum = 1
                {11, 1},         // Sum = 2
                {12, 1},         // Sum = 3
                {19, 1},         // Sum = 10 -> palindrome? No
                {20, 1},         // Sum = 2
                {29, 1},         // Sum = 11
                {38, 1},         // Sum = 11
                {47, 1},         // Sum = 11
                {56, 1},         // Sum = 11
                {65, 1},         // Sum = 11
                {74, 1},         // Sum = 11
                {83, 1},         // Sum = 11
                {92, 1},         // Sum = 11

                {98, 0},         // Sum = 17
                {99, 0},         // Sum = 18

                {123, 1},        // Sum = 6
                {456, 0},        // Sum = 15
                {789, 0},        // Sum = 24

                {999, 0},        // Sum = 27
                {909, 0},        // Sum = 18
                {1111, 1},       // Sum = 4
                {12321, 1},      // Sum = 9
                {99999, 0},      // Sum = 45
                {123456, 0},     // Sum = 21
                {999999, 0},     // Sum = 54

                {1000000000, 1}, // Sum = 1
                {2147483647, 0}  // Sum = 46
        };

        int passed = 0;

        PalindromeDigitSum solution = new PalindromeDigitSum();

        for (int[] test : testCases) {

            int input = test[0];
            boolean expected = test[1] == 1;

            boolean actual = solution.isDigitSumPalindrome(input);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Input: %d | Expected: %b | Actual: %b%n",
                        input,
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    boolean isDigitSumPalindrome(int n) {
        int sum = 0;

        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            n /= 10;
        }

        n = sum;
        int reversed = 0;

        while (n > 0) {
            int rem = n % 10;
            reversed = reversed * 10 + rem;
            n /= 10;
        }

        return reversed == sum;
    }
    // Time Complexity: O(log10(n))
    // Space Complexity: O(1)
    /*
        Runs once for every digit of n.
        If n has d digits, it runs d times.
        Number of digits in n = log₁₀(n) + 1
     */
}