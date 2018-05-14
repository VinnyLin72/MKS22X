import java.util.Stack;

public class FrontierStack implements Frontier{
    private Stack<Location> s;
    
    public FrontierStack(){
	s = new Stack<Location>();
    }
    
    public Location next(){
	return s.pop();
    }
    
    public void add(Location n){
	s.add(n);
    }
    
    public boolean hasNext(){
	return (s.size() != 0);
    }
    
}
