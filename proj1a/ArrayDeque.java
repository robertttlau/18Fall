/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /**
     * Resizes the underlying array to the target capacity.
     */
    private void resize(int capacity) {
        if (capacity > items.length) {
            T[] a = (T[]) new Object[capacity];
            if (nextFirst == items.length - 1) {
                System.arraycopy(items, 0, a, 0, items.length);
            } else {
                System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
                System.arraycopy(items, 0, a, items.length - nextFirst - 1, nextLast);
            }
            items = a;
            nextFirst = items.length - 1;
            nextLast = size;
        } else {
            T[] a = (T[]) new Object[capacity];
            if (nextFirst == items.length - 1) {
                System.arraycopy(items, 0, a, 0, size);
            } else if (nextFirst + size > items.length - 1) {
                System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
                System.arraycopy(items, 0, a, items.length - nextFirst - 1, nextLast);
            } else {
                System.arraycopy(items, nextFirst + 1, a, 0, size);
            }
            items = a;
            nextFirst = items.length - 1;
            nextLast = size;
        }
    }


    /**
     * Inserts X into the front of the list.
     */
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = x;
        size = size + 1;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = x;
        size = size + 1;
        nextLast += 1;
        if (nextLast > items.length - 1) {
            nextLast = 0;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
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
    public void printDeque() {
        int i = nextFirst + 1;
        int printNum = 0;
        while (printNum <= size) {
            if (i == items.length) {
                i = 0;
            }
            System.out.print(items[i] + " ");
            i += 1;
            printNum += 1;
        }
    }


    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (nextFirst + 1 == items.length) {
            if (items[0] == null) {
                return null;
            } else {
                T first = items[0];
                items[0] = null;
                size = size - 1;
                nextFirst = 0;
                if (items.length >= 16 & size <= items.length / 4) {
                    resize(items.length / 2);
                }
                return first;
            }
        } else {
            if (items[nextFirst + 1] == null) {
                return null;
            } else {
                T first = items[nextFirst + 1];
                items[nextFirst + 1] = null;
                nextFirst += 1;
                size = size - 1;
                if (items.length >= 16 & size <= items.length / 4) {
                    resize(items.length / 2);
                }
                return first;
            }
        }

    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (nextLast == 0) {
            if (items[items.length - 1] == null) {
                return null;
            } else {
                T last = items[items.length - 1];
                items[items.length - 1] = null;
                size = size - 1;
                nextLast = items.length - 1;
                if (items.length >= 16 & size <= items.length / 4) {
                    resize(items.length / 2);
                }
                return last;
            }
        } else {
            if (items[nextLast - 1] == null) {
                return null;
            } else {
                T last = items[nextLast - 1];
                items[nextLast - 1] = null;
                nextLast -= 1;
                size = size - 1;
                if (items.length >= 16 & size <= items.length / 4) {
                    resize(items.length / 2);
                }
                return last;
            }
        }
    }


    /**
     * Gets the ith item in the list (0 is the front).
     */
    public T get(int i) {
        int j = nextFirst + 1;
        if (j == items.length) {
            j = 0;
        }
        int index = 0;
        while (index < i) {
            j += 1;
            index += 1;
            if (j == items.length) {
                j = 0;
            }
        }
        System.out.println(items[j]);
        return items[j];
    }
}

