public class LinkedListDeque<T> implements Deque<T> {

    /**
     * The first item (if it exists) is at sentinel.next.
     */
    private StuffNode sentinel;
    private int size;


    /**
     * Constructors
     */
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        StuffNode p = sentinel.prev;
        sentinel.prev = new StuffNode(x, sentinel.prev);
        sentinel.prev.next = sentinel;
        sentinel.prev.prev = p;
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StuffNode p = sentinel.next;
        int i = 0;
        if (p != null) {
            while (i < size) {
                System.out.print(p.item + " ");
                p = p.next;
                i += 1;
            }
        } else {
            System.out.print(" ");
        }
    }

    @Override
    public T removeFirst() {
        if (size != 0) {
            T first = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return first;
        } else {
            return null;
        }
    }

    @Override
    public T removeLast() {
        if (size != 0) {
            T last = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return last;
        } else {
            return null;
        }
    }

    @Override
    public T get(int index) {
        if (size != 0 & size > index) {
            StuffNode p = sentinel;
            int i = 0;
            while (i != index) {
                p = p.next;
                i += 1;
            }
            return p.next.item;
        } else {
            return null;
        }
    }

    public T getRecursive(int index) {
        if (index == 0) {
            return sentinel.next.item;
        } else {
            return getRecursiveHelper(sentinel.next, index);
        }
    }

    private T getRecursiveHelper(StuffNode p, int index) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursiveHelper(p.next, index - 1);
        }
    }

    private class StuffNode {
        private T item;
        private StuffNode next;
        private StuffNode prev;

        public StuffNode(T i, StuffNode n) {
            item = i;
            next = n;
        }
    }
}
