/*
 * Created by Jasque Saydyk and Caley Halpern
 * Lab 09 - Doubly Linked List
 * CS 136L
 * 18 April 2017
 * Description - This class creates a doubly linked list
*/
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

public class DoublyLinkedList<T> extends AbstractSequentialList<T> implements List<T>{//  {
	
	private INode<T> head;
	private INode<T> tail;
	private int size;
	
	
	/**
	 * Default constructor for a LinkedList
	 */
	public DoublyLinkedList(){
		size = 0;
		head = null;
		tail = null;
	}
	
	
	 /** 
	  * Appends the specified element at the given index.  The index of all
      * elements at index or later is increased.
      * Throws an IndexOutOfBoundsException when index is out of range.
      * @param e - The data to be stored in the node
      * @param index - The index in the list for the data to be stored
      */
	@Override
	public void add(int index, T e) {
		// If invalid index entry
		if(index < 0){
			throw new IndexOutOfBoundsException();
		}
		
		// Starting a new list 
		else if(size == 0){
			// At the beginning
			if(index == 0){
				head = new INode<>(null, null, e);
				size++;
			}
			
			// The second spot
			else if(index == 1){
				head = new INode<>(null, null, null);
				tail = new INode<>(head, null, e);
				head.setNext(tail);
				size++;
				size++;
			}
			
			// Beyond
			else{
				head = new INode<>(null, null, null);
				tail = new INode<>(head, null, null);
				head.setNext(tail);
				size++;
				size++;
				// Make empty nodes till you get to the desired index
				for(int ii = size; ii < index; ii++){
					INode<T> newNode = new INode<>(tail, null, null);
					tail.setNext(newNode);
					tail = newNode;
					size++;
				}
				// Loop ends at index to insert object
				INode<T> newNode = new INode<>(tail, null, e);
				tail.setNext(newNode);
				tail = newNode;
				size++;
			}
		}
		
		// If new item is to be put at the end of the list
		else if(size == index){
			// If there is only the head
			if(size == 1){
				tail = new INode<>(head, null, e);
				head.setNext(tail);
				size++;
			}
			// Otherwise, add at end of the list
			else{			
				INode<T> newNode = new INode<>(tail, null, e);
				tail.setNext(newNode);
				tail = newNode;
				size++;
			}
		}
		
		// If new item is to be put in slot bigger than already created list
		else if(size < index){
			// If there is only the head
			if(size == 1){
				tail = new INode<>(head, null, null);
				head.setNext(tail);
				size++;
			}
			
			// Make empty nodes till you get to the desired index
			for(int ii = size; ii < index; ii++){
				INode<T> newNode = new INode<>(tail, null, null);
				tail.setNext(newNode);
				tail = newNode;
				size++;
			}
			// Loop ends at index to insert object
			INode<T> newNode = new INode<>(tail, null, e);
			tail.setNext(newNode);
			tail = newNode;
			size++;
		}
		
		// Adding inside of list(push all numbers back, append to location)
		else if(size > index){
			// If appending to head with no tail
			if(index == 0 && size == 1){
				INode<T> newNode = new INode<>(null, head, e);
				head.setPrevious(newNode);
				tail = head;
				head = newNode;
				size++;
			}
			// If appending to head
			else if(index == 0){
				INode<T> newNode = new INode<>(null, head, e);
				head.setPrevious(newNode);
				head = newNode;
				size++;
			}
			// If appending in body
			else{
				// Find node, when found, add the node
				INode<T> current = head.next();
				for(int ii = 1; ii < size; ii++){
					if(ii == index){
						INode<T> newNode = new INode<>(current.previous(), current, e);
						current.previous.setNext(newNode);
						current.setPrevious(newNode);
						size++;
						break;
					}
					else{
						current = current.next();
					}
				}
			}
		}
		
		else{
			System.out.println("Something went wrong in adding to array!");
		}
	}

	
	/**
	 * Returns the element at the specified position in this list.
	 * Throws an IndexOutOfBoundsException when index is out of range.
	 * @param index - Location of node to get data from
	 * @return The element at the specified position
	 */
	@Override
	public T get(int index) {
		if(index < 0 || size == 0){
			throw new IndexOutOfBoundsException();
		}
		INode<T> current = getFirstNode();
		for(int ii = 0; ii != index; ii++){
			current = current.next();
		}
		return current.data();
	}

	
	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this list, or -1 if this list does not contain the element.
	 * @param e - Data to find index of in list
	 * @return The index of the first occurrence of the specified element
	 */
	@Override
	public int indexOf(Object e) {
		INode<T> current = head;
		for(int ii = 0; ii < size; ii++){
			T data = current.data();
			if(e.equals(data)){
				return ii;
			}
			else{
				current = current.next();
			}
		}
		// Failed to find object
		return -1;
	}

	
	/**
	 * Removes the element at the specified position in this list.
	 * Throws an IndexOutOfBoundsException when index is out of range.
	 * @param index - Location of node to remove
	 * @return Data in removed node
	 */
	@Override
	public T remove(int index) {
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		// Remove from head
		else if(index == 0){
			INode<T> newHead = head.next();
			T data = head.data();
			head.next = null;
			head.data = null;
			//newHead.setPrevious(null);  // Only TestPopAfterPush stack test fails for some odd reason with line
			head = newHead;
			size--;
			return data;
		}
		// Remove from tail
		else if(index == size - 1){
			tail.previous().setNext(null);
			INode<T> oldTail = tail;
			tail = tail.previous();
			T data = oldTail.data();
			oldTail.setPrevious(null);
			oldTail.data = null;
			size--;
			return data;
		}
		// Remove from anywhere else in list
		else{
			// Finds node to remove
			INode<T> current = getFirstNode();
			for(int ii = 0; ii != index; ii++){
				current = current.next();
			}
			// Removes the node
			INode<T> before = current.previous();
			INode<T> after = current.next();
			before.setNext(current.next());
			after.setPrevious(current.previous());
			T data = current.data();
			current.next = null;
			current.previous = null;
			current.data = null;
			size--;
			return data;
		}
	}

	
	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * Throws an IndexOutOfBoundsException when index is out of range.
	 * @param index - Location of node to set data
	 * @param element - Data to replace existing data in node
	 */
	@Override
	public T set(int index, T element) {
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		else{
			INode<T> current = head;
			for(int ii = 0; ii != index; ii++){
				current = current.next();
			}
			T pastData = current.data;
			current.data = element;
			return pastData;
		}
	}

	
	/**
	 * @return The number of elements in this list.
	 */
	@Override
	public int size() {
		return size;
	}
	
	
	/**
	 *  Returns this list in string form, surrounded by [] brackets and with each
     *  items separated by a comma and space.  For example:
     *  [First, Second, Third, Fourth]
     *  @return String representation of the data in LinkedList
     */
	public String toString(){
		INode<T> current = getFirstNode();
		String s = "[";
		for(int ii = 0; ii < size; ii++){
			s += current.data().toString();
			current = current.next();
			if(ii != size - 1){
				s += ", ";
			}
		}
		s += "]";
		return s;
	}
	

