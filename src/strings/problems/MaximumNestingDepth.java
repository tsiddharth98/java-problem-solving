package strings.problems;

/*
1614. Maximum Nesting Depth of the Parentheses

Difficulty: Easy

Problem Statement:
Given a valid parentheses string s, return the nesting depth of s.

The nesting depth is the maximum number of nested parentheses.

Examples:

Input:
s = "(1+(2*3)+((8)/4))+1"

Output:
3

Explanation:
Digit 8 is inside 3 nested parentheses.

Input:
s = "(1)+((2))+(((3)))"

Output:
3

Input:
s = "()(())((()()))"

Output:
3

Constraints:
1 <= s.length <= 100

s consists of:
- digits (0-9)
- '+', '-', '*', '/'
- '(' and ')'

It is guaranteed that s is a valid parentheses string (VPS).

Expected Time Complexity:
O(n)

Expected Auxiliary Space:
O(1)
*/

public class MaximumNestingDepth {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {"(1+(2*3)+((8)/4))+1", 3},
                {"(1)+((2))+(((3)))", 3},
                {"()(())((()()))", 3},

                // No nesting
                {"()", 1},
                {"()()", 1},
                {"(1+2)", 1},

                // Increasing nesting
                {"((1))", 2},
                {"(((1)))", 3},
                {"((((1))))", 4},
                {"(((((1)))))", 5},

                // Mixed expressions
                {"((2+3)*(4+(5)))", 3},
                {"((1+(2))+3)", 3},
                {"((8)/(4))", 2},
                {"((1+2)*(3+(4*5)))", 3},

                // Nested empty parentheses
                {"((()))", 3},
                {"(()())", 2},
                {"((())())", 3},

                // Complex expressions
                {"((1+(2*(3+(4)))))", 5},
                {"((1)+((2))+((3+(4))))", 4},

                // Minimum length
                {"()", 1}
        };

        int passed = 0;

        MaximumNestingDepth solution = new MaximumNestingDepth();

        for (Object[] test : testCases) {

            String s = (String) test[0];
            int expected = (int) test[1];

            int actual = solution.maxDepth(s);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Input: \"%s\" | Expected: %d | Actual: %d%n",
                        s,
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    public int maxDepth(String s) {
        int count = 0;
        int maxCount = 0;
        for(char ch: s.toCharArray()) {
            if( ch == '(') {
                count++;
                maxCount = Math.max(maxCount, count);
            } else if(ch == ')') {
                count--;
            }
        }
        return maxCount;
    }

    // Count current depth while traversing the string.
    // Update maximum depth whenever '(' is encountered.
    //
    // Time Complexity: O(n)
    //
    // Space Complexity: O(1)
}