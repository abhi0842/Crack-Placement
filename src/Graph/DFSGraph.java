package Graph;

import java.util.ArrayList;


public class DFSGraph{
    public static class Edge{
        int src;
        int des;
        Edge(int src, int des){
            this.src=src;
            this.des=des;

        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));
    }

    public static void dfs(ArrayList<Edge> graph[],int curr,int v,boolean vis[]){
        if(vis[curr]==false){
            System.out.println(curr);
            vis[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                dfs(graph,e.des,v,vis);
            }
        }
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        creategraph(graph);
        boolean vis[]=new boolean[v];
       dfs(graph,0,v,vis);


    }
}
