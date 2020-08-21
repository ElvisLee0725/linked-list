// Use 2 pointers (slow and fast). The fast pointer runs twice as fast as the slow pointer
// If there is a cycle, fast and slow point are going to meet again; Otherwise, fast is going to reach the end
// Return true if fast == slow, return false when fast reaches the end

// Time: O(n), Slow: O(1)

public class Solution {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = a;
        System.out.print(new Solution().hasCycle(a));
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }

        return false;
    }
}
