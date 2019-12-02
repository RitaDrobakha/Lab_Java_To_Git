package Lab_5.linked_list;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}. In order to keep track on nodes, {@link LinkedList} keeps a reference to a head node.
 *
 * @param <T> generic type parameter
 */
public class LinkedList<T> implements List<T> {
    static class Node<T> {
        private Node<T> previous;
        private Node<T> next;
        private T value;

        public Node() {
            this.previous = null;
            this.value = null;
            this.next = null;
        }

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
    private int size;

    public LinkedList() {
        this.size = 0;
        this.head = null;
    }

    public LinkedList(Node<T> head, Integer size) {
        this.head = head;
        this.size = size;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> selected = this.head;
            for (int i = 0; i < index; i++) {
                selected = selected.getNext();
            }
            return selected;
        }
    }

    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> List<T> of(T... elements) {
        Node<T> last = null;
        if (elements.length > 0) {
            for (T element : elements) {
                last = new Node<>(last, element);
            }
            while (last.getPrevious() != null) { // Return back to first node
                last = last.getPrevious();
            }
        }
        return new LinkedList<>(last, elements.length);
    }

    /**
     * Adds an element to the end of the list
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if (this.head != null) {
            new Node<>(getNode(this.size - 1), element);
        } else {
            this.head = new Node<>(element);
        }
        this.size++;
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if (index > this.size  || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0 ) {
            this.head = new Node<>(element, this.head);
        } else if (index == this.size) {
            new Node<>(getNode(index - 1 ), element);
        } else {
            Node<T> selected = getNode(index);
            new Node<>(selected.getPrevious(), element, selected);
        }
        this.size++;
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        getNode(index).setValue(element);
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        Node<T> selected = getNode(index);
        if (selected == null) {
            throw new IndexOutOfBoundsException();
        }
        return selected.getValue();
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     */
    @Override
    public void remove(int index) {
        Node<T> selected = getNode(index);
        if (selected == this.head) {
            this.head = this.head.getNext();
        }
        selected.unlink();
        this.size--;
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        Node<T> selected = this.head;
        while (selected != null) {
            if (selected.getValue().equals(element)) {
                return true;
            }
            selected = selected.getNext();
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }
}
