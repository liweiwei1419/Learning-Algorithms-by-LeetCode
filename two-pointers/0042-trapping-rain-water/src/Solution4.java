import java.util.Stack;

/**
 * @author liwei
 * @date 2019/8/20 11:16 PM
 */
public class Solution4 {

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }
        int res = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int last = 0;

            while (!stack.empty() && height[stack.peek()] <= height[i]) {
                int top = stack.pop();
                res += (i - top - 1) * (height[top] - last);
                last = height[top];
            }

            if (!stack.empty()) {
                res += (i - stack.peek() - 1) * (height[i] - last);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{3, 0, 0, 1, 0, 2, 0, 4};
        Solution4 solution4 = new Solution4();
        int res = solution4.trap(height);
        System.out.println(res);
    }
}
