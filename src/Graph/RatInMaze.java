package Graph;

import java.util.ArrayList;

public class RatInMaze {
    public static boolean isvalid(int maze[][],int i,int j,boolean vis[][]){
        int n=maze.length;

        return (i>=0&&i<n&&j>=0&&j<n&&!vis[i][j]&&maze[i][j]==1);
    }
    public static void findpaths(int [][]maze,int i,int j,boolean [][]vis,ArrayList<String>paths,String path){
        int n=maze.length;

        if(i==n-1&&j==n-1){
            paths.add(path);
            return;
        }
        vis[i][j]=true;
        if(isvalid(maze,i,j+1,vis)){
            findpaths(maze,i,j+1,vis,paths,path+'R');
        }
        if(isvalid(maze,i,j-1,vis)){
            findpaths(maze,i,j-1,vis,paths,path+'L');
        }if(isvalid(maze,i+1,j,vis)){
            findpaths(maze,i+1,j,vis,paths,path+'D');
        }if(isvalid(maze,i-1,j,vis)){

            findpaths(maze,i-1,j,vis,paths,path+'U');
        }
        vis[i][j]=false;
    }
    public static  ArrayList<String> findPath(int[][] mat) {
        int n=mat.length;
        boolean vis[][]=new boolean[n][n];
        ArrayList<String> paths=new ArrayList<>();
        if(mat[0][0]==0||mat[n-1][n-1]==0){
            return paths;
        }
        findpaths(mat,0,0,vis,paths,"");
        return paths  ;
    }

    public static void main(String[] args) {
        int arr[][]={{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.println(findPath(arr));
    }
}
