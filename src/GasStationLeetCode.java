public class GasStationLeetCode {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, tank = 0, i=0;
        while (true) {
            int nextCost = cost[i];
            tank = tank+gas[i]-nextCost;
            i = (i + 1) % gas.length;
            if(tank>=0 && i==start) return start;
            while(tank<0){
                if(start==i) return -1;
                start--;
                if(start==-1) start = gas.length-1;
                tank= tank+ gas[start]-cost[start];
            }
        }
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4};
        int[] cost = {2,2,4,1};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    
}
