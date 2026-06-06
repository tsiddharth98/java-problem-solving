package patterns;

/*
Problem:
Print the following pattern
1 4 9 16 25
1 4 9 16 25
1 4 9 16 25
1 4 9 16 25
1 4 9 16 25
1 4 9 16 25
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern04 {

    public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            for(int j=1; j<=5; j++) {
                System.out.print(j*j+" ");
            }
            System.out.println();
        }
    }
}
