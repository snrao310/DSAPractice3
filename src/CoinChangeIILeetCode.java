import java.util.Arrays;
import java.util.HashMap;

public class CoinChangeIILeetCode {
    public static int change(int amount, int[] coins) {
        return backtrack(amount,coins,0, new HashMap<Integer,int[]>());
    }

    public static int backtrack(int target,int[] coins, int i, HashMap<Integer,int[]> dp){
        if(target==0){
            return 1;
        }
        if(target<0) return 0;
        if(dp.containsKey(target) && dp.get(target)[i]!=-1) return dp.get(target)[i];
        if(i==coins.length) return 0;
        int res = backtrack(target, coins,i+1,dp) + backtrack(target-coins[i],coins,i,dp);
        if(!dp.containsKey(target)){
            int[] arr = new int[coins.length];
            Arrays.fill(arr,-1);
            dp.put(target,arr);
        }
        dp.get(target)[i] = res;
        return res;
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(change(amount,coins));
    }
}
