public class Solution {

    // 参考资料：http://zxi.mytechroad.com/blog/math/leetcode-69-sqrtx/

    public int mySqrt(int x) {
        if (x < 1) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        long left = 1;
        long right = x / 2;
        while (left <= right) {
            // long mid = left + (right - left) / 2;
            long mid = (left + right) >>> 1;
            long square = mid * mid;
            if (square <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
        int max = 2147395599;
        for (int i = 0; i < max; i++) {
            int mySqrt = solution.mySqrt(i);
            int sysSqrt = (int) Math.sqrt(i);
            if (mySqrt != sysSqrt) {
                System.out.println(i);
                break;
            }
        }
    }
}