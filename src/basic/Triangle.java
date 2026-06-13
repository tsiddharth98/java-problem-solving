package basic;

import java.util.Scanner;

/*
Problem:
Given three sticks with lengths L1, L2, L3 - find out if these sticks can form a triangle.
If they can form a triangle, calculate the circumference of the triangle.=
Circumference of a triangle (C) = L1 + L2 + L3
The condition to be satisfied for three sticks to form a triangle is that the sum of lengths of any two sides of the triangle
should be greater than or equal to the length of the third side.

Input  : n1 = 3, n2 = 4, n3 = 5
Output: Circumference: 12

Input  : n1 = 1, n2 = 4, n3 = 2
Output: Circumference: -1

Platform:
Difficulty: Basic
link:
*/
public class Triangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the side 1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter the side 2: ");
        int n2 = sc.nextInt();
        System.out.println("Enter the side 3: ");
        int n3 = sc.nextInt();
        System.out.println("Circumference: "+circumference(n1,n2,n3));
    }

    private static int circumference(int n1, int n2, int n3) {
        if((n1+n2)>n3) return -1;
        if((n2+n3)>n1) return -1;
        if((n3+n1)>n2) return -1;
        return n1+n2+n3;
    }

    private static void twoChars() {
        String str = "WORKATTECH";
        int i=0;
        while(i<str.length()) {
            System.out.println(str.charAt(i)+""+str.charAt(i+1));
            i = i+2;
        }
    }
}
