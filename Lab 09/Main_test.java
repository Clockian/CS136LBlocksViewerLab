import java.util.ListIterator;

public class Main_test {
	public static void main (String[] args){
		DoublyLinkedList2<Integer> test1 = new DoublyLinkedList2<>();
		
		System.out.println("\nRetrieveCustomIteratorObject");
		int jj = 0;
		for(Integer ii = 0; ii < 6; ii++, jj++){
			System.out.println("add(ii): " + ii);
			test1.add(jj, ii);
		}
		
		System.out.println();
		for(int ii = 0; ii < 6; ii++){
			System.out.print("Pre result: " + test1.get(ii) + ", ");
		}
		
		//ListIterator<Integer> iter = test1.listIterator(4);
		
		System.out.println();
		for(Integer ii = 0; ii < 6; ii++){
			System.out.print("Post result: " + test1.get(ii) + ", ");
		}
		
		System.out.println("\n");
	}
}
