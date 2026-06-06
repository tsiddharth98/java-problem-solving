package patterns;

/*
Problem:
Print the following pattern
        1
      2 1
    3 2 1
  4 3 2 1
5 4 3 2 1
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern19 {

    public static void main(String[] args) {
        method1(5);
        method2(5);
    }

    private static void method1(int n) {
        for(int row=5;row>=1;row--) {
            for(int col=1;col<=5;col++) {
                if(col>=row) System.out.print((5-col+1)+" ");
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
            for(int col=row;col>=1;col--) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}
