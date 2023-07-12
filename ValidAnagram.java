/*
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.An Anagram is a word or phrase formed by rearranging the letters of
 * a different word or phrase, typically using all the original letters exactly
 * once.
 */

import java.util.HashMap;

class Solution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } // It is automatically false if the strings are not of the same length

        // Creating a HashMap with a <key, value> pair of <Character, count> to show how
        // many times a character appears in a string
        HashMap<Character, Integer> countMap = new HashMap<>();
        // int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (!countMap.containsKey(s.charAt(i))) {
                countMap.put(s.charAt(i), 1);
            } else {
                countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char n = t.charAt(i);
            if (countMap.containsKey(n) && countMap.get(n) != 0) {
                if (countMap.get(n) != 0) {
                    countMap.put(n, countMap.get(n) - 1); /*
                                                           * Decrease the count of that character by one, once an
                                                           * instance has been encountered in string t
                                                           */
                }
            } else {
                return false; // If the character being iterated over is not in the existing hashmap, return
                              // false at that point;
            }
        }

        return true; // If the conditions are satisfied throughout the iteration over string t
    }
}

public class ValidAnagram {
    public static void main(String[] args) {
        Solution1 obj1 = new Solution1();
        System.out.println(obj1.isAnagram("aacc", "ccac"));
    }
}