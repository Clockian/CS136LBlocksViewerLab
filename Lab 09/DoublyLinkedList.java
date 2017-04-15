import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> extends AbstractSequentialList<E> implements List<E>{

	private Node<E> firstNode;
	private Node<E> lastNode;
	private int size = 0;
	
	//private int modificationCount = 0;
	
	private class Node<E>{
		public Node<E> previous;
		public Node<E> next;
		public E data;
		
		/**
		 * Default Constructor to create a node
		 * @param data - The data to be stored in the node
		 */
		public Node(Node<E> previous, Node<E> next, E data){
			this.previous = previous;
			this.next = next;
			this.data = data;
		}

		public void setPrevious(Node<E> previous) {
			this.previous = previous;
		}
		
		public Node<E> getPrevious(){
			return this.previous;
		}
		
		public void setNext(Node<E> Next) {
			this.next = next;
		}
		
		public Node<E> getNext(){
			return this.next;
		}
		
		//public void setData(E data) {
		//	this.data = data;
		//}
		
		public E getData(){
			return this.data;
		}
	}
	/*
	private class DoublyLinkedListIterator implements ListIterator<E>{
		private Node<E> iNext;
		private Node<E> iPrev;
		private Node<E> returned;
		private int index = 0;
		private int iModificationsCount;
		
		public DoublyLinkedListIterator(){
			index = 0;
			iNext = firstNode;
		}
		
		public DoublyLinkedListIterator(int num){
			//index = num;
			//iNext = firstNode;
		}
		
		@Override
		public boolean hasNext() {
			if(iNext == null){
				return false;
			}
			iPrev = iNext;
			iNext = iNext.getNext();
			return true;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
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
		public void add(E data) {
			//if(size == 0){
			//	Node<E> temp = new Node<>(data);
			//	firstNode = temp; 
			//	iNext = firstNode;
			//	iPrev = null;
			//}
			
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}	
	}*/
	
	/**
	 * Default constructor for a LinkedList
	 */
	public DoublyLinkedList(){
		size = 0;
		firstNode = null;
		lastNode = null;
	}

	/**
	 * @return The number of elements in this list.
	 */
	@Override
	public int size() {
		return size;
	}
	



	@Override
	public ListIterator<E> listIterator(int index) {
		/*if(index < 0){
			throw new IndexOutOfBoundsException();
		}

		DoublyLinkedListIterator it = new DoublyLinkedListIterator();
		// Iterators are created at the beginning of the list by default.
		// It must be advanced to the index parameter by hand
		int actualIndex = 0;
		int actualIndex1 = 0;
		for(int ii = 0; ii < index; ii++){
			actualIndex1++;
			if(it.hasNext()){
				actualIndex++;
			}
		}
		System.out.println("actual: " + actualIndex + "  control: " + actualIndex1);
		
		if(actualIndex == index){
			return it;
		}
		else{
			throw new IndexOutOfBoundsException();
		}*/
		return null;
	}
	
	/**
	 * Returns the element at the specified position in this list.
	 * Throws an IndexOutOfBoundsException when index is out of range.
	 * @param index - Location of node to get data from
	 * @return The element at the specified position
	 */
	@Override
	public E get(int index) {
		if(index < 0 || size == 0){
			throw new IndexOutOfBoundsException();
		}
		Node<E> current = this.getFirstNode();
		for(int ii = 0; ii != index; ii++){
			current = current.getNext();
		}
		return current.getData();
	}
	
	public DoublyLinkedList<E>.Node<E> getFirstNode() {
		return firstNode;
	}
	
	@Override
	public void add(int index, E data) {
		// If invalid index entry
				if(index < 0){
					throw new IndexOutOfBoundsException();
				}
				
				// Starting a new list 
				else if(size == 0){
					// At the beginning
					if(index == 0){
						firstNode = new Node<>(null, null, data);
						size++;
						System.out.println("Working? 1");
					}
					
					// The second spot
					else if(index == 1){
						firstNode = new Node<>(null, null, null);
						lastNode = new Node<>(firstNode, null, data);
						firstNode.setNext(lastNode);
						size++;
						size++;
					}
					
					// Beyond
					else{
						firstNode = new Node<>(null, null, null);
						lastNode = new Node<>(firstNode, null, null);
						firstNode.setNext(lastNode);
						size++;
						size++;
						// Make empty nodes till you get to the desired index
						for(int ii = size; ii < index; ii++){
							Node<E> newNode = new Node<>(lastNode, null, null);
							lastNode.setNext(newNode);
							lastNode = newNode;
							size++;
						}
						// Loop ends at index to insert object
						Node<E> newNode = new Node<>(lastNode, null, data);
						lastNode.setNext(newNode);
						lastNode = newNode;
						size++;
					}
				}
				
				// If new item is to be put at the end of the list
				else if(size == index){
					// If there is only the head
					if(size == 1){
						lastNode = new Node<>(firstNode, null, data);
						firstNode.setNext(lastNode);
						size++;
						System.out.println("Working? 2");
					}
					// Otherwise, add at end of the list
					else{			
						Node<E> newNode = new Node<>(lastNode, null, data);
						lastNode.setNext(newNode);
						lastNode = newNode;
						size++;
						System.out.println("Working? 3");
					}
				}
				
				// If new item is to be put in slot bigger than already created list
				else if(size < index){
					// If there is only the head
					if(size == 1){
						lastNode = new Node<>(firstNode, null, null);
						firstNode.setNext(lastNode);
						size++;
					}
					
					// Make empty nodes till you get to the desired index
					for(int ii = size; ii < index; ii++){
						Node<E> newNode = new Node<>(lastNode, null, null);
						lastNode.setNext(newNode);
						lastNode = newNode;
						size++;
					}
					// Loop ends at index to insert object
					Node<E> newNode = new Node<>(lastNode, null, data);
					lastNode.setNext(newNode);
					lastNode = newNode;
					size++;
				}
				
				// Adding inside of list(push all numbers back, append to location)
				else if(size > index){
					// If appending to head with no tail
					if(index == 0 && size == 1){
						Node<E> newNode = new Node<>(null, firstNode, data);
						firstNode.setPrevious(newNode);
						lastNode = firstNode;
						firstNode = newNode;
						size++;
					}
					// If appending to head
					else if(index == 0){
						Node<E> newNode = new Node<>(null, firstNode, data);
						firstNode.setPrevious(newNode);
						firstNode = newNode;
						size++;
					}
					// If appending in body
					else{
						// Find node, when found, add the node
						Node<E> current = firstNode.getNext();
						for(int ii = 1; ii < size; ii++){
							if(ii == index){
								Node<E> newNode = new Node<>(current.getPrevious(), current, data);
								current.previous.setNext(newNode);
								current.setPrevious(newNode);
								size++;
								break;
							}
							else{
								current = current.getNext();
							}
						}
					}
				}
				
				else{
					System.out.println("Something went wrong in adding to array!");
				}
	}
}
