public class RemoveDuplicates {
    public static int remove(int arr[]){
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=arr[k]){
                k++;
                arr[k]=arr[i];
            }
        }
        return k+1;
    }

    public static void main(String[] args) {
        int arr[]={1,1,2};
        System.out.println(remove(arr));
    }
}
