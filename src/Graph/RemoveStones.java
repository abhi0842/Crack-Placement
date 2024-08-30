package Graph;

public class RemoveStones {
    public void dfs(int [][]stones,int ind,boolean vis[]){
        vis[ind]=true;
        for(int i=0;i<stones.length;i++){
            if((vis[i]==false)&&(stones[i][0]==stones[ind][0]||stones[i][1]==stones[ind][1])){
                dfs(stones,i,vis);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        boolean vis[]=new boolean[n];
        int grp=0;
        for(int i=0;i<n;i++){
            if(vis[i]==true){
                continue;
            }
            dfs(stones,i,vis);
            grp++;
        }
        return n-grp;
    }
}
