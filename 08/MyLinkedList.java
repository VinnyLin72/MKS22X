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
	String s = "[";
	Node current = start;
	for (int i = 0; i < size; i ++){
	    s += current.getValue() + ", ";
	    current = current.getNext();
	    
	}
	return s.substring(0, s.length() - 2) + "]";
    }

    public Node getNode(int index){
	checkerror(index);
	Node current = start;
	for (int i = 0; i < index; i ++){
	    current = current.getNext();
	    
	}
	return current.getNext();
    }

    public void clear(){
	start = null;
	end = null;
	size = 0;
    }

    private void checkerror(int i){
	if (i >= size){
	    throw new IndexOutOfBoundsException();
	}
    }

    public Integer get(int index){
	checkerror(index);
	Node current = start;
	for (int i = 0; i <= index; i ++){
	    current = current.getNext();
	    
	}
	return current.getValue();
    }

    public Integer set(int index, Integer newValue){
	checkerror(index);
	Node current = start;
	Integer ans = 0;
	for (int i = 0; i <= index; i ++){
	    if (i == index){
		ans = current.getValue();
		current.setValue(newValue);
	    }
	    current = current.getNext();
	}
	return ans; 
    }

    public void add(int index, Integer value){   
	size ++;
	checkerror(index);
	if (size == 1){
	    Node node = new Node(value);
	    start = node;
	    end = node;
	}
	else{
	    add(0);
	    Node current = end;
	    for (int i = size - 1; i >= index; i --){
		if (i == index) current.setValue(value);
		else current.setValue(current.getPrev().getValue());
		current = current.getPrev();
	    }
	}
    }

    public int indexOf(Integer value){
	Node current = start;
	for (int i = 0; i < size; i ++){
	    if (current.getValue() == value){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }
    
    public boolean add(Integer value){
	Node node = new Node(value);
	if (size == 1){
	    start = node;
	    end = node;
	    return true;
	}
	node.setPrev(end);
	end.setNext(node);
	end = node;
	size ++;
	return true;
    }

    public Integer remove(int index){
	checkerror(index);
	size --;
	Node current = start;
	Integer ans = 0;
	for (int i = 0; i <= index; i ++){
	    if (i == index){
		current.setValue(current.getNext().getValue());
		ans = current.getValue();
	    }
	    current = current.getNext();
	}
	for (int i = index; i < size; i ++){
	    current.setValue(current.getNext().getValue());
	    current = current.getNext();
	}
	end = end.getPrev();
	return ans;
    } 

    public boolean remove(Integer value){
	Node current = start;
	for (int i = 0; i < size; i ++){
	    if (current.getValue() == value){
		size --;
		remove(i);
		return true;
	    }
	    current = current.getNext();
	}
	return false;
    }
    
    
}
