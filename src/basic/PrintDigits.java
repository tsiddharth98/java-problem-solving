package basic;

import java.util.Scanner;

/*
Problem:
Given a two-digit number n, print both the digits of the number.

Input  : n = 34
Output: Number digits are 3 and 4

Input : n = 24
Output : Number digits are 2 and 4

Platform:
Difficulty: Basic
link:
*/
public class PrintDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        printDigits(num);
    }

    private static void printDigits(int n) {
        int ones = n%10;
        int tens = n/10;
        System.out.println("Number digits are "+tens+" and "+ones);
    }
}
