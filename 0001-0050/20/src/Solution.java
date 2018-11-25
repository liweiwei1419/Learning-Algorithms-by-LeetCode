import java.util.Stack;

// https://leetcode-cn.com/problems/valid-parentheses/description/

public class Solution {

    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
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

    // 括号匹配问题
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = new Solution().isValid(s);
        System.out.println(valid);
    }
}

