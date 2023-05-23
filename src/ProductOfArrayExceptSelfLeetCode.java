import java.util.Arrays;

public class ProductOfArrayExceptSelfLeetCode {

    public static int[] productExceptSelfBasic(int[] nums) {
        int prod = 1, numZeroes = 0, zeroInd = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0) {numZeroes++; zeroInd =i;}
            prod*=(nums[i]==0)?1:nums[i];
        }
        int[] prods = new int[nums.length];
        if(numZeroes >0)  {
            Arrays.fill(prods,0);
            if(numZeroes == 1) prods[zeroInd] = prod;
            return prods;
        }
        for(int i =0;i<nums.length;i++){
            prods[i] = prod/nums[i];
        }
        return prods;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prods = new int[nums.length];
        prods[0] =1;
        int prod = 1;
        for(int i=1;i<nums.length;i++){
            prod*=nums[i-1];
            prods[i]=prod;
        }
        prod = 1;
        for(int i=nums.length-2;i>=0;i--){
            prod*= nums[i+1];
            prods[i] *= prod;
        }
        return prods;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}
