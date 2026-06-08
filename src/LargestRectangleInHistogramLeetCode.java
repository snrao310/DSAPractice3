import java.util.Stack;

public class LargestRectangleInHistogramLeetCode {

    public static int largestRectangleArea(int[] heights){
        int n = heights.length;
        int[] nextLower = new int[n], prevLower = new int[n];
        nextLower[n-1]=n;prevLower[0]=-1;
        Stack<Integer> next= new Stack<>(), prev = new Stack<>();
        next.push(0);prev.push(n-1);
        for(int i=1;i<n;i++){
            int j=n-i-1;
            while(!next.isEmpty()&&heights[i]<heights[next.peek()])
                nextLower[next.pop()]=i;
            while(!prev.isEmpty() && heights[j]<heights[prev.peek()])
                prevLower[prev.pop()]=j;
            next.push(i);
            prev.push(j);
        }
        while(!next.isEmpty())
            nextLower[next.pop()]=n;
        while(!prev.isEmpty())
            prevLower[prev.pop()]=-1;

        int res = 0;
        for(int i=0;i<n;i++){
            int left = i-(prevLower[i]+1);
            int right = (nextLower[i]-1)-i;
            int area = heights[i]*(left+right+1);
            res = Math.max(res,area);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = { 7,1,7,2,2,4 };
        System.out.println(largestRectangleArea(heights));
        heights = new int[]{ 1,3,7 };
        System.out.println(largestRectangleArea(heights));
    }
    
}
