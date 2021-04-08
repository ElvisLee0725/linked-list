// We are given head, the head node of a linked list containing unique integer values.
//
//We are also given the list G, a subset of the values in the linked list.
//
//Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

// Use a HashSet to store all values in array G. Ex. <0, 1, 3>
// Iterate from the head of the linked list. If cur node is in set and next node is null or not in set, counter + 1
// Return the counter in the end

// Time: O(n), Space: O(n)

import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.print(new Solution().numComponents(n1, new int[]{0, 1, 3}));
    }
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> hs = new HashSet();
        for(int n : G) {
            hs.add(n);
        }

        int counter = 0;
        while(head != null) {
            if(hs.contains(head.val) && (head.next == null || !hs.contains(head.next.val))) {
                counter++;
            }
            head = head.next;
        }
        return counter;
    }
}
