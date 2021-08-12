/*
- Create 2 pointers, cur is pointing at head and prev's next is head.
- Create a dummy node pointing at prev
- While cur is not null, check if cur's val equals val?
    - If so, move prev's next to cur's next and move cur to next
    - Else, move both prev and cur to its next
- Return the dummy.next
Time: O(N), Space: O(1)
*/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }

        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode cur = head;
        ListNode dummy = prev;
        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            }
            else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}