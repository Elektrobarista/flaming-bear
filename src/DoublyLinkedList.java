import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * Doubly linked list with Iterator usage.
 * Sheet 10 Exercise 2
 * @author Chrissi Sax, Nina Metzinger, Alexander Lind
 */
/**
 * Implementation of a doubly linked list.
 * 
 * @author Thomas Kemmer
 * @version 1.1 (2015-06-19)
 * 
 * @param <E>
 *            type of the list elements
 */
public class DoublyLinkedList<E> implements Iterable<E>{

	/**
	 * Internal representation of a single list element.
	 * 
	 * @author Thomas Kemmer
	 * @version 1.1 (2015-06-19)
	 */
	private class Node {
		private E val;
		private Node prev;
		private Node next;

		/**
		 * Sets all members.
		 * 
		 * @param val
		 *            value
		 * @param prev
		 *            previous node
		 * @param next
		 *            next node
		 */
		public Node(E val, Node prev, Node next) {
			this.val = val;
			this.prev = prev;
			this.next = next;
		}
	}

	// =======================================================
	// ==================== class members ====================
	// =======================================================
	
	private Node head;
	private Node tail;
	private int size;

	// ==========================================================
	// ==================== public interface ====================
	// ==========================================================
	
	/**
	 * Creates an empty list.
	 */
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return list size
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns whether the list is empty.
	 * 
	 * @return true iff list is empty
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Appends the given element to the list.
	 * 
	 * @param e
	 *            new element
	 * @return true
	 */
	public boolean add(E e) {

		if (this.isEmpty()) {
			this.tail = new Node(e, null, null);
			this.head = this.tail;
		} else {
			this.tail = new Node(e, this.tail, null);
			this.tail.prev.next = this.tail;
		}

		this.size++;
		return true;
	}

	/**
	 * Returns the list element at the given index.
	 * 
	 * @param index
	 *            element index
	 * @return list element
	 */
	public E get(int index) {
		return this.getNode(index).val;
	}

	/**
	 * Replaces the element at the given index. Returns the replaced element.
	 * 
	 * @param index
	 *            element index
	 * @param element
	 *            new element
	 * @return replaced element
	 */
	public E set(int index, E element) {

		Node current = this.getNode(index);

		E old = current.val;
		current.val = element;
		return old;
	}

	/**
	 * Adds a new element at the given index. Shifts existing elements to the
	 * right.
	 * 
	 * @param index
	 *            element index
	 * @param element
	 *            new element
	 */
	public void add(int index, E element) {
		if (this.isEmpty() || index == this.size()) {
			this.add(element);
			return;
		}

		this.add(this.getNode(index), element);
	}

	/**
	 * Removes and returns the element at the given index. Shifts following
	 * elements to the left.
	 * 
	 * @param index
	 *            element index
	 * @return removed element
	 */
	public E remove(int index) {
		Node e = this.getNode(index);
		this.remove(e);
		return e.val;
	}
	
	// ================================================================
	// ==================== private helper methods ====================
	// ================================================================
	
	/**
	 * Adds a new node right before the given one.
	 * 
	 * @param next
	 *            successor of the new node
	 * @param val
	 *            new element
	 */
	private void add(Node next, E val) {
		Node current = new Node(val, next.prev, next);
		next.prev = current;
		
		if (current.prev != null)
			current.prev.next = current;
		else
			this.head = current;
		
		this.size++;
	}

	/**
	 * Removes the given element. Shifts following elements to the left.
	 * 
	 * @param current
	 *            element to be removed
	 */
	private void remove(Node current) {

		if (current.prev != null)
			current.prev.next = current.next;
		else
			this.head = current.next;

		if (current.next != null)
			current.next.prev = current.prev;
		else
			this.tail = current.prev;

		this.size--;
	}

	/**
	 * Returns the node at the given index.
	 * 
	 * @param index
	 *            index of the node to return
	 * @return node at the given index
	 */
	private Node getNode(int index) {
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();

		Node current;

		// search forwards
		if (index < this.size() / 2) {
			current = this.head;
			for (int i = 0; i < index; i++)
				current = current.next;
			return current;
		}

		// search backwards
		current = this.tail;
		for (int i = 0; i < this.size() - index - 1; i++)
			current = current.prev;
		return current;
	}
	@Override
	public Iterator<E> iterator() {
		return new DLLIterator(head);
	}
	
	public Iterator<E> listIterator(){
		return new DLLIterator(head);
	}
	
	class DLLIterator implements ListIterator<E> {
		Node nextn;			// next element
		Node prevn;			// previous element	
		Node lastReturn;	// last element returned
		Node head;			// head-node of the binary tree
		int pos;			// current position of cursor
		/**
	     * Constructor. Setting position in front of first element.
	     * @param head head-element of the doubly linked list
	     */
		DLLIterator(Node head) {
			this.head = head;
			nextn = head;
			prevn = null;
			pos = 0;
		}
		/**
	     * Checks if there is an element left of the cursor.
	     * @return true if this element exists
	     */
		public boolean hasPrevious() {
			return (prevn != null);
		}
		/**
	     * Returns previous element and moves cursor one element to the left.
	     * @return previous element
	     * @throws NoSuchElementException
	     */
		public E previous() {
			if (prevn == null)
				throw new NoSuchElementException();
			E temp = prevn.val;
			lastReturn = prevn;
			nextn = prevn;
			prevn = nextn.prev;	
			return temp;
		}
		/**
	     * Returns index of next element or size if cursor at end of list.
	     * @return index of next element or size
	     */
		public int nextIndex() {
			if (nextn == null)
				return size;
			return pos;
		}
		/**
	     * Returns index of previous element or size if cursor at end of list.
	     * @return index of previous element or size
	     */
		public int previousIndex() {
			if (prevn == null)
				return size;
			return pos-1;
		}
		/**
	     * Sets value at last returned position.
	     * @param e new value
	     * @throws IllegalStateException if add or remove has already been called after last next/previous.
	     */
		public void set(E e) {
			if (lastReturn == null)
				throw new IllegalStateException();
			lastReturn.val = e;
		}
		/**
	     * Adds new value between previous and next element, behind cursor.
	     * @param e new value
	     */
		public void add(E e) {
			size++;
			pos++;
			Node temp = new Node(e,prevn,nextn);
			nextn.prev=temp;
			prevn.next=temp;
			prevn=temp;
			lastReturn = null;
		}
		/**
	     * Checks if there is an element right of the cursor.
	     * @return true if this element exists
	     */
		public boolean hasNext() {
			return (nextn != null);
		}
		/**
	     * Returns next element and moves cursor one element to the right.
	     * @return next element
	     * @throws NoSuchElementException
	     */
		public E next() {
			if (nextn == null)
				throw new NoSuchElementException();
			E temp = nextn.val;
			lastReturn = nextn;
			prevn = nextn;
			nextn = prevn.next;			
			return temp;
		}
		/**
	     * Removes value at last returned position.
	     * @throws IllegalStateException if add or remove has already been called after last next/previous.
	     */
		public void remove() {
			if (lastReturn == null)
				throw new IllegalStateException();
			size--;
			if (lastReturn == prevn) {
				pos--;
				DoublyLinkedList.this.remove(pos);
				prevn = prevn.prev;
			}
			if (lastReturn == nextn) {
				DoublyLinkedList.this.remove(pos);
				nextn = nextn.next;
			}
			lastReturn = null;
		}
	}
}
