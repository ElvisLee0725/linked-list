// Find the middle point to divide the list to half
// If fast is null, then slow is the head of second half. Else, slow.next is the head of second half
// Reverse the second half
// Use 2 pointers to point at the head of 2 lists, while second is not null, point the next of first to second, and point the next of second to the original next of first.
// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        new Solution().reorderList(n1);
        ListNode cur = n1;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = new ListNode(0);
        slowPrev.next = slow;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            slowPrev = slowPrev.next;
        }

        ListNode first = head;
        ListNode second = null;
        if(fast == null) {
            second = slow;
            slowPrev.next = null;
        }
        else {
            second = slow.next;
            slow.next = null;
        }

        // Reverse 2nd half
        ListNode prev = null;
        ListNode cur = second;
        ListNode tmp = null;
        while(cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        second = prev;

        while(second != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}
