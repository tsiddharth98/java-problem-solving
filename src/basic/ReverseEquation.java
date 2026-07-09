package basic;

/*
Reversing the Equation

Difficulty: Easy

Problem Statement:
Given a mathematical equation that contains only numbers and the
operators '+', '-', '*', and '/'.

Reverse the equation such that:
- The order of numbers and operators is reversed.
- Each number itself remains unchanged.

It is guaranteed that:
- The given equation is valid.
- There are no leading zeros.

Examples:

Input:
S = "20-3+5*2"

Output:
"2*5+3-20"

Explanation:
The equation is reversed while keeping each number intact.

Input:
S = "5+2*56-2/4"

Output:
"4/2-56*2+5"

Explanation:
Numbers remain unchanged while the equation is reversed.

Expected Time Complexity:
O(|S|)

Expected Auxiliary Space:
O(|S|)

Constraints:
1 <= |S| <= 10^5
The string contains only:
'0' - '9', '+', '-', '*', '/'
*/

public class ReverseEquation {

    public static void main(String[] args) {

        String[][] testCases = {
                // {Input, Expected Output}

                {"1+2", "2+1"},
                {"2-1", "1-2"},
                {"5*3", "3*5"},
                {"8/2", "2/8"},

                {"20-3+5*2", "2*5+3-20"},
                {"5+2*56-2/4", "4/2-56*2+5"},
                {"12+34", "34+12"},
                {"123+456", "456+123"},
                {"10*20+30", "30+20*10"},
                {"100/20-5", "5-20/100"},

                {"1+22+333", "333+22+1"},
                {"999*888/777", "777/888*999"},
                {"12345-67890", "67890-12345"},
                {"10+20-30*40/50", "50/40*30-20+10"},
                {"99999+1", "1+99999"},
                {"1000*2000/3000+4000", "4000+3000/2000*1000"},

                // Single number
                {"7", "7"},
                {"123456", "123456"},

                // Numbers of different lengths
                {"1+2345", "2345+1"},
                {"123+45*6", "6*45+123"},
                {"999999/111", "111/999999"},
                {"11111-2222+333", "333+2222-11111"},
                {"98765*4321/123", "123/4321*98765"}
        };

        int passed = 0;

//        Solution solution = new Solution();

        for (String[] test : testCases) {

            String input = test[0];
            String expected = test[1];

            String actual = reverseEqn(input);

            if (actual.equals(expected)) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> Input: \"%s\" | Expected: \"%s\" | Actual: \"%s\"%n",
                        input,
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed, testCases.length);
    }

    static String reverseEqn(String S) {
        // your code here
        char[] ch = S.toCharArray();
        int first=0;
        int last=ch.length-1;
        swap(ch, first, last);

        for(int i=0;i<ch.length;i++) {
            first = i;
            while(i<ch.length) {
                if(ch[i] == '/' || ch[i] == '*' || ch[i] == '+' || ch[i] == '-'){
                    break;
                }
                i++;
            }
            swap(ch, first, i-1);
        }

        return String.valueOf(ch);
    }

    static void swap(char[] ch, int first, int last) {
        while (first < last) {
            char c = ch[first];
            ch[first] = ch[last];
            ch[last] = c;
            first++;
            last--;
        }
    }
}