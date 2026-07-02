package basic;

/*
Problem:
Given a number n, determine whether it is a prime number or not.

Note:
A prime number is a number greater than 1 that has exactly two positive divisors: 1 and itself.

Examples:

Input  : n = 7
Output : true

Input  : n = 25
Output : false

Input  : n = 1
Output : false

Constraints:
1 <= n <= 10^9

Expected Time Complexity: O(sqrt(n))
Expected Auxiliary Space: O(1)

Platform: GFG
Difficulty: Easy
Link: https://www.geeksforgeeks.org/problems/prime-number2314/1
*/
public class PrimeNumbers {

    public static void main(String[] args) {

        int[][] testCases = {
                // {input, expectedOutput (1 = true, 0 = false)}
                {1, 0},
                {2, 1},
                {3, 1},
                {4, 0},
                {5, 1},
                {6, 0},
                {7, 1},
                {8, 0},
                {9, 0},
                {10, 0},
                {11, 1},
                {13, 1},
                {17, 1},
                {19, 1},
                {23, 1},
                {25, 0},
                {29, 1},
                {49, 0},
                {97, 1},
                {121, 0},
                {999983, 1},
                {1000000000, 0}
        };

        int passed = 0;

        for (int[] test : testCases) {
            int input = test[0];
            boolean expected = test[1] == 1;
            boolean actual = isPrime(input);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Input: %d | Expected: %b | Actual: %b%n",
                        input, expected, actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n", passed, testCases.length);
    }

    static boolean isPrime(int n) {
        // code here
        int count=0;
        for(int i=1;i*i<=n;i++) {
            if(n%i == 0) {
                count++;
                if(n/i != i) count++;
            }
        }
        if(count==2) return true;
        else return false;
    }
}
