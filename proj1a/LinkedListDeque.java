

/**
 * @param <T>, specify the data type of linked list
 */
public class LinkedListDeque<T> {


    /**
     * Node class. Each element of the Deque is an instance of a Node.
     */
    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node (Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * Constructor to create an empty LinkedListDeque
     */
    public LinkedListDeque() {
        Node start = new Node(null, null, null);
        sentinel = start;
        sentinel.prev = start;
        sentinel.next = start;
        size = 0;
    }


    /**
     * Constructor to create a deep copy of the supplied LinkedListDeque.
     * @param other, a LinkedListDeque to copy
     */
    public LinkedListDeque(LinkedListDeque other) {

        LinkedListDeque<T> temp1 = new LinkedListDeque<T>();
        LinkedListDeque<T> temp2 = new LinkedListDeque<T>();
        temp1.sentinel.next = other.sentinel.next;

        while (temp1.sentinel.next != other.sentinel) {
            temp2.addLast(temp1.sentinel.next.item);
            temp1.sentinel.next = temp1.sentinel.next.next;
        }

        Node start = new Node(null, null, null);
        sentinel = start;
        sentinel.next = temp2.sentinel.next;
        sentinel.prev = temp2.sentinel.prev;
        sentinel.next.prev = sentinel;
        sentinel.prev.next = sentinel;
        size = temp2.size();
    }

    /**
     * Add node, containing item, to beginning of list
     * @param item
     */
    public void addFirst(T item) {
        size += 1;
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    /**
     * Add node, containing item, to end of list
     * @param item
     */
    public void addLast(T item) {
        size += 1;
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    /**
     * Check if list is empty
     * @return
     */
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    /**
     * Return size of list
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Print the items in the deque from first to last, separated by a space.
     * Once all items printed, print a new line.
     */
    public void printDeque() {
        LinkedListDeque<T> temp = new LinkedListDeque<T>();
        temp.sentinel.next = sentinel.next;
        while (temp.sentinel.next != sentinel) {
            System.out.print(temp.sentinel.next.item + " ");
            temp.sentinel.next = temp.sentinel.next.next;
        }
        System.out.println("\n");
    }

    /**
     * Remove and return the item at the front of the deque.
     * If no such item exists, returns null.
     * @return
     */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return temp;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null
     * @return
     */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T temp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return temp;
    }


    /**
     *
     * @param index
     * @return
     */
    public T get(int index) {
        LinkedListDeque<T> temp = new LinkedListDeque<T>();
        temp.sentinel.next = sentinel.next;
        int curr = 0;
        while (curr < index) {
            temp.sentinel.next = temp.sentinel.next.next;
            curr += 1;
        }
        return temp.sentinel.next.item;
    }

    public T getRecursive(int index) {
        if (index > size - 1) {System.out.println("Index larger than size of list!");}
        if (index == 0) {return sentinel.next.item;}
        LinkedListDeque<T> temp = new LinkedListDeque<T>();
        temp.sentinel.next = sentinel.next.next;
        temp.sentinel.prev = sentinel.prev;
        temp.size = size - 1;
        return temp.getRecursive(index - 1);
    }

/*
    public static void main(String args[]) {
        LinkedListDeque<String> d1 = new LinkedListDeque<>();
        System.out.println(d1.isEmpty());
        d1.addFirst("Ryan");
        d1.addFirst("Matt");
        d1.addLast("Carp");
        d1.printDeque();
        System.out.println(d1.get(0));
        System.out.println(d1.get(2));
        System.out.println(d1.getRecursive(0));
        System.out.println(d1.getRecursive(3));
        d1.removeFirst();
        d1.printDeque();
        d1.removeLast();
        d1.printDeque();
    }

 */
}

























