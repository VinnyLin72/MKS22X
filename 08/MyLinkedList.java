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
	return s + "]";
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
	if (i >= size || i < 0){
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
	for (int i = 0; i == index; i ++){
	    if (current == end) end = end.getPrev();
	    else if (current == start) start = start.getNext();
	    else if (i == index){
		current.getPrev().setNext(current.getNext());
		current.getNext().setPrev(current.getPrev());
		ans = current.getValue();
	    }
	    current = current.getNext();
	}
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

     public static void main(String[] args){
     MyLinkedList a = new MyLinkedList();

     System.out.println("Testing add(Integer value)");
     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
       System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
     } //adds the integers from 0 to 9 inclusive and prints out the LinkedList

     System.out.println("\nTesting get(int index)");
     for (int i = 0; i < 10; i++){
       System.out.println("index: " + i + " data: " + a.get(i));
     } //prints the integers from 0 to 9 inclusive

     System.out.println("\nTesting exception for get(int index)");
     try{
       System.out.println(a.get(10));
       System.out.println(a.size());
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.get(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
     }

     System.out.println("\nTesting indexOf(Integer value)");
     for (int i = 0; i < 10; i++){
       System.out.println("Value: " + i + " Index: " + a.indexOf(i));
     } //prints 0 to 9 inclusive

     System.out.println("\nTesting remove(Integer value)");
     for(int i = 0; i < 10; i++){
       a.remove(new Integer(i));
       System.out.println(a);
     } //removes first half of the LinkedList

     System.out.println("\nTesting set(int index, Integer value)");
     for (int i = 0; i < 10; i++){
       a.set(i, new Integer(i * 10));
       System.out.println(a);
     } //sets the data of each node to 10 * index

     System.out.println("\nTesting exceptions for set(int index, Integer value)");
     try{
       System.out.println(a.set(-1, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.set(10, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesing add(int index, Integer value)");
     for (int i = 0; i < 9; i++){
       a.add(i, new Integer(i * 3));
       System.out.println("index added: " + i + " LinkedList: " + a.toString());
     } //adds multiples of 3 up to 24 to the LinkedList at the beginning
     a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
     System.out.println("index added: " + 19 + " LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for add(int index, Integer value)");
     try{
       a.add(-1, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       a.add(21, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesting remove(int index)");
     System.out.println("Original LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
     System.out.println("LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for remove(int index)");
     try{
       System.out.println(a.remove(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.remove(17));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesting clear()");
     a.clear();
     System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
   }
    
}
