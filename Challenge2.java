/* You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.*/

import java.util.HashMap;
import java.util.Map;

import java.util.Iterator;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Map<Integer, Integer> l1Map = new HashMap<>();
        retriveValues(l1, l1Map);
        Map<Integer, Integer> l2Map = new HashMap<>();
        retriveValues(l2, l2Map);

        Map<Integer, ListNode> l3Map = new HashMap<>(); // This is the HashMap that will be populated with the listNodes

        int remainder = 0; // This is a variable to store the value 1 when the sum of two node values is
                           // greater than 9

        Iterator<Integer> l1Iterator = l1Map.values().iterator(); // Setting an iterator for the l1 map (map with l1
                                                                  // values)
        Iterator<Integer> l2Iterator = l2Map.values().iterator();
        int count = 1; // A value to be used to populate the HashMap storing the sum of nodes
        while (l1Iterator.hasNext() || l2Iterator.hasNext() || remainder == 1) {
            int sum = remainder; // Adding the remainder, if any, from the preceeding nodes
            if (l1Iterator.hasNext()) {
                sum += l1Iterator.next(); // Adding the value in the <key, value> pair to the sum
            }

            if (l2Iterator.hasNext()) {
                sum += l2Iterator.next(); // Adding the values in the <key, value> pair to the sum
            }

            remainder = sum / 10; // Getting the new value of the remainder

            l3Map.put(count, new ListNode(sum % 10));
            count++;
        }

        // for (int i = 1; i <= l1Map.size(); i++) {
        // int sum = (l1Map.get(i) + l2Map.get(i));
        // l3Map.put(i, new ListNode(sum));
        // }

        for (int i = 1; i <= l3Map.size(); i++) {
            if (i == l3Map.size()) {
                break;
            }
            l3Map.get(i).next = l3Map.get(i + 1);
        }

        return l3Map.get(1);

    }

    private static void retriveValues(ListNode list1, Map<Integer, Integer> listMap) {
        // This function extracts the values from the given lists and creates a HashMap
        int count = 1;
        while (list1 != null) {
            listMap.put(count, list1.val);
            count++;
            list1 = list1.next;
        }
    }
}

public class Challenge2 {
    public static void main(String[] args) {
        // ListNode l2 = new ListNode();
        // System.out.println(l2.val + " " + l2.next);
        int l1 = 2, l2 = 4, l3 = 3, l4 = 5, l5 = 6, l6 = 4;
        ListNode list1 = new ListNode(l1, new ListNode(l2, new ListNode(l3)));
        ListNode list2 = new ListNode(l4, new ListNode(l5, new ListNode(l6)));

        ListNode result = ListNode.addTwoNumbers(list1, list2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}