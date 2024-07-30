import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    private  static void helper(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] vis) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) continue;  // Skip duplicates
            vis[i] = true;
            tempList.add(nums[i]);
            helper(result, tempList, nums, vis);
            vis[i] = false;
            tempList.remove(tempList.size() - 1);

        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        helper(result, new ArrayList<>(), nums, vis);
        return result;
    }

    public static void main(String[] args) {
        int n[]={1,2,3};
        System.out.println(permuteUnique(n));
    }
}
