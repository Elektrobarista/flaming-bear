public class DoublyLinkedList<T> extends ListAdapter{
  private Node<T> head;
  private Node<T> tail;
  private int size=0;
  
  public int size(){
    return size;
  } 
  
  public boolean isEmpty(){
    return (size==0);
  }  
  
  public boolean contains(Node<T> o){
    Node<T> current=head;
    while (current.equals(tail)==false) { 
      if (current.equals(o)) {
        return true;
      }
      current=head.getNext(); 
    } 
    if (tail==o) {
      return true;
    }
    return false; 
  }
  
  ////
  public boolean add(T e){
    Node<T> newNode=new Node<T>(e);
    if (this.contains(newNode)) {
      return false;
    } 
    head.setPrevious(newNode);
    newNode.setNext(head);
    head=newNode;
    size=size+1;
    return true;
  }
  
  public  void clear(){
    head=null;
    tail=null;
    size=0;
  }  
  
  public T get(int index){
    //Da wir eine doppelt verkettete Liste haben können wir zunächst prüfen ob index näher an head oder tail liegt 
    //und dann den kürzen Weg zum Index wählen
    if (index >(size/2)){ 
      Node<T> current=head;
      for (int i=0;i<index;i++) {
        current=current.getNext();
      }
      return current.getValue();
    } else {
      Node<T> current=tail;
      for (int i=size;i>index;i++) {
        current=current.getPrevious();
      }
      return current.getValue();
    } 
  }  
  
  ////
  public T set(int index, T element){
    Node<T> current=head;
    for (int i=index;i>0;i--) {
      current=current.getNext();
    }
    T previous=current.getValue();
    current.setValue(element);
    return previous;
  }  
  
  ////
  public void add(int index, T element){
    Node<T> current=head;
    for (int i=index;i>0;i--) {
      current=current.getNext();
    }
    Node<T> newNode=new Node<T>(element);
    current.getNext().setPrevious(newNode);
    current.setNext(newNode);
    size=size+1;
  }
  
  public T remove(int index){
    Node<T> current=head;
    for (int i=index;i>1;i--) {
      current=current.getNext();
    }
    T previous=current.getNext().getValue();
    current.setNext(current.getNext().getNext());
    current.getNext().setPrevious(current);
    size=size-1;
    return previous; 
  }  
}