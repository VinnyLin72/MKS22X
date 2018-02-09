public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board[r].length; c ++){
		board[r][c] = 0;
	    }
	}
    }

    public String toString(){
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board[r].length; c ++){
		//System.out.println(board[r][c]);
		if (board[r][c] == -1) System.out.print("Q ");
		else System.out.print(board[r][c]);
	    }
	    System.out.print("\n");
	}
	return "";
    }

    //   public boolean solve(){
	
    //  }

    public boolean addQueen(int r, int c){
	if (board[r][c] != 0) return false;
	for (int ri = r; ri < board.length; ri ++){
	    for (int ci = c; ci < board[ri].length; ci ++){
	        if (ri == r || ci == c || ri - r == ci - c) board[ri][ci] ++;
	    }
	}
	board[r][c] = -1;
	return true;
    }

    private boolean removeQueen(int r, int c){
	if (board[r][c] != -1) return false;
	for (int ri = r; ri < board.length; ri ++){
	    for (int ci = c; ci < board[ri].length; ci ++){
	        if (ri == r || ci == c || ri - r == ci - c) board[ri][ci] --;
	    }
	}
	board[r][c] += 2;
	return true;
    }

    public int countSolutions(){
	
	
	int ans = 0;
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board[r].length; c ++){
		if (board[r][c] == -1) ans ++;
	    }
	}
	return ans;
    }


    public static void main(String[] args){
	QueenBoard x = new QueenBoard(5);

	x.addQueen(2,2);
	x.removeQueen(2,2);
	x.toString();
    }
}