	/**
	 * Returns the first node object in the linked list, which should link to
	 * all of the linked nodes through next links.
	 * @return Head of LinkedList
	 */
	public DoublyLinkedList<T>.INode<T> getFirstNode() {
		return head;
	}

	
	/**
	 * Returns the last node object in the linked list, which should link to all
	 * of the linked nodes through previous links.
	 * @return Tail of LinkedList
	 */
	public INode<T> getLastNode() {
		if(size == 0 || size == 1){
			return head;
		}
		else{
			return tail;
		}
	}
	
	/**
	 * Returns a listIterator to use to manipulate the list with
	 * @param index - The index the Iterator will initially be
	 * @return DoublyLinkedListIterator that is at the correct specified index
	 */
	@Override
	public ListIterator<T> listIterator(int index) {
		if(index < 0){
			throw new IndexOutOfBoundsException();
		}
		
		DoublyLinkedListIterator result = new DoublyLinkedListIterator();
		
		for(int ii = 0; ii < index; ii++){
			result.next();
		}
		
		return result;
	}
	
	
	/**
	 * Node class for use by DoublyLinkedList and it's iterator
	 */
	public class INode<E>{
		private INode<T> previous;
		private INode<T> next;
		private T data;
		
		
		/**
		 * Default Constructor to create a node
		 * @param previous - The previous node
		 * @param next - The next node
		 * @param data - The data to be stored in the node
		 */
		public INode(INode<T> previous, INode<T> next, T data){
			this.previous = previous;
			this.next = next;
			this.data = data;
		}
		
		
		/**
		 * @return The previous node, or null if this is the first node.
		 */
		public INode<T> previous() {
			return this.previous;
		}
		
		
		/**
		 * Setter for node, not necessary, but habit makes if feel right
		 * @param previous - New node that previous will be set to
		 */
		public void setPrevious(INode<T> previous){
			this.previous = previous;
		}

		
		/**
		 * @return The next node, or null if this is the last node.
		 */
		public INode<T> next() {
			return this.next;
		}
		
		
		/**
		 * Setter for node, not necessary, but habit makes if feel right
		 * @param next - New node that next will be set to
		 */
		public void setNext(INode<T> next){
			this.next = next;
		}

		
		/**
		 * @return - The element contained in this node
		 */
		public T data() {
			if(this.data == null){
				T s = null;
				return s;
			}
			return this.data;
		}
		
