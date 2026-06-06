package patterns;

/*
Problem:
Print the following pattern
        A
      A B
    A B C
  A B C D
A B C D E
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern18 {

    public static void main(String[] args) {
        method1(5);
        method2(5);
    }

    private static void method1(int n) {
        for(int row=5;row>=1;row--) {
            for(int col=1;col<=5;col++) {
                if(col>=row) System.out.print((char) ('A' + col - row) + " ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void method2(int n) {
        for(int row=1;row<=n;row++) {
            for(int col=1;col<=n-row;col++) {
                System.out.print("  ");
            }
            for(int col=1;col<=row;col++) {
                System.out.print((char)('A'+col-1)+" ");
            }
            System.out.println();
        }
    }
}
