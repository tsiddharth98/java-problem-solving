package patterns;

/*
Problem:
Print the following pattern
        *
      * *
    * * *
  * * * *
* * * * *
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern15 {

    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        for(int row=5;row>=1;row--) {
            for(int col=1;col<=5;col++) {
                if(col>=row) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}
