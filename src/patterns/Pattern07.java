package patterns;

/*
Problem:
Print the following pattern
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern07 {

    public static void main(String[] args) {
        method1();
        method2();
        method3();
    }

    private static void method1() {
        int p=1;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                System.out.print(p+" ");
                p++;
            }
            System.out.println();
        }
    }

    private static void method2() {
        for(int i=0; i<25;) {
            for(int j=1; j<=5; j++) {
                System.out.print(i+j+" ");
            }
            i += 5;
            System.out.println();
        }
    }

    private static void method3() {
        for(int i=1; i<=5;i++) {
            for(int j=1; j<=5; j++) {
                // value = (row-1)*5 + col;
                System.out.print(((i-1)*5+j)+" ");
            }
            System.out.println();
        }
    }
}
