import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationII {
    public static void subsets(int ind , int nums[], ArrayList<Integer> curr, List<List<Integer>> res, int target){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=ind;i<nums.length;i++){
            if(i>ind&&nums[i]==nums[i-1])continue;
            if(nums[i]>target){
                break;
            }
            curr.add(nums[i]);
            subsets(i+1,nums,curr,res,target-nums[i]);
            curr.remove(curr.size()-1);
        }
    }
    public static  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        subsets(0,candidates,new ArrayList<>(),res,target);
        return res;

    }

    public static void main(String[] args) {
        int nums[]={10,1,2,7,6,1,5};
        int target=8;
        System.out.println(combinationSum2(nums,target));
    }
}
