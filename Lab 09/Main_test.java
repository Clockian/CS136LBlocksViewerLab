/*
 * Created by Jasque Saydyk and Caley Halpern
 * Lab 09 - Doubly Linked List
 * CS 136L
 * 18 April 2017
 * Description - This class is an ad hoc testing environment for the
 * DoublyLinkedList class. Performs some tests the JUnit testing 
 * environment fails to test, but is generally ugly and off the cuff.
*/
import java.util.ListIterator;

public class Main_test {
	public static void main (String[] args){
		DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
		
		System.out.println("\nTesting DoublyLinkedList2 object");
		int jj = 0;
		for(Integer ii = 0; ii < 6; ii++, jj++){
			System.out.println("add(ii): " + ii);
			test1.add(jj, ii);
		}
		
		System.out.println();
		for(int ii = 0; ii < 6; ii++){
			System.out.print("Pre result: " + test1.get(ii) + ", ");
		}
				
		System.out.println();
		for(Integer ii = 0; ii < 6; ii++){
			System.out.print("Post result: " + test1.get(ii) + ", ");
		}
		
		System.out.println("\n\nTesting DoublyLinkedListIterator\n");
		
		ListIterator<Integer> iter = test1.listIterator();

		System.out.println("     hasNext() - return true: " + iter.hasNext());
		System.out.println("hasPrevious() - return false: " + iter.hasPrevious());
		
		System.out.println("previous() - return null: " + iter.previous());
		System.out.println("       next() - return 1: " + iter.next());
		System.out.println("       next() - return 2: " + iter.next());
		System.out.println("       next() - return 3: " + iter.next());
		System.out.println("       next() - return 4: " + iter.next());
		System.out.println("       next() - return 5: " + iter.next());
		System.out.println("    next() - return null: " + iter.next());
		
		System.out.println("   previous() - return 3: " + iter.previous());
		System.out.println("   previous() - return 2: " + iter.previous());
		
		System.out.println("remove() - removing 2: ");
		iter.remove();
		
		System.out.println("       next() - return 4: " + iter.next());
		System.out.println("       next() - return 5: " + iter.next());
		System.out.println("   previous() - return 3: " + iter.previous());
		System.out.println("   previous() - return 1: " + iter.previous());
		System.out.println("   previous() - return 0: " + iter.previous());
		System.out.println("previous() - return null: " + iter.previous());
		
		System.out.println("       next() - return 3: " + iter.next());
		System.out.println("set() - 3 to 2: ");
		iter.set(2);
		System.out.println("       next() - return 4: " + iter.next());
		System.out.println("       next() - return 5: " + iter.next());
		System.out.println("   previous() - return 2: " + iter.previous());
		System.out.println("   previous() - return 1: " + iter.previous());
		System.out.println("   previous() - return 0: " + iter.previous());
		
		System.out.println("\n\nTesting DoublyLinkedListIterator with custom constructor\n");
		
		DoublyLinkedList<Integer> test2 = new DoublyLinkedList<>();
		jj = 0;
		for(Integer ii = 0; ii < 6; ii++, jj++){
			System.out.println("add(ii): " + ii);
			test1.add(jj, ii);
		}
		
		ListIterator<Integer> iter2 = test2.listIterator(2);
		
		System.out.println("    hasNext() - return true: " + iter2.hasNext());
		System.out.println("hasPrevious() - return true: " + iter2.hasPrevious());
		
		System.out.println("    next() - return 3: " + iter2.next());
		System.out.println("    next() - return 4: " + iter2.next());
		System.out.println("previous() - return 2: " + iter2.previous());
		System.out.println("previous() - return 1: " + iter2.previous());
		System.out.println("previous() - return 0: " + iter2.previous());
	}
}
