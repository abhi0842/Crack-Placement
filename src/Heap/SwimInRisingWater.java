package Heap;

import java.util.PriorityQueue;

public class SwimInRisingWater {
    public class Pair implements Comparable<Pair>{
        int row;
        int col;
        int msf;
        Pair(int row,int col,int msf){
            this.row=row;
            this.col=col;
            this.msf=msf;
        }
        @Override
        public int compareTo(Pair o){
            return this.msf-o.msf;
        }
    }
    public int swimInWater(int[][] grid) {
        int n= grid.length;
        PriorityQueue<Pair> q=new PriorityQueue<>();
        q.add(new Pair(0,0,grid[0][0]));
        boolean vis[][]=new boolean[n][n];
        int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
        while(q.size()>0){
            Pair rem=q.remove();
            if(rem.row==n-1&&rem.col==n-1){
                return rem.msf;

            }
            if(vis[rem.row][rem.col]==true){
                continue;
            }
            vis[rem.row][rem.col]=true;
            for(int i=0;i<4;i++){
                int rowdash=rem.row+dir[i][0];
                int coldash=rem.col+dir[i][1];
                if(rowdash<0||coldash<0||rowdash>=n||coldash>=n||vis[rowdash][coldash]==true){
                    continue;
                }
                q.add(new Pair(rowdash,coldash,Math.max(rem.msf,grid[rowdash][coldash])));
            }
        }
        return 0;
    }

}
