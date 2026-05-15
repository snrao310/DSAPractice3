import java.util.Stack;

public class EvaluateReversePolishNotationLeetCode {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if (tokens.length == 0)
            return 0;
        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int l = stack.pop();
                int r = stack.pop();
                if (tokens[i].equals("+"))
                    stack.push(l + r);
                if (tokens[i].equals("-"))
                    stack.push(l - r);
                if (tokens[i].equals("*"))
                    stack.push(l * r);
                if (tokens[i].equals("/"))
                    stack.push(l / r);
            }
            stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }

}
