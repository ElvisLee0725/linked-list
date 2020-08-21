public class Solution {
    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        deque.insertFront(1);
        deque.insertFront(2);
        deque.insertLast(3);
        deque.insertLast(4);
        deque.deleteFront();
        System.out.print(deque.getFront() + " ");
        System.out.print(deque.getRear() + " ");
    }
}
