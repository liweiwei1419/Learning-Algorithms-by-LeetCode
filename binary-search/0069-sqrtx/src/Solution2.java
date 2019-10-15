/**
 * @author liweiwei1419
 * @date 2019/9/19 7:03 下午
 */
public class Solution2 {

    /**
     * 方法二：牛顿法
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        double cur = 1;
        while (true) {
            double pre = cur;
            cur = (x / cur + cur) / 2;
            if (Math.abs(pre - cur) < 1e-6) {
                break;
            }
        }
        return (int) cur;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int x = 8;
        int res = solution2.mySqrt(8);
        System.out.println(res);
    }
}
