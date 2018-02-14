public class KnightBoard{

    private int[][] board;

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
		if (board[r][c] == 0) ans += "__";
	        if (board[r][c] <= 10) ans += " _" + board[r][c];
		else ans += " " + board[r][c];
	    }
	}
	return ans;
    }

    public boolean solve(int row, int col){
	return solveH(row-1, col-1, 1);
    }

    public boolean solveH(int row, int col, int level){
	if (board[row][col] != 0) return false;
	if (level > board.length * board[0].length) return true;
	board[row][col] = level;
	return solveH(row + 1, col + 2, level + 1) || solveH(row + 1, col - 2, level + 1) || solveH(row - 1, col + 2, level + 1) || solveH(row + 2, col + 1, level + 1) || solveH(row + 2, col - 1, level + 1) || solveH(row - 2, col + 1, level + 1) || solveH(row - 2, col - 1, level + 1) || solveH(row - 1, col - 2, level + 1);
    }

    // public int countSolutions(){

    //}

    public static void main(String[] args){
	KnightBoard k = new KnightBoard(8,8);
	k.solve(1,1);
    }
    
}
