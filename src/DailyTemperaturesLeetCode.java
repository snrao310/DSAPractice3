import java.util.Stack;

public class DailyTemperaturesLeetCode {

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int val = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[0]<val){
                int[] element = stack.pop();
                res[element[1]] = i-element[1];
            }
            stack.push(new int[]{val,i});
        }
        while(!stack.isEmpty()){
            int[] element = stack.pop();
            res[element[1]]=0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(temperatures);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    
}
