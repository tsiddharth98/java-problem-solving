package basic.prime_numbers;

public class PrintSumOfFactors {

//    public static void main(String[] args) {
//
//        int[][] testCases = {
//                // {input, expectedSumOfPrimeFactors}
//
//                {1, 0},
//                {2, 2},
//                {3, 3},
//                {4, 4},        // 2 + 2
//                {5, 5},
//                {6, 5},        // 2 + 3
//                {7, 7},
//                {8, 6},        // 2 + 2 + 2
//                {9, 6},        // 3 + 3
//                {10, 7},       // 2 + 5
//                {11, 11},
//                {12, 7},       // 2 + 2 + 3
//                {13, 13},
//                {14, 9},       // 2 + 7
//                {15, 8},       // 3 + 5
//                {16, 8},       // 2 + 2 + 2 + 2
//                {18, 8},       // 2 + 3 + 3
//                {20, 9},       // 2 + 2 + 5
//                {24, 9},       // 2 + 2 + 2 + 3
//                {25, 10},      // 5 + 5
//                {27, 9},       // 3 + 3 + 3
//                {30, 10},      // 2 + 3 + 5
//                {36, 10},      // 2 + 2 + 3 + 3
//                {49, 14},      // 7 + 7
//                {50, 12},      // 2 + 5 + 5
//                {64, 12},      // six 2's
//                {81, 12},      // four 3's
//                {100, 14},     // 2 + 2 + 5 + 5
//                {121, 22},     // 11 + 11
//                {169, 26},     // 13 + 13
//                {225, 16},     // 3 + 3 + 5 + 5
//                {9973, 9973}   // prime number
//        };
//
//        int passed = 0;
//
//        for (int[] test : testCases) {
//            int input = test[0];
//            int expected = test[1];
//            int actual = sumOfPrimeFactors(input);
//
//            if (actual == expected) {
//                passed++;
//            } else {
//                System.out.printf(
//                        "❌ Failed -> Input: %d | Expected: %d | Actual: %d%n",
//                        input, expected, actual
//                );
//            }
//        }
//
//        System.out.printf("%nPassed %d/%d test cases.%n", passed, testCases.length);
//    }

    public static void main(String[] args) {

        int[][] testCases = {
                // {input, expectedSumOfFactors}

                {1, 1},
                {2, 3},        // 1 + 2
                {3, 4},        // 1 + 3
                {4, 7},        // 1 + 2 + 4
                {5, 6},        // 1 + 5
                {6, 12},       // 1 + 2 + 3 + 6
                {7, 8},
                {8, 15},       // 1 + 2 + 4 + 8
                {9, 13},       // 1 + 3 + 9
                {10, 18},      // 1 + 2 + 5 + 10
                {11, 12},
                {12, 28},      // 1 + 2 + 3 + 4 + 6 + 12
                {13, 14},
                {14, 24},      // 1 + 2 + 7 + 14
                {15, 24},      // 1 + 3 + 5 + 15
                {16, 31},      // 1 + 2 + 4 + 8 + 16
                {18, 39},      // 1 + 2 + 3 + 6 + 9 + 18
                {20, 42},      // 1 + 2 + 4 + 5 + 10 + 20
                {24, 60},      // 1 + 2 + 3 + 4 + 6 + 8 + 12 + 24
                {25, 31},      // 1 + 5 + 25
                {27, 40},      // 1 + 3 + 9 + 27
                {28, 56},      // Perfect number
                {30, 72},      // 1 + 2 + 3 + 5 + 6 + 10 + 15 + 30
                {36, 91},
                {49, 57},      // 1 + 7 + 49
                {50, 93},      // 1 + 2 + 5 + 10 + 25 + 50
                {64, 127},     // Powers of 2
                {81, 121},     // Powers of 3
                {97, 98},      // Prime
                {100, 217},    // 1 + 2 + 4 + 5 + 10 + 20 + 25 + 50 + 100
                {121, 133},    // 1 + 11 + 121
                {225, 403},    // 1 + 3 + 5 + 9 + 15 + 25 + 45 + 75 + 225
                {1000, 2340}   // Larger composite
        };

        int passed = 0;

        for (int[] test : testCases) {
            int input = test[0];
            int expected = test[1];
            int actual = sumOfFactors(input);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Input: %d | Expected: %d | Actual: %d%n",
                        input, expected, actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n", passed, testCases.length);
    }

    private static int sumOfFactors(int n) {
        int sum = 0;
        for(int i = 1; i * i <= n ; i++) {
            if(n%i==0) {
                sum += i;
                if(i != n/i) sum += n/i;
            }
        }
        return sum;
    }
}
