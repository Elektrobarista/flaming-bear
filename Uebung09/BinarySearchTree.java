import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Exercise 2 Sheet 9, Einfuehrung in die Softwareentwicklung, SS 2015
 * 
 * @author Chrissi Sax, Nina Metzinger, Alexander Lind
 */
public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {
	
	private int size = 0;			// Size of tree	
	private Node<E> head = null;	// Head of tree
	/**
	 * Returns the number of elements in the tree.
	 * @return size of tree
	 */
	public int size(){		
		return size;
	}
	/**
	 * Adds n element to the tree, if its value isn't already in the tree.
	 * 
	 * @param element, which should be inserted
	 */
	public void add(E element){
		if (head==null){
			head = new Node<E>(element);
			size++;
			return;
		}
		if (contains(element)){
			return;
		}
		size++;
		Node<E> target = head;
		while (target != null){
			if (element.compareTo(target.value) < 0){
				if (target.left == null){
					target.left = new Node<E>(element, target);
					return;
				}
				target = target.left;
			} else {
				if (target.right == null){
					target.right = new Node<E>(element, target);
					return;
				}
				target = target.right;
			}
		}
	}
	/**
	 * Checks, if element is in the tree.
	 * @param element to check
	 * @return true if element is in tree, else false
	 */
	public boolean contains(E element){
		if (head == null){
			return false;
		}
		Node<E> target = head;
		while (target != null){
			if (element.equals(target.value)){
				return true;
			}
			if (element.compareTo(target.value) < 0){
				target = target.left;
			} else {
				target = target.right;
			}
		}
		return false;
	}
	/**
	 * Returns the first element.
	 * @return first element of the tree
	 * @throws NoSuchElementException
	 */
	public E getFirst(){
		if (head==null){
			throw new NoSuchElementException();
		}
		Node<E> target = head;
		while (target.left != null){
			target = target.left;
		}
		return target.value;
	}
	/**
	 * Returns an iterator over elements of type E
	 * @return iterator
	 */
	public Iterator<E> iterator(){
		return new TreeIterator<E>(head);
	}
}

class Node<E extends Comparable<E>>{
	E value;		// value of Node
	Node<E> left;	// left and right children of the Node
	Node<E> right;
	Node<E> parent;	// parent of the Node
	/**
	 * Constructor
	 * @param v value assigned to Node
	 */
	Node(E v){
		this(v,null);
	}
	/**
	 * Constructor
	 * @param v value assigned to Node
	 * @param p	parent of Node
	 */
	public Node(E v, Node<E> p) {
		value = v;
		parent = p;
	}
}

class TreeIterator<E extends Comparable<E>> implements Iterator<E>{
	Node<E> target;	// next element
	Node<E> head;	// head Node of the tree
	/**
	 * Constructor
	 * @param head head node of the tree
	 */
	TreeIterator(Node<E> head) {
		this.head = head;
		target = head;
		if (target == null){
			return;
		}
		while (target.left != null){
			target = target.left;
		}
	}
	/**
	 * Checks if there are elements left in tree
	 * @return true, if there is at least one element left, false in the other cases 
	 */
	public boolean hasNext() {
		return (target != null);
	}
	/**
	 * Returns the next element and sets target to the new next element
	 * @return next element
	 * @throws NoSuchElementException
	 */
	public E next() {
		if (target == null){
			throw new NoSuchElementException();
		}
		E value = target.value;
		goToNext();
		return value;
	}
	/**
	 * Sets target to the next element in order
	 */
	private void goToNext(){
		if (target.right != null){
			target = target.right;
			while (target.left != null){
				target = target.left;
			}
		}
		while (target != head && target == (target.parent).right){
			target = target.parent;
		}
		if (target == head){
			target = null;
			return;
		}
		if (target == (target.parent).left){
			target = target.parent;
			return;
		}
	}	
}
