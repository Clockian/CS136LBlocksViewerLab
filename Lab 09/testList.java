import java.util.List;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class testList<E> extends AbstractSequentialList<E> implements List<E>
{
    private Node<E> start;
    private int size = 0;
    private int modcount = 0;

    public int size() {
        return size;
    }

    public ListIterator<E> listIterator(int index) {
	//Are you trying to create an iterator that's not on the list?
        if(index < 0) {
	    // Probably should be an error
	}

	DoublyLinkedListIterator it = new DoublyLinkedListIterator();
	// Iterators are created at the beginning of the list by default.
	// It must be advanced to the index parameter by hand

	return it;
    }

    private class Node<E>
    {
	public Node<E> next;
	public Node<E> prev;
	public E data;

	public Node(E data)
	{
	    this.data = data;
	}
    }

    private class DoublyLinkedListIterator implements ListIterator<E>
    {
	private Node<E> inext;
	private Node<E> iprev;
	private Node<E> returned;
	private int index = 0;
	private int imodcount;

	public DoublyLinkedListIterator() {
	    inext = start;
	    iprev = null;
	    
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E previous() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(E e) {
		// TODO Auto-generated method stub
		
	}
    }


}