public class Solution5 {

    // 使用组合数来求解
    // 走到坐标为 (m,n) 的地方，向下走 m-1 格，向右边走 n-1 格
    // 一共走 m + n - 2 格

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        // 取最小的，减少计算量
        int min = Math.min(m - 1, n - 1);
        long ret = factor(m + n - 2, m + n - 2 - min + 1);
        ret /= factor(min, 1);
        return (int) ret;
    }

    // 求 k * (k+1) * ... * n 的乘积
    private long factor(int n, int k) {
        long ret = 1;
        for (int i = n; i >= k; i--) {
            ret *= i;
        }
        return ret;
    }

    public static void main(String[] args) {
        // 输入: m = 7, n = 3
        // 输出: 28
        Solution5 solution5 = new Solution5();
        int m = 10;
        int n = 10;
        int uniquePaths = solution5.uniquePaths(m, n);
        System.out.println(uniquePaths);
    }
}
