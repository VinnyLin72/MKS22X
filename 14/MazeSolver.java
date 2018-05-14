public class MazeSolver{
    
    private Maze maze;
    private Frontier frontier;
  
    public MazeSolver(String mazeText) throws FileNotFoundException{
	maze = new Maze(mazeText);
    }

    //Default to BFS
    public boolean solve(){
	return solve(0);
    }
    
    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){
	if(mode == 0) frontier = new FrontierQueue();
	if(mode == 1) frontier = new FrontierStack();
	else frontier = new FrontierPriorityQueue();
	Location e = maze.getEnd();
	frontier.add(maze.getStart());
	while(frontier.hasNext()){
	    Location next = frontier.next();
	    Location[] neighbors = maze.getNeighbors(next);
	    if (!next.equals(maze.getStart())) maze.set(next.getX(), next.getY(), '.');
	    for (Location n : neighbors){
		if(n != null){
		    if(n.equals(e)){
			while(!next.equals(maze.getStart())){
			    maze.set(next.getX(), next.getY(), '@');
			    next = next.getPrev();
			}
			return true;
		    }
		    frontier.add(n);
		    maze.set(n.getX(), n.getY(), '?');
		}
	    }
	}
	return false;
    }

    public String toString(){
	return maze.toString();
    }
    
}
