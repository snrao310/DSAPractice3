import java.util.Stack;

public class ValidParanthesesLeetCode {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            } else if (stack.isEmpty())
                return false;
            else if (c == ')' && stack.peek() != '(')
                return false;
            else if (c == '}' && stack.peek() != '{')
                return false;
            else if (c == ']' && stack.peek() != '[')
                return false;
            stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean result = isValid(s);
        System.out.println(result); // Output: true
    }
}
