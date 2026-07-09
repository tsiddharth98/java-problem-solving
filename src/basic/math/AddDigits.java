package basic.math;

/*
258. Add Digits

Difficulty: Easy

Problem Statement:
Given an integer num, repeatedly add all its digits until the result
has only one digit, and return it.

Examples:

Input:
num = 38

Output:
2

Explanation:
38 -> 3 + 8 = 11
11 -> 1 + 1 = 2

Since 2 has only one digit, return 2.

Input:
num = 0

Output:
0

Constraints:
0 <= num <= 2^31 - 1

Follow-up:
Can you solve it in O(1) time without using loops or recursion?
*/

public class AddDigits {

    public static void main(String[] args) {

        int[][] testCases = {
                // {input, expectedOutput}

                {0, 0},
                {1, 1},
                {5, 5},
                {9, 9},

                {10, 1},
                {11, 2},
                {12, 3},
                {15, 6},
                {18, 9},
                {19, 1},

                {20, 2},
                {27, 9},
                {28, 1},
                {29, 2},
                {38, 2},
                {45, 9},
                {56, 2},
                {99, 9},

                {100, 1},
                {101, 2},
                {123, 6},
                {456, 6},
                {789, 6},
                {999, 9},

                {1000, 1},
                {12345, 6},
                {99999, 9},
                {123456, 3},
                {987654, 3},
                {999999, 9},

                {1000000000, 1},
                {2147483647, 1} // Integer.MAX_VALUE
        };

        int passed = 0;

        AddDigits solution = new AddDigits();

        for (int[] test : testCases) {

            int input = test[0];
            int expected = test[1];

            int actual = solution.addDigits2(input);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Input: %d | Expected: %d | Actual: %d%n",
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

    public int addDigits1(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
    //T.C. : O(n)

    public int addDigits2(int num) {
        if(num==0) return 0;
        return 1+(num-1)%9;
    }
    //T.C. : O(1)
}