package Arrays;

import java.util.Arrays;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        int temp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[i][j]=board[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(temp[i][j]==1){
                    int lives=helper(temp,i,j);
                    if(lives==2||lives==3){
                        board[i][j]=1;
                    }
                    else{
                        board[i][j]=0;
                    }
                }
                else{
                    if(helper(temp,i,j)==3){
                        board[i][j]=1;
                    }
                    else{
                        board[i][j]=0;
                    }
                }
            }
        }
    }
    public static int helper(int [][]temp,int i,int j){
        int lives=0;
        int m=temp.length;
        int n=temp[0].length;
        if(i+1<m&&temp[i+1][j]==1)lives++;
        if(i-1>=0&&temp[i-1][j]==1)lives++;
        if(j+1<n&&temp[i][j+1]==1)lives++;
        if(j-1>=0&&temp[i][j-1]==1)lives++;
        if(i+1<m&&j+1<n&&temp[i+1][j+1]==1)lives++;
        if(i-1>=0&&j-1>=0&&temp[i-1][j-1]==1)lives++;
        if(i+1<m&&j-1>=0&&temp[i+1][j-1]==1)lives++;
        if(i-1>=0&&j+1<n&&temp[i-1][j+1]==1)lives++;
        return lives;
    }

    public static void main(String[] args) {
        int arr[][]={{0,1,0},{0,0,1},{1,1,1}};
        gameOfLife(arr);
        System.out.println(Arrays.toString(arr));
    }
}
