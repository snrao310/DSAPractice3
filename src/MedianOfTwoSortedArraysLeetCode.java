public class MedianOfTwoSortedArraysLeetCode {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1l = nums1.length, n2l = nums2.length;
        if (n2l<n1l){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int leftArrLength = (nums1.length+nums2.length)/2;
        if(leftArrLength==0)
            return nums2[0];
        boolean isEven = (nums1.length+nums2.length)%2==0;
        int l=0,r=nums1.length-1;
        while(true){
            if(r<0){
                int mid = nums2[leftArrLength-1];
                int num2Next = (nums2.length>=leftArrLength)?nums2[leftArrLength]:Integer.MAX_VALUE;
                int num1Next = (nums1.length!=0)?nums1[0]:Integer.MAX_VALUE;
                int midNext= Math.min(num2Next,num1Next);
                return (isEven)?(mid+midNext)/2.0:midNext;
            }
            int m = (l+r)/2;
            int m2 = leftArrLength - (m+1) -1;
            if(m2>=-1 && m2<nums2.length-1 && nums1[m] > nums2[m2+1]){
                r=m-1;
            }
            else if (m<nums1.length && m2>=0 && m2<nums2.length && nums1[m+1]<nums2[m2]){
                l=m+1;
            }
            else{
                int num2Next = (m2<nums2.length-1)?nums2[m2+1]:Integer.MAX_VALUE;
                int num1Next = (m<nums1.length-1)?nums1[m+1]:Integer.MAX_VALUE;
                if(!isEven){
                    return Math.min(num1Next,num2Next);
                }
                else{
                    int num2mid =(m2>=0 && m2<nums2.length)?nums2[m2]:Integer.MIN_VALUE;
                    int num1mid =(m>=0 && m<nums1.length)?nums1[m]:Integer.MIN_VALUE;
                    int midNext =  Math.min(num1Next,num2Next);
                    int mid = Math.max(num2mid,num1mid);
                    return (mid+midNext)/2.0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    
}
