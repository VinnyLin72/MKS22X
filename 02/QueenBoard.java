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
		if (board[r][c] == -1) System.out.print("Q ");
		else System.out.print("_ ");
	    }
	    System.out.print("\n");
	}
	return "";
    }

    public boolean solve(){
	
    }

    private boolean addQueen(int r, int c){
	
    }

    private boolean removeQueen(int r, int c){

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

	x.toString();
    }
}
