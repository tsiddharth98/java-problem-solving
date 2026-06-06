package patterns;

/*
Problem:
Print the following pattern
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1

Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern13 {

    public static void main(String[] args) {
        method1();
        method2();
    }

    private static void method1() {
        for(int row=5;row>=1;row--) {
            for(int col=1;col<=row;col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    private static void method2() {
        for(int row=1;row<=5;row++) {
            for(int col=1;col<=5-(row-1);col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}
