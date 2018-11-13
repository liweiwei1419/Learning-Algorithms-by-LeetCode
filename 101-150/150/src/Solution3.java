package leetcode.q150;

import java.util.Stack;

/**
 * Created by liwei on 17/9/15.
 */
public class Solution2 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            String pattern = "-?[0-9]+|[\\+\\-\\*/]";
            if (!token.matches(pattern)) {
                throw new RuntimeException("非法的表达式");
            }
            if (token.matches("-?[0-9]+")) {
                int num = Integer.valueOf(token);
                System.out.println(num);
                stack.push(num);
            }
            if (token.matches("[\\+\\-\\*/]")) {
                System.out.println("加减乘除" + token);
                if (stack.size() >= 2) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int result = 0;
                    switch (token){
                        case "+":
                            result = num2 +num1;
                            break;
                        case "-":
                            result = num2 -num1;
                            break;
                        case "*":
                            result = num2 *num1;
                            break;
                        case "/":
                            result = num2 /num1;
                            break;
                    }
                    stack.push(result);
                }
            }
        }

        return stack.pop();
    }


}
