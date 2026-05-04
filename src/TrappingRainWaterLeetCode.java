public class TrappingRainWaterLeetCode {

    public static int trap(int[] height) {
        int trap =0,i=0,len=height.length, j=len-1;
        
        //this part is optional. just helps throw away the edges and helps mentally understand.
        //Even if we remove this, the main while loop will work.
        while(i<len-1 && height[i]<=height[i+1]){
          i++;
        }
        while(j>0 && height[j]<=height[j-1]){
          j--;
        }
        ////////////////////////////////////////////////////////////////////////////////////
    
        while(i<j){
            int heightleft=height[i], heightright=height[j];
            while(heightleft<=heightright && i<j){
                i++;
                if(height[i]<heightleft){
                    trap+=(heightleft-height[i]);
                }
                else{
                    heightleft=height[i];
                }
            }
            while(heightright<=heightleft && i<j){
                j--;
                if(height[j]<heightright){
                    trap+=(heightright-height[j]);
                }
                else{
                    heightright=height[j];
                }
            }
        }
        return trap;
    }

    public static void main(String[] args) {
        int[] height = {0,2,0,3,1,0,1,3,2,1};
        System.out.println(trap(height));
        height = new int[]{0,0,0};
        System.out.println(trap(height));
        height = new int[]{1,0,0};
        System.out.println(trap(height));
        height = new int[]{1,1,1};
        System.out.println(trap(height));
        height = new int[]{1,2,3};
        System.out.println(trap(height));
        height = new int[]{3,2,1};
        System.out.println(trap(height));
        height = new int[]{1,0,1};
        System.out.println(trap(height));
    }

    
}
