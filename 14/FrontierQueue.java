import java.util.LinkedList;

public class FrontierQueue implements Frontier{
    
    private LinkedList<Location> q;
    
    public FrontierQueue(){
	q = new LinkedList<Location>();
    }
    
    public Location next(){
	return q.remove();
    }
    
    public void add(Location n){
	q.add(n);
    }
    
    public boolean hasNext(){
	return (q.peek() != null);
    }
    
}
