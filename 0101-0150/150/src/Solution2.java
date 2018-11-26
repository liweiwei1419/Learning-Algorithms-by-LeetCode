

import java.util.Stack;

/**
 * 这个版本是 A 过的。
 * Created by liwei on 17/9/15.
 */
public class Solution2 {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.matches("^-?\\d+$")) { // 整数
                int num = Integer.valueOf(token);
                System.out.println(num);
                stack.push(num);
            } else { // token.matches("[\\+\\-\\*/]"
                System.out.println("加减乘除" + token);

                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = 0;
                switch (token) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        String[] tokens = new String[]{"3", "-4", "+"};

        Solution solution = new Solution();
        int result = solution.evalRPN(tokens);
        System.out.println(result);
    }


}

