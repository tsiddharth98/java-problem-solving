package strings.problems;

/*
Multiply Two Strings

Difficulty: Medium

Problem Statement:
Given two numbers as strings s1 and s2, calculate and return
their product as a string.

Note:
- The numbers can be negative.
- The numbers may contain leading zeros.
- You are NOT allowed to use any built-in function or convert
  the strings directly to integers.
- You don't need to specify '+' for positive numbers.

Examples:

Input:
s1 = "0033"
s2 = "2"

Output:
"66"

Explanation:
33 × 2 = 66

Input:
s1 = "11"
s2 = "23"

Output:
"253"

Explanation:
11 × 23 = 253

Input:
s1 = "123"
s2 = "0"

Output:
"0"

Explanation:
Anything multiplied by 0 is 0.

Constraints:
1 <= s1.length <= 10^3
1 <= s2.length <= 10^3

Expected Time Complexity:
O(n * m)

Expected Auxiliary Space:
O(n + m)
*/

public class MultiplyTwoStrings {

    public static void main(String[] args) {

        String[][] testCases = {
                // {s1, s2, expected}

                {"0", "0", "0"},
                {"0", "123", "0"},
                {"123", "0", "0"},
                {"1", "1", "1"},
                {"2", "3", "6"},
                {"9", "9", "81"},

                {"11", "23", "253"},
                {"12", "12", "144"},
                {"99", "99", "9801"},
                {"123", "456", "56088"},
                {"999", "999", "998001"},
                {"100", "100", "10000"},
                {"500", "20", "10000"},

                {"0033", "2", "66"},
                {"000123", "0456", "56088"},
                {"0010", "0010", "100"},
                {"0000", "999", "0"},

                {"-5", "3", "-15"},
                {"5", "-3", "-15"},
                {"-5", "-3", "15"},
                {"123", "456", "56088"},
                {"-123", "456", "-56088"},
                {"123", "-456", "-56088"},
                {"-123", "-456", "56088"},

                {"99999", "99999", "9999800001"},
                {"12345", "67890", "838102050"},
                {"100000", "100000", "10000000000"},
                {"2147483647", "2", "4294967294"},
                {"999999999", "999999999", "999999998000000001"}
        };

        int passed = 0;

        MultiplyTwoStrings solution = new MultiplyTwoStrings();

        for (String[] test : testCases) {

            String s1 = test[0];
            String s2 = test[1];
            String expected = test[2];

            String actual = solution.multiplyStrings(s1, s2);

            if (actual.equals(expected)) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> s1: \"%s\", s2: \"%s\" | Expected: \"%s\" | Actual: \"%s\"%n",
                        s1,
                        s2,
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    public String multiplyStrings(String s1, String s2) {

        // Handle sign
        boolean negative = false;

        if (s1.charAt(0) == '-') {
            negative = !negative;
            s1 = s1.substring(1);
        }

        if (s2.charAt(0) == '-') {
            negative = !negative;
            s2 = s2.substring(1);
        }

        // Remove leading zeros
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);

        // If either number becomes 0
        if (s1.equals("0") || s2.equals("0"))
            return "0";

        int n = s1.length();
        int m = s2.length();

        int[] result = new int[n + m];

        // Multiply from right to left
        for (int i = n - 1; i >= 0; i--) {
            int num1 = s1.charAt(i) - '0';

            for (int j = m - 1; j >= 0; j--) {
                int num2 = s2.charAt(j) - '0';

                int product = num1 * num2;

                int p2 = i + j + 1; // Current digit
                int p1 = i + j;     // Carry position

                int sum = product + result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        // Skip leading zeros
        while (i < result.length && result[i] == 0)
            i++;

        if (negative)
            ans.append('-');

        while (i < result.length)
            ans.append(result[i++]);

        return ans.toString();
    }
    // Time Complexity: O(n * m)
    // Space Complexity: O(n + m)

    private String removeLeadingZeros(String s) {
        int i = 0;

        while (i < s.length() - 1 && s.charAt(i) == '0')
            i++;

        return s.substring(i);
    }
}