package patterns;

/*
Problem:
Print the following pattern
a
b b
c c c
d d d d
e e e e e

Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern11 {

    public static void main(String[] args) {
//        method1();
        method2();
    }

    private static void method1() {
        for(char ch='a';ch<='e';ch++) {
            for(char col=ch; col>='a'; col--) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }

    private static void method2() {
        for(int row=1;row<=5;row++) {
            char ch = (char)('a' + (row-1));
            for(int col=1;col<=row;col++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}
