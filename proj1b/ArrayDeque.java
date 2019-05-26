/** Array based list.
 *  @author Josh Hug
 */

public class ArrayDeque<T> implements Deque<T> {

    int size;
    int nextFirst;
    int nextLast;
    T[] arr;
    private int RFACTOR;

    /** Creates an empty list. */
    public ArrayDeque() {
        size = 0;
        arr = (T[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
        RFACTOR = 2;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T x) {
        if (size == arr.length) {
            resize(size * RFACTOR);
        }
        arr[nextLast] = x;
        size += 1;
        nextLast = (nextLast + 1) % arr.length;
    }

    @Override
    public void addFirst(T x) {
        if (size == arr.length) {
            resize(size * RFACTOR);
        }
        arr[nextFirst] = x;
        size += 1;
        nextFirst = ((nextFirst - 1) % arr.length + arr.length) % arr.length;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return arr[(nextLast - 1) % arr.length];
    }

    /** Gets the ith item in the list (0 is the front). */
    @Override
    public T get(int i) {
        return arr[(nextFirst + i + 1) % arr.length];
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    @Override
    public T removeLast() {
        T temp = arr[(nextLast - 1) % arr.length];
        arr[(nextLast - 1) % arr.length] = null;
        size -= 1;
        nextLast = (nextLast - 1) % arr.length;
        if ((float) size / arr.length < 0.25) {
            resize(arr.length / 2);
        }
        return temp;
    }

    @Override
    public T removeFirst() {
        T temp = arr[(nextFirst + 1) % arr.length];
        arr[(nextFirst + 1) % arr.length] = null;
        size -= 1;
        nextFirst = (nextFirst + 1) % arr.length;
        if ((float) size / arr.length < 0.25) {
            resize(size / 2);
        }
        return temp;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(nextFirst + 1 + i) % arr.length] + " ");
        }
        System.out.println();
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int start = (nextFirst + 1) % arr.length;
        int end = (nextLast - 1) % arr.length;
        int len = arr.length - start;
        if (start <= end) {
            System.arraycopy(arr, start, a, capacity / 4, size);
            nextFirst = capacity / 4 - 1;
            nextLast = capacity / 4 + size;
        } else {
            System.arraycopy(arr, start, a, capacity / 4, len);
            System.arraycopy(arr, 0, a, capacity / 4 + len, end + 1);
            nextFirst = (capacity / 4 - 1);
            nextLast = (capacity / 4 + len + end + 1);
        }
        arr = a;

    }

    /*
    public static void main(String[] args) {
        ArrayDeque<String> d1 = new ArrayDeque();
        System.out.println(d1.isEmpty());
        d1.addFirst("Ryan");
        d1.addFirst("Matt");
        d1.addLast("Carp");
        d1.addFirst("Matt");
        d1.addFirst("Matt");
        d1.addFirst("Matt");
        d1.addFirst("Matt");
        d1.addFirst("Matt");
        d1.addFirst("Matt");
        d1.printDeque();
        System.out.println(d1.get(0));
        System.out.println(d1.get(2));
        d1.removeFirst();
        d1.printDeque();
        d1.removeLast();
        d1.printDeque();
    }

     */
}
