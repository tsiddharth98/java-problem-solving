package strings.problems;

/*
13. Roman to Integer

Difficulty: Easy

Problem Statement:
Roman numerals are represented by seven different symbols:

I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000

Roman numerals are usually written from largest to smallest from left to right.

However, there are six subtraction cases:

I before V or X  -> 4, 9
X before L or C  -> 40, 90
C before D or M  -> 400, 900

Given a Roman numeral, convert it to an integer.

Examples:

Input: s = "III"
Output: 3

Input: s = "LVIII"
Output: 58

Input: s = "MCMXCIV"
Output: 1994

Constraints:
1 <= s.length <= 15

s contains only:
'I', 'V', 'X', 'L', 'C', 'D', 'M'

It is guaranteed that s is a valid Roman numeral
in the range [1, 3999].

Expected Time Complexity:
O(n)

Expected Auxiliary Space:
O(1)
*/

public class RomanToInteger {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Single symbols
                {"I", 1},
                {"V", 5},
                {"X", 10},
                {"L", 50},
                {"C", 100},
                {"D", 500},
                {"M", 1000},

                // Problem examples
                {"III", 3},
                {"LVIII", 58},
                {"MCMXCIV", 1994},

                // Subtractive notation
                {"IV", 4},
                {"IX", 9},
                {"XL", 40},
                {"XC", 90},
                {"CD", 400},
                {"CM", 900},

                // Small numbers
                {"II", 2},
                {"VI", 6},
                {"VIII", 8},
                {"XI", 11},
                {"XV", 15},
                {"XIX", 19},
                {"XX", 20},

                // Medium numbers
                {"XLIV", 44},
                {"XLIX", 49},
                {"LIX", 59},
                {"XCIX", 99},
                {"CXLV", 145},
                {"CCXLVI", 246},
                {"CCCXCIX", 399},

                // Large numbers
                {"D", 500},
                {"DC", 600},
                {"CMXCIX", 999},
                {"M", 1000},
                {"MCDXLIV", 1444},
                {"MCMLXXXIV", 1984},
                {"MMXXIV", 2024},
                {"MMMDCCCLXXXVIII", 3888},
                {"MMMCMXCIX", 3999}      // Maximum valid Roman numeral
        };

        int passed = 0;

        RomanToInteger solution = new RomanToInteger();

        for (Object[] test : testCases) {

            String input = (String) test[0];
            int expected = (int) test[1];

            int actual = solution.romanToInt(input);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Roman: %s | Expected: %d | Actual: %d%n",
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

    public int romanToInt(String s) {
        int l = s.length();
        int sum = 0;
        int i = 0;
        while(i < l-1) {
            int n1 = getValue(s.charAt(i));
            int n2 = getValue(s.charAt(i+1));
            if (n1 < n2) sum -= n1;
            else sum += n1;
            i++;
        }
        sum += getValue(s.charAt(i));
        return sum;
    }

    public int getValue(char c) {
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    /*
     * Time Complexity: O(n)
     *
     * Space Complexity: O(1)
     */
}