public class SearchInRotatedArray {
    public static int findpivot(int nums[]){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid>start&&nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(end>mid&&nums[mid]>nums[mid+1]){
                return mid;
            }
            if(nums[mid]<nums[start]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    public  static int binary(int nums[],int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
    public static int search(int[] nums, int target) {
        int pivot=findpivot(nums);
        if(pivot==-1){
            return binary(nums,target,0,nums.length-1);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        if(target>=nums[0]){
            return binary(nums,target,0,pivot-1);
        }
        return binary(nums,target,pivot+1,nums.length-1);
    }

    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(search(arr,target));
    }
}
