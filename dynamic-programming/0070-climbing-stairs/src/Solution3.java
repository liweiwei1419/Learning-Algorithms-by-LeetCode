public class Solution3 {

    private int[] memory;

    public int climbStairs(int n) {
        if (n <= 0) {
            return 1;
        }
        memory = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            memory[i] = -1;
        }
        int res = climbinng(n);
        return res;
    }

    private int climbinng(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            // 方法1：一个台阶，一个台阶；方法2：一次上两个台阶
            return 2;
        }
        // 接下来就是看图说话了(乘法计数原理)
        if (memory[n] == -1) {
            memory[n] = climbinng(n - 1) * 1 + climbinng(n - 2) * 1;
        }
        return memory[n];
    }
}
