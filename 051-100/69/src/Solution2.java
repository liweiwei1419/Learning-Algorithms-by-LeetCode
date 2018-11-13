/**
 * @author liwei
 * @date 18/7/5 下午3:18
 */
public class Solution2 {

    // 暴力解法也能通过

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        for (long s = 1; s <= x; ++s) {
            if (s * s > x) {
                return (int) s - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int mySqrt = solution2.mySqrt(2147483647);
        System.out.println(mySqrt);
    }
}