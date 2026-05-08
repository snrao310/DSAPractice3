import java.util.Arrays;

public class CoinChangeLeetCode {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        return coinCount(coins, dp, amount);
    }

    public static int coinCount(int[] coins, int[] dp, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (dp[amount] != -2)
            return dp[amount];
        int min = amount + 1;
        for (int c : coins) {
            int numCoins = coinCount(coins, dp, amount - c);
            if (numCoins != -1)
                min = Math.min(min, numCoins);
        }
        if (min == amount + 1) {
            dp[amount] = -1;
        } else {
            dp[amount] = min + 1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

}
