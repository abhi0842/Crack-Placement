package DP;
import java.util.*;

public class CoinChange {
//    public static int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, amount + 1);
//        dp[0] = 0;
//
//
//        for (int coin : coins) {
//            for (int i = coin; i <= amount; i++) {
//                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
//    }
public static int helper(int[] coins, int amount,int []dp) {
    if (amount == 0) return 0;
    int minCoins = Integer.MAX_VALUE;
    if (dp[amount] != -1) return dp[amount];
    for (int coin : coins) {
        if (amount - coin >= 0) {
            int result = helper(coins, amount - coin,dp);
            if (result != -1) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }
    }
    dp[amount] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    return dp[amount];
}
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        return helper(coins, amount, dp);
    }

    public static void main(String[] args) {
        int coin[]={1,2,5};
        int amount=11;
        System.out.println(coinChange(coin,amount));

    }
}
