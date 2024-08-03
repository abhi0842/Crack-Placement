package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static boolean isvalid(int row,int col,char[][]chess){
        for(int j=0;j<chess.length;j++){
            if(chess[row][j]=='Q'){
                return false;
            }
        }
        for(int i=0;i<chess.length;i++){
            if(chess[i][col]=='Q'){
                return false;
            }
        }
        //upper right
        int r=row;
        for(int c=col;c<chess.length&&r>=0;r--,c++){
            if( chess[r][c]=='Q'){
                return false;
            }
        }
        //upper left
        r=row;
        for(int c=col;c>=0&&r>=0;r--,c--){
            if( chess[r][c]=='Q'){
                return false;
            }
        }
        r=row;
        for(int c=col;c>=0&&r<chess.length;r++,c--){
            if( chess[r][c]=='Q'){
                return false;
            }
        }
        r=row;
        for(int c=col;c<chess.length&&r<chess.length;r++,c++){
            if( chess[r][c]=='Q'){
                return false;
            }
        }

        return true;
    }
    public static void addqueen(char[][] chess,List<List<String>> res){
        String row="";
        List<String> queen=new ArrayList<>();
        for(int i=0;i<chess.length;i++){
            row="";
            for(int j=0;j<chess[0].length;j++){
                if(chess[i][j]=='Q')
                    row+='Q';
                else
                    row+='.';
            }
            queen.add(row);
        }
        res.add(queen);
    }
    public static void solve(char[][] chess,int col,List<List<String>> res){
        if(col==chess.length){
            addqueen(chess,res);
            return;
        }
        for(int i=0;i<chess.length;i++){
            if(isvalid(i,col,chess)){
                chess[i][col]='Q';
                solve(chess,col+1,res);
                chess[i][col]='.';
            }
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] chess=new char[n][n];
        solve(chess,0,res);
        return res;
    }

    public static void main(String[] args) {
        int n=4;
        System.out.println(solveNQueens(n));
    }
}
