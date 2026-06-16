import java.util.HashMap;

public class BestTimeToBuyAndSellStockWithCooldownLeetCode {

    public static int maxProfit(int[] prices) {
        HashMap<Integer,Integer>[] dp = new HashMap[2];
        dp[0]=new HashMap<>(); dp[1]=new HashMap<>();
        return maxProfitDP(prices, 0, false, dp);
    }

    public static int maxProfitDP(int[] prices, int i, boolean bought, HashMap<Integer,Integer>[] dp){
        if(i>=prices.length) return 0;
        if(dp[bought?0:1].containsKey(i)) return dp[bought?0:1].get(i);
        int cooldown = maxProfitDP(prices, i+1, bought, dp);
        int maxProfit = cooldown;
        if (bought){
            int sell = maxProfitDP(prices, i+2, false, dp) + prices[i];
            maxProfit = Math.max(maxProfit, sell);
        }
        else{
            int buy = maxProfitDP(prices, i+1, true, dp) - prices[i];
            maxProfit = Math.max(maxProfit, buy);
        }
        dp[bought?0:1].put(i,maxProfit);
        return maxProfit;
    }
    

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
}
