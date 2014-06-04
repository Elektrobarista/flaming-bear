public class Node<T> {
	private T info;
	private Node<T> left;
	private Node<T> right;
	private Node<T> parent;
	
	Node(T i, Node<T> l, Node<T> r, Node<T> p) {
		this.info = i;
		this.left = l;
		this.right = r;
		this.parent = p;
	}
	
	public T getInfo(){
		return this.info;
	}
	
	public Node<T> getLeft(){
		return this.left;
	}
	
	public Node<T> getRight(){
		return this.right;
	}
	
	public Node<T> getParent(){
		return this.parent;
	}
	
	public void setInfo(T i){
		this.info = i;
	}
	
	public void setLeft(Node<T> l){
		this.left = l;
	}
	
	public void setRight(Node<T> r){
		this.right = r;
	}
	
	public void setParent(Node<T> p){
		this.parent = p;
	}
	
	//gibt das nächst größere Element aus
	public T getNext(){
		if(right == null){
			if (parent == null ){
				return null;
			}
			return parent.getInfo();
		}
		return right.getInfo();
	}
	
}
 