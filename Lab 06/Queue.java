
public class Queue{
	
	Character[] queue;
	private int tail;
	
	public Queue(int size){
		queue = new Character[size];
		tail = 0;
	}
	
	public void enqueue(Character e) {
		queue[tail] = e;
		tail++;
	}
	
	public Character dequeue() {
		Character pop = queue[0];
		for(int ii = 0; ii < tail - 1; ii++){
			queue[ii] = queue[ii + 1];
		}
		tail--;
		return pop;
	}
	
	public Character peek() {
		return queue[0];
	}
	
	public int size() {
		return tail;
	}
	
	public String toString(){
		String remains = "";
		for(int ii = 0; ii < tail; ii++){
			remains += queue[ii].getName();
			if(ii != tail -1){
				remains += ", ";
			}
		}
		
		return remains;
	}
}
