// Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
// The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
// The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
// Return a List of ListNode's representing the linked list parts that are formed.


// Create a array with length k, get the length of input linked-list by a while loop, and get the remainder of len % k
// Loop through the array, at each round, do:
// Copy the value from cur node len / k times
// If remainder is greater than 0, copy 1 more val from cur node
// Assign list to array[i]. Return the array

// Time: O(n+k), Space: O(Math.max(n, k))
public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for(int i = 0; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        ListNode [] res = new Solution().splitListToParts(dummy.next, 3);
        for(int i = 0; i < res.length; i++) {
            ListNode cur = res[i];
            while(cur != null) {
                System.out.print(cur.val);
                if(cur.next != null) {
                    System.out.print(" -> ");
                }
                cur = cur.next;
            }
            System.out.println();
        }
    }


    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode [] res = new ListNode[k];
        ListNode cur = root;
        int len = 0;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        cur = root;
        int remainder = len % k;

        for(int i = 0; i < k; i++) {
            ListNode head = new ListNode(0);
            ListNode dummy = head;
            for(int j = 0; j < len / k; j++) {
                head.next = new ListNode(cur.val);
                cur = cur.next;
                head = head.next;
            }
            if(remainder > 0) {
                head.next = new ListNode(cur.val);
                cur = cur.next;
                head = head.next;
                remainder--;
            }

            res[i] = dummy.next;
        }
        return res;
    }
}
