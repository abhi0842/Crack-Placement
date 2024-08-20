package Graph;

import java.util.ArrayList;
import java.util.List;

public class TimeNeededInformEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(manager[i]!=-1){
                list.get(manager[i]).add(i);
            }
        }
        return dfs(headID,list,informTime);

    }
    public int dfs(int curr,List<List<Integer>> list,int []informTime){
        int max=0;
        //max is a length of tree
        for(int sub:list.get(curr)){
            max = Math.max(max, dfs(sub, list, informTime));
        }
        return informTime[curr] + max;
    }
}