		/**
		 * @param - The element to set data contained in this node to
		 */
		public void setData(T data) {
			this.data = data;
		}
	}

	private class DoublyLinkedListIterator implements ListIterator<T>{

		private INode next;
		private INode previous;
		private INode returned;
		private int index;
		
		/**
		 * Default constructor
		 */
		public DoublyLinkedListIterator(){
			next = head;
			previous = null;
			index = 0;
		}
		
		/**
		 * Adds a new Node before the current next Node, then reconfigures all of the pointers
		 * @param arg0 - Object to store in the Node
		 */
		@Override
		public void add(T arg0) {
			DoublyLinkedList<T>.INode<T> newNode = new INode<T>(next.previous(), next, arg0);
			if(next != null){
				next.setPrevious(newNode);
			}
			if(previous != null){
				previous.setNext(newNode);
			}
			previous = newNode;
		}

		/**
		 * Checks to see if there is a Node after the current next Node
		 * @return true if there is a Node, false if there is a null
		 */
		@Override
		public boolean hasNext() {
			if(next != null){
				if(next.next() != null){
					return true;
				}
			}
			return false;
		}

		/**
		 * Checks to see if there is a Node after the current previous Node
		 * @return true if there is a Node, false if there is a null
		 */
		@Override
		public boolean hasPrevious() {
			if(previous != null){
				if(previous.previous() != null){
					return true;
				}
			}
			return false;
		}

		/**
		 * Moves iterator to the next Node, then returns the object inside of it
		 * @return Object inside of next Node, null if you can't move next
		 */
		@Override
		public T next() {
			if(next != null){
				if(next.next() != null){
					previous = next;
					next = next.next();
					returned = next;
					index++;
					return (T) next.data();
				}
			}
			return null;
		}

		/**
		 * Moves iterator to the previous Node, then returns the object inside of it
		 * @return Object inside of previous Node, null if you can't move next
		 */
		@Override
		public T previous() {
			if(previous != null){
				if(previous.previous() != null){
					next = previous;
					previous = previous.previous();
					returned = previous;
					index--;
					return (T) previous.data();
				}
			}
			return null;
		}
		
		/**
		 * Returns the index of the next Node
		 * @return the index of the next Node, current index if there is no next Node
		 */
		@Override
		public int nextIndex() {
			if(next != null){
				if(next.next() != null){
					return index + 1;
				}
			}
			return index;
		}
		
		/**
		 * Returns the index of the previous Node
		 * @return the index of the previous Node, current index if there is no previous Node
		 */
		@Override
		public int previousIndex() {
			if(previous != null){
				if(previous.previous() != null){
					return index - 1;
				}
			}
			return index;
		}

		/**
		 * Removes the Node of the last returned "move", so if you had next(), it will remove that Node
		 */
		@Override
		public void remove() {
			INode temp;
			// If removing next
			if(returned == next){
				// If removing at beginning of the list
				if(previous == null){
					temp = next.next();
					temp.setPrevious(null);
					next.setNext(null);
					index--;
				}
				// If removing at end of list
				else if(next.next() == null){
					previous.setNext(null);
					next.setPrevious(null);
					next = previous;
					previous = previous.previous();
					index--;
				}
				// Removing everywhere else in the list
				else{
					temp = next.next();
					temp.setPrevious(previous);
					previous.setNext(temp);
					next.setPrevious(null);
					next.setNext(null);
					index--;
				}
			}
			else if(returned == previous){
				// If removing at beginning of the list
				if(previous.previous() == null){
					next.setPrevious(null);
					previous.setNext(null);
					previous = next;
					next = next.next();
					index--;
				}
				// If removing at end of list - Exception not needed, I think
				
				// Removing everywhere else in the list
				else{
					temp = previous.previous();
					temp.setNext(next);
					next.setPrevious(temp);
					previous.setPrevious(null);
					previous.setNext(null);
					index--;
				}
			}
			else{
				System.out.println("ERROR: DoublyLinkedList2 Iterator Remove()");
			}
		}

		/**
		 * Changes the object stored in the last returned node to the new object
		 */
		@Override
		public void set(T arg0) {
			if(returned == next){
				next.setData(arg0);
			}
			else if(returned == previous){
				previous.setData(arg0);
			}
			else{
				System.out.println("ERROR: DoublyLinkedList2 Iterator Set()");
			}
			
		}
	}	
}
