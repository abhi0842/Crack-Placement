import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsetArray(int[] nums) {

        List<List<Integer>> outer =new ArrayList<>();
        subset(0,nums,new ArrayList(),outer);
        return outer;
    }
    static void  subset(int index,int []nums,List<Integer> curr,List<List<Integer>> outer){
        outer.add(new ArrayList(curr));
        for(int i=index;i<nums.length;i++){
            curr.add(nums[i]);
            subset(i+1,nums,curr,outer);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        System.out.println(subsetArray(arr));
    }
}
