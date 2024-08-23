package Greedy;

public class Rope_Colouring {
    public static int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int i = 0, j = 0;

        while (i < neededTime.length && j < neededTime.length) {
            int currTotal = 0, currMax = 0;

            while (j < neededTime.length && colors.charAt(i) == colors.charAt(j)) {
                currTotal += neededTime[j];
                currMax = Math.max(currMax, neededTime[j]);
                j++;
            }

            totalTime += currTotal - currMax;
            i = j;
        }
        return totalTime;
    }

    public static void main(String[] args) {
        String colors = "abaac";
        int arr[]={1,2,3,4,5};
        System.out.println(minCost(colors,arr));
    }
}
