package Graph;

import java.util.ArrayList;
import java.util.List;

public class SafeStateInGraph {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean []vis=new boolean[V];

        boolean []rec=new boolean[V];

        for(int i = 0; i<V; i++) {
            if(!vis[i])
                isCycleDFS(graph, i, vis,rec);
        }

        List<Integer> res=new ArrayList<>();
        for(int i = 0; i<V; i++) {
            if(!rec[i])
                res.add(i);
        }

        return res;
    }
    static boolean   isCycleDFS(int[][] graph, int curr, boolean[] vis, boolean[] rec) {
        vis[curr] = true;
        rec[curr] = true;


        for(int next : graph[curr]) {

            if(vis[next] == false && isCycleDFS(graph, next, vis, rec))
                return true;
            else if(rec[next] == true)
                return true;
        }

        rec[curr] = false;
        return false;

    }

    public static void main(String[] args) {
        int arr[][]={{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(arr));
    }
}
