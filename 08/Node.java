public class Node{

    private Integer data;
    private Node prev, next;

    public Node(Integer value){
	data = value;
    }

    public Node getPrev(){
	return prev;
    }

    public void setPrev(Node node){
	prev = node;
    }

    public Node getNext(){
	return next;
    }

    public void setNext(Node node){
	next = node;
    }

    public Integer getValue(){
	return data;
    }

    public void setValue(int value){
	data = value;
    }

    public void remove(){
        prev.setNext(this.getNext());
	next.setPrev(this.getPrev());
    }
    
}
