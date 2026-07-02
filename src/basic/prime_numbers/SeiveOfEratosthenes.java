package basic.prime_numbers;

public class SeiveOfEratosthenes {

    private static final boolean[] sieve = new boolean[1000001];
    private static final int n = 1000000;

    private static void buildSieve() {
        for(int i=2;i<=n;i++) {
            sieve[i] = true;
        }
        for(int i=2;i*i<=n;i++) {
            if(sieve[i]) {
                for(int j=i*i;j<=n;j+=i){
                    sieve[j] = false;
                }
            }
        }
    }
    //T.C.: O( nLog(Log(n))) )

    public static void main(String[] args) {

        buildSieve();   // Call your sieve generation method first

        int[][] testCases = {
                // {number, expected (1 = prime, 0 = not prime)}

                {-10, 0},
                {-1, 0},
                {0, 0},
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
                {12, 0},
                {13, 1},
                {14, 0},
                {15, 0},
                {16, 0},
                {17, 1},
                {18, 0},
                {19, 1},
                {20, 0},

                {23, 1},
                {25, 0},
                {29, 1},
                {31, 1},
                {35, 0},
                {37, 1},
                {41, 1},
                {49, 0},
                {53, 1},
                {97, 1},
                {99, 0},
                {100, 0},

                {101, 1},
                {121, 0},     // 11²
                {127, 1},
                {169, 0},     // 13²
                {289, 0},     // 17²
                {997, 1},
                {999, 0},
                {1000, 0},

                {99991, 1},
                {99999, 0},
                {100000, 0},
                {999983, 1},      // Large prime
                {1000000, 0}      // Max limit (assuming sieve size = 1_000_001)
        };

        int passed = 0;

        for (int[] test : testCases) {

            int input = test[0];
            boolean expected = test[1] == 1;

            boolean actual = input >= 0 && input < sieve.length && sieve[input];

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
}
