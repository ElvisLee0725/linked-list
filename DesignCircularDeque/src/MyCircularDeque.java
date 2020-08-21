// Implement those methods:
// insertFront(), return true if successful
// insertLast(), return true if successful
// deleteFront(), return true if successful
// deleteLast(), return true if successful
// getFront(), return the val of the first node, return -1 if deque is empty
// getRear(), return the val of the last node, return -1 if deque is empty
// isEmpty(), return true if is empty
// isFull(), return true if is full

public class MyCircularDeque {
    class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public MyCircularDeque(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean insertFront(int value) {
        if(this.isFull()) {
            return false;
        }

        Node n = new Node(value);
        if(this.isEmpty()) {
            head = n;
            tail = n;
        }
        else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        this.size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(this.isFull()) {
            return false;
        }

        Node n = new Node(value);
        if(this.isEmpty()) {
            head = n;
            tail = n;
        }
        else {
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
        this.size++;
        return true;
    }


    public boolean deleteFront() {
        if(this.isEmpty()) {
            return false;
        }
        else if(head == tail) {
            head = null;
            tail = null;
        }
        else {
            head.next.prev = null;
            head = head.next;
        }

        this.size--;
        return true;
    }

    public boolean deleteLast() {
        if(this.isEmpty()) {
            return false;
        }
        else if(head == tail) {
            head = null;
            tail = null;
        }
        else {
            tail.prev.next = null;
            tail = tail.prev;
        }

        this.size--;
        return true;
    }

    public int getFront() {
        if(this.isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if(this.isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
