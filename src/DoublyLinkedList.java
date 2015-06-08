/**
 * DoublyLinkedList Sheet 07
 * @author Alex, Nina, Christel
 */

public class DoublyLinkedList<E> {
	private Element<E> head;
	private Element<E> tail;
	private int size=0;
	
	  //returns size of list
	  public int size(){
	    return size;
	  } 
	  /**
	   * adding an element at the end of the list 
	   * @param value value of element to add
	   */
	  public void add(E value){
	    Element<E> newElement=new Element<E>(value);
	    head.setPrevious(newElement);
	    newElement.setNext(head);
	    head=newElement;
	    size=size+1;
	  }  
	  /**
	   * returns value of element at index
	   * @param index positin of element
	   * @return returns value at index
	   */
	  public E get(int index){
		if(index>size-1 || index < 0)
			throw new IndexOutOfBoundsException();
	    if (index >(size/2)){ 
	      Element<E> current=head;
	      for (int i=0;i<index;i++) {
	        current=current.getNext();
	      }
	      return current.getValue();
	    } else {
	      Element<E> current=tail;
	      for (int i=size;i>index;i++) {
	        current=current.getPrevious();
	      }
	      return current.getValue();
	    } 
	  }  
	  
	  /**
	   * setting new value at indexposition an returning old value
	   * @param index position of element
	   * @param value value of new element
	   * @return old value
	   */
	  public E set(int index, E value){
		if(index>size-1 || index < 0)
			throw new IndexOutOfBoundsException();
	    Element<E> current=head;
	    for (int i=index;i>0;i--) {
	      current=current.getNext();
	    }
	    E previous=current.getValue();
	    current.setValue(value);
	    return previous;
	  }  
	  
	  /**
	   * adding new element at indexposition
	   * @param index position of new element
	   * @param element element to add
	   */
	  public void add(int index, E element){
		if(index>size-1 || index < 0)
			throw new IndexOutOfBoundsException();
	    Element<E> current=head;
	    for (int i=index;i>0;i--) {
	      current=current.getNext();
	    }
	    Element<E> newElement=new Element<E>(element);
	    current.getNext().setPrevious(newElement);
	    current.setNext(newElement);
	    size=size+1;
	  }
	  /**
	   * delete elemnt at index and returns value of old element
	   * @param index position of element to delete
	   * @return value of old element
	   */
	  public E remove(int index){
		if(index>size-1 || index < 0)
			throw new IndexOutOfBoundsException();
	    Element<E> current=head;
	    for (int i=index;i>1;i--) {
	      current=current.getNext();
	    }
	    E previous=current.getNext().getValue();
	    current.setNext(current.getNext().getNext());
	    current.getNext().setPrevious(current);
	    size=size-1;
	    return previous; 
	  }
	  
   @SuppressWarnings("hiding")
 /**
  * Class to organize en element
  * @author Alex,Nina,Christel
  */
private class Element<E>{
		  private E value; 
		  private Element<E> previous;
		  private Element<E> next;
		  
		  /**
		   * stores value of element in constructor
		   * @param value
		   */
		  public Element (E value) {
		    this.value=value;
		  }
		  
		  /**
		   * sets previos element
		   * @param previous
		   */
		  public void setPrevious (Element<E> previous){
		    this.previous=previous;
		  }
		  /**
		   * sets next element
		   * @param next
		   */
		  public void setNext (Element<E> next){
		    this.next=next;
		  }
		  /**
		   * sets value of element
		   * @param value
		   */
		  public void setValue(E value){
		    this.value=value;
		  }  
		  /**
		   * returns value of element
		   * @return
		   */
		  public E getValue(){
		    return value;
		  }
		  /**
		   * returns previos element
		   * @return
		   */
		  public Element<E> getPrevious(){
		    return previous;
		  }
		  /**
		   * returns next element
		   * @return
		   */
		  public Element<E> getNext(){
		    return next;
		  }  
}

}
   
