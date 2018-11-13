public class Solution {

    public int[] singleNumber(int[] nums) {
        int a_xor_b = 0;
        for (int num : nums) {
            a_xor_b ^= num;
        }
        // n&(n-1) 将从右边到左边的第 1 个 1 变成 0
        // n&(~(n-1)) 只保留从右边到左边的第 1 个 1
        int mask = a_xor_b & (~(a_xor_b - 1));
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
