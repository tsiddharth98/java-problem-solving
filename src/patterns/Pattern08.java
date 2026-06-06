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

public class Pattern08 {

    public static void main(String[] args) {
        for(int i=1; i<=5; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
