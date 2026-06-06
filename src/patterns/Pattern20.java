package patterns;

/*
Problem:
Print the following pattern
        *
      * * *
    * * * * *
  * * * * * * *
* * * * * * * * *
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern20 {

    public static void main(String[] args) {
        method1(5);
        method2(5);
        method3(5);
    }

    private static void method1(int n) {
        for(int row=1;row<=n;row++) {
            for(int col=1;col<=n-row;col++) {
                System.out.print("  ");
            }
            for(int col=n-row+1;col<n+row;col++) {
                System.out.print("* ");
            }
            for(int col=n-row+1;col<2*row;col++) {
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void method2(int n) {
        for(int row=1;row<=n;row++) {
            for(int col=1;col<=n-row;col++) {
                System.out.print("  ");
            }
            for(int col=n-row+1;col<n+row;col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void method3(int n) {
        int center = n;

        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= 2*n-1; col++) {
                if(col >= center-row+1 && col <= center+row-1) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}


