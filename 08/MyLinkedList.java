public class MyLinkedList{
    
    private Node start, end;
    private int size;
    
    public MyLinkedList(){
	size = 0;
    }

    public int size(){
	return size;
    }

    public String toString(){
	
    }

    public int get(int index){
	Node current = start;
	for (int i = 0; i <= index; i ++){
	    current = current.getNext();
	    
	}
	return current.getValue();
    }

    public void set(int index, int newValue){
	
    }

    public void add(int index, int value){

    }

    public boolean addEnd(int value){
	Node node = new Node(value);
	node.setPrev(end);
	end.setNext(node);
	end = node;
	return true;
    }

    public boolean addBeg(int value){
	Node node = new Node(value);
        node.setNext(start);
	start.setPrev(node);
	start = node;
	return true;
    }

    public int remove(int index){

    }

    
    
}
