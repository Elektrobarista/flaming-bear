import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Exercise 1 Sheet 9, Einfuehrung in die Softwareentwicklung, SS 2015
 * 
 *	@author Chrissi Sax, Nina Metzinger, Alexander Lind
 */

public class ComparingLists {

	public static void main(String[] args) {
		
		long start;		// saves start time
		long stop;		// saves stop time
		long diff;		// saves the difference of stop and start time
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		LinkedList<Integer> lin = new LinkedList<Integer>();
		
		// stopping time for adding Elements at the end of the two list types
		// Array List
		System.out.println("a)");
		start = System.currentTimeMillis();
		for (int i=0; i<100000; i++){
			arr.add(i);
		}
		stop = System.currentTimeMillis();
		diff = stop - start;
		System.out.println("Zeit fuer das Hinzufuegen von 100000 Elementen an das Ende einer Array List: "+ diff);
		
		// Linked List
		start = System.currentTimeMillis();
		for (int i=0; i<100000; i++){
			lin.addLast(i);
		}
		stop = System.currentTimeMillis();
		diff = stop - start;
		System.out.println("Zeit fuer das Hinzufuegen von 100000 Elementen an das Ende einer Linked List: "+ diff);
		
		// stopping time for removing Elements at the end of the two list types 
		// Array List
		start = System.currentTimeMillis();
		for (int i=99999; i>=0; i--){
			arr.remove(i);
		}
		stop = System.currentTimeMillis();
		diff = stop - start;
		System.out.println("Zeit fuer das Entfernen von 100000 Elementen an das Ende einer Array List: "+ diff);
		
		// Linked List
		start = System.currentTimeMillis();
		for (int i=0; i<100000; i++){
			lin.removeLast();
		}
		stop = System.currentTimeMillis();
		diff = stop - start;
		System.out.println("Zeit fuer das Entfernen von 100000 Elementen an das Ende einer Linked List: "+ diff);
		
		// stopping time for adding Elements at the head of the two list types
		// Array List
		System.out.println("b)");
		start = System.currentTimeMillis();
		for (int i=0; i<100000; i++){
			arr.add(0,i);
		}
		stop = System.currentTimeMillis();
		diff = stop - start;
		System.out.println("Zeit fuer das Hinzufuegen von 100000 Elementen an den Anfang einer Array List: "+ diff);
		
		// Linked List
		start = System.currentTimeMillis();
		for (int i=0; i<100000; i++){
			lin.addFirst(i);
		}
		stop = System.currentTimeMillis();
		diff = stop - start;
		System.out.println("Zeit fuer das Hinzufuegen von 100000 Elementen an den Anfang einer Linked List: "+ diff);
		
		// stopping time for removing Elements at the head of the two list types 
		// Array List
		start = System.currentTimeMillis();
		for (int i=0; i<100000; i++){
			arr.remove(0);
		}
		stop = System.currentTimeMillis();
		diff = stop - start;
		System.out.println("Zeit fuer das Entfernen von 100000 Elementen an den Anfang einer Array List: "+ diff);
		
		// Linked List
		start = System.currentTimeMillis();
		for (int i=0; i<100000; i++){
			lin.removeFirst();
		}
		stop = System.currentTimeMillis();
		diff = stop - start;
		System.out.println("Zeit fuer das Entfernen von 100000 Elementen an den Anfang einer Linked List: "+ diff);
		
		// add Elements at the end of the two list types
		System.out.println("c)");
		for (int i=0; i<100000; i++){
			arr.add(i);
		}
		for (int i=0; i<100000; i++){
			lin.addLast(i);
		}
		
		// Stopping time for reading an entry for 100000 elements
		// Array List
		start = System.currentTimeMillis();
		for (int i=1; i<100000; i++){
			arr.get(i);
		}
		stop = System.currentTimeMillis();
		diff = stop - start;
		System.out.println("Zeit fuer das Auslesen von 100000 Elementen mittels get-Methode einer Array List: "+ diff);
		
		// Linked List
		start = System.currentTimeMillis();
		for (int i=0; i<100000; i++){
			lin.get(i);
		}
		stop = System.currentTimeMillis();
		diff = stop - start;
		System.out.println("Zeit fuer das Auslesen von 100000 Elementen mittels get-Methode einer Linked List: "+ diff);
	}
}