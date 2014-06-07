
public class Main {
	public static void main(String[]args){
		Tree<Integer> intTree = new Tree<Integer>();
		
		intTree.add(25);
		intTree.add(4);
		intTree.add(3);
		intTree.add(31);
		intTree.add(9);
		intTree.add(2);
		intTree.add(44);
		System.out.println("First:"+intTree.getFirst());
		System.out.println("Root:"+intTree.root.getLeft().getLeft().getLeft().getNext());
	}
}
