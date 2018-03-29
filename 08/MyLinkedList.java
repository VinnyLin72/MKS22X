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
	Node current = start;
	for (int i = 0; i <= index; i ++){
	    if (i == index) current.setValue(newValue);
	    current = current.getNext();
	}
    }

    public void add(int index, int value){	
	Node current = end;
	add(end.getValue());
	for (int i = size - 2; i >= index; i --){
	    if (i == index) current.setValue(value);
	    else current.setValue(current.getPrev().getValue());
	    current = current.getNext()
	}
	size ++;
    }

    /* public void add(int index, int Value){
	Node current = start;
	add(0);
	for (int i = 0; i < size; i ++){
	    if (i == index)
	}
	}*/

    public boolean add(int value){
	Node node = new Node(value);
	node.setPrev(end);
	end.setNext(node);
	end = node;
	return true;
    }

    public int remove(int index){
	size --;
	Node current = start;
	for (int i = 0; i <= index; i ++){
	    if (i == index) current.setValue(current.getNext());
	    current = current.getNext();
	}
	for (int i = index; i < size; i ++){
	    current.setValue(current.getNext().getValue());
	    current = current.getNext();
	}
	end = end.get
    } 
    
}
