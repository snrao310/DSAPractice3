public class ProductsOfArrayExceptSelfLeetCode {

    public static int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        product[0] = 1;
        int curProd = 1;
        for (int i = 1; i < nums.length; i++) {
            curProd *= nums[i-1];
            product[i] = curProd;
        }
        curProd = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            curProd *=nums[i+1];
            product[i] *= curProd;
        }
        return product;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf(nums);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
    
}
