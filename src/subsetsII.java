import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        subset(0,nums,new ArrayList<>(),res);
        return res;
    }
    public static void subset(int ind , int arr[], ArrayList<Integer> curr, List<List<Integer>> res){

        res.add(new ArrayList<>(curr));
        for(int i=ind;i<arr.length;i++){
            if(i>ind&&arr[i]==arr[i-1])continue;
            curr.add(arr[i]);
            subset(i+1,arr,curr,res);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,2};
        System.out.println(subsetsWithDup(arr));
    }
}
