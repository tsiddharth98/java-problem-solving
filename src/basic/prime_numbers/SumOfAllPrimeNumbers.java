package basic.prime_numbers;

/*
Sum of all Prime Numbers between 1 and n

Difficulty: Easy

Problem Statement:
Given a positive integer n, compute and return the sum of all prime
numbers between 1 and n (inclusive).

A prime number is a natural number greater than 1 that has
no positive divisors other than 1 and itself.

Examples:

Input:
n = 5

Output:
10

Explanation:
Prime numbers between 1 and 5 are:
2, 3, 5
Their sum = 2 + 3 + 5 = 10.

Input:
n = 10

Output:
17

Explanation:
Prime numbers between 1 and 10 are:
2, 3, 5, 7
Their sum = 2 + 3 + 5 + 7 = 17.

Constraints:
1 <= n <= 10^5

Expected Time Complexity:
O(n log log n)

Expected Auxiliary Space:
O(n)
*/

public class SumOfAllPrimeNumbers {

    public static void main(String[] args) {

        int[][] testCases = {
                // {input, expectedOutput}

                {1, 0},
                {2, 2},
                {3, 5},
                {4, 5},
                {5, 10},
                {6, 10},
                {7, 17},
                {8, 17},
                {9, 17},
                {10, 17},

                {11, 28},
                {12, 28},
                {13, 41},
                {15, 41},
                {20, 77},
                {25, 100},
                {30, 129},
                {50, 328},
                {100, 1060},
                {200, 4227},

                {500, 21536},
                {1000, 76127},
                {5000, 1548136},
                {10000, 5736396},
                {100000, 454396537}
        };

        int passed = 0;

        SumOfAllPrimeNumbers solution = new SumOfAllPrimeNumbers();

        for (int[] test : testCases) {

            int input = test[0];
            int expected = test[1];

            int actual = solution.prime_Sum(input);

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

    public int prime_Sum(int n) {
        int[] primes = new int[n + 1];
        int sum = 0;
        int i = 2;

        for (i = 2; i * i <= n; i++) {
            if (primes[i] == 0) {
                sum += i;
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = 1;
                }
            }
        }

        for (; i <= n; i++) {
            if (primes[i] == 0) {
                sum += i;
            }
        }

        return sum;
    }
    // Time Complexity: O(n log log n)
    // Space Complexity: O(n)
}