/*
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
 * The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. 
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            }
        }

        nums = new int[set.size()];
        int i = 0; // Used to traverse the array 'nums'
        for (Iterator<Integer> n = set.iterator(); n.hasNext();) {
            nums[i] = n.next();
            i++;
        }

        Arrays.sort(nums);
        for (int k : nums) {
            System.out.print(" " + k);
        }

        return nums.length;
    }
}

public class Challenge26 {
    public static void main(String[] args) {
        Solution obj1 = new Solution();
        int[] array1 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(array1.length);
        System.out.println(obj1.removeDuplicates(array1));
    }
}