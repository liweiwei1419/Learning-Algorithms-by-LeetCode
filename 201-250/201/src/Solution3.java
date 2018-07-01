/**
 * https://blog.csdn.net/DERRANTCM/article/details/47997613
 *
 * @author liwei
 * @date 18/6/29 下午9:37
 */
public class Solution3 {

    /**
     * 利用了 n &= (n - 1) 一下能消死一大片
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n &= (n - 1);
        }
        return n;
    }
}
