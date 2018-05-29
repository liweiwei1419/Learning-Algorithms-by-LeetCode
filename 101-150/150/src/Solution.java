import java.util.Stack;

public class Solution {

    private String operator = "+-*/";


    public int evalRPN(String[] tokens) {
        if(tokens.length==0)return 0;
        Stack<Integer> stack = new Stack<>();
        int a;
        int b;
        int c = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (operator.contains(tokens[i])) { // 是运算符
                a = stack.pop();
                b = stack.pop();
                if ("+".equals(tokens[i])) {
                    c = b + a;
                }
                if ("-".equals(tokens[i])) {
                    c = b - a;
                }
                if ("*".equals(tokens[i])) {
                    c = b * a;
                }
                if ("/".equals(tokens[i])) {
                    c = b / a;
                }
                stack.push(c);

            } else { // 是数字
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    // https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/description/
    // 其实是一个很简单的问题，读到数字的时候入栈，读到符号的时候出栈
    public static void main(String[] args) {
        // write your code here
        // String[] tokens =new String[] {"2", "1", "+", "3", "*"};
        // String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        // String[] tokens = new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] tokens = new String[0];
        int evalRPN = new Solution().evalRPN(tokens);
        System.out.println(evalRPN);


    }
}
