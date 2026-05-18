public class BestTimeToBuyAndSellStockLeetCode {

    public static int maxProfit(int[] prices) {
        int s=Integer.MAX_VALUE, l=Integer.MIN_VALUE, p=0, maxP=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<s){
                s=prices[i];
                p=0;
                l=prices[i];
            }
            if(prices[i]>l){
                l=prices[i];
                p=l-s;
                maxP = Math.max(maxP, p);
            }
        }
        return maxP;
    }



    public static void main(String[] args) {
        int[] prices = {10,1,5,6,7,1};
        System.out.println(maxProfit(prices));
    }
    
}
