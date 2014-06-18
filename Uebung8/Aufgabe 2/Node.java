public class Node<T>{
  private T value; 
  private Node<T> previous;
  private Node<T> next;
  
  public Node (T value) {
    this.value=value;
  }
  
  public void setPrevious (Node<T> previous){
    this.previous=previous;
  }  
  public void setNext (Node<T> next){
    this.next=next;
  }  
  public void setValue(T value){
    this.value=value;
  }  
  
  public T getValue(){
    return value;
  }  
  public Node<T> getPrevious(){
    return previous;
  }  
  public Node<T> getNext(){
    return next;
  }  
}