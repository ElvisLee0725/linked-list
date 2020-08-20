// Corner Case: Only 1 node in the list and it is the one to be removed
// Create a dummy node with next pointing to head, slow and fast equal to dummy
// While fast.next != null, keep moving fast and n - 1. When n is <= 0, start moving slow
// When fast reaches the end, then we know the node to remove is slow.next, so assign slow.next = slow.next.next
// Return dummy.next

// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode cur = new Solution().removeNthFromEnd(a, 1);
        while(cur != null) {
            System.out.print(cur.val);
            if(cur.next != null) {
                System.out.print(", ");
            }
            cur = cur.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast.next != null) {
            if(n <= 0) {
                slow = slow.next;
            }
            fast = fast.next;
            n--;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
