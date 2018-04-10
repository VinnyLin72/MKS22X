public class QueenBoard{
    private int[][] board;
    private int numSols;

    public QueenBoard(int size){
	board = new int[size][size];
	clear();
    }

    public void clear(){
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board[r].length; c ++){
		board[r][c] = 0;
	    }
	}
    }

    public void checkError(){
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
    }
    
    public String toString(){
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board[r].length; c ++){
		//System.out.println(board[r][c]);
		if (board[r][c] == -1) System.out.print("Q ");
		else System.out.print("_ ");
	    }
	    System.out.print("\n");
	}
	return "";
    }

    public boolean solve(){
	checkError();
	return solHelper(0);
    }

    public boolean solHelper(int c){
	if (c >= board.length) return true;
	for (int r = 0; r < board.length; r ++){
	    if (addQueen(r, c) && solHelper(c + 1)) return true;
	    removeQueen(r, c);
	}
    return false;
    }

    public boolean addQueen(int r, int c){
	if (board[r][c] != 0) return false;
	for (int ri = r; ri < board.length; ri ++){
	    for (int ci = c; ci < board[ri].length; ci ++){
	        if (ri == r || ci == c || Math.abs(ri - r) == Math.abs(ci - c)) board[ri][ci] ++;
	    }
	}
	board[r][c] = -1;
	return true;
    }

    private boolean removeQueen(int r, int c){
	if (board[r][c] != -1) return false;
	for (int ri = r; ri < board.length; ri ++){
	    for (int ci = c; ci < board[ri].length; ci ++){
	        if (ri == r || ci == c ||  Math.abs(ri - r) == Math.abs(ci - c)) board[ri][ci] --;
	    }
	}
	board[r][c] += 2;
	return true;
    }

    public int countSolutions(){
	checkError();
	numSols = 0;
	return countHelper(0);
	    }

    public int countHelper(int c){
	if (c == board.length) numSols ++;
	for(int r = 0;r < board.length;r++){
	    if(addQueen(r,c)){
		countHelper(c + 1);
		removeQueen(r,c);
	    }
	}
	return numSols;
    }
    public static void main(String[] args){
    QueenBoard b = new QueenBoard(4);

    System.out.println(b.solve()); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      b.countSolutions();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    for (int i = 0; i < 12; i++){
      QueenBoard a = new QueenBoard(i);
      System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
      /*          Expected Values
       i --> # of Solutions   i --> # of Solutions
      0 --> 1                      6 --> 4
      1 --> 1                      7 --> 40
      2 --> 0                      8 --> 92
      3 --> 0                      9 --> 352
      4 --> 2                    10 --> 724
      5 --> 10                  11 --> 2680
      */
      System.out.println(a); //prints out an empty i by i grid of underscores
    }
    }
}
