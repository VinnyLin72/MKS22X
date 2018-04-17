public class Node{

    private Integer data;
    private Node prev, next;

    public Node(Integer value){
	data = value;
    }

    public Node getPrev(){
	if (prev != null)return prev;
	return null;
    }

    public boolean setPrev(Node node){
	prev = node;
	return true;
    }

    public Node getNext(){
	if (next != null)return next;
	return null;
    }

    public boolean setNext(Node node){
	next = node;
	return true;
    }

    public Integer getValue(){
	return data;
    }

    public void setValue(Integer value){
	data = value;
    }

    public void remove(){
        prev.setNext(this.getNext());
	next.setPrev(this.getPrev());
    }
    
}
