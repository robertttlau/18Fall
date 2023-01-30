/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst=4;
        nextLast=5;
    }

    /**
     * Resizes the underlying array to the target capacity.
     */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, nextFirst+1, a, nextFirst+1, size);
        items = a;
    }

    /**
     * Inserts X into the front of the list.
     */
    public void addFirst(Item x) {
        if (size == items.length) {
            resize(size*2);
        }

        items[nextFirst] = x;
        size = size+1;
        nextFirst-=1;
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size*2);
        }

        items[nextLast] = x;
        size = size+1;
        nextLast-=1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque(){
        int i = nextFirst+1;
        while (i <= nextLast-1) {
            System.out.print(items[i] + " ");
            i += 1;
        }
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public Item removeFirst() {
        if (items[nextFirst+1] == null) {
            return null;
        } else {
            Item first = items[nextFirst+1];
            items[nextFirst+1] = null;
            size = size - 1;
            if (size<=0.25*items.length){
                resize(size/2);
            }
            return first;
        }
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public Item removeLast() {
        if (items[nextLast-1] == null) {
            return null;
        } else {
            Item last = items[nextLast-1];
            items[nextLast-1] = null;
            size = size - 1;
            if (size<=0.25*items.length){
                resize(size/2);
            }
            return last;
        }
    }


    /**
     * Gets the ith item in the list (0 is the front).
     */
    public Item get(int i) {
        return items[i];
    }

}