/*Given an integer array nums, return true if any value appears at least twice in the array, 
and return false if every element is distinct. */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        boolean status = false; /*
                                 * Stores the status of the array.
                                 * Changes to true if the condition we are looking for is satisfied
                                 */
        for (int i : nums) {
            if (!numbers.contains(i)) {
                numbers.add(i);
            } else {
                status = true;
                return status; // This is what will be returned if the is no repeating value
            }
        }

        return false;
    }
}

public class Challenge217 {
    public static void main(String[] args) {
        Solution obj1 = new Solution();
        int[] array1 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println(obj1.containsDuplicate(array1));
    }
}
