/*Given an integer x, return true if x is a palindrome, and false otherwise. */

// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Map;
// import java.util.Set;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            // Automatically return false if the given integer is negative
            return false;
        }

        long reversed = 0;
        long digit = x;

        while (digit != 0) {
            int num = (int) (digit % 10);
            reversed = reversed * 10 + num;
            digit = digit / 10;
        }

        return reversed == x;
    }
}

public class Challenge9 {
    public static void main(String[] args) {
        Solution obj1 = new Solution();
        System.out.println(obj1.isPalindrome(12233221));
    }
}
