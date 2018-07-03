/**
 * @author liwei
 * @date 18/6/29 下午6:03
 */
public class Solution6 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int half = len / 2;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;

            // 1 的个数
            int ones = 0;
            for (int num : nums) {
                // 特例 ：
                if ((num & mask) != 0) {
                    ones++;
                    if (ones > half) {
                        res |= mask;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 1000 0000 0000 0000 0000 0000 0000 0000
        int[] nums = {Integer.MIN_VALUE};
        Solution6 solution6 = new Solution6();
        int majorityElement = solution6.majorityElement(nums);
        System.out.println("结果 " + majorityElement);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE & Integer.MIN_VALUE));
        System.out.println(Integer.MIN_VALUE == -Integer.MIN_VALUE);
    }
}
