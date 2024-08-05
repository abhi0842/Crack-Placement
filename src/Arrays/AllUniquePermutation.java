package Arrays;

import java.util.*;

public class AllUniquePermutation {
    private  static void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempList, ArrayList<Integer> nums, boolean[] vis) {
        if(tempList.size()==nums.size()){
            result.add(tempList);
        }
        for(int i=0;i<nums.size();i++){
            if(vis[i]||(i>0 &&nums.get(i)== nums.get(i-1)&&!vis[i-1]))continue;
            vis[i]=true;
            tempList.add(nums.get(i));
            helper(result,tempList,nums,vis);
            vis[i]=false;
            tempList.remove(tempList.size()-1);
        }
    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
       ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Collections.sort(arr);
        ArrayList<Integer> temp=new ArrayList<>();
        boolean vis[]=new boolean[n];
        helper(res,temp,arr,vis);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums=new ArrayList<>();
        nums.add(1);
        nums.add(1);

        nums.add(2);

        System.out.println( uniquePerms(nums,nums.size()));



    }
}
