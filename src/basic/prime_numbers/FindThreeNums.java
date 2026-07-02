package basic.prime_numbers;

/*
find 3 nums so that a*b*c=n
and a!=b!=c!=1
constraints: n <= 10^9
 */
public class FindThreeNums {

    public static void main(String[] args) {

        int[][] testCases = {
                // {n, expected (1 = YES, 0 = NO)}

                {2, 0},
                {3, 0},
                {4, 0},
                {5, 0},
                {6, 0},       // 2 * 3
                {7, 0},
                {8, 0},       // 2 * 2 * 2
                {9, 0},
                {10, 0},
                {12, 0},      // 2 * 2 * 3
                {16, 0},      // 2^4
                {18, 0},      // 2 * 3 * 3
                {20, 0},      // 2 * 2 * 5
                {24, 1},      // 2 * 3 * 4
                {27, 0},      // 3^3
                {30, 1},      // 2 * 3 * 5
                {32, 0},      // 2^5
                {36, 1},      // 2 * 3 * 6
                {40, 1},      // 2 * 4 * 5
                {42, 1},      // 2 * 3 * 7
                {45, 0},      // 3 * 3 * 5
                {48, 1},      // 2 * 3 * 8
                {49, 0},      // 7^2
                {50, 0},      // 2 * 5 * 5
                {54, 1},      // 2 * 3 * 9
                {60, 1},      // 2 * 3 * 10
                {64, 1},      // 2 * 4 * 8
                {72, 1},      // 2 * 3 * 12
                {81, 0},      // 3^4
                {90, 1},      // 2 * 3 * 15
                {96, 1},      // 2 * 3 * 16
                {97, 0},      // prime
                {100, 1},     // 2 * 5 * 10
                {108, 1},     // 2 * 3 * 18
                {125, 0},     // 5^3
                {128, 1},     // 2 * 4 * 16
                {210, 1},     // 2 * 3 * 35
                {216, 1},     // 2 * 3 * 36
                {343, 0},     // 7^3
                {512, 1},     // 2 * 4 * 64
                {729, 1},     // 3 * 9 * 27
                {1000, 1},    // 2 * 4 * 125
                {1024, 1},    // 2 * 4 * 128
                {999983, 0},  // large prime
                {1000000000, 1}
        };

        int passed = 0;

        for (int[] test : testCases) {
            int input = test[0];
            boolean expected = test[1] == 1;
            boolean actual = canFindThreeNumbers(input);

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

    private static boolean canFindThreeNumbers(int n) {
        int a=1,b=1,c=1;
        for(int i=2;i*i<=n;i++) {
            if(n%i == 0) {
                a = i;
                n = n / i;
                break;
            }
        }
        if (a == 1) return false;
        for(int i=a+1;i*i<=n;i++) {
            if(n%i == 0) {
                b = i;
                break;
            }
        }
        if (b == 1) return false;
        c = n / b;
        return c != 1 && b != c &&  a != c;
    }
    //T.C.: O( sqrt(n) )
}
