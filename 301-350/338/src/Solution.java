/**
 * 338. Bit位计数
 * https://leetcode-cn.com/problems/counting-bits/description/
 */
public class Solution {

    /**
     * 使用库函数，很容易通过
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[0];
        }
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}
