package SearchingSorting;

public class splitArrayLargestSum {
    private static int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
    private static int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
    private static boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                if (count > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }

        return true;
    }
    public static int splitArray(int[] nums, int k) {
        int left = getMax(nums);
        int right = getSum(nums);


        int ans=0;
        if(k==nums.length){
            return left;
        }
        while (left <=right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                ans=mid;
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[]={7,2,5,10,8};
        int k=2;
        System.out.println(splitArray(nums,k));
    }
}
