import java.util.Arrays;
import java.util.Stack;

/**
 * @author liwei
 * @date 2019/8/20 8:44 PM
 */
public class Solution3 {

    // 思路：单调栈
    // 考虑每个位置左边和右边第一个比它高的位置的矩形条，以及三个矩形条构成的 U 型

    // 类比问题：LeetCode 第 11 题，LeetCode 第 239 题，存的是索引

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                // top 是 U 形的底部
                int top = stack.pop();
                if (stack.empty()) {
                    break;
                }
                res += (i - stack.peek() - 1) * (Math.min(height[stack.peek()], height[i]) - height[top]);

                // System.out.println("res = " + res + "，peek = " + stack.peek() + "，top = " + top + "，i = " + i);
            }
            stack.push(i);
        }
        // System.out.println(stack);
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{3, 0, 0, 1, 0, 2, 0, 4};
        Solution3 solution3 = new Solution3();
        int res = solution3.trap(height);
        System.out.println(res);
    }
}
