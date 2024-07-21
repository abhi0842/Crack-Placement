import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistribution {

        public static long findMinDiff(ArrayList<Integer> a, int n, int m)
        {
            Collections.sort(a);
            long ans=Integer.MAX_VALUE;
            for(int i=0;i<=n-m;i++){
                long min=a.get(i);
                long max=a.get(i+m-1);
                long dif=max-min;
                if(ans>dif){
                    ans=dif;
                }

            }
            return ans;
        }

        public static void main(String[] args) {
            int arr[]={7, 3, 2, 4, 9, 12, 56};
            int n=arr.length;
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
            System.out.println(findMinDiff(list,n,3));
        }
    }


