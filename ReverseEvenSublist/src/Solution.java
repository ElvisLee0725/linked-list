
public class Solution {
    public static void main(String[] args) {
        int [] nodeList = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        Node head = new Solution().createList(nodeList);

        Node res = new Solution().reverse(head);
        while(res != null) {
            System.out.print(res.data);
            if(res.next != null) {
                System.out.print(" -> ");
            }
            res = res.next;
        }
    }

    Node createList(int [] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }
        Node dummy = new Node(0);
        Node head = dummy;
        for(int i = 0; i < arr.length; i++) {
            Node n = new Node(arr[i]);
            head.next = n;
            head = head.next;
        }
        return dummy.next;
    }

    Node helper(Node start, Node end) {
        Node prev = end.next;
        Node stopNode = end.next;
        Node next = null;
        while(start != stopNode) {
            next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        return prev;
    }

    Node reverse(Node head) {
        // Write your code here
        Node cur = head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        while(cur != null) {
            // Find the start of subpart
            while(cur.data % 2 != 0) {
                prev = cur;
                cur = cur.next;
            }
            if(cur == null) {
                break;
            }
            // Find the end of subpart
            while(cur.next != null && cur.next.data % 2 == 0) {
                cur = cur.next;
            }
            Node next = cur.next;
            prev.next = helper(prev.next, cur);
            cur = next;
        }

        return dummy.next;
    }
}
