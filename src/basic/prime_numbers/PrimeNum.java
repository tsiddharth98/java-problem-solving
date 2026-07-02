package basic.prime_numbers;

public class PrimeNum {

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
            boolean actual = isPrime1(input);

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

    private static boolean isPrime1(int n) {
        int count = 0;
        for (int i=1;i<=n;i++) {
            if(n%i == 0) count++;
        }
        return count == 2;
    }
    //T.C.: O(n)

    private static boolean isPrime2(int n) {
        int cnt=0;
        for(int i=1;i*i<=n;i++) {
            if(n%i == 0) {
                cnt++;
                if(i != n/i) cnt++;
            }
        }
        return cnt == 2;
    }
    //T.C.: O( sqrt(n) )
}
