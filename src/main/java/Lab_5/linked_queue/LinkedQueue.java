package Lab_5.linked_queue;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 *
 * @param <T> a generic parameter
 */

public class LinkedQueue<T> implements Queue<T> {
    static class Node<T> {
        private Node<T> previous;
        private Node<T> next;
        private T value;

        public Node(Node<T> previous, T value, Node<T> next) {
            setPrevious(previous);
            this.value = value;
            setNext(next);
        }

        public Node(Node<T> previous, T value) {
            this(previous, value, null);
        }

        public Node(T value, Node<T> next) {
            this(null, value, next);
        }

        public Node(T value) {
            this(null, value, null);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        /**
         * Sets previous node for the called one while also setting the next for the previous one.
         * @param previous
         */
        public void setPrevious(Node<T> previous) {
            this.previous = previous;
            if (previous != null) {
                previous.next = this;
            }
        }

        public Node<T> getNext() {
            return next;
        }

        /**
         * Sets next node for the called one while also setting the previous for the next one.
         * @param next
         */
        public void setNext(Node<T> next) {
            this.next = next;
            if (next != null) {
                next.previous = this;
            }
        }

        /**
         * Removes references to this node from the neighboured ones thus allowing JVM to free up memory faster.
         * @return value stored in unlinked node
         */
        public T unlink() {
            if (this.previous != null) {
                this.previous.setNext(this.next);
            }
            if (this.next != null) {
                this.next.setPrevious(this.previous);
            }
            this.previous = null;
            this.next = null;
            return this.value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    @Override
    public void add(T element) {
        if (size == 0) {
            this.tail = this.head = new Node<>(element);
        } else {
            this.tail = new Node<>(this.tail, element);
        }
        this.size++;
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    @Override
    public T poll() {
        T value;
        if (this.head != null) {
            Node<T> selected = this.head;
            this.head = selected.getNext();
            value = selected.unlink();
            this.size--;
        } else {
            value = null;
        }
        return value;
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
