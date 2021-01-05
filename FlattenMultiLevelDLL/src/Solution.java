// You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
// Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

// Base Case: head is null, return it.
// For each cur node, get its child node and next node
// If the child node is not null, do:
// Set cur node's next to child, child node's prev to cur
// Find the end of child list, set its next to next node, and set next node's prev to that end if its not null
// Return cur node at the end
public class Solution {
    public static void main(String[] args) {

    }
    public Node flatten(Node head) {
        if(head == null) {
            return head;
        }
        Node child = flatten(head.child);
        Node next = flatten(head.next);

        if(child != null) {
            head.next = child;
            child.prev = head;
            head.child = null;
            while(child.next != null) {
                child = child.next;
            }
            child.next = next;
            if(next != null) {
                next.prev = child;
            }
        }
        return head;
    }
}
