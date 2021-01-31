// Given head which is a reference node to a singly-linked list. The value of each node in the linked list is
// either 0 or 1. The linked list holds the binary representation of a number.
// Return the decimal value of the number in the linked list.

// Find the total number of nodes in list
// While head is not null, calculate the current val and sum up
// Return the sum
// Time: O(n), Space: O(1)
class Solution {
    public static void main(String[] args) {
        ListNode head = createList(new int[]{1, 0, 1});
        System.out.print(new Solution().getDecimalValue(head));
    }

    public static ListNode createList(int [] arr) {
        ListNode cur = new ListNode(0);
        ListNode dummy = cur;
        for(int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }

    public int getDecimalValue(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        int sum = 0;
        int index = 0;
        while(head != null) {
            sum += head.val * (int) Math.pow(2, count - index - 1);
            index++;
            head = head.next;
        }
        return sum;
    }
}