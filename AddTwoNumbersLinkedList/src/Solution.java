// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Create a dummy node and a cur node point to it. A curSum variable starts from 0
// Reverse l1 and l2
// While l1 != null or l2 != null or curSum is not 0, do:
// 1. curSum add up with the value in l1 and l2, if they are not null
// 2. If curSum is >= 10, get the mod by 10 and create a new ListNode with the mod value. cur.next pointing to the new ListNode, then cur = cur.next. Set curSum to 1
// 3. Else, create a new ListNode with the curSum value and cur.next pointing to it. Set curSum to 0
// After the while loop, return the reverse of dummy.next since it is pointing to the head of list

// Time: O(m+n) Space: O(m+n)
public class Solution {
    public static void main(String[] args) {
        int [] arr1 = new int[]{7,2,4,3};
        int [] arr2 = new int[]{5,6,4};

        ListNode l1 = new Solution().createList(arr1);
        ListNode l2 = new Solution().createList(arr2);

        ListNode res = new Solution().addTwoNumbers(l1, l2);

        while(res != null) {
            System.out.print(res.val);
            if(res.next != null) {
                System.out.print(" -> ");
            }
            res = res.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int curSum = 0;
        l1 = reverse(l1);
        l2 = reverse(l2);
        while(l1 != null || l2 != null || curSum != 0) {
            if(l1 != null) {
                curSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                curSum += l2.val;
                l2 = l2.next;
            }

            cur.next = new ListNode(curSum % 10);
            cur = cur.next;

            curSum = curSum / 10;   // Make curSum either 1 or 0 depending on if it's greater than 10
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode createList(int [] arr) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for(int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return dummy.next;
    }
}
