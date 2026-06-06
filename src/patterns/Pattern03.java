package patterns;

/*
Problem:
Print the following pattern
4 4 4 4 4 4
4 4 4 4 4 4
4 4 4 4 4 4
4 4 4 4 4 4
4 4 4 4 4 4
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern03 {

    public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<6; j++) {
                System.out.print("4 ");
            }
            System.out.println();
        }
    }
}
