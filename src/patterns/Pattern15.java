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
        method2();
    }

    private static void method1() {
        for(int row=1;row<=5;row++) {
            for(int col=1;col<=row;col++) {
                System.out.print((5-col+1)+" ");
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
