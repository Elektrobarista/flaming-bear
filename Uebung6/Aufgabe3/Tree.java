
public class Tree<T extends Comparable<T>>{
	//first element is saved in root, the root has to children but no parent
	Node<T> root;
	
	
	//Returns true if could add a Node with element from type T 
	public boolean add(T element){
		//If root, the first Node of the tree, has no reference yet initilize with a new Node. 
		if (root == null){
			root = new Node<T>(element,null,null,null);
			return true;
		}
		
		Node<T> node = root;
		Node<T> parentNode = null;
		boolean tryToAdd = true;
		//Go threw the tree and tries to initlize a node containing element.
		while(tryToAdd == true){
			//If Actual Node points to null
			if (node == null){
				node = new Node<T>(element,null,null,parentNode);
				return true;
			}
			else{ 
				// element already exsisting in tree returns false because can not add an other node with the same element.
				if(node.getInfo().compareTo(element) == 0){
					return false;
					
				}
				//element is smaller than the one in the actual Node looking in the left child
				else if (element.compareTo(node.getInfo()) < 0){
						
						//adds node 
						if (node.getLeft() == null){
							
							node.setLeft(new Node<T>(element,null,null,node));
							return true;
							
						}
						//could not add node
						if (element.compareTo(node.getLeft().getInfo()) == 0){
							return false;
						}
						//looking in left child cause element smaller 
						else if (element.compareTo(node.getLeft().getInfo()) < 0){
							
							parentNode = node;
							node = node.getLeft();
							continue;
							
						}
						//looking in right child cause element bigger
						else if(element.compareTo(node.getLeft().getInfo()) > 0){
							
							parentNode = node;
							node = node.getRight();
							continue;
							
						}
				
						
				}
				//element bigger
				else if (element.compareTo(node.getInfo()) > 0){
				
					
						if (node.getRight() == null){
							
							node.setRight(new Node<T>(element,null,null,node));
							return true;
							
						}
						if (element.compareTo(node.getRight().getInfo()) == 0){
							return false;
						}
						else if (element.compareTo(node.getRight().getInfo()) < 0){
							
							parentNode = node;
							node = node.getLeft();
							continue;
							
						}
						else if(element.compareTo(node.getRight().getInfo()) > 0){
			
							parentNode = node;
							node = node.getRight();
							continue;
						}
				}
			}
		}
		return false;	
	}
	
	//returns smallest element of T saved in the tree (is inn the Node very left).
	public T getFirst(){
		if(root == null){
			return null;
		}
		else{
			Node<T> s = root;
			while(s.getLeft()!=null){
				s=s.getLeft();
			}
			return s.getInfo();
		}
	}
	
}

