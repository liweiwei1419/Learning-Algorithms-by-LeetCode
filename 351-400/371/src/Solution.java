public class Solution {

    /**
     * 先做加法，其实就是异或运算
     * 再做进位
     * 1 0 1 1
     * 1 1 1 1
     * 异或： 0 1 0 0
     * 与运算 1 0 1 1
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        int sum;
        while (true) {
            sum = a ^ b;
            int carry = a & b;
            if (carry == 0) {
                break;
            }
            a = sum;
            b = carry << 1;
        }
        return sum;
    }
}
