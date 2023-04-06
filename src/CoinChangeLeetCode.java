import java.util.HashMap;

public class CoinChangeLeetCode {

    HashMap<Integer, Integer> dp = new HashMap();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (dp.containsKey(amount)) {
            return dp.get(amount);
        }
        int minCoins = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < coins.length; i++) {
            res = coinChange(coins, amount - coins[i]);
            if (res != -1) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }
        int result = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        dp.put(amount, result);
        return result;
    }

}

class RunTest{

    public static void main(String args[]){
        CoinChangeLeetCode test = new CoinChangeLeetCode();
        System.out.println(test.coinChange(new int[]{2},3));
    }
}
