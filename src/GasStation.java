public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int fuel=0;
        int totalfuel=0;
        int index=0;
        int diff=0;
        for(int i=0;i<n;i++){
            diff=gas[i]-cost[i];
            totalfuel+=diff;
            fuel+=diff;
            if(fuel<0){
                index=i+1;
                fuel=0;
            }

        }
        return (totalfuel<0)?-1:index;
    }

    public static void main(String[] args) {
        int gas[]={1,2,3,4,5};
        int cost[]={3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
