/*Given a string s, find the longest substring without repeating characters */

import java.util.HashMap;
import java.util.Map;

class CharNode {
    /*
     * This is a class to define the structure of a node to store each character of
     * the given string.
     */
    private char val; // The character to be stored
    private CharNode next; // The refernce to the next node

    public CharNode() {
    }

    public CharNode(char val) {
        this.val = val;
    }

    public CharNode(char val, CharNode next) {
        this.val = val;
        this.next = next;
    }

    public static int lengthOfLongestSubString(String s) {
        CharNode head = new CharNode();
        CharNode temp = head;
        for (int i = 0; i < s.length(); i++) { // Creating the linked list
            temp.val = s.charAt(i);
            temp.next = new CharNode();
            temp = temp.next;
        }

        Map<Character, Integer> string = new HashMap<>(); // Creating a hashmap to store the longest substring
        temp = head;
        int i = 1; // This is a value to index the characters in the Map
        while (temp != null) {
            if (temp.next != null) { // This condition is to avoid an OutOfBoundException
                if (temp.val != temp.next.val && !string.containsKey(temp.val)) {
                    string.put(temp.val, i);
                } else {
                    string.remove(temp.val);
                }
            }
            i++;
            temp = temp.next;
        }
        return string.size();
    }
}

public class Challenge3 {
    public static void main(String[] args) {
        // String s = "Hansel";
        // System.out.println(s.charAt(1));

        System.out.println("Longest substring = " + CharNode.lengthOfLongestSubString("abcabcbb"));
    }
}
