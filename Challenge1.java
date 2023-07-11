import java.util.HashMap;
import java.util.Map;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order. */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2]; // Array to store the two numbers that add up to 'target'

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); // The <key, value> pair is <arrayElement, index>
        }

        for (int i = 0; i < map.size(); i++) {
            int value = target - nums[i];
            if (map.containsKey(value) && (i != map.get(value))) {
                array[0] = i;
                array[1] = map.get(value);
            }
        }

        return array;
    }
}

public class Challenge1 {
    public static void main(String[] args) {
        Solution obj1 = new Solution();
        int[] nums = { 2, 5, 5, 7 };
        System.out.println(obj1.twoSum(nums, 10));

    }
}