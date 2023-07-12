/*
* Given an array of strings strs, group the anagrams together. 
* You can return the answer in any order.
* An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
* typically using all the original letters exactly once. 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String i : strs) {
            char[] stringCharArray = i.toCharArray(); // Converting each string in the array to a character array
            Arrays.sort(stringCharArray); // Sorting each character array for simplification of comparison
            String sortedString = String.valueOf(stringCharArray); // Converting the sorted character array back to a
                                                                   // string

            List<String> anagram = map.getOrDefault(sortedString, new ArrayList<>()); /*
                                                                                       * This returns the list of
                                                                                       * similar words(anagrams) or
                                                                                       * creates a new ArrayList if none
                                                                                       * is found
                                                                                       */
            anagram.add(i);
            map.put(sortedString, anagram);
        }

        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        Solution2 obj1 = new Solution2();
        System.out.println(obj1.groupAnagrams(strs));
    }
}
