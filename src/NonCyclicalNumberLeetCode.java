import java.util.HashSet;

public class NonCyclicalNumberLeetCode {

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int number = n;
        while (number != 1 && !set.contains(number)) {
            set.add(number);
            int newNumber = 0;
            while (number > 0) {
                newNumber += Math.pow(number % 10, 2);
                number = number / 10;
            }
            number = newNumber;
        }
        return number == 1;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(isHappy(n));
    }
}
