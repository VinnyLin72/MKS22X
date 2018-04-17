public class MyLinkedList{
    
    private Node start, end;
    private int size;
    
    public MyLinkedList(){
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
	return current;
    }

    public void clear(){
	start = null;
	end = null;
	size = 0;
    }

    private void checkerror(int i){
	if (i > size || i < 0){
	    throw new IndexOutOfBoundsException();
	}
    }

    public Integer get(int index){
	checkerror(index);
	Node current = start;
	for (int i = 0; i < index; i ++){
	    current = current.getNext();
	    
	}
	return current.getValue();
    }

    public Integer set(int index, Integer newValue){
	checkerror(index);
	Node current = getNode(index);
	Integer ans = current.getValue();
	current.setValue(newValue);
	return ans; 
    }

    public void add(int index, Integer value){   
	checkerror(index);
	if (index == size){
	    add(value);
	}
	if (index == 0){
	    Node current = start;
	    start = new Node(value);
	    start.setNext(current);
	}
	else{
	    Node temp = getNode(index);
	    getNode(index - 1).setNext(new Node(value));
	    Node newer = getNode(index);
	    newer.setNext(temp);
	    temp.setPrev(newer);
	    newer.setPrev(getNode(index - 1));
	}
	size ++;
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
	if (size == 0){
	    start = node;
	    end = node;
	    size ++;
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
