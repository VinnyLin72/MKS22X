public class Location implements Comparable<Location>{
    
    private int x, y, priority;
    private Location previous;
    
    public Location(int _x, int _y, Location prev, int dist){
	x = _x;
	y = _y;
	previous = prev;
	priority = dist;
    }
    
    public int getX(){
	return x;
    }
    
    public int getY(){
	return y;
    }
    
    public Location getPrev(){
	return previous;
    }
    
    public String toString(){
	return x + " " +y;
    }
    
    public boolean equals(Location o){
	return x == o.getX() && y == o.getY();
    }
    
    public int compareTo(Location o){
	return getPriority() - o.getPriority();
    }
    
    public int getPriority(){
	return priority;
    }
    
}
