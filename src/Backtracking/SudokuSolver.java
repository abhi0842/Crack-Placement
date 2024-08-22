package Backtracking;

public class SudokuSolver {
    public boolean isSafe(char[][] board,int i,int j,int num){
        for(int k=0;k<board.length;k++){
            if( board[k][j]==(char)(num+'0')){
                return false;
            }
            if(board[i][k]==(char)(num+'0')){
                return false;
            }


        }
        int sr=(i/3)*3;
        int sc=(j/3)*3;
        for(int m=sr;m<sr+3;m++ ){
            for(int p=sc;p<sc+3;p++){
                if(board[m][p]==(char)(num+'0')){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(char[][] board,int i,int j){

        if(i==board.length){
            return true;
        }
        int new_i=0;
        int new_j=0;
        if(j!=board.length-1){
            new_i=i;
            new_j=j+1;
        }
        else{
            new_i=i+1;
            new_j=0;
        }
        if(board[i][j]!='.'){
            if( helper(board,new_i,new_j)){
                return true;
            }
        }
        else{
            for(int k=1;k<=9;k++){
                if(isSafe(board,i,j,k)){
                    board[i][j]=(char)(k+ '0');
                    if(helper(board,new_i,new_j)){
                        return true;
                    }
                    else{
                        board[i][j]='.';
                    }
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}
