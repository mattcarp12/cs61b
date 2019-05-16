/** Array based list.
 *  @author Josh Hug
 */

public class ArrayDeque<T> {

    int size;
    T[] arr;

    /** Creates an empty list. */
    public ArrayDeque() {
        size = 0;
        arr = (T[]) new Object[1000];
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        arr[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return arr[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return arr[i - 1];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T temp = arr[size - 1];
        arr[size - 1] = null;
        size -= 1;
        return temp;
    }
} 