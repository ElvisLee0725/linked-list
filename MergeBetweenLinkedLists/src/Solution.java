// Find the ath prev node in list1 and bth next node in list1
// Point ath prev node next to the head of list2
// Iterate to the end of list2, point its next to bth next node
// Return the head of list1
// Time: O(m+n), Space: O(1)

class Solution {
    public static void main(String[] args) {
        
    }
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aPrev = list1;
        ListNode bNext = list1;

        for(int i = 0; i < a-1; i++) {
            aPrev = aPrev.next;
        }

        for(int i = 0; i < b+1; i++) {
            bNext = bNext.next;
        }

        aPrev.next = list2;
        while(aPrev.next != null) {
            aPrev = aPrev.next;
        }
        aPrev.next = bNext;
        return list1;
    }
}