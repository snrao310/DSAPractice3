import java.util.Arrays;
import java.util.Comparator;

public class CarFleetLeetCode {

    public static int carFleet(int target, int[] position, int[] speed){
        class PosSpeed{
            int position;
            int speed;
            PosSpeed(int p, int s){
                position = p;
                speed = s;
            }
        }
        PosSpeed[] posSpeeds = new PosSpeed[position.length];
        for(int i=0;i<position.length;i++){
            posSpeeds[i] = new PosSpeed(position[i], speed[i]);
        }
        Arrays.sort(posSpeeds, new Comparator<PosSpeed>() {
            @Override
            public int compare(PosSpeed ps1, PosSpeed ps2){
                return Integer.compare(ps2.position, ps1.position);
            }
        });
        int fleets =0;
        double lastFleetTime = Double.MIN_VALUE;
        for(int i=0;i<posSpeeds.length;i++){
            PosSpeed posSpeed = posSpeeds[i];
            int distToTarget = target-posSpeed.position;
            double timeToTarget = distToTarget/(double)posSpeed.speed;
            if(timeToTarget>lastFleetTime){
                fleets++;
                lastFleetTime = timeToTarget;
            }
        }
        return fleets;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {1,4};
        int[] speed = {3,2};
        System.out.println(carFleet(target, position, speed));
        target = 10;
        position = new int[]{4,1,0,7};
        speed = new int[]{2,2,1,1};
        System.out.println(carFleet(target, position, speed));
        target = 10;
        position = new int[]{2,4,1,0,7};
        speed = new int[]{4,2,2,1,1};
        System.out.println(carFleet(target, position, speed));
    }
}
