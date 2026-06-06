package patterns;

/*
Problem:
Print the following pattern
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern01 {

    public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
