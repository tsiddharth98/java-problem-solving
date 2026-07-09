package basic;

import java.util.ArrayList;
import java.util.Arrays;

/*
All Divisors of a Number

Difficulty: Easy

Problem Statement:
Given an integer n, return all the divisors of n in ascending order.

Examples:

Input:
n = 20

Output:
[1, 2, 4, 5, 10, 20]

Explanation:
20 is completely divisible by
1, 2, 4, 5, 10 and 20.

Input:
n = 21191

Output:
[1, 21191]

Explanation:
21191 is a prime number, so it has only
two divisors: 1 and itself.

Expected Time Complexity:
O(√n)

Expected Auxiliary Space:
O(√n)

Constraints:
1 <= n <= 10^9
*/

public class AllDivisorsOfANumber {

    public static void main(String[] args) {

        int[] testCases = {
                1,
                2,
                3,
                4,
                5,
                6,
                8,
                9,
                10,
                12,
                16,
                18,
                20,
                24,
                25,
                30,
                36,
                49,
                64,
                81,
                97,
                100,
                121,
                360,
                1000,
                1024,
                999983,
                1000000000
        };

        int passed = 0;

        AllDivisorsOfANumber solution = new AllDivisorsOfANumber();

        for (int input : testCases) {

            ArrayList<Integer> actual = solution.getDivisors2(input);
            ArrayList<Integer> expected = expectedDivisors(input);

            if (actual.equals(expected)) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Input: %d%nExpected: %s%nActual:   %s%n%n",
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

    public ArrayList<Integer> getDivisors1(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);

                if (i != n / i) {
                    ans.add(n / i);
                }
            }
        }

        ans.sort(null);
        return ans;
    }

    public ArrayList<Integer> getDivisors2(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();
        for(int i=1;i*i<=n;i++) {
            if(n%i==0) {
                ans.add(i);
                if(i!=n/i) large.add(n/i);
            }
        }
        for (int i = large.size() - 1; i >= 0; i--) {
            ans.add(large.get(i));
        }
        return ans;
    }

    // Brute-force method for verifying test cases
    private static ArrayList<Integer> expectedDivisors(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}

