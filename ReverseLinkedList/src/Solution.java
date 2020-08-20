public class Solution {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;

        ListNode n = new Solution().reverseListRecursively(one);
        while(n != null) {
            System.out.print(n.val);
            if(n.next != null) {
                System.out.print(", ");
            }
            n = n.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ListNode reverseListRecursively(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursively(head.next);
        ListNode prev = head.next;
        head.next = null;
        prev.next = head;

        return newHead;
    }
}
