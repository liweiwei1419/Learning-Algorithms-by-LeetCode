import java.util.Stack;

// https://leetcode-cn.com/problems/valid-parentheses/description/
public class Solution2 {

    // 下面这种写法是比较简洁的
    public boolean isValid(String s) {
        int len = s.length();
        if(len==0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            switch (c){
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
                    if(stack.isEmpty() || stack.pop()!=c){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
