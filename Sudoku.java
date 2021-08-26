package test;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

	public static void main(String[] args) {

		char[][] board= {{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		boolean valid=isValidSudoku(board);
		System.out.println(valid);			
		
	}
	
	public static boolean isValidSudokuPart1(char[][] board) {
		Set<Character> set1=new HashSet<>();
		Set<Character> set2=new HashSet<>();

		
		for(int i=0;i<9;i++)
		{
			for(int j=i;j<9;j++)
			{
				if(!set1.contains(board[i][j]) && board[i][j]!='.')
				{
					set1.add(board[i][j]);
				}
				else if(set1.contains(board[i][j]))
					return false;
			}
			
			for(int k=i;k<9;k++)
			{
				if(!set2.contains(board[k][i])  && board[k][i]!='.')
				{
					set2.add(board[k][i]);
				}
				else if(set2.contains(board[k][i]))
					return false;
			}
		}
		
		return true;
		
	}
	
	public static boolean isValidSudoku(char[][] board) 
    {
        Set<String> hs = new HashSet<>();
        
        for(int i=0;i<9;i++)//Loop through the complete matrix
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    String row = board[i][j] + "in row" + i;//Make a unique key for every element 
                    String col = board[i][j] + "in col" + j;
                    String mat = board[i][j] + "in mat" + i/3 + "and" + j/3;
                    
                    if(hs.contains(row) || hs.contains(col) || hs.contains(mat))
                        return false;//If any of them is already contained in our hashset, simply return false.
                    
					//If none of the above condition matches then we add all the unique keys for a particular number.
					
                    hs.add(row);
                    hs.add(col);
                    hs.add(mat);
                }
            }
        }
        return true;
    }

}
