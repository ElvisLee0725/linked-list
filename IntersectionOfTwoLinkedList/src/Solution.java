// List A + List B = List B + List A
// Create pointer a and b pointing headA and headB
// While a != b, keep moving a and b to the next
// If a is null, a will be assigned to headB. If b is null, b will be assigne to headA
// At most for a to iterate both and b to iterate both linked list, a and b will either be
// null or the intersection. So return a in the end
// Time: O(N+M), Space: O(1)
public class Solution {
    public static void main(String[] args) {
        
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while(a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }
}
