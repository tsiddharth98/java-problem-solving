package basic.prime_numbers;

/*
Minimum Prime Factor Queries

Problem Statement:
You are given multiple queries. Each query contains an integer n.

For every query, determine how many numbers in the range [1, 10^6]
have their minimum (smallest) prime factor equal to n.

For example:

Minimum Prime Factor:
2  -> 2, 4, 6, 8, 10, 12, ...
3  -> 3, 9, 15, 21, 27, ...
5  -> 5, 25, 35, 55, ...
7  -> 7, 49, 77, ...

Input:
The first line contains an integer Q (number of queries).

Each of the next Q lines contains one integer n.

Output:
For each query, print the count of numbers in the range [1, 10^6]
whose minimum prime factor is exactly n.

Constraints:
1 <= Q <= 10^5
1 <= n <= 10^6

Hint:
- Precompute the smallest prime factor (SPF) for every number from 1 to 10^6.
- Build a frequency array where:
      freq[p] = count of numbers whose smallest prime factor is p.
- Each query can then be answered in O(1).
*/

public class MinimumPrimeFactorQueries {

    public static void main(String[] args) {
        buildSieve();
        int[][] testCases = {
                // {query, expectedAnswer}

                {1, 0},          // 1 has no prime factor
                {2, 500000},
                {3, 166667},
                {4, 0},          // not prime
                {5, 66667},
                {6, 0},
                {7, 38095},
                {8, 0},
                {9, 0},
                {10, 0},

                {11, 20779},
                {13, 15984},
                {17, 11282},
                {19, 9503},
                {23, 7428},
                {29, 5648},
                {31, 5270},
                {37, 4323},
                {41, 3876},
                {43, 3696},

                {97, 1637},
                {101, 1569},
                {997, 169},
                {1009, 167},

                {999983, 1},     // prime > 500000, only itself
                {999979, 1},     // another large prime

                {1000000, 0}     // composite
        };

        int passed = 0;

        // buildSPF();
        // buildFrequency();

        for (int[] test : testCases) {

            int query = test[0];
            int expected = test[1];

            // Replace with your implementation
            int actual = countNumbersWithMinPrimeFactor(query);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Query: %d | Expected: %d | Actual: %d%n",
                        query,
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed, testCases.length);
    }

    private static int countNumbersWithMinPrimeFactor1(int n) {
        int cnt=0;
        for(int i=n;i<=1000000;i++) {
            if(i%n==0) cnt++;
        }
        return cnt;
    }

    private static final int[] sieve = new int[1000001];
    private static final int N = 1000000;

    private static void buildSieve() {
        for(int i=2;i<=N;i++) {
            sieve[i] = 1;
        }
        for(int i=2;i*i<=N;i++) {
            if(sieve[i]==1) {;
                for(int j=i*i;j<=N;j+=i){
                    if(sieve[j]==1) {
                        sieve[j] = 0;
                        sieve[i] = sieve[i] + 1;
                    }
                }
            }
        }
    }
    //T.C.: O( nLog(Log(n))) )

    private static int countNumbersWithMinPrimeFactor(int n) {
        if(n<=1) return 0;
        return sieve[n] == 1 ? 0 : sieve[n];
//        return 0;
    }
}