// In the while loop, the 1st while loop is to find nodes that need to preserve, so we keep 2 pointers prev and cur while cur is at 1 node ahead of prev.
// In the 2nd while loop, we keep moving cur to get nodes that need to be deleted. At the end, every node between prev and cur are nodes that need to be removed, so prev.next = cur.
// Keep doing and we’ll get the result.

class Solution {
    public static void main(String[] args) {
        
    }
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head;
        ListNode prev = head;

        while(cur != null) {
            int countM = m;
            int countN = n;
            while(cur != null && countM > 0) {
                prev = cur;
                cur = cur.next;
                countM--;
            }

            while(cur != null && countN > 0) {
                cur = cur.next;
                countN--;
            }

            prev.next = cur;
        }
        return head;
    }
}
