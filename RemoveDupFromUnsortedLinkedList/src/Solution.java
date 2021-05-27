import java.util.HashMap;
// Given the head of a linked list, find all the values that appear more than once in the list and delete the nodes that have any of those values.
// Return the linked list after the deletions.

class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode head = new Solution().deleteDuplicatesUnsorted(l1);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap();

        ListNode cur = head;
        while(cur != null) {
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }

        cur = head;
        ListNode dummy = new ListNode(0);
        ListNode cur2 = dummy;
        while(cur != null) {
            if(map.get(cur.val) == 1) {
                ListNode node = new ListNode(cur.val);
                cur2.next = node;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
