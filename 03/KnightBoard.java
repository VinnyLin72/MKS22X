public class KnightBoard{

    private int[][] board;
    private int[][] p = {{1,2},{2,1},{-1,2},{2,-1},{-2,1},{1,-2},{-2,-1},{-1,-2}};

	
    public KnightBoard(int row, int col){
	board = new int[row][col];
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

    public boolean solve(int row, int col){
	return solveH(row-1, col-1, 1);
    }

    public boolean solveH(int row, int col, int level){
	try{
	    if (board[row][col] != 0) return false;
	    if (level > board.length * board[0].length) return true;
	    board[row][col] += level;
	    System.out.println(toString());
	    for (int i = 0; i < 8; i ++){
		System.out.println(toString());
	        if(solveH(row + p[i][0], col + p[i][1], level + 1)) return true;
	    }
	    return false;
	    //   return solveH(row + 1, col + 2, level + 1) || solveH(row + 1, col - 2, level + 1) || solveH(row - 1, col + 2, level + 1) || solveH(row + 2, col + 1, level + 1) || solveH(row + 2, col - 1, level + 1) || solveH(row - 2, col + 1, level + 1) || solveH(row - 2, col - 1, level + 1) || solveH(row - 1, col - 2, level + 1);
	}
	catch(ArrayIndexOutOfBoundsException e){
	    return false;
	}
    }

    // public int countSolutions(){

    //}

    public static void main(String[] args){
	KnightBoard k = new KnightBoard(8,8);
	k.solve(1,1);
	System.out.println(k.toString());
    }
    
}
