import java.util.Stack;

public class Solution3 {

    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
