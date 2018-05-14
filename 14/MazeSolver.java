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
	//initialize your frontier
	//while there is stuff in the frontier:
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false
	if(mode == 0){
	    frontier = new FrontierQueue();
	}
	if(mode == 1){
	    frontier = new FrontierStack();
	}
	else{
	    frontier = new FrontierPriorityQueue();
	}
	Location e = maze.getEnd();
	frontier.add(maze.getStart());
	while(frontier.hasNext()){
	    Location next = frontier.next();
	    //  System.out.println(maze);
	    Location[] neighbors = maze.getNeighbors(next);
	    if(!next.equals(maze.getStart())){
		maze.set(next.getX(), next.getY(), '.');
	    }
	    for(Location n : neighbors){
		if(n != null){
		    if(n.equals(e)){
			while(!next.equals(maze.getStart())){
			    maze.set(next.getX(), next.getY(), '@');
			    next = next.getPrev();
			}
			//  System.out.println(maze);
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
