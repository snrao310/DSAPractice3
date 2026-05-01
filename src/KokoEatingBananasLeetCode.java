public class KokoEatingBananasLeetCode {

    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int i = 0; i < piles.length; i++) {
            r = Math.max(piles[i], r);
        }
        int res = r;
        while (l <= r) {
            int m = (l + r) / 2;
            int timeToEat = numHoursToEat(piles, m);
            if (timeToEat > h) {
                l = m + 1;
            } else {
                if (m < res) {
                    res = m;
                }
                r = m - 1;
            }
        }
        return res;
    }

    public static int numHoursToEat(int[] piles, int rate) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += Math.ceilDiv(piles[i], rate);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] piles = { 1,1,1,999999999 };
        int h = 10;
        System.out.println(minEatingSpeed(piles, h));
    }

}