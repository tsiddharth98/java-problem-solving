package patterns;

/*
Problem:
Print the following pattern
1 8 27 64 125 216
1 8 27 64 125 216
1 8 27 64 125 216
1 8 27 64 125 216
1 8 27 64 125 216
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern05 {

    public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            for(int j=1; j<=6; j++) {
                System.out.print(j*j*j+" ");
            }
            System.out.println();
        }
    }
}
