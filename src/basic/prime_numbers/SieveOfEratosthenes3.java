package basic.prime_numbers;

/*
TDKPRIME - Finding the Kth Prime

Problem Statement:
Given multiple queries, answer each query by printing the Kth prime number.

Input:
The first line contains an integer Q (number of queries).

The next Q lines each contain one integer K (1 <= K <= 5,000,000),
where K represents the position of the prime number to find.

Output:
For each query, print the Kth prime number.

Example:

Input:
7
1
10
100
1000
10000
100000
1000000

Output:
2
29
541
7919
104729
1299709
15485863

Constraints:
1 <= Q <= 50000
1 <= K <= 5000000

Hint:
- Use the Sieve of Eratosthenes once.
- Store all prime numbers in an ArrayList.
- Answer each query in O(1) by returning primes.get(k - 1).
*/

import java.util.ArrayList;

public class SieveOfEratosthenes3 {

    static ArrayList<Integer> sieve = new ArrayList<>();

    public static void main(String[] args) {
        sieve();
        int[][] testCases = {
                // {K, Expected Kth Prime}

                {1, 2},
                {2, 3},
                {3, 5},
                {4, 7},
                {5, 11},
                {6, 13},
                {7, 17},
                {8, 19},
                {9, 23},
                {10, 29},

                {20, 71},
                {25, 97},
                {50, 229},
                {100, 541},
                {200, 1223},
                {500, 3571},
                {1000, 7919},
                {5000, 48611},
                {10000, 104729},
                {25000, 287117},
                {50000, 611953},
                {100000, 1299709},
                {200000, 2750159},
                {500000, 7368787},
                {1000000, 15485863}
        };

        int passed = 0;

        // Call your preprocessing method once.
        // buildSieve();

        for (int[] test : testCases) {

            int k = test[0];
            int expected = test[1];

            // Replace this with your implementation.
            int actual = kthPrime(k);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> K: %d | Expected: %d | Actual: %d%n",
                        k,
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed, testCases.length);
    }

    private static int kthPrime(int k) {
        return sieve.get(k-1);
    }

    private static void sieve() {
        // code here
        int n = 100000000;
        boolean[] arr = new boolean[n+1];

        for(int i=2;i<=n;i++) {
            arr[i] = true;
        }

        for(int i=2;i*i<=n;i++) {
            if(arr[i]) {
                for(int j=i*i;j<=n;j+=i) {
                    arr[j] = false;
                }
            }
        }

        //like 5th prime is in 11th pos
        //so to get max limit just iterate till size
        int limit = 5*1000000;
        int cnt = 0;
        int size=1;
        for(int i=2;;i++) {
            if(arr[i]) {
                cnt++;
            }
            if(cnt == limit) {
                size=i;
                break;
            }
        }

        for(int i=2;i<=size;i++) {
            if(arr[i]) {
                sieve.add(i);
            }
        }
    }
    //T.C.: O( nLog(Log(n))) )
}