import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
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
    public static void bfs(ArrayList<Edge> graph[],int v,boolean vis[]){
        Queue<Integer> q=new LinkedList<>();

        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.des);
                }
            }

        }
    }

    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        creategraph(graph);

        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                bfs(graph,v,vis);
            }
        }

    }
}
