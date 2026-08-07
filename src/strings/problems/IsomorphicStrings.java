package strings.problems;

/*
205. Isomorphic Strings

Difficulty: Easy

Problem Statement:
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced
to get t.

Rules:
1. All occurrences of a character must map to the same character.
2. No two different characters can map to the same character.
3. A character may map to itself.

Examples:

Input:
s = "egg"
t = "add"

Output:
true

Explanation:
e -> a
g -> d

Input:
s = "f11"
t = "b23"

Output:
false

Explanation:
'1' would need to map to both '2' and '3'.

Input:
s = "paper"
t = "title"

Output:
true

Constraints:
1 <= s.length <= 5 * 10^4
t.length == s.length
s and t consist of any valid ASCII character.

Expected Time Complexity:
O(n)

Expected Auxiliary Space:
O(1)      // ASCII character set
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {

        Object[][] testCases = {

                // Problem examples
                {"egg", "add", true},
                {"f11", "b23", false},
                {"paper", "title", true},

                // Basic cases
                {"a", "b", true},
                {"a", "a", true},
                {"ab", "cd", true},
                {"ab", "aa", false},
                {"aa", "ab", false},
                {"aa", "bb", true},

                // Popular test cases
                {"foo", "bar", false},
                {"badc", "baba", false},
                {"abba", "cddc", true},
                {"abab", "baba", true},
                {"abab", "bbaa", false},

                // Same strings
                {"abc", "abc", true},
                {"aaaa", "aaaa", true},
                {"xyz", "xyz", true},

                // Duplicate mappings
                {"abca", "zbxz", true},
                {"abca", "zbxy", false},
                {"abcd", "aaaa", false},
                {"aaaa", "abcd", false},

                // Numbers and symbols
                {"121", "343", true},
                {"121", "345", false},
                {"@@##", "$$%%", true},
                {"@#@#", "$%$%", true},
                {"@#@#", "$$$$", false},

                // Mixed ASCII characters
                {"A1A1", "B2B2", true},
                {"A1A2", "B2B2", false},
                {"AaBb", "XxYy", true},
                {"AaAa", "XxYx", false},

                // Longer strings
                {"abcdefghijklmnopqrstuvwxyz",
                        "bcdefghijklmnopqrstuvwxyza",
                        true},

                {"abcdefghijklmnopqrstuvwxyz",
                        "aaaaaaaaaaaaaaaaaaaaaaaaaa",
                        false}
        };

        int passed = 0;

        IsomorphicStrings solution = new IsomorphicStrings();

        for (Object[] test : testCases) {

            String s = (String) test[0];
            String t = (String) test[1];
            boolean expected = (boolean) test[2];

            boolean actual = solution.isIsomorphic(s, t);

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

    /*public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if(mapST.containsKey(chS)) {
                if(mapST.get(chS) != chT) return false;
            } else {
                if(mapTS.containsKey(chT)) return false;
                mapST.put(chS, chT);
                mapTS.put(chT, chS);
            }
        }

        return true;
    }*/

    /*
     * Time Complexity: O(n)
     *
     * Space Complexity: O(1)
     * (At most 256 ASCII character mappings)
     */

    /*public boolean isIsomorphic(String s, String t) {
        int[] mapST = new int[128];
        int[] mapTS = new int[128];
        Arrays.fill(mapST, -1);
        Arrays.fill(mapTS, -1);
        for(int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if(mapST[chS] == -1 && mapTS[chT] == -1) {
                mapST[chS] = chT;
                mapTS[chT] = chS;
            } else if(mapST[chS] != chT || mapTS[chT] != chS) {
                return false;
            }
        }

        return true;
    }*/
    /*
     * Time Complexity: O(n)
     *
     * Space Complexity: O(1)
     * (At most 256 ASCII character mappings)
     */

    public boolean isIsomorphic(String s, String t) {
        char[] mapST = new char[128];
        char[] mapTS = new char[128];
        for(int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if(mapST[chS] == '\u0000' && mapTS[chT] == '\u0000') {
                mapST[chS] = t.charAt(i);
                mapTS[chT] = s.charAt(i);
            } else if(mapST[chS] != chT || mapTS[chT] != chS) {
                return false;
            }
        }

        return true;
    }
    /*
     * Time Complexity: O(n)
     *
     * Space Complexity: O(1)
     * (At most 256 ASCII character mappings)
     */
}