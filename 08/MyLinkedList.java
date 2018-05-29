public class MyLinkedList{
    
    private Node start, end;
    private int size;


    public MyLinkedList(){
    }

    private Node getNode(int index){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node ans = start;
	for (int i = 0; i < index; i++){
	    ans = ans.getNextNode();
	}
	return ans;
    }

    public String toString(){
	String ans = "{ ";
	Node temp = start;
	for (int i = 0; i < size; i++){
	    ans += temp.toString() + " ";
	    temp = temp.getNextNode();
	}
	return ans + "}";
    }

    public void clear(){
	start = null;
	end = null;
	size = 0;
    }

    public void checkerror(){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
    }

    public int size(){
	return size;
    }

    public Integer get(int index){
	return getNode(index).getData();
    }

    public Integer set(int index, Integer value){
	checkerror();
	Integer temp = getNode(index).getData();
	getNode(index).setData(value);
	return temp;
    }

    public int indexOf(Integer value){
	for (int i = 0; i < size; i++){
	    if(getNode(i).getData().equals(value)){
		return i;
	    }
	}
	return -1;
    }

    public boolean add(Integer newData){
	if (size == 0){
	    start = new Node(newData);
	    end = start;
	    size ++;
	    return true;
	}
	Node a = new Node(newData);
	end.setNextNode(a);
	size ++;
	Node temp = end;
	end = a;
	end.setPrevNode(temp);
	return true;
    }

    public void add(int index, Integer value){
	checkerror();
	if(index == size){
	    add(value);
	}
	else if(index == 0){
	    Node temp = start;
	    start = new Node(value);
	    start.setNextNode(temp);
	    size ++;
	}
	else{
	    Node temp = getNode(index);
	    getNode(index - 1).setNextNode(new Node(value));
	    Node newer = getNode(index);
	    newer.setNextNode(temp);
	    temp.setPrevNode(newer);
	    newer.setPrevNode(getNode(index - 1));
	    size ++;
	}
    }//exceptions!

    //The remove methods can cause a problem, this is why we shouldn't
    //use an int as the data, we need objects to distinguish between index and data
    public boolean remove(Integer value){
	int index = indexOf(value);
	if(index != -1){
	    remove(index);
	    return true;
	}
	return false;
    }

    public Integer remove(int index){
	checkerror();
	Integer ans = get(index);
	if(size == 1){
	    start = null;
	    end = null;
	}
	else if(index == 0){
	    start = getNode(1);
	    start.setPrevNode(null);
	}
	else if(index == size - 1){
	    end = getNode(size - 2);
	    end.setNextNode(null);
	}
	else{
	    Node previous = getNode(index - 1), next = getNode(index + 1);
	    previous.setNextNode(next);
	    next.setPrevNode(previous);
	}
	size --;
	return ans;
    }

    private class Node{
	private Integer data;
	private Node next;
	private Node prev;

	public Node(Integer value){
	    data = value;
	}
	public Node(Integer value, Node nextNode){
	    this(value);
	    next = nextNode;
	}
	public Integer getData(){
	    return data;
	}
	public boolean setData(Integer a){
	    data = a;
	    return true;
	}
	public Node getNextNode(){
	    if(next != null){
		return next;
	    }
	    return null;
	}

	public Node getPrevNode(){
	    if(prev != null){
		return prev;
	    }
	    return null;
	}

	public boolean setNextNode(Node a){
	    next = a;
	    return true;
	}

	public boolean setPrevNode(Node a){
	    prev = a;
	    return true;
	}

	public String toString(){
	    return "[" + data + "]";
	}
    }

}
