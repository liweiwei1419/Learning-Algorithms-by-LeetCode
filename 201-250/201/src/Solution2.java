/**
 * @author liwei
 * @date 18/6/29 下午9:28
 */
public class Solution2 {
    /**
     * 真的是很酷！
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }
}