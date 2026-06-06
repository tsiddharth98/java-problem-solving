package patterns;

/*
Problem:
Print the following pattern
5
5 4
5 4 3
5 4 3 2
5 4 3 2 1
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern14 {

    public static void main(String[] args) {
        for(int row=1;row<=5;row++) {
            for(int col=1;col<=row;col++) {
                System.out.print((5-col+1)+" ");
            }
            System.out.println();
        }
    }
}
