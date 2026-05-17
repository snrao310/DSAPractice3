public class ContainerWithMostWaterLeetCode {

    public static int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = Math.min(heights[l], heights[r]) * (r - l);
        while (l < r) {
            int i = l, j = r;
            while (i < r && heights[l] <= heights[r]) {
                i++;
                if (heights[i] >= heights[l]) {
                    l = i;
                    maxArea = Math.max(maxArea, Math.min(heights[l], heights[r]) * (r - l));
                }
            }
            while (j > l && heights[r] < heights[l]) {
                j--;
                if (heights[j] >= heights[r]) {
                    r = j;
                    maxArea = Math.max(maxArea, Math.min(heights[l], heights[r]) * (r - l));
                }
            }

        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] height = { 1, 7, 2, 5, 4, 7, 3, 6 };
        System.out.println(maxArea(height));
        int[] height2 = { 2, 2, 2 };
        System.out.println(maxArea(height2));
    }

}
