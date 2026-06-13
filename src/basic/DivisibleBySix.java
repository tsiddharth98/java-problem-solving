package basic;

/*
Problem:
Given a number, the task is to check if a number is divisible by 6 or not. The input number may be large and it may not be possible
to store even if we use long long int.

Input  : n = 2112
Output: Yes

Input : n = 1124
Output : No

Input  : n = 363588395960667043875487
Output : No

Platform:
Difficulty: Basic
link:
*/

public class DivisibleBySix {

    public static void main(String[] args) {
        String str = "1332";
        if(check(str))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    // Function to find that number divisible by 6 or not
    static boolean check(String str) {
        int n = str.length();

        // Return false if number is not divisible by 2.
        if ((str.charAt(n-1) -'0')%2 != 0)
            return false;

        // If we reach here, number is divisible by 2.
        // Now check for 3.
        // A number is divisible by 3 if sum of its digits is divisible by 3.
        // Compute sum of digits
        int digitSum = 0;
        for (int i=0; i<n; i++)
            digitSum += (str.charAt(i)-'0');

        // Check if sum of digits is divisible by 3
        return (digitSum % 3 == 0);
    }
}
