import java.util.*;
import java.io.*;

public class USACO{

    public static int bronze(String filename){
	try{
	    Scanner info = new Scanner(new File(filename));
	    int rows = info.nextInt();
	    int cols = info.nextInt();
	    int elevation = info.nextInt();
	    int numMoves = info.nextInt();
	    int[][] lake = new int[rows][cols];
	    for(int r = 0; r< rows; r++){
		for(int c = 0; c< cols; c++){
		    lake[r][c] = info.nextInt();
		}
	    }
	    int[][] moves = new int[numMoves][3];
	    for(int i = 0; i < numMoves; i ++){
		for(int j = 0; j < 3; j ++){
		    moves[i][j] = info.nextInt();
		}
	    }
	    for(int m= 0; m < numMoves; m ++){
		int maxElevation = 0;
		for(int i = moves[m][0] - 1; i < moves[m][0] + 2 ; i ++){
		    for(int j = moves[m][1] - 1; j < moves[m][1] +2 ; j ++){
			if(lake[i][j] > maxElevation) maxElevation = lake[i][j];
		    }
		}
		int threshold = maxElevation - moves[m][2];
		for(int i = moves[m][0] - 1; i < moves[m][0] + 2 ; i ++){
		    for(int j = moves[m][1] - 1; j < moves[m][1] + 2 ; j ++){
			if(lake[i][j] >= threshold) lake[i][j] = threshold;
		    }
		}
	    }
	    int water = 0;
	    for(int i = 0; i < rows ; i++){
		for(int j = 0; j < cols; j++){
		    if(elevation - lake[i][j] > 0) lake[i][j] = elevation - lake[i][j];
		    else lake[i][j] = 0;
		    water+= lake[i][j];
		}
	    }
	    return water * 6 * 6 * 12 * 12;
	}
	catch(FileNotFoundException e){
	    System.out.println("File not Found");
	}
	return -1;
    }



    public static int silver(String filename){
	try{
	    Scanner info = new Scanner(new File(filename));
	    int row = info.nextInt();
	    int col = info.nextInt();
	    int time = info.nextInt();
	    info.nextLine();
	    char[][] ary0 = new char[row][col];
	    for(int i = 0; i < row;i ++){
		ary0[i] = info.nextLine().toCharArray();
	    }
	    int R1 = info.nextInt() - 1;
	    int C1 = info.nextInt() - 1;
	    int R2 = info.nextInt() - 1;
	    int C2 = info.nextInt() - 1;
	    int[][] ary1 = new int[row][col];
	    ary1[R1][C1] = 1;

	    int it = 0;
	    while(it < time){
		int[][] ary2 = new int[row][col];
		for(int r = 0; r < row; r++){
		    for(int c = 0; c < col; c++){
			if(r > 0){
			    ary2[r][c] += ary1[r - 1][c];
			}
			if(r < row - 1){
			    ary2[r][c] += ary1[r + 1][c];
			}
			if(c>0){
			    ary2[r][c] += ary1[r][c - 1];
			}
			if(c < col - 1){
			    ary2[r][c] +=  ary1[r][c + 1];
			}
			if(ary0[r][c] == '*'){
			    ary2[r][c] = 0;
			}
		    }
		}
		for(int r = 0; r < row; r++){
		    for(int c = 0; c < col; c++){
			ary1[r][c] = ary2[r][c];
		    }
		}

        it++;
	    }
	    return ary1[R2][C2];
	}
	catch(FileNotFoundException e){
	    System.out.println("file not found");
	}
	return -1;
    }
    public static String toString(int[] input){
	String answer = " ";
	for(int c1 = 0; c1 < input.length; c1++){
	    answer += input[c1];
	}
	return answer;
    }
    public static String toString(int[][] input){
	String answer = " ";
	int counter = 0;
	for(int c1 = 0; c1 < input.length; c1++){
	    for(int c2 = 0; c2 < input[c1].length; c2++){
		if(counter == 5){
		    answer += "\n";
		    counter = 0;
		}
		answer += input[c1][c2] + " ";
		counter++;
	    }
	}
	return answer;
    }
}
