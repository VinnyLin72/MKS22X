public class KnightBoard{

    private int[][] board;
   
	
    public KnightBoard(int row, int col){
        checkArgument(row,col);
	board = new int[row][col];
	clear();
    }

    public void clear(){
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board[r].length; c ++){
		board[r][c] = 0;
	    }
	}
    }

    public String toString(){
	String ans = "";
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board[r].length; c ++){
		if (board[r][c] == 0) ans += " __";
	        else if (board[r][c] < 10) ans += " _" + board[r][c];
		else ans += " " + board[r][c];
	    }
	    ans += "\n";
	}
	return ans;
    }

    private void checkState(){
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board[r].length; c ++){
		if (board[r][c] != 0) throw new IllegalStateException();
	    }
	}
    }

    private void checkArgument(int r, int c){
	if (r < 0 || c < 0) throw new IllegalArgumentException();
    }

    public boolean solve(int row, int col){
	checkState();
	checkArgument(row, col);
	return solveH(row, col, 1);
    }

    public boolean solveH(int row, int col, int level){
	try{
	    if (board[row][col] != 0 || row > board.length || col > board[row].length) return false;
	    if (level > board.length * board[0].length) return true;
	    board[row][col] = level;
	    //System.out.println(toString());
	    if (solveH(row + 1, col + 2, level + 1) || solveH(row + 1, col - 2, level + 1) || solveH(row - 1, col + 2, level + 1) || solveH(row + 2, col + 1, level + 1) || solveH(row + 2, col - 1, level + 1) || solveH(row - 2, col + 1, level + 1) || solveH(row - 2, col - 1, level + 1) || solveH(row - 1, col - 2, level + 1)) return true;
	    board[row][col] = 0;
	    return false;
	}
	catch(ArrayIndexOutOfBoundsException e){
	    return false;
	}
    }

    public int countSolutions(int row, int col){
	checkState();
	checkArgument(row, col);
	int sum = 0;
	for (int r = row; r < board.length; r ++){
	    for (int c = col; c < board[0].length; c ++){
		sum += countHelp(row, col, 1);
		clear();
	    }
	}
	return sum;
    }

    public int countHelp(int row, int col, int level){
        int solution = 0;
	if (row < 0|| col < 0 || row >= board.length || col >= board[0].length) return 0;
	if (level > board.length * board[0].length) return 1;
	if (board[row][col]==0){
	    board[row][col]=level;
	    if(countHelp(row+2, col+1, level+1)!=0){
		solution++;
	    } 
	    if(countHelp(row+1, col+2, level+1)!=0){
		solution++;
	    }
	    if(countHelp(row-2, col+1, level+1)!=0){
		solution++;
	    }
	    if(countHelp(row+2, col-1, level+1)!=0){
		solution++;
	    } 
	    if(countHelp(row-2, col-1, level+1)!=0){
		solution++;
	    } 
	    if(countHelp(row-1, col+2, level+1)!=0){
		solution++;
	    } 
	    if(countHelp(row+1, col-2, level+1)!=0){
		solution++;
	    } 
	    if(countHelp(row-1, col-2, level+1)!=0){
		solution++;
	    }
	    board[row][col]=0;
	}
	return solution;
    }

    public static void main(String[] args){
	 /*
	KnightBoard k = new KnightBoard(1,1);
	k.solve(1,1);
	System.out.println(k.toString());
	}*/

    KnightBoard a = new KnightBoard(3,3);

	System.out.println(a);
	/* Prints
	   _ _ _
	   _ _ _
	   _ _ _
	*/

	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
		if (a.solve(i,j)){
		    System.out.println("There is an error with your solve method");
		}
	    }
	} //prints nothing

	System.out.println(a.countSolutions(0,0)); //prints 0



	KnightBoard b = new KnightBoard(5,5);
	System.out.println(b.solve(0,0)); //prints true
	System.out.println(b); //prints a valid solution

	try{
	    b.solve(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    b.countSolutions(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    KnightBoard b1 = new KnightBoard(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(0,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"



	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		KnightBoard abc = new KnightBoard(5,5);
		System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
	    }
	}
	KnightBoard c = new KnightBoard(5,5);

	int totalSol = 0;
	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		totalSol += c.countSolutions(i,j);
	    }
	}

	System.out.println(totalSol); //prints 1728

	KnightBoard d = new KnightBoard(5,5);
	System.out.println(d.countSolutions(0,0)); //prints 304

    }
    
}
