package Arrays;

public class majorityelement {
    public static  int majorityElement(int[] nums) {
        int count = 0;
        int can = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                can = nums[i];
            }
            if (can == nums[i]) {
                count++;
            } else if (can != nums[i]) {
                count--;
            }
        }
        return can;
    }


    public static void main(String[] args) {
        int arr[]={2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}