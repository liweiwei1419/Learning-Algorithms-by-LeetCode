import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://leetcode-cn.com/problems/perfect-squares/description/
// 广度优先遍历
public class Solution {

    public int numSquares(int n) {
        assert n > 0;
        LinkedList<Integer[]> stack = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        stack.addLast(new Integer[]{n, 0});
        visited[n] = true;
        int curNum;
        int curStep;
        while (!stack.isEmpty()) {
            Integer[] pair = stack.removeFirst();
            curNum = pair[0];
            curStep = pair[1];
            curStep++;
            for (int i = 1; ; i++) {
                int next = curNum - i * i;
                if (next < 0) {
                    break;
                }
                if (!visited[next]) {
                    if (next == 0) {
                        return curStep;
                    }
                    stack.addLast(new Integer[]{next, curStep});
                    // 只要添加到队列中，说明我们已经考虑过，就没有必要再添加到队列中
                    visited[next] = true;
                }
            }
        }
        // 正常情况下是不会走到这句的
        throw new IllegalArgumentException("参数错误");
    }

    public static void main(String[] args) {
        // write your code here
        int n = 7168;
        Solution s = new Solution();
        int numSquares = s.numSquares(n);
        System.out.println(numSquares);
    }
}
