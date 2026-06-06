package patterns;

/*
Problem:
Print the following pattern
        1
      2 2
    3 3 3
  4 4 4 4
5 5 5 5 5
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern16 {

    public static void main(String[] args) {
        method1(5);
        method2(5);
    }

    private static void method1(int n) {
        for(int row=5;row>=1;row--) {
            for(int col=1;col<=5;col++) {
                if(col>=row) System.out.print((5-row+1)+" ");
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
                System.out.print(row+" ");
            }
            System.out.println();
        }
    }
}
