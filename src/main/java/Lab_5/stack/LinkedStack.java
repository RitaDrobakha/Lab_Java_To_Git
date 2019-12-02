package Lab_5.stack;

public class LinkedStack<T> implements Stack<T> {
	static class Node<T> {
		private Node<T> previous;
		private T value;

		public Node() {
			this.previous = null;
			this.value = null;
		}

		public Node(Node<T> previous, T value, Node<T> next) {
			setPrevious(previous);
			this.value = value;
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
		}


		/**
		 * Sets next node for the called one while also setting the previous for the next one.
		 * @param next
		 */
		public void setNext(Node<T> next) {
			if (next != null) {
				next.previous = this;
			}
		}

		/**
		 * Removes references to this node from the neighboured ones thus allowing JVM to free up memory faster.
		 * @return value stored in unlinked node
		 */
		public T unlink() {
			this.previous = null;
			return this.value;
		}
	}

	private Node<T> tail;
	private int size;

	public LinkedStack() {
		this.tail = null;
		this.size = 0;
	}

	@Override
	public void push(T element) {
		this.tail = new Node<>(this.tail, element);
		this.size++;
	}

	@Override
	public T pop() {
		if (this.size > 0) {
			T value = this.tail.getValue();
			this.tail = this.tail.getPrevious();
			this.size--;
			return value;
		} else {
			throw new EmptyStackException();
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
}
