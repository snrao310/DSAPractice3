public class MergeTripletsToFormTargetLeetCode {

    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean found0=false,found1=false,found2=false;
        int target0=target[0],target1=target[1],target2=target[2];
        for(int[] triplet: triplets){
            if(triplet[0]==target0 && triplet[1]<=target1 && triplet[2]<=target2){
                found0=true;
            }
            if(triplet[1]==target1 && triplet[0]<=target0 && triplet[2]<=target2){
                found1=true;
            }
            if(triplet[2]==target2 && triplet[0]<=target0 && triplet[1]<=target1){
                found2=true;
            }
        }
        if(found0 && found1 && found2)
        return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] triplets = {{2,5,3},{1,8,4},{1,7,5}};
        int[] target = {2,7,5};
        boolean result = mergeTriplets(triplets, target);
        System.out.println("Can merge triplets to form target: " + result);
    }
    
}
