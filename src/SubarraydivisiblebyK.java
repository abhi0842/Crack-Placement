import java.util.ArrayList;
import java.util.List;

public class SubarraydivisiblebyK {
    public static void main(String[] args) {
        int nums[]={1,1,1};
        int count=0;
        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            List<Integer> li=new ArrayList<>();
            for(int j=i;j<nums.length;j++){
                li.add(nums[j]);

            }
            res.add(li);
        }
        System.out.println(res);
    }
}
