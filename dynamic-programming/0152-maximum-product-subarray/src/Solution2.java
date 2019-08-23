/**
 * @author liwei
 * @date 2019/8/22 12:09 PM
 */
public class Solution2 {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int preMax = nums[0];
        int preMin = nums[0];
        int curMax;
        int curMin;

        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                curMax = Math.max(preMax * nums[i], nums[i]);
                curMin = Math.min(preMin * nums[i], nums[i]);
            } else {
                curMax = Math.max(preMin * nums[i], nums[i]);
                curMin = Math.min(preMax * nums[i], nums[i]);
            }
            res = Math.max(res, curMax);

            // 滚动变量
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-4, -3, -2};
        Solution2 solution2 = new Solution2();
        int res = solution2.maxProduct(nums);
        System.out.println(res);
    }
}
