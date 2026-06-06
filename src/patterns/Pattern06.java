package patterns;

/*
Problem:
Print the following pattern
F G H I J K
F G H I J K
F G H I J K
F G H I J K
F G H I J K
Platform: Practice
Difficulty: Easy
link:
*/

public class Pattern06 {

    public static void main(String[] args) {
        for(int i=0; i<5; i++) {
            for(char j='F'; j<='K'; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
