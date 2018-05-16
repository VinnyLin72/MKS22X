import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private int[][]moves = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private boolean animate = true;
    private int steps;

    public Maze(String filename) throws FileNotFoundException{
	try {	
	    File text = new File(filename);
	    Scanner file = new Scanner(text);
	    Scanner count = new Scanner(text);
	    int r = 0;
	    int c = 0;
	    while (count.hasNextLine()){
		String line = count.nextLine();
	        c = line.length();
		r ++;
	    }
	    maze = new char[r][c];
	    int ri = 0;
	    while(file.hasNextLine()){
		String line = file.nextLine();
		for (int ci = 0; ci < line.length() ; ci ++){
		    maze[ri][ci] = line.charAt(ci);
		}
		ri ++;
	    }
	    if (isValid()) {
		throw new IllegalStateException("Ya gots to have an E and an S");
	    }
	}

	catch (FileNotFoundException e) {
	    System.err.println("FileNotFoundException: " + e.getMessage());
	}
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    private boolean isValid() {
	int e = 0, s = 0;
	for (int r=0 ; r<maze.length ; r++) {
	    for (int c=0 ; c<maze[r].length ; c++) {
		if (maze[r][c] == 'E') {
		    e++;
		}
		if (maze[r][c] == 'S') {
		    s++;
		}
	    }
	}	
	return e != 1 || s != 1;
    }

    public String toString() {
	    	String string = "";
	    	for (int r = 0; r < maze.length; r ++){
	    	    for (int c = 0; c < maze[0].length; c ++){
	    	    		string += (maze[r][c]);
	    	    }
	    	    string += "\n";
	    	}
	    	return string;
    }

    public int solve(){
	steps = -1;
	int r = 0;
	int c = 0;
	for (int ri = 0; r == 0 && ri < maze.length; ri ++){
	    for (int ci = 0; c == 0 && ci < maze[0].length; ci ++){
		if (maze[ri][ci] == 'S'){
		    r = ri;
		    c = ci;
		}
	    }
	}
	maze[r][c] = ' ';
	return solve(r, c);
    }

    private int solve(int r, int c){
	if (maze[r][c] == 'E'){
	   steps = 1;
	   return steps;
	}
	if (maze[r][c] != ' ') return 0;
	maze[r][c] = '.';
	for (int[] i: moves){
	    if (solve(r + i[0], c + i[1]) > 0) steps += 1 ;
	    if (steps > 0){
		maze[r][c] = '@';
		return steps;
	    }
	    if(animate){
		clearTerminal();
		System.out.println(this);
		wait(20);
	    }
	}
        return -1;
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        Maze f = new Maze("data3.dat");//true animates the maze.
        
        System.out.println(f.solve());
	System.out.println(f.toString());

    }
    
}
