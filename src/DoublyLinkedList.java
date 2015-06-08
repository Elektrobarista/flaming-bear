public class DoublyLinkedList<E> {
	private Element<E> head;
	private Element<E> tail;
	private int size=0;
	  
	  public int size(){
	    return size;
	  } 
	  
	  public boolean isEmpty(){
	    return (size==0);
	  }  
	  
	  public void add(E value){
	    Element<E> newElement=new Element<E>(value);
	    head.setPrevious(newElement);
	    newElement.setNext(head);
	    head=newElement;
	    size=size+1;
	  }
	  
	  public  void clear(){
	    head=null;
	    tail=null;
	    size=0;
	  }  
	  
	  public E get(int index){
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
	  
	  
	  public E set(int index, E value){
	    Element<E> current=head;
	    for (int i=index;i>0;i--) {
	      current=current.getNext();
	    }
	    E previous=current.getValue();
	    current.setValue(value);
	    return previous;
	  }  
	  
	  
	  public void add(int index, E element){
	    Element<E> current=head;
	    for (int i=index;i>0;i--) {
	      current=current.getNext();
	    }
	    Element<E> newElement=new Element<E>(element);
	    current.getNext().setPrevious(newElement);
	    current.setNext(newElement);
	    size=size+1;
	  }
	  
	  public E remove(int index){
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
private class Element<E>{
		  private E value; 
		  private Element<E> previous;
		  private Element<E> next;
		  
		  public Element (E value) {
		    this.value=value;
		  }
		  
		  public void setPrevious (Element<E> previous){
		    this.previous=previous;
		  }  
		  public void setNext (Element<E> next){
		    this.next=next;
		  }  
		  public void setValue(E value){
		    this.value=value;
		  }  
		  
		  public E getValue(){
		    return value;
		  }  
		  public Element<E> getPrevious(){
		    return previous;
		  }  
		  public Element<E> getNext(){
		    return next;
		  }  
}

}
   
