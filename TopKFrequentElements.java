/*
 * Given an integer array nums and an integer k, return the k most frequent elements. 
 * You may return the answer in any order.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k]; // This is the array to return the k most frequent elements
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                int frequency = 1;
                map.put(num, frequency);
            } else {
                int frequency = map.get(num) + 1;
                map.put(num, frequency);
            }
        }

        List<Integer> mostFrequent = new ArrayList<>(map.values());
        Collections.sort(mostFrequent, Collections.reverseOrder());
        mostFrequent = mostFrequent.subList(0, k); /*
                                                    * Getting the values in the list from 0 (inclusive) to k (exclusive)
                                                    */
        for (int i = 0; i < k; i++) {
            result[i] = mostFrequent.get(i); // Populating the array with the values inthe list created
        }

        return result;
    }
}

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] array1 = { 1, 1, 1, 2, 2, 3 }; // Creating the array to be tested
        Solution3 obj1 = new Solution3();

        System.out.println(Arrays.toString(obj1.topKFrequent(array1, 2))); /*
                                                                            * Returning the array in a string form
                                                                            * enclosed in square brackets
                                                                            */
    }
}
