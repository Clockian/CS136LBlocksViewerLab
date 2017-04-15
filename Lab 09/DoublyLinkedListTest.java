import java.util.ListIterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {
	DoublyLinkedList<Integer> test;
	
	@Before
	public void setup(){
		test = new DoublyLinkedList<>();
	}
	/*
	@Test
	public void testInitialization(){
		
	}
	
	@Test
	public void retrieveDefaultIteratorObject(){
		ListIterator<Integer> iter = test.listIterator();
		Assert.assertNotEquals(iter, null);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void retrieveCustomIteratorObjectThrowsOutOfBoundsException(){
		ListIterator<Integer> iter = test.listIterator(4);
	}
	*/
	@Test
	public void retrieveCustomIteratorObject(){
		DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
		
		System.out.println("\nRetrieveCustomIteratorObject");
		for(Integer ii = 0; ii < 6; ii++){
			System.out.println("add(ii): " + ii);
			test1.add(ii, ii);
		}
		
		System.out.println();
		for(Integer ii = 0; ii < 6; ii++){
			System.out.print("Pre result: " + test1.get(ii) + ", ");
		}
		
		ListIterator<Integer> iter = test1.listIterator(4);
		
		System.out.println();
		for(Integer ii = 0; ii < 6; ii++){
			System.out.print("Post result: " + test1.get(ii) + ", ");
		}
		
		System.out.println("\n");
		//Integer answer = 4;
		//Assert.assertEquals(answer, test.next());
	}
	/*
	@Test
	public void addToEmptyList(){
		DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
		ListIterator<Integer> iter = test1.listIterator();
		iter.add(55);
		Integer answer = 55;
		Assert.assertEquals(answer, test1.get(0));
	}*/
}
