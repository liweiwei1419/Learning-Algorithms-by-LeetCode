import java.util.Stack;

/**
 * @author liwei
 * @date 2019/6/27 10:26 AM
 */
public class Solution2 {

    public String removeDuplicateLetters(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.contains(s.charAt(i))) {
                continue;
            }
            while (!stack.isEmpty() && s.charAt(i) < stack.peek() && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
