/*
 * Created by Jasque Saydyk and Caley Halpern
 * Lab 09 - Doubly Linked List
 * CS 136L
 * 18 April 2017
 * Description - This class performs a JUnit test on the DoublyLinkedList class
 * incomplete and doesn't fulfill all requirements
*/
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

	@Test
    public void readFirstElement() {
	    DoublyLinkedList<Integer> test3 = new DoublyLinkedList<>();
	    test3.add(1);
	    Integer number1 = 1;
	    Assert.assertEquals(number1, test3.get(0));
    }
    @Test
    public void moveThroughoutList() {
	    DoublyLinkedList<Integer> test4 = new DoublyLinkedList<>();
	    ListIterator<Integer> iter = test4.listIterator();
	    iter.next();
	    iter.next();
	    iter.previous();
    }
    @Test
    public void addArbitraryElements() {
	    DoublyLinkedList<Integer> test5 = new DoublyLinkedList<>();

    }
    @Test
    public void readArbitraryElements() {
        DoublyLinkedList<Integer> test6 = new DoublyLinkedList<>();

    }
    @Test
    public void removeElements() {
        DoublyLinkedList<Integer> test7 = new DoublyLinkedList<>();
        // test7.remove(0);
        // assertEquals("The element at index zero should be removed.");
    }
    @Test
    public void replaceValues() {
        DoublyLinkedList<String> test8 = new DoublyLinkedList<>();
        test8.set(0, "New");
    }
    @Test
    public void DetBeginningOrEnd() {
        DoublyLinkedList<Integer> test9 = new DoublyLinkedList<>();
        test9.add(0, 1);
        test9.add(1, 8);
        test9.add(2,5);
        test9.add(3, 7);
        test9.add(4, 2);
        test9.add(5, 9);
        ListIterator<Integer> iter = test9.listIterator();
        Assert.assertEquals(0,0);
    }
    @Test
    public void DetCurrentIndex() {
        DoublyLinkedList<Integer> test10 = new DoublyLinkedList<>();

    }
    @Test
    public void RetrieveIteratorObjects() {
        DoublyLinkedList<Integer> test11 = new DoublyLinkedList<>();

    }
    @Test
    public void RetrieveListSize() {
        DoublyLinkedList<Integer> test12 = new DoublyLinkedList<>();

    }
    @Test
    public void addAllTest() {
        DoublyLinkedList<Integer> test13 = new DoublyLinkedList<>();

    }
    @Test
    public void readByIndex() {
        DoublyLinkedList<Integer> test14 = new DoublyLinkedList<>();

    }
    @Test
    public void removeByIndex() {
        DoublyLinkedList<Integer> test15 = new DoublyLinkedList<>();

    }
    @Test
    public void addByIndex() {
        DoublyLinkedList<Integer> test16 = new DoublyLinkedList<>();

    }
    @Test
    public void replaceByIndex() {
        DoublyLinkedList<Integer> test17 = new DoublyLinkedList<>();

    }
    @Test
    public void outOfBounds() {
        DoublyLinkedList<Integer> test18 = new DoublyLinkedList<>();

    }
}