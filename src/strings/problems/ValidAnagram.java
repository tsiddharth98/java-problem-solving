package strings.problems;

/*
242. Valid Anagram

Difficulty: Easy

Problem Statement:
Given two strings s and t, return true if t is an anagram of s,
and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters
of another word using all the original letters exactly once.

Examples:

Input:
s = "anagram"
t = "nagaram"

Output:
true

Input:
s = "rat"
t = "car"

Output:
false

Constraints:
1 <= s.length, t.length <= 5 * 10^4

s and t consist of lowercase English letters.

Expected Time Complexity:
O(n)

Expected Auxiliary Space:
O(1)
*/

public class ValidAnagram {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {"anagram", "nagaram", true},
                {"rat", "car", false},

                // Single character
                {"a", "a", true},
                {"a", "b", false},

                // Different lengths
                {"ab", "abc", false},
                {"abcd", "abc", false},

                // Same strings
                {"abc", "abc", true},
                {"leetcode", "leetcode", true},

                // Valid anagrams
                {"listen", "silent", true},
                {"triangle", "integral", true},
                {"evil", "vile", true},
                {"dusty", "study", true},
                {"binary", "brainy", true},

                // Invalid anagrams
                {"hello", "world", false},
                {"apple", "apply", false},
                {"abcd", "abce", false},

                // Repeated characters
                {"abb", "bab", true},
                {"abb", "baa", false},
                {"aabbcc", "ccbbaa", true},
                {"aaaabbbb", "bbbbaaaa", true},
                {"aaaa", "aaab", false},
                {"zzzz", "zzzz", true},

                // Large strings
                {
                        "abcdefghijklmnopqrstuvwxyz",
                        "zyxwvutsrqponmlkjihgfedcba",
                        true
                },
                {
                        "abcdefghijklmnopqrstuvwxyz",
                        "abcdefghijklmnopqrstuvwxyy",
                        false
                }
        };

        int passed = 0;

        ValidAnagram solution = new ValidAnagram();

        for (Object[] test : testCases) {

            String s = (String) test[0];
            String t = (String) test[1];
            boolean expected = (boolean) test[2];

            boolean actual = solution.isAnagram(s, t);

            if (actual == expected) {
                passed++;
            } else {
                System.out.printf(
                        "❌ Failed -> s: \"%s\" | t: \"%s\" | Expected: %b | Actual: %b%n",
                        s,
                        t,
                        expected,
                        actual
                );
            }
        }

        System.out.printf("%nPassed %d/%d test cases.%n",
                passed,
                testCases.length);
    }

    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        for(char ch: s.toCharArray()) {
            chars[ch - 'a']++;
        }
        for(char ch: t.toCharArray()) {
            if(chars[ch - 'a'] > 0) chars[ch - 'a']--;
            else return false;
        }
        for(int n: chars) {
            if(n != 0) return false;
        }
        return true;
    }

    /*
     * Time Complexity: O(n+M)
     *
     * Space Complexity: O(1)
     * (Using a frequency array of size 26)
     */
}