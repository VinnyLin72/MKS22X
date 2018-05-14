public class FroniterPriorityQueue implements Frontier{
    
    private MyHeap<Location> q;

    public FrontierPriorityQueue(){
	q  = new MyHeap<Location>(false);
    }
    
    public Location next(){
	return q.remove();
    }
    
    public void add(Location n){
	q.add(n);
    }
    
    public boolean hasNext(){
	return q.size() != 0;
    }
    
}
