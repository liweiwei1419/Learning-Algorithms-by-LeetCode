import java.util.Stack;

public class Solution {

    // https://leetcode-cn.com/problems/valid-parentheses/description/
    // 常规问题：使用栈就可以轻松解决，但是下面的代码显得有些臃肿，可以尝试优化一下
    public boolean isValid(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')') { // 在判断的过程中，执行了出队的操作
                if (stack.empty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (s.charAt(i) == ']') {
                if (stack.empty() || stack.pop() != '[') {
                    return false;
                }
            }
            if (s.charAt(i) == '}') {
                if (stack.empty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    // 括号匹配问题
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = new Solution().isValid(s);
        System.out.println(valid);
    }
}
