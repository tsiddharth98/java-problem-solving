package sorting;

/*
Problem:
Print the following pattern
        1
      1 2 1
    1 2 3 2 1
  1 2 3 4 3 2 1
1 2 3 4 5 4 3 2 1
Platform: Practice
Difficulty: Easy
link:
*/

import utils.Utils;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {

    public static void main(String[] args) {

        Random random = new Random();

        for(int test = 1; test <= 100000; test++) {

            int size = random.nextInt(50) + 1;

            int[] arr1 = new int[size];
            int[] arr2 = new int[size];

            for(int i = 0; i < size; i++) {
                arr1[i] = random.nextInt(1000) - 500;
                arr2[i] = arr1[i];
            }

            sort2(arr1, arr1.length);
            Arrays.sort(arr2);

            if(!Arrays.equals(arr1, arr2)) {
                System.out.println("FAILED ON TEST " + test);

                System.out.println("Your Result:");
                Utils.printArray(arr1);

                System.out.println("Expected:");
                Utils.printArray(arr2);

                return;
            }
        }

        System.out.println("ALL TESTS PASSED");
    }

    private static void sort2(int[] arr, int n) {
        for(int gap=n/2;gap>=1;gap/=2) {
            for(int j=gap;j<n;j++) {
                for(int i=j-gap;i>=0;i=i-gap) {
                    if (arr[i+gap]>arr[i]) break;
                    else Utils.swap(arr, i+gap,i);
                }
            }
        }
    }
}


