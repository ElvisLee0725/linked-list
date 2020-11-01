// We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
// Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i,
// node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
// Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).


// Recursion + Stack
// Use a stack to store all the possible next values that's greater than current value
// At each round, while the stack is not empty, check if the top on stack is greater than cur val? If so, use it as the answer[i] and break while loop. Else, keep pop from stack and check again.
// If stack is empty, that means the current value is the greatest. Set answer[i] to 0.
// After each round, insert the current value into stack

import java.util.Deque;
import java.util.LinkedList;

// Time: O(n), Space: O(n)
public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{8,8,7,1,6,6,9,8,10,5};
        ListNode head = new Solution().buildList(arr);
        int [] ans = new Solution().nextLargerNodes(head);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
            if(i != ans.length-1) {
                System.out.print(", ");
            }
        }
    }

    public ListNode buildList(int [] arr) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;

        for(int i = 0; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        return dummy.next;
    }

    public int[] nextLargerNodes(ListNode head) {
        if(head == null) {
            return new int[0];
        }
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        int [] answer = new int[count];
        Deque<Integer> stack = new LinkedList();
        traverseNode(head, 0, answer, stack);
        return answer;
    }

    public void traverseNode(ListNode head, int i, int [] answer, Deque<Integer> stack) {
        if(head == null) {
            return ;
        }

        traverseNode(head.next, i + 1, answer, stack);

        while(!stack.isEmpty()) {
            if(stack.peekLast() > head.val) {
                answer[i] = stack.peekLast();
                break;
            }
            else {
                stack.pollLast();
            }
        }
        if(stack.isEmpty()) {
            answer[i] = 0;
        }
        stack.offerLast(head.val);
    }
}
