/**
 * @author liwei
 * @date 18/7/5 下午9:45
 */
public class Solution3 {

    // 牛顿法（重视，要会手写）

    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }
}
