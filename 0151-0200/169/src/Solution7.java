/**
 * @author liwei
 * @date 18/6/29 下午6:03
 */
public class Solution7 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int half = len / 2;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int zeros = 0;
            for (int num : nums) {
                if ((num & mask) == 0) {
                    zeros++;
                    if (zeros > half) {
                        break;
                    }
                }
            }
            if (zeros <= half) {
                res |= mask;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 6};
        Solution7 solution7 = new Solution7();
        int majorityElement = solution7.majorityElement(nums);
        System.out.println(majorityElement);
    }
}
